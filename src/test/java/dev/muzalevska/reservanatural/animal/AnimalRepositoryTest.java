package dev.muzalevska.reservanatural.animal;

import dev.muzalevska.reservanatural.country.Country;
import dev.muzalevska.reservanatural.country.CountryRepository;
import dev.muzalevska.reservanatural.family.Family;
import dev.muzalevska.reservanatural.family.FamilyRepository;
import dev.muzalevska.reservanatural.type.Type;
import dev.muzalevska.reservanatural.type.TypeRepository;
import dev.muzalevska.reservanatural.gender.Gender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class AnimalRepositoryTest {

    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private FamilyRepository familyRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private CountryRepository countryRepository;

    private Family mammals;
    private Type bigCats;
    private Gender male;
    private Country ukraine;

    @BeforeEach
void setUp() {

    animalRepository.deleteAll();
    typeRepository.deleteAll();
    familyRepository.deleteAll();
    countryRepository.deleteAll();

    mammals = new Family(null, "Mammals");
    mammals = familyRepository.save(mammals); // Зберігаємо і отримуємо ID

    bigCats = new Type(null, "Big Cats", mammals);
    bigCats = typeRepository.save(bigCats); // Зберігаємо і отримуємо ID

    male = Gender.M;
    ukraine = countryRepository.save(new Country(null, "Ukraine"));

    // Додавання тестових тварин
    animalRepository.save(new Animal(null, "Tiger", mammals, bigCats, male, ukraine, LocalDate.now(), "tiger.jpg"));
    animalRepository.save(new Animal(null, "Lion", mammals, bigCats, male, ukraine, LocalDate.now(), "lion.jpg"));
}

    @Test
    void testFindAllWithPagination() {
        Pageable pageable = PageRequest.of(0, 2);
        Page<Animal> page = animalRepository.findAll(pageable);

        assertThat(page.getContent()).hasSize(2);
    }

    @Test
    void testFindByFamilyIdWithPagination() {
        Pageable pageable = PageRequest.of(0, 2);
        Page<Animal> page = animalRepository.findByFamilyId(mammals.getId(), pageable);

        assertThat(page.getContent()).hasSize(2);
    }

    @Test
    void testFindByCountryId() {
        List<Animal> animals = animalRepository.findByCountryId(ukraine.getId());

        assertThat(animals).hasSize(2);
    }

    @Test
    void testFindByName() {
        List<Animal> animals = animalRepository.findByName("Tiger");

        assertThat(animals).hasSize(1);
        assertThat(animals.get(0).getName()).isEqualTo("Tiger");
    }
}
