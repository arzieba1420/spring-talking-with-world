package pl.edu.wszib.springtalkingwithworld.model;

import org.springframework.stereotype.Component;


public class Customer {

    public String name;
    public boolean partner;
    public boolean child;
    public boolean pet;

    public Customer(String name, boolean partner, boolean child, boolean pet) {
        this.name = name;
        this.partner = partner;
        this.child = child;
        this.pet = pet;
    }
}
