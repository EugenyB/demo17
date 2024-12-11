package com.example.demo;

import com.example.demo.repo.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Demo17Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo17Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentRepository repository) {
        System.out.println("dsvdsf");
        return args -> {
            MainController.setRepo(repository);
            MainApp.main(args);
        };
    }

}
