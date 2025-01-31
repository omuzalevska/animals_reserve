package dev.muzalevska.reservanatural.country;

// import dev.muzalevska.reservanatural.country.Country;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class CountryControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CountryRepository countryRepository;

    @InjectMocks
    private CountryController countryController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(countryController).build();
    }

    @Test
    void getAllCountries_ShouldReturnListOfCountries() throws Exception {
        when(countryRepository.findAll()).thenReturn(Arrays.asList(new Country(1L, "Ukraine"), new Country(2L, "Poland")));

        mockMvc.perform(get("/api/countries"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].name").value("Ukraine"))
                .andExpect(jsonPath("$[1].name").value("Poland"));

        verify(countryRepository, times(1)).findAll();
    }

    @Test
    void getCountryById_ShouldReturnCountry() throws Exception {
        when(countryRepository.findById(1L)).thenReturn(Optional.of(new Country(1L, "Ukraine")));

        mockMvc.perform(get("/api/countries/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Ukraine"));

        verify(countryRepository, times(1)).findById(1L);
    }

    @Test
    void createCountry_ShouldReturnCreatedCountry() throws Exception {
        // Country newCountry = new Country(null, "Germany");
        when(countryRepository.save(any(Country.class))).thenReturn(new Country(1L, "Germany"));

        mockMvc.perform(post("/api/countries")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Germany\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Germany"));

        verify(countryRepository, times(1)).save(any(Country.class));
    }

    @Test
    void updateCountry_ShouldReturnUpdatedCountry() throws Exception {
        Country existingCountry = new Country(1L, "France");
        when(countryRepository.findById(1L)).thenReturn(Optional.of(existingCountry));
        when(countryRepository.save(any(Country.class))).thenReturn(new Country(1L, "Spain"));

        mockMvc.perform(put("/api/countries/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Spain\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Spain"));

        verify(countryRepository, times(1)).findById(1L);
        verify(countryRepository, times(1)).save(any(Country.class));
    }

    @Test
    void deleteCountry_ShouldReturnNoContent() throws Exception {
        doNothing().when(countryRepository).deleteById(1L);

        mockMvc.perform(delete("/api/countries/1"))
                .andExpect(status().isOk());

        verify(countryRepository, times(1)).deleteById(1L);
    }
}
