package dev.muzalevska.reservanatural.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.muzalevska.reservanatural.family.Family;
import dev.muzalevska.reservanatural.family.FamilyRepository;

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
