package dev.muzalevska.reservanatural.family;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
