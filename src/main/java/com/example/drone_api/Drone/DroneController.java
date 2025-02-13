package com.example.drone_api.Drone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/drone")
public class DroneController {
    private final DroneService droneService;

    @Autowired
    DroneController(DroneService droneService) {
        this.droneService = droneService;
    }

    @GetMapping
    public List<Drone> getDrones() {
        return droneService.getDrones();
    }

    @GetMapping(path = "{drone-id}")
    public Drone getDroneById(@PathVariable("drone-id") Long id) {
        return droneService.getDroneById(id);
    }

    @PostMapping
    public Drone postDrone(@RequestBody Drone drone) {
        return droneService.createDrone(drone);
    }

    @PutMapping(path = "{drone-id}")
    public Drone putDrone(
            @PathVariable("drone-id") Long id,
            @RequestBody DroneUpdate kilometers
    ) {
        return droneService.updateDrone(id, kilometers);
    }

    @DeleteMapping(path = "{drone-id}")
    public void deleteDrone(@PathVariable("drone-id") Long id) {
        droneService.deleteDrone(id);
    }

}
