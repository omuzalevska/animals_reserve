package dev.muzalevska.reservanatural.type;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import dev.muzalevska.reservanatural.family.Family;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TypeController.class)
class TypeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("removal")
    @MockBean
    private TypeService typeService;

    @SuppressWarnings("removal")
    @MockBean
    private TypeRepository typeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllTypes_ShouldReturnListOfTypes() throws Exception {
        when(typeRepository.findAll()).thenReturn(Arrays.asList(
                new Type(1L, "Mammal", new Family(1L, "Felidae")),
                new Type(2L, "Bird", new Family(2L, "Aves"))
        ));

        mockMvc.perform(get("/api/types"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].name").value("Mammal"))
                .andExpect(jsonPath("$[1].name").value("Bird"));

        verify(typeRepository, times(1)).findAll();
    }

    @Test
    void getTypeById_ShouldReturnType() throws Exception {
        when(typeRepository.findById(1L)).thenReturn(Optional.of(new Type(1L, "Mammal", new Family(1L, "Felidae"))));

        mockMvc.perform(get("/api/types/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Mammal"));

        verify(typeRepository, times(1)).findById(1L);
    }

    @Test
    void createType_ShouldReturnCreatedType() throws Exception {
        // TypeDTO newTypeDTO = new TypeDTO(null, "Reptile", 1L);
        TypeDTO savedTypeDTO = new TypeDTO(1L, "Reptile", 1L);

        when(typeService.save(any(TypeDTO.class))).thenReturn(savedTypeDTO);

        mockMvc.perform(post("/api/types")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Reptile\", \"familyId\": 1}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Reptile"));

        verify(typeService, times(1)).save(any(TypeDTO.class));
    }

    @Test
    void updateType_ShouldReturnUpdatedType() throws Exception {
        Family family = new Family(1L, "Felidae");
        Type existingType = new Type(1L, "Mammal", family);
        when(typeRepository.findById(1L)).thenReturn(Optional.of(existingType));
        when(typeRepository.save(any(Type.class))).thenReturn(new Type(1L, "Amphibian", family));

        mockMvc.perform(put("/api/types/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 1, \"name\": \"Amphibian\", \"familyId\": 1}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Amphibian"));

        verify(typeRepository, times(1)).findById(1L);
        verify(typeRepository, times(1)).save(any(Type.class));
    }

    @Test
    void deleteType_ShouldReturnNoContent() throws Exception {
        doNothing().when(typeRepository).deleteById(1L);

        mockMvc.perform(delete("/api/types/1"))
                .andExpect(status().isOk());

        verify(typeRepository, times(1)).deleteById(1L);
    }
}
