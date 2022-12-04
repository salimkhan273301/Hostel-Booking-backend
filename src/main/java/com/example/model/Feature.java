package com.example.model;

import javax.persistence.*;




@Entity
@Table(name = "features")
public class Feature {
  


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    public Feature() {

    }

    public Feature(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Feature[id = '%d', name = '%s', price = '%8.2f']", id, name, price);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

}
