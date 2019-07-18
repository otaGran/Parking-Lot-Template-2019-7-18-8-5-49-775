package com.thoughtworks.parking_lot.model;


import javax.persistence.*;

@Entity
public class parkingLot {

    @Id
    //@GeneratedValue(strategy= GenerationType.AUTO)
    private String name;

    private int capacity;

    private String location;

    public parkingLot() {
    }

    public parkingLot(String name, int capacity, String location) {
        this.name = name;
        this.capacity = capacity;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
