package com.example.drone_api.Owner;

import com.example.drone_api.Drone.Drone;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Owner {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @JsonIgnoreProperties("owner")
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Drone> drones_owned = new HashSet<>();

    private LocalDate dob;

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", drones_owned=" + drones_owned +
                ", dob=" + dob +
                '}';
    }


    public Owner() {

    }
    public Owner(String name, Integer drones_owned, LocalDate dob) {
        this.name = name;
        this.dob = dob;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDrones_owned(Set<Drone> drones_owned) {
        this.drones_owned = drones_owned;
    }


    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void addDrone(Drone drone) {
        this.drones_owned.add(drone);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Drone> getDrones_owned() {
        return drones_owned;
    }

    public LocalDate getDob() {
        return dob;
    }
}
