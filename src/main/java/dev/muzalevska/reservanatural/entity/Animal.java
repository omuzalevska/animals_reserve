package dev.muzalevska.reservanatural.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "animals") // Назва таблиці
public class Animal {
    
    //private static long idCounter = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "family_id")
    private Long familyId;

    @Column(name = "type_id")
    private Long typeId;

    private Gender gender;

    @Column(name = "country_id")
    private Long countryId;

    @Column(name = "arrival_date")
    private LocalDate arrivalDate;

    @Column(name = "photo_url")
    private String photoUrl;


    public Animal() {
    }

    public Animal(Long id, String name, Long family_id, Long type_id, Gender gender, Long country_id, LocalDate arrivalDate, String photo_url) {
        this.id = id;//generateId(); //idCounter++;
        this.name = name;
        this.familyId = family_id;
        this.typeId = type_id;
        this.gender = gender;
        this.countryId = country_id;
        this.arrivalDate = arrivalDate;
        this.photoUrl = photo_url;
    }

    // private static synchronized long generateId() {
    //     return ++idCounter;
    // }

    // public static void setIdCounter(Long idCounter) {
    //     Animal.idCounter = idCounter;
    // }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getFamilyId() {
        return familyId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public Gender getGender() {
        return gender;
    }

    public Long getCountryId() {
        return countryId;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFamilyId(Long familyId) {
        this.familyId = familyId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    
}
