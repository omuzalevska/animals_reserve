package dev.muzalevska.reservanatural.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "family") 
public class Family {

    // private static long idCounter = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

     @OneToMany(mappedBy = "family") // Зв’язок "один до багатьох" з Type
    private List<Type> types;


    public Family() {
    }

    public Family(Long id, String name) {
        this.id = id;//generateId(); //idCounter++;
        this.name = name;
    }

    // private static synchronized long generateId() {
    //     return ++idCounter;
    // }

    // public static void setIdCounter(Long idCounter) {
    //     Family.idCounter = idCounter;
    // }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

}
