package dev.muzalevska.reservanatural.animal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    @SuppressWarnings("null")
    Page<Animal> findAll(Pageable pageable); // Пагінація для всіх тварин

    Page<Animal> findByFamilyId(Long familyId, Pageable pageable); // Пошук за родиною з пагінацією

    List<Animal> findByCountryId(Long countryId); // Пошук за країною без пагінації

    List<Animal> findByFamilyIdAndTypeId(Long familyId, Long typeId); // Пошук за родиною та типом
    
    List<Animal> findByName(String name);
}
