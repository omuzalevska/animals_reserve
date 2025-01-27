package dev.muzalevska.reservanatural.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "countries") 
public class Country {

    // private static long idCounter = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    
    public Country() {
    }

    public Country(Long id, String name) {
        this.id = id; //generateId(); //idCounter++;
        this.name = name;
    }

    // private static synchronized long generateId() {
    //     return ++idCounter;
    // }

    // public static void setIdCounter(Long idCounter) {
    //     Country.idCounter = idCounter;
    // }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}