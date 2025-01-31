package dev.muzalevska.reservanatural.family;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

// import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class FamilyControllerTest {

    private MockMvc mockMvc;

    @Mock
    private FamilyService familyService;

    @Mock
    private FamilyRepository familyRepository;

    @InjectMocks
    private FamilyController familyController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(familyController).build();
    }

    // @Test
    // void getAllFamilies_ShouldReturnListOfFamilies() throws Exception {
    //     when(familyRepository.findAll()).thenReturn(Arrays.asList(new Family(3L, "Felidae"), new Family(2L, "Canidae")));

    //     mockMvc.perform(get("/api/families"))
    //             .andExpect(status().isOk())
    //             .andExpect(jsonPath("$.size()").value(2))
    //             .andExpect(jsonPath("$[0].name").value("Felidae"))
    //             .andExpect(jsonPath("$[1].name").value("Canidae"));

    //     verify(familyRepository, times(1)).findAll();
    // }

    @Test
    void getFamilyById_ShouldReturnFamily() throws Exception {
        when(familyRepository.findById(1L)).thenReturn(Optional.of(new Family(1L, "Felidae")));

        mockMvc.perform(get("/api/families/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Felidae"));

        verify(familyRepository, times(1)).findById(1L);
    }

    // @Test
    // void createFamily_ShouldReturnCreatedFamily() throws Exception {
    //     // FamilyDTO newFamilyDTO = new FamilyDTO(null, "Ursidae");
    //     FamilyDTO savedFamilyDTO = new FamilyDTO(1L, "Ursidae");

    //     when(familyService.save(any(FamilyDTO.class))).thenReturn(savedFamilyDTO);

    //     mockMvc.perform(post("/api/families")
    //                     .contentType(MediaType.APPLICATION_JSON)
    //                     .content("{\"name\": \"Ursidae\"}"))
    //             .andExpect(status().isCreated())
    //             .andExpect(jsonPath("$.name").value("Ursidae"));

    //     verify(familyService, times(1)).save(any(FamilyDTO.class));
    // }

    @Test
    void createFamily_ShouldReturnCreatedFamily() throws Exception {
        FamilyDTO savedFamilyDTO = new FamilyDTO(1L, "Ursidae");

        when(familyService.save(any(FamilyDTO.class))).thenReturn(savedFamilyDTO);

        mockMvc.perform(post("/api/families")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON) // Додали accept
                        .content("{\"name\": \"Ursidae\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Ursidae"));

        verify(familyService, times(1)).save(any(FamilyDTO.class));
    }

    // @Test
    // void updateFamily_ShouldReturnUpdatedFamily() throws Exception {
    //     Family existingFamily = new Family(1L, "Felidae");
    //     when(familyRepository.findById(1L)).thenReturn(Optional.of(existingFamily));
    //     when(familyRepository.save(any(Family.class))).thenReturn(new Family(1L, "Canidae"));

    //     mockMvc.perform(put("/api/families/1")
    //                     .contentType(MediaType.APPLICATION_JSON)
    //                     .accept(MediaType.APPLICATION_JSON) // Додали accept
    //                     .content("{\"name\": \"Canidae\"}"))
    //             .andExpect(status().isOk())
    //             .andExpect(jsonPath("$.name").value("Canidae"));

    //     verify(familyRepository, times(1)).findById(1L);
    //     verify(familyRepository, times(1)).save(any(Family.class));
    // }

    @Test
    void deleteFamily_ShouldReturnNoContent() throws Exception {
        doNothing().when(familyRepository).deleteById(1L);

        mockMvc.perform(delete("/api/families/1"))
                .andExpect(status().isOk());

        verify(familyRepository, times(1)).deleteById(1L);
    }
}
