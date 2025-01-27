package dev.muzalevska.reservanatural.controllers;

import dev.muzalevska.reservanatural.entity.Family;
import dev.muzalevska.reservanatural.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/families")
public class FamilyController {

    @Autowired
    private FamilyRepository familyRepository;

    // Отримати всі сімейства
    @GetMapping
    public List<Family> getAllFamilies() {
        return familyRepository.findAll();
    }

    // Додати нове сімейство
    @PostMapping
    public Family createFamily(@RequestBody Family family) {
        return familyRepository.save(family);
    }

    // Отримати сімейство за ID
    @GetMapping("/{id}")
    public Family getFamilyById(@PathVariable Long id) {
        return familyRepository.findById(id).orElseThrow(() -> new RuntimeException("Family not found"));
    }

    // Оновити сімейство
    @PutMapping("/{id}")
    public Family updateFamily(@PathVariable Long id, @RequestBody Family updatedFamily) {
        Family family = familyRepository.findById(id).orElseThrow(() -> new RuntimeException("Family not found"));
        family.setName(updatedFamily.getName());
        return familyRepository.save(family);
    }

    // Видалити сімейство
    @DeleteMapping("/{id}")
    public void deleteFamily(@PathVariable Long id) {
        familyRepository.deleteById(id);
    }
}