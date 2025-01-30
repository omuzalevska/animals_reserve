package dev.muzalevska.reservanatural.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    // JpaRepository автоматично створює всі необхідні CRUD-операції без написання SQL-коду:
    // - findAll()
    // - findById()
    // - save()
    // - deleteById()
    // ...
}