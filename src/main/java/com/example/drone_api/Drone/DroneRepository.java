package com.example.drone_api.Drone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {

    @Query("SELECT d FROM Drone d Where d.name = ?1")
    Optional<Drone> findByName(String name);

}
