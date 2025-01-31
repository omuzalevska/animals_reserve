package dev.muzalevska.reservanatural.country;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

@DataJpaTest
class CountryRepositoryTest {

    @Autowired
    private CountryRepository countryRepository;

    @Test
    void testSaveAndFindById() {
   
        Country country = new Country(null, "Ukraine");
        Country savedCountry = countryRepository.save(country);

        assertThat(savedCountry.getId()).isNotNull();

        Optional<Country> foundCountry = countryRepository.findById(savedCountry.getId());
        assertThat(foundCountry).isPresent();
        assertThat(foundCountry.get().getName()).isEqualTo("Ukraine");
    }

    @Test
    void testFindAll() {

        countryRepository.deleteAll();
        countryRepository.save(new Country(null, "Ukraine"));
        countryRepository.save(new Country(null, "Poland"));

        List<Country> countries = countryRepository.findAll();

        assertThat(countries).hasSize(2);
    }

    @Test
    void testUpdateCountry() {

        Country country = countryRepository.save(new Country(null, "Ukraine"));

        country.setName("France");
        Country updatedCountry = countryRepository.save(country);

        assertThat(updatedCountry.getName()).isEqualTo("France");
    }

    @Test
    void testDeleteCountry() {
        Country country = countryRepository.save(new Country(null, "Ukraine"));

        countryRepository.deleteById(country.getId());

        Optional<Country> deletedCountry = countryRepository.findById(country.getId());
        assertThat(deletedCountry).isEmpty();
    }
}