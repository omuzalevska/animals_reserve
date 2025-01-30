package dev.muzalevska.reservanatural.animal;

// import dev.muzalevska.reservanatural.entity.Animal;
// import dev.muzalevska.reservanatural.entity.Country;
// import dev.muzalevska.reservanatural.entity.Family;
// import dev.muzalevska.reservanatural.entity.Gender;
// import dev.muzalevska.reservanatural.entity.Type;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// import java.time.LocalDate;
// import java.util.List;

// import static org.junit.jupiter.api.Assertions.*;

// @DataJpaTest
class AnimalRepositoryTest {

    // @Autowired
    // private AnimalRepository animalRepository;
    // @Autowired
    // private FamilyRepository familyRepository;
    // @Autowired
    // private TypeRepository typeRepository;
    // @Autowired
    // private CountryRepository countryRepository;


    // @Test
    // void testSaveAndFindById() {
    //     Animal animal = new Animal(null, "Tiger", null, null, Gender.M, null, LocalDate.now(), "url");
    //     Animal savedAnimal = animalRepository.save(animal);
    //     assertNotNull(savedAnimal.getId());

    //     Animal foundAnimal = animalRepository.findById(savedAnimal.getId()).orElse(null);
    //     assertNotNull(foundAnimal);
    //     assertEquals("Tiger", foundAnimal.getName());
    // }

    // @Test
    // void testFindByName() {
    // Family family = new Family();
    // family.setName("Felidae");
    // family = familyRepository.save(family); // Збереження в базу

    // Type type = new Type();
    // type.setName("Mammal");
    // type = typeRepository.save(type);

    // Country country = new Country();
    // country.setName("India");
    // country = countryRepository.save(country);

    // Animal animal = new Animal(null, "Tiger", family, type, Gender.M, country, LocalDate.now(), "url");
    // animalRepository.save(animal);

    // List<Animal> foundAnimals = animalRepository.findByName("Tiger");
    // assertFalse(foundAnimals.isEmpty());
    // }

}
