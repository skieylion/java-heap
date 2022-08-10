package project.java.feigns;

import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.java.config.FeignClientConfig;

@FeignClient(
        url = "https://audio.oxforddictionaries.com",
        value = "audioRepository",
        configuration = FeignClientConfig.class
)
public interface AudioRepository {
    @GetMapping("/{dialect}/{format}/{name}")
    Response upload(
            @RequestParam(value = "dialect", defaultValue = "en") String dialect,
            @RequestParam(value = "format", defaultValue = "mp3") String format,
            @RequestParam(value = "name") String name
    );
}
