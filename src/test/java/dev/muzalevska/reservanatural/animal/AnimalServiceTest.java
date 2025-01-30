package dev.muzalevska.reservanatural.animal;

// import dev.muzalevska.reservanatural.animal.Animal;
// import dev.muzalevska.reservanatural.animal.AnimalDTO;
// import dev.muzalevska.reservanatural.animal.AnimalRepository;
// import dev.muzalevska.reservanatural.animal.AnimalService;
import dev.muzalevska.reservanatural.country.Country;
import dev.muzalevska.reservanatural.country.CountryRepository;
import dev.muzalevska.reservanatural.family.Family;
import dev.muzalevska.reservanatural.family.FamilyRepository;
import dev.muzalevska.reservanatural.gender.*;
// import dev.muzalevska.reservanatural.repository.*;
import dev.muzalevska.reservanatural.type.Type;
import dev.muzalevska.reservanatural.type.TypeRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AnimalServiceTest {

    @InjectMocks
    private AnimalService animalService;

    @Mock
    private AnimalRepository animalRepository;
    @Mock
    private FamilyRepository familyRepository;
    @Mock
    private TypeRepository typeRepository;
    @Mock
    private CountryRepository countryRepository;

    private Animal animal;
    private AnimalDTO animalDTO;

    @BeforeEach
    void setUp() {
        Family family = new Family();
        family.setId(1L);

        Type type = new Type();
        type.setId(1L);

        Country country = new Country();
        country.setId(1L);

        animal = new Animal(1L, "Tiger", family, type, Gender.M, country, LocalDate.now(), "url");

        animalDTO = new AnimalDTO(1L, "Tiger", 1L, 1L, Gender.M, 1L, LocalDate.now(), "url");
    }

    @Test
    void getAllAnimals_ShouldReturnList() {
        when(animalRepository.findAll()).thenReturn(List.of(animal));

        List<AnimalDTO> result = animalService.getAllAnimals();

        assertEquals(1, result.size());
        assertEquals("Tiger", result.get(0).getName());
    }

    @Test
    void getAnimalById_ShouldReturnAnimal() {
        when(animalRepository.findById(1L)).thenReturn(Optional.of(animal));

        AnimalDTO result = animalService.getAnimalById(1L);

        assertNotNull(result);
        assertEquals("Tiger", result.getName());
    }

    @Test
    void save_ShouldCreateAnimal() {
        when(familyRepository.findById(1L)).thenReturn(Optional.of(new Family()));
        when(typeRepository.findById(1L)).thenReturn(Optional.of(new Type()));
        when(countryRepository.findById(1L)).thenReturn(Optional.of(new Country()));
        when(animalRepository.save(any(Animal.class))).thenReturn(animal);

        AnimalDTO result = animalService.save(animalDTO);

        assertNotNull(result);
        assertEquals("Tiger", result.getName());
    }

    @Test
    void update_ShouldModifyAnimal() {
        when(animalRepository.findById(1L)).thenReturn(Optional.of(animal));
        when(familyRepository.findById(1L)).thenReturn(Optional.of(new Family()));
        when(typeRepository.findById(1L)).thenReturn(Optional.of(new Type()));
        when(countryRepository.findById(1L)).thenReturn(Optional.of(new Country()));
        when(animalRepository.save(any(Animal.class))).thenReturn(animal);

        AnimalDTO result = animalService.update(1L, animalDTO);

        assertNotNull(result);
        assertEquals("Tiger", result.getName());
    }

    @Test
    void delete_ShouldRemoveAnimal() {
        doNothing().when(animalRepository).deleteById(1L);

        assertDoesNotThrow(() -> animalService.delete(1L));

        verify(animalRepository, times(1)).deleteById(1L);
    }
}
