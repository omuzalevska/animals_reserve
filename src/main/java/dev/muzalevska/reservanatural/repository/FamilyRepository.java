package dev.muzalevska.reservanatural.repository;

import dev.muzalevska.reservanatural.entity.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRepository extends JpaRepository<Family, Long> {
    //методи для фільтрації
}