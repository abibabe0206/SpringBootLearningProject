package com.example.SpringBootLearningProject.simpleSpringBootProject.config;


import com.example.SpringBootLearningProject.simpleSpringBootProject.model.student.Student;
import com.example.SpringBootLearningProject.simpleSpringBootProject.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student maraim = new Student(
                    "Maraim",
                    "maraim.ok@gmail.com",
                    LocalDate.of(2000, Month.JULY, 5)
            );

            Student alex = new Student(
                    "Alex",
                    "alex.ok@gmail.com",
                    LocalDate.of(2004, Month.JULY, 5)
            );

            repository.saveAll(
                    List.of(maraim, alex)
            );
        };
    }
}
