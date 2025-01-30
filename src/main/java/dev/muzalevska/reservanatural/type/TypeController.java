package dev.muzalevska.reservanatural.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/types")
public class TypeController {

    //@Autowired
    private final TypeService typeService;
   //@Autowired
    private TypeRepository typeRepository;

    @Autowired
    public TypeController(TypeService typeService, TypeRepository typeRepository) {
        this.typeService = typeService;
        this.typeRepository = typeRepository;
    }

    // Отримати всі типи
    @GetMapping
    public List<TypeDTO> getAllTypes() {
        List<Type> types = typeRepository.findAll();
        return types.stream()
                .map(type -> new TypeDTO(type))
                //new TypeDTO(type.getId(), type.getName()))
                .collect(Collectors.toList());
    }
    
    // Додати новий тип
    @PostMapping
     public ResponseEntity<TypeDTO> createType(@RequestBody TypeDTO typeDTO) {
    TypeDTO savedTypeDTO = typeService.save(typeDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedTypeDTO);
     }

    // Отримати тип за ID
    @GetMapping("/{id}")
    public Type getTypeById(@PathVariable Long id) {
        return typeRepository.findById(id).orElseThrow(() -> new RuntimeException("Type not found"));
    }

    // Оновити тип
    @PutMapping("/{id}")
    public Type updateType(@PathVariable Long id, @RequestBody Type updatedType) {
        Type type = typeRepository.findById(id).orElseThrow(() -> new RuntimeException("Type not found"));
        type.setName(updatedType.getName());
        type.setFamilyId(updatedType.getFamilyId());
        return typeRepository.save(type);
    }

    // Видалити тип
    @DeleteMapping("/{id}")
    public void deleteType(@PathVariable Long id) {
        typeRepository.deleteById(id);
    }
}