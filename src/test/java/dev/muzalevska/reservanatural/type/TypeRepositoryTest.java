package dev.muzalevska.reservanatural.type;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TypeRepositoryTest {

    @Autowired
    private TypeRepository typeRepository;

    @Test
    void testFindById() {
        // Save a test type
        Type type = new Type(1L, "Test Type", null);
        typeRepository.save(type);

        // Test find by ID
        Type foundType = typeRepository.findById(1L).orElse(null);

        assertNotNull(foundType);
        assertEquals("Test Type", foundType.getName());
    }

    // Add additional tests for other repository methods
}
