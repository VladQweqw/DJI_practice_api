package com.example.drone_api.Drone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DroneService {
    private final DroneRepository droneRepository;

    @Autowired
    DroneService(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }

    public List<Drone> getDrones() {
        return droneRepository.findAll();
    }

    public Drone getDroneById(Long id) {
        return droneRepository.findById(id).orElseThrow(() -> {
            throw new IllegalStateException("Drone ID is invalid");
        });
    }

    public Drone createDrone(Drone drone_obj) {
        Optional<Drone> found = droneRepository.findByName(drone_obj.getName());

        if(found.isPresent()) {
            throw new IllegalStateException("Drone with the same name already exists");
        }else {
            droneRepository.save(drone_obj);
            return drone_obj;
        }

    }

    public Drone updateDrone(Long id, DroneUpdate kilometers) {
        Drone found = droneRepository.findById(id).orElseThrow(() -> {
            throw new IllegalStateException("Drone ID is invalid");
        });

        found.setKilometers_traveled(kilometers.getKilometers());
        droneRepository.save(found);

        return found;
    }

    public void deleteDrone(Long id) {
        Drone found = droneRepository.findById(id).orElseThrow(() -> {
            throw new IllegalStateException("Drone ID is invalid");
        });

        droneRepository.deleteById(id);
    }
}
