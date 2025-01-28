package dev.muzalevska.reservanatural.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.muzalevska.reservanatural.dto.TypeDTO;
import dev.muzalevska.reservanatural.entity.Type;
import dev.muzalevska.reservanatural.repository.TypeRepository;

import dev.muzalevska.reservanatural.entity.Family;
import dev.muzalevska.reservanatural.repository.FamilyRepository;

@Service
public class TypeService {

    private final TypeRepository typeRepository;
    private final FamilyRepository familyRepository;

    @Autowired
    public TypeService(TypeRepository typeRepository, FamilyRepository familyRepository) {
        this.typeRepository = typeRepository;
        this.familyRepository = familyRepository;
    }

    public TypeDTO save(TypeDTO typeDTO) {
        // Знайти Family по ID
        Family family = familyRepository.findById(typeDTO.getFamilyId())
                .orElseThrow(() -> new RuntimeException("Family not found"));

        Type type = new Type();
        type.setName(typeDTO.getName());
        type.setFamily(family);

        // Зберегти в базу
        Type savedType = typeRepository.save(type);

        // Повернути DTO
        return new TypeDTO(savedType);
    }

}
