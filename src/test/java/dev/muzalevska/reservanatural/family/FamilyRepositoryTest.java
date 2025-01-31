package dev.muzalevska.reservanatural.family;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import dev.muzalevska.reservanatural.type.TypeRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class FamilyRepositoryTest {

    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private FamilyRepository familyRepository;

    @BeforeEach
    void setUp() {
        typeRepository.deleteAll();  // Спочатку видаляємо всі `Type`
        familyRepository.deleteAll(); // Потім видаляємо всі `Family`
    }

    @Test
    void testSaveAndFindAll() {
       
        familyRepository.save(new Family(null, "Mammals"));
        familyRepository.save(new Family(null, "Reptiles"));

        List<Family> families = familyRepository.findAll();

        assertThat(families).hasSize(2);
    }

    @Test
    void testFindById() {
       
        Family savedFamily = familyRepository.save(new Family(null, "Birds"));

        Family foundFamily = familyRepository.findById(savedFamily.getId()).orElse(null);

        assertThat(foundFamily).isNotNull();
        assertThat(foundFamily.getName()).isEqualTo("Birds");
    }

    @Test
    void testDeleteById() {
 
        Family family = familyRepository.save(new Family(null, "Fish"));

        familyRepository.deleteById(family.getId());

        assertThat(familyRepository.findById(family.getId())).isEmpty();
    }
}
