package dev.muzalevska.reservanatural.controllers;

import dev.muzalevska.reservanatural.entity.Animal;
import dev.muzalevska.reservanatural.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    // Отримати всі тварини
    @GetMapping
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    // Додати нову тварину
    @PostMapping
    public Animal createAnimal(@RequestBody Animal animal) {
        return animalRepository.save(animal);
    }

    // Отримати тварину за ID
    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable Long id) {
        return animalRepository.findById(id).orElseThrow(() -> new RuntimeException("Animal not found"));
    }

    // Оновити тварину
    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable Long id, @RequestBody Animal updatedAnimal) {
        Animal animal = animalRepository.findById(id).orElseThrow(() -> new RuntimeException("Animal not found"));
        animal.setName(updatedAnimal.getName());
        animal.setFamilyId(updatedAnimal.getFamilyId());
        animal.setTypeId(updatedAnimal.getTypeId());
        animal.setGender(updatedAnimal.getGender());
        animal.setCountryId(updatedAnimal.getCountryId());
        animal.setArrivalDate(updatedAnimal.getArrivalDate());
        animal.setPhotoUrl(updatedAnimal.getPhotoUrl());
        return animalRepository.save(animal);
    }

    // Видалити тварину
    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable Long id) {
        animalRepository.deleteById(id);
    }
}
