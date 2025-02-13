package com.example.drone_api.Drone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DroneConfig {
    @Bean
    CommandLineRunner commandLineRunner(DroneRepository droneRepository) {
        return args -> {
            Drone d1 = new Drone("Mavic Mini", LocalDate.of(2016,5,13));
            Drone d2 = new Drone("Mini 4k", LocalDate.of(2018,8,13));

            droneRepository.saveAll(
                    List.of(d1 ,d2)
            );
        };
    }
}
