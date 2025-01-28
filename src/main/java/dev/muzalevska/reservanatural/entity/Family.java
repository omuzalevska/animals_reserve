package dev.muzalevska.reservanatural.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "family") 
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

     @OneToMany(mappedBy = "family") // Зв’язок "один до багатьох" з Type
     @JsonManagedReference // Вказує, що це головний бік зв’язку
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
