package dev.muzalevska.reservanatural.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "types") 
public class Type {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne // Налаштовуємо зв'язок "багато до одного" з Family
    @JoinColumn(name = "family_id", nullable = false) // Поле, яке відповідає зовнішньому ключу
    private Family family;
    
    public Type() {
    }

    public Type(Long id, String name, Family family) {
        this.id = id; 
        this.name = name;
        this.family = family;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Family getFamilyId() {
        return family;
    }

    public void setFamilyId(Family familyId) {
        this.family = familyId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}