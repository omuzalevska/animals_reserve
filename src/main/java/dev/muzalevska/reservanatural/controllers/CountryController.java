package dev.muzalevska.reservanatural.controllers;

import dev.muzalevska.reservanatural.entity.Country;
import dev.muzalevska.reservanatural.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    // Отримати всі країни
    @GetMapping
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    // Додати нову країну
    @PostMapping
    public Country createCountry(@RequestBody Country country) {
        return countryRepository.save(country);
    }

    // Отримати країну за ID
    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable Long id) {
        return countryRepository.findById(id).orElseThrow(() -> new RuntimeException("Country not found"));
    }

    // Оновити країну
    @PutMapping("/{id}")
    public Country updateCountry(@PathVariable Long id, @RequestBody Country updatedCountry) {
        Country country = countryRepository.findById(id).orElseThrow(() -> new RuntimeException("Country not found"));
        country.setName(updatedCountry.getName());
        return countryRepository.save(country);
    }

    // Видалити країну
    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable Long id) {
        countryRepository.deleteById(id);
    }
}

