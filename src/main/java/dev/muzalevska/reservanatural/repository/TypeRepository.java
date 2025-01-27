package dev.muzalevska.reservanatural.repository;

import dev.muzalevska.reservanatural.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
    // методи для фільтрації
}
