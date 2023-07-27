package project.java.service;

import org.springframework.stereotype.Service;
import project.java.model.Developer;

import javax.annotation.Resource;


@Service
public class Runner {


    //бин не будет внедряться потому что имя указано некорректно
    @Resource(name = "develop")
    Developer developer;

    public void run() {
        System.out.println(developer);
    }
}
