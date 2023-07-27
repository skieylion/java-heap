package project.java.service;

import org.springframework.stereotype.Service;
import project.java.model.Developer;

import javax.annotation.Resource;


@Service
public class Runner {


    //указываем корректное имя бина
    @Resource(name = "dev")
    Developer developer;

    public void run() {
        System.out.println(developer);
    }
}
