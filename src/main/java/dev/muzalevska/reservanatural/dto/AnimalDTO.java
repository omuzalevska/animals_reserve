package dev.muzalevska.reservanatural.dto;

import dev.muzalevska.reservanatural.entity.Animal;
import dev.muzalevska.reservanatural.entity.Gender;

import java.time.LocalDate;

public class AnimalDTO {
    private Long id;
    private String name;
    private Long familyId;
    private Long typeId;
    private Gender gender;
    private Long countryId;
    private LocalDate arrivalDate;
    private String photoUrl;

    public AnimalDTO() {}

    public AnimalDTO(Long id, String name, Long familyId, Long typeId, Gender gender, Long countryId, LocalDate arrivalDate, String photoUrl) {
        this.id = id;
        this.name = name;
        this.familyId = familyId;
        this.typeId = typeId;
        this.gender = gender;
        this.countryId = countryId;
        this.arrivalDate = arrivalDate;
        this.photoUrl = photoUrl;
    }

    public AnimalDTO(Animal animal) {
        this.id = animal.getId();
        this.name = animal.getName();
        this.familyId = animal.getFamily().getId();
        this.typeId = animal.getType().getId();
        this.gender = animal.getGender();
        this.countryId = animal.getCountry().getId();
        this.arrivalDate = animal.getArrivalDate();
        this.photoUrl = animal.getPhotoUrl();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Long getFamilyId() { return familyId; }
    public void setFamilyId(Long familyId) { this.familyId = familyId; }

    public Long getTypeId() { return typeId; }
    public void setTypeId(Long typeId) { this.typeId = typeId; }

    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }

    public Long getCountryId() { return countryId; }
    public void setCountryId(Long countryId) { this.countryId = countryId; }

    public LocalDate getArrivalDate() { return arrivalDate; }
    public void setArrivalDate(LocalDate arrivalDate) { this.arrivalDate = arrivalDate; }

    public String getPhotoUrl() { return photoUrl; }
    public void setPhotoUrl(String photoUrl) { this.photoUrl = photoUrl; }
}
