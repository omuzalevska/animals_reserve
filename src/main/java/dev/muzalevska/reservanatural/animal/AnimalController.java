package dev.muzalevska.reservanatural.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;


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
    @GetMapping("/private/count")
    public Long getAnimalCount() {
        return animalRepository.count();
    }

    // пошук по імені
    @GetMapping("/private/name/{name}")
    public List<Animal> getAnimalByName(@PathVariable String name) {
        return animalRepository.findByName(name);
    }

    //всі тварини посторінково по 20 шт\стор
    @GetMapping("/public/paged")
    public Page<Animal> getAllAnimalsPaged(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return animalRepository.findAll(pageable);
    }

    // пошук по родині посторінково по 10 шт\стор
    @GetMapping("/public/by-family")
    public Page<Animal> getAnimalsByFamilyPaged(@RequestParam Long familyId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return animalRepository.findByFamilyId(familyId, pageable);
    }

    // пошук тварин за країною (countryId)
    @GetMapping("/public/country/{countryId}")
    public ResponseEntity<List<AnimalDTO>> getAnimalsByCountry(@PathVariable Long countryId) {
        List<Animal> animals = animalRepository.findByCountryId(countryId);
        List<AnimalDTO> animalDTOs = animals.stream().map(AnimalDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(animalDTOs);
    }

    // пошук тварин за родиною (familyId) та типом (typeId)
    @GetMapping("/public/family/{familyId}/type/{typeId}")
    public ResponseEntity<List<AnimalDTO>> getAnimalsByFamilyAndType(@PathVariable Long familyId, @PathVariable Long typeId) {
        List<Animal> animals = animalRepository.findByFamilyIdAndTypeId(familyId, typeId);
        List<AnimalDTO> animalDTOs = animals.stream().map(AnimalDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(animalDTOs);
    }

    //CRUD
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
