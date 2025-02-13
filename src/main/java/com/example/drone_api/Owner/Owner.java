package com.example.drone_api.Owner;

import com.example.drone_api.Drone.Drone;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Owner {
    @Id
    @SequenceGenerator(
            name="owner-id",
            sequenceName = "owner-id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "owner-id"
    )
    private Long id;

    private String name;
    @OneToMany(mappedBy = "drone-id")
    private List<Drone> drones_owned;
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

    public void setDrones_owned(Drone drone) {
        this.drones_owned.add(drone);
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Drone> getDrones_owned() {
        return drones_owned;
    }

    public LocalDate getDob() {
        return dob;
    }
}
