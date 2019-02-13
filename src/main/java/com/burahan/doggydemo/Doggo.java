package com.burahan.doggydemo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data // automatically makes my setters and getters
@Entity
public class Doggo
{
    private @Id @GeneratedValue Long id;
    private String breedName;
    private double avgWeight;
    private boolean apartmentOK;

    public Doggo()
    {
        // Default Constructor
    }

    public Doggo(String breedName, double avgWeight, boolean apartmentOK)
    {
        this.breedName = breedName;
        this.avgWeight = avgWeight;
        this.apartmentOK = apartmentOK;
    }
}
