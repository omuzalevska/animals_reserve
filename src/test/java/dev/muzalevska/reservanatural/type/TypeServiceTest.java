package dev.muzalevska.reservanatural.type;

import dev.muzalevska.reservanatural.family.Family;
import dev.muzalevska.reservanatural.family.FamilyRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TypeServiceTest {

    @Mock
    private TypeRepository typeRepository;

    @Mock
    private FamilyRepository familyRepository;

    @InjectMocks
    private TypeService typeService;

    @Test
    void testSaveType() {
        // Mock data
        Long familyId = 1L;
        TypeDTO typeDTO = new TypeDTO(1L, "Type1", familyId);
        Family family = new Family();
        family.setId(familyId);
        
        // Mock repository interactions
        when(familyRepository.findById(familyId)).thenReturn(Optional.of(family));
        when(typeRepository.save(any(Type.class))).thenReturn(new Type(1L, "Type1", family));

        // Test save
        TypeDTO savedType = typeService.save(typeDTO);

        assertNotNull(savedType);
        assertEquals("Type1", savedType.getName());
        verify(familyRepository, times(1)).findById(familyId);
        verify(typeRepository, times(1)).save(any(Type.class));
    }

    // Add additional tests for error scenarios like family not found
}
