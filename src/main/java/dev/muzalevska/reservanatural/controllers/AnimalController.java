package dev.muzalevska.reservanatural.controllers;

import dev.muzalevska.reservanatural.dto.AnimalDTO;
import dev.muzalevska.reservanatural.entity.Animal;
import dev.muzalevska.reservanatural.repository.AnimalRepository;
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
    private AnimalRepository animalRepository;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    // список всіх тварини
    @GetMapping
    public ResponseEntity<List<AnimalDTO>> getAllAnimals() {
        List<AnimalDTO> animals = animalService.getAllAnimals();
        return ResponseEntity.ok(animals);
    }

    //к-ть тварин
    @GetMapping("/count")
    public Long getAnimalCount() {
        return animalRepository.count();
    }

    // пошук по імені
    @GetMapping("/name/{name}")
    public List<Animal> getAnimalByName(@PathVariable String name) {
        return animalRepository.findByName(name);
    }

    // Додати
    @PostMapping
    public ResponseEntity<AnimalDTO> createAnimal(@RequestBody AnimalDTO animalDTO) {
        AnimalDTO savedAnimal = animalService.save(animalDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAnimal);
    }

    // Отримати за ID
    @GetMapping("/{id}")
    public ResponseEntity<AnimalDTO> getAnimalById(@PathVariable Long id) {
        AnimalDTO animalDTO = animalService.getAnimalById(id);
        return ResponseEntity.ok(animalDTO);
    }

    // Оновити
    @PutMapping("/{id}")
    public ResponseEntity<AnimalDTO> updateAnimal(@PathVariable Long id, @RequestBody AnimalDTO updatedAnimalDTO) {
        AnimalDTO updatedAnimal = animalService.update(id, updatedAnimalDTO);
        return ResponseEntity.ok(updatedAnimal);
    }

    // Видалити
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Long id) {
        animalService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
