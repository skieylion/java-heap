package project.java.app;

import feign.Response;
import lombok.AllArgsConstructor;
import org.apache.commons.codec.Charsets;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import project.java.feigns.AudioRepository;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
@AllArgsConstructor
public class Runner {

    private final AudioRepository audioRepository;

    public void run() throws IOException {
        System.out.println("123123123");
        Response response=audioRepository.upload("en", "mp3", "work__gb_1.mp3");
        final InputStreamSource inputStreamSource=new InputStreamResource(response.body().asInputStream());
        InputStreamResource ob;
        // attachment = ;
        System.out.println(IOUtils.toString(inputStreamSource.getInputStream(), String.valueOf(Charsets.UTF_8)));


    }
}
