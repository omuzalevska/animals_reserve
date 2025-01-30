package dev.muzalevska.reservanatural.animal;

import dev.muzalevska.reservanatural.country.Country;
import dev.muzalevska.reservanatural.country.CountryRepository;
import dev.muzalevska.reservanatural.family.Family;
import dev.muzalevska.reservanatural.family.FamilyRepository;
import dev.muzalevska.reservanatural.type.Type;
import dev.muzalevska.reservanatural.type.TypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final FamilyRepository familyRepository;
    private final TypeRepository typeRepository;
    private final CountryRepository countryRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository, FamilyRepository familyRepository, TypeRepository typeRepository, CountryRepository countryRepository) {
        this.animalRepository = animalRepository;
        this.familyRepository = familyRepository;
        this.typeRepository = typeRepository;
        this.countryRepository = countryRepository;
    }

    // Отримати всі тварини
    public List<AnimalDTO> getAllAnimals() {
        List<Animal> animals = animalRepository.findAll();
        return animals.stream().map(AnimalDTO::new).collect(Collectors.toList());
    }

    // Додати нову тварину
    public AnimalDTO save(AnimalDTO animalDTO) {
        Family family = familyRepository.findById(animalDTO.getFamilyId())
                .orElseThrow(() -> new RuntimeException("Family not found"));
        Type type = typeRepository.findById(animalDTO.getTypeId())
                .orElseThrow(() -> new RuntimeException("Type not found"));
        Country country = countryRepository.findById(animalDTO.getCountryId())
                .orElseThrow(() -> new RuntimeException("Country not found"));

        Animal animal = new Animal();
        animal.setName(animalDTO.getName());
        animal.setFamily(family);
        animal.setType(type);
        animal.setGender(animalDTO.getGender());
        animal.setCountry(country);
        animal.setArrivalDate(animalDTO.getArrivalDate());
        animal.setPhotoUrl(animalDTO.getPhotoUrl());

        Animal savedAnimal = animalRepository.save(animal);
        return new AnimalDTO(savedAnimal);
    }

    // Отримати тварину за ID
    public AnimalDTO getAnimalById(Long id) {
        Animal animal = animalRepository.findById(id).orElseThrow(() -> new RuntimeException("Animal not found"));
        return new AnimalDTO(animal);
    }

    // Оновити тварину
    public AnimalDTO update(Long id, AnimalDTO updatedAnimalDTO) {
        Animal animal = animalRepository.findById(id).orElseThrow(() -> new RuntimeException("Animal not found"));

        Family family = familyRepository.findById(updatedAnimalDTO.getFamilyId())
                .orElseThrow(() -> new RuntimeException("Family not found"));
        Type type = typeRepository.findById(updatedAnimalDTO.getTypeId())
                .orElseThrow(() -> new RuntimeException("Type not found"));
        Country country = countryRepository.findById(updatedAnimalDTO.getCountryId())
                .orElseThrow(() -> new RuntimeException("Country not found"));

        animal.setName(updatedAnimalDTO.getName());
        animal.setFamily(family);
        animal.setType(type);
        animal.setGender(updatedAnimalDTO.getGender());
        animal.setCountry(country);
        animal.setArrivalDate(updatedAnimalDTO.getArrivalDate());
        animal.setPhotoUrl(updatedAnimalDTO.getPhotoUrl());

        Animal updatedAnimal = animalRepository.save(animal);
        return new AnimalDTO(updatedAnimal);
    }

    // Видалити тварину
    public void delete(Long id) {
        animalRepository.deleteById(id);
    }
}
