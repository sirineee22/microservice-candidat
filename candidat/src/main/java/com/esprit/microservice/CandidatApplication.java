package com.esprit.microservice;

import com.esprit.microservice.entity.Candidat;
import com.esprit.microservice.repository.CandidatRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class CandidatApplication {

    public static void main(String[] args) {
        SpringApplication.run(CandidatApplication.class, args);
    }

    @Bean
    ApplicationRunner init(CandidatRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new Candidat("Mariem", "Mariem", "mariem@esprit.tn"));
                repository.save(new Candidat("Sarra", "Sarra", "sarra@esprit.tn"));
                repository.save(new Candidat("Mohamed", "Mohamed", "mohamed@esprit.tn"));
                repository.save(new Candidat("Marou", "Marou", "marou@esprit.tn"));
            }
        };
    }
}
