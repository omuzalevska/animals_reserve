package dev.muzalevska.reservanatural.repository;

import dev.muzalevska.reservanatural.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    // методи для фільтрації
}
