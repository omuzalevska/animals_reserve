package dev.muzalevska.reservanatural.family;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/families")
public class FamilyController {
    
    @Autowired
    private final FamilyService familyService;

    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    // @Autowired
    // public FamilyController(FamilyService familyService, FamilyRepository familyRepository) {
    //     this.familyService = familyService;
    //     this.familyRepository = familyRepository;
    // }
    
    // Отримати всі сімейства
    @GetMapping("/api/families")
    public List<FamilyDTO> getAllFamilies() {
    List<Family> families = familyRepository.findAll();
    return families.stream()
            .map(family -> new FamilyDTO(family.getId(), family.getName()))
            .collect(Collectors.toList());
}
    // Додати нове сімейство
    @PostMapping
     public ResponseEntity<FamilyDTO> createFamily(@RequestBody FamilyDTO familyDTO) {
    FamilyDTO savedFamilyDTO = familyService.save(familyDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedFamilyDTO);
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