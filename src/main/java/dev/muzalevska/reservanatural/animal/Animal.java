package dev.muzalevska.reservanatural.animal;

import java.time.LocalDate;

import dev.muzalevska.reservanatural.country.Country;
import dev.muzalevska.reservanatural.family.Family;
import dev.muzalevska.reservanatural.gender.Gender;
import dev.muzalevska.reservanatural.type.Type;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "animals") // Назва таблиці
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "family_id", nullable = false)
    private Family family; // Зв'язок з Family

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private Type type; // Зв'язок з Type

    @Enumerated(EnumType.STRING) 
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country; // Зв'язок з Country

    @Column(name = "arrival_date")
    private LocalDate arrivalDate;

    @Column(name = "photo_url")
    private String photoUrl;


    public Animal() {
    }

    public Animal(Long id, String name, Family family, Type type, Gender gender, Country country, LocalDate arrivalDate, String photoUrl) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.type = type;
        this.gender = gender;
        this.country = country;
        this.arrivalDate = arrivalDate;
        this.photoUrl = photoUrl;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    
    
}
