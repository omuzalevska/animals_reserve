package dev.muzalevska.reservanatural.family;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(FamilyController.class)
@ExtendWith(MockitoExtension.class)
class FamilyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("removal")
    @MockBean
    private FamilyService familyService;

    @SuppressWarnings("removal")
    @MockBean
    private FamilyRepository familyRepository;

    @SuppressWarnings("unused")
    @Autowired
    private ObjectMapper objectMapper; // Для конвертації JSON

    private Family testFamily;
    @SuppressWarnings("unused")
    private FamilyDTO testFamilyDTO;

    @BeforeEach
    void setUp() {
        testFamily = new Family(1L, "Mammals");
        testFamilyDTO = new FamilyDTO(1L, "Mammals");
    }

    @WithMockUser(username = "user", roles = "ADMIN")
    @Test
    void testGetAllFamilies() throws Exception {
        List<Family> families = Arrays.asList(testFamily);
        when(familyRepository.findAll()).thenReturn(families);

        mockMvc.perform(get("/api/families")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].id").value(testFamily.getId()))
                .andExpect(jsonPath("$[0].name").value(testFamily.getName()));
    }

    @WithMockUser(username = "user", roles = "ADMIN")
    @Test
    void testGetFamilyById() throws Exception {
        when(familyRepository.findById(1L)).thenReturn(Optional.of(testFamily));

        mockMvc.perform(get("/api/families/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(testFamily.getId()))
                .andExpect(jsonPath("$.name").value(testFamily.getName()));
    }

    // @WithMockUser(username = "user", roles = "ADMIN")
    // @Test
    // void testCreateFamily() throws Exception {
    //     when(familyService.save(any(FamilyDTO.class))).thenReturn(testFamilyDTO);

    //     mockMvc.perform(post("/api/families")
    //                     .contentType(MediaType.APPLICATION_JSON)
    //                     .content(objectMapper.writeValueAsString(testFamilyDTO)))
    //             .andExpect(status().isCreated())
    //             .andExpect(jsonPath("$.id").value(testFamilyDTO.getId()))
    //             .andExpect(jsonPath("$.name").value(testFamilyDTO.getName()));
    // }

    // @WithMockUser(username = "user", roles = "ADMIN")
    // @Test
    // void testUpdateFamily() throws Exception {
    //     Family updatedFamily = new Family(1L, "Birds");
    //     when(familyRepository.findById(1L)).thenReturn(Optional.of(testFamily));
    //     when(familyRepository.save(any(Family.class))).thenReturn(updatedFamily);

    //     mockMvc.perform(put("/api/families/1")
    //                     .with(csrf()) // додає CSRF-токен
    //                     .contentType(MediaType.APPLICATION_JSON)
    //                     .accept(MediaType.APPLICATION_JSON)
    //                     .content(objectMapper.writeValueAsString(updatedFamily)))
    //             .andExpect(status().isOk())
    //             .andExpect(jsonPath("$.id").value(updatedFamily.getId()))
    //             .andExpect(jsonPath("$.name").value(updatedFamily.getName()));
    // }

    @WithMockUser(username = "user", roles = "ADMIN")
    @Test
    void testDeleteFamily() throws Exception {
        Mockito.doNothing().when(familyRepository).deleteById(1L);

        mockMvc.perform(delete("/api/families/1")
                        .with(csrf()) // Додає CSRF-токен
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
