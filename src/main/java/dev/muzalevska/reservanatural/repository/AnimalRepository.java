package dev.muzalevska.reservanatural.repository;

import dev.muzalevska.reservanatural.entity.Animal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findByName(String name);
}
