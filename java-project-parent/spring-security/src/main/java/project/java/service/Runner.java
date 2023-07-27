package project.java.service;

import org.springframework.stereotype.Service;
import project.java.model.Developer;

import javax.annotation.Resource;


@Service
public class Runner {


    //указываем корректное имя бина
    @Resource
    Developer d_e_v_e_l_o_p_e_r;

    public void run() {
        System.out.println(d_e_v_e_l_o_p_e_r);
    }
}
