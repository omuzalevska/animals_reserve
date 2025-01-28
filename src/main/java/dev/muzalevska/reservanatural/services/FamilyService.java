package dev.muzalevska.reservanatural.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.muzalevska.reservanatural.dto.FamilyDTO;
import dev.muzalevska.reservanatural.entity.Family;
import dev.muzalevska.reservanatural.repository.FamilyRepository;

@Service 
public class FamilyService {

    private final FamilyRepository familyRepository;

    @Autowired
    public FamilyService(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    public FamilyDTO save(FamilyDTO familyDTO) {
        Family family = new Family();
        family.setName(familyDTO.getName());
        Family savedFamily = familyRepository.save(family);
        return new FamilyDTO(savedFamily);
    }
 
}
