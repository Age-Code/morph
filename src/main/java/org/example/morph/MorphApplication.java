package org.example.morph;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MorphApplication {

    public static void main(String[] args) {
        SpringApplication.run(MorphApplication.class, args);
    }

}
