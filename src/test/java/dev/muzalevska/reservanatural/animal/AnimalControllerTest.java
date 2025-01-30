package dev.muzalevska.reservanatural.animal;

// import dev.muzalevska.reservanatural.animal.AnimalController;
// import dev.muzalevska.reservanatural.animal.AnimalDTO;
// import dev.muzalevska.reservanatural.animal.AnimalService;
import dev.muzalevska.reservanatural.gender.Gender;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AnimalControllerTest {

    @InjectMocks
    private AnimalController animalController;

    @Mock
    private AnimalService animalService;

    private AnimalDTO animalDTO;

    @BeforeEach
    void setUp() {
        animalDTO = new AnimalDTO(1L, "Tiger", 1L, 1L, Gender.M, 1L, LocalDate.now(), "url");
    }

    @SuppressWarnings("null")
    @Test
    void getAllAnimals_ShouldReturnList() {
        when(animalService.getAllAnimals()).thenReturn(List.of(animalDTO));

        ResponseEntity<List<AnimalDTO>> response = animalController.getAllAnimals();

        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
        assertEquals("Tiger", response.getBody().get(0).getName());
    }

    @SuppressWarnings("null")
    @Test
    void getAnimalById_ShouldReturnAnimal() {
        when(animalService.getAnimalById(1L)).thenReturn(animalDTO);

        ResponseEntity<AnimalDTO> response = animalController.getAnimalById(1L);

        assertNotNull(response.getBody());
        assertEquals("Tiger", response.getBody().getName());
    }

    @SuppressWarnings({ "deprecation", "null" })
    @Test
    void createAnimal_ShouldReturnCreatedAnimal() {
        when(animalService.save(any(AnimalDTO.class))).thenReturn(animalDTO);

        ResponseEntity<AnimalDTO> response = animalController.createAnimal(animalDTO);

        assertEquals(201, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("Tiger", response.getBody().getName());
    }

    @SuppressWarnings("null")
    @Test
    void updateAnimal_ShouldReturnUpdatedAnimal() {
        when(animalService.update(eq(1L), any(AnimalDTO.class))).thenReturn(animalDTO);

        ResponseEntity<AnimalDTO> response = animalController.updateAnimal(1L, animalDTO);

        assertNotNull(response.getBody());
        assertEquals("Tiger", response.getBody().getName());
    }

    @SuppressWarnings("deprecation")
    @Test
    void deleteAnimal_ShouldReturnNoContent() {
        doNothing().when(animalService).delete(1L);

        ResponseEntity<Void> response = animalController.deleteAnimal(1L);

        assertEquals(204, response.getStatusCodeValue());
    }
}
