package com.example.demo;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner initDataBase(ClientRepository clientRepository){
        return  args -> {
          clientRepository.save(new Client("mehdi","mehdi@gmail.com"));
            clientRepository.save(new Client("jawad","jawad@gmail.com"));
            clientRepository.save(new Client("oussama","oussama@gmail.com"));
        };
    }

}
