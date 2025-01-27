package dev.muzalevska.reservanatural.controllers;

import dev.muzalevska.reservanatural.entity.Type;
import dev.muzalevska.reservanatural.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/types")
public class TypeController {

    @Autowired
    private TypeRepository typeRepository;

    // Отримати всі типи
    @GetMapping
    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    // Додати новий тип
    @PostMapping
    public Type createType(@RequestBody Type type) {
        return typeRepository.save(type);
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