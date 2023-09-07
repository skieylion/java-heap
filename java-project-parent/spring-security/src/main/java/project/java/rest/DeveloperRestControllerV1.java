package project.java.rest;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import project.java.model.Developer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestControllerV1 {
    private List<Developer> developerList = Stream.of(
            new Developer(1L, "Ivan", "Ivanov"),
            new Developer(2L, "Petr", "Petrov"),
            new Developer(3L, "Misha", "Sidorov")
    ).collect(Collectors.toList());


    @Cacheable(cacheManager = "caffeineCacheManager", cacheNames = "serviceEntityService", key = "#root.methodName")
    @PreAuthorize("hasAuthority('developer:read')")
    @GetMapping
    public List<Developer> getAll() throws InterruptedException {
        Thread.sleep(5000);
        return developerList;
    }

    @Cacheable(cacheManager = "caffeineCacheManager", cacheNames = "serviceEntityService", key = "#id+'-'+#test")
    @PreAuthorize("hasAuthority('developer:read')")
    @GetMapping("/{id}")
    public Developer getById(@PathVariable("id") Long id, @RequestParam("test") String test) throws InterruptedException {
        Thread.sleep(5000);
        return developerList.stream().filter((developer -> developer.getId().equals(id))).findFirst().orElse(null);
    }

    @PreAuthorize("hasAuthority('developer:write')")
    @PostMapping
    public Developer create(@RequestBody Developer developer) {
        developerList.add(developer);
        return developer;
    }

    @PreAuthorize("hasAuthority('developer:write')")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        developerList.removeIf(developer -> developer.getId().equals(id));
    }
}
