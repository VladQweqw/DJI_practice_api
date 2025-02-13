package com.example.drone_api.Drone;

import com.example.drone_api.Owner.Owner;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table
public class Drone {

    @Id
    @SequenceGenerator(
            name="drone-id",
            sequenceName = "drone-id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "drone-id"
    )
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name="owner-id")
    private Owner owner_id;
    private Double kilometers_traveled = 0.0;
    private Integer flights = 0;
    private LocalDate fabrication_date;
    @Transient
    private Integer age_in_days;

    public Drone() {

    }

    public void setOwner_id(Owner owner_id) {
        this.owner_id = owner_id;
    }

    public Owner getOwner_id() {
        return owner_id;
    }

    public Drone(String name, LocalDate fabrication_date) {
        this.name = name;
        this.fabrication_date = fabrication_date;
    }

    @Override
    public String toString() {
        return "Drone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kilometers_traveled=" + kilometers_traveled +
                ", flights=" + flights +
                ", fabrication_date=" + fabrication_date +
                ", age_in_days=" + age_in_days +
                '}';
    }

    public void setAge_in_days(Integer age_in_days) {
        this.age_in_days = age_in_days;
    }

    public Integer getAge_in_days() {
        return (int) ChronoUnit.DAYS.between(this.fabrication_date, LocalDate.now());
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKilometers_traveled(Double kilometers_traveled) {
        this.kilometers_traveled = this.kilometers_traveled + kilometers_traveled;
        this.flights++;
    }

    public void setFlights(Integer flights) {
        this.flights = flights;
    }

    public void setFabrication_date(LocalDate fabrication_date) {
        this.fabrication_date = fabrication_date;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getKilometers_traveled() {
        return kilometers_traveled;
    }

    public Integer getFlights() {
        return flights;
    }

    public LocalDate getFabrication_date() {
        return fabrication_date;
    }
}

