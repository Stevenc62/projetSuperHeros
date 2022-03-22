package com.steven.projetSuperHeros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProjetSuperHerosApplication {

    public static void main(String[] args) {
            SpringApplication.run(ProjetSuperHerosApplication.class, args);
    }
}
