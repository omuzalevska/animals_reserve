package dev.muzalevska.reservanatural.type;

// import dev.muzalevska.reservanatural.type.TypeController;
// import dev.muzalevska.reservanatural.type.TypeService;
// import dev.muzalevska.reservanatural.type.TypeDTO;
// import dev.muzalevska.reservanatural.type.TypeRepository;
// import dev.muzalevska.reservanatural.type.Type;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)  // Забезпечує ініціалізацію моків
class TypeControllerTest {

    @Mock
    private TypeService typeService;  // Мок сервісу

    @Mock
    private TypeRepository typeRepository;  // Мок репозиторію

    @InjectMocks
    private TypeController typeController;  // Контролер, до якого ми інжектимо моки

    private MockMvc mockMvc;

    public TypeControllerTest() {
        // Ініціалізація MockMvc для тестування контролера
        this.mockMvc = MockMvcBuilders.standaloneSetup(typeController).build();
    }

    @Test
    void testGetAllTypes() throws Exception {
        // Моковані дані
        Type type1 = new Type(1L, "Type1", null);
        Type type2 = new Type(2L, "Type2", null);

        // Мокаємо поведінку репозиторію
        when(typeRepository.findAll()).thenReturn(List.of(type1, type2));

        mockMvc.perform(get("/api/types"))  // Виконання запиту до контролера
                .andExpect(status().isOk())  // Перевірка статусу відповіді
                .andExpect(jsonPath("$[0].name").value("Type1"))  // Перевірка значення поля "name" для першого елемента
                .andExpect(jsonPath("$[1].name").value("Type2"));  // Перевірка значення поля "name" для другого елемента

        verify(typeRepository, times(1)).findAll();  // Перевірка, що метод findAll() був викликаний 1 раз
    }

    @Test
    void testCreateType() throws Exception {
        // Моковані дані для створення нового типу
        TypeDTO typeDTO = new TypeDTO(1L, "New Type", 1L);
        when(typeService.save(typeDTO)).thenReturn(typeDTO);  // Мокаємо сервіс

        mockMvc.perform(post("/api/types")  // Запит на створення нового типу
                .contentType(MediaType.APPLICATION_JSON)  // Вказуємо тип контенту JSON
                .content("{\"id\": 1, \"name\": \"New Type\", \"familyId\": 1}"))  // Тіло запиту
                .andExpect(status().isCreated())  // Перевірка, що статус відповіді 201 (Created)
                .andExpect(jsonPath("$.name").value("New Type"));  // Перевірка, що в відповіді є правильне ім'я

        verify(typeService, times(1)).save(typeDTO);  // Перевірка, що метод save() сервісу був викликаний один раз
    }

    // Додати інші тести для методів update, delete і т.д.
}
