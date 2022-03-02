package project.java.rest;

import org.springframework.web.bind.annotation.*;
import project.java.model.Developer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRest {
    private List<Developer> developerList = Stream.of(
            new Developer(1L, "Ivan", "Ivanov"),
            new Developer(2L, "Petr", "Petrov"),
            new Developer(3L, "Misha", "Sidorov")
    ).collect(Collectors.toList());


    @GetMapping
    public List<Developer> getAll() {
        return developerList;
    }

    @GetMapping("/{id}")
    public Developer getById(@PathVariable("id") Long id) {
        return developerList.stream().filter((developer -> developer.getId().equals(id))).findFirst().orElse(null);
    }

    @PostMapping
    public Developer create(@RequestBody Developer developer) {
        developerList.add(developer);
        return developer;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        developerList.removeIf(developer -> developer.getId().equals(id));
    }
}
