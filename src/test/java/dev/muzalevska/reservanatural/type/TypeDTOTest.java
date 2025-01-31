package dev.muzalevska.reservanatural.type;

// import dev.muzalevska.reservanatural.type.TypeDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TypeDTOTest {

    @Test
    void testTypeDTOConstructorAndGetters() {
        TypeDTO typeDTO = new TypeDTO(1L, "Type1", 1L);

        assertEquals(1L, typeDTO.getId());
        assertEquals("Type1", typeDTO.getName());
        assertEquals(1L, typeDTO.getFamilyId());
    }

    @Test
    void testTypeDTOSetters() {
        TypeDTO typeDTO = new TypeDTO();
        typeDTO.setId(2L);
        typeDTO.setName("Updated Type");
        typeDTO.setFamilyId(2L);

        assertEquals(2L, typeDTO.getId());
        assertEquals("Updated Type", typeDTO.getName());
        assertEquals(2L, typeDTO.getFamilyId());
    }
}

