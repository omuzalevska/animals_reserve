package dev.muzalevska.reservanatural.controllers;

import dev.muzalevska.reservanatural.dto.AnimalDTO;
//import dev.muzalevska.reservanatural.entity.Animal;
import dev.muzalevska.reservanatural.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    // Отримати всі тварини
    @GetMapping
    public ResponseEntity<List<AnimalDTO>> getAllAnimals() {
        List<AnimalDTO> animals = animalService.getAllAnimals();
        return ResponseEntity.ok(animals);
    }

    // Додати нову тварину
    @PostMapping
    public ResponseEntity<AnimalDTO> createAnimal(@RequestBody AnimalDTO animalDTO) {
        AnimalDTO savedAnimal = animalService.save(animalDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAnimal);
    }

    // Отримати тварину за ID
    @GetMapping("/{id}")
    public ResponseEntity<AnimalDTO> getAnimalById(@PathVariable Long id) {
        AnimalDTO animalDTO = animalService.getAnimalById(id);
        return ResponseEntity.ok(animalDTO);
    }

    // Оновити тварину
    @PutMapping("/{id}")
    public ResponseEntity<AnimalDTO> updateAnimal(@PathVariable Long id, @RequestBody AnimalDTO updatedAnimalDTO) {
        AnimalDTO updatedAnimal = animalService.update(id, updatedAnimalDTO);
        return ResponseEntity.ok(updatedAnimal);
    }

    // Видалити тварину
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Long id) {
        animalService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
