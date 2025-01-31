package dev.muzalevska.reservanatural.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class SecurityConfigTest {

    @Autowired
    private MockMvc mockMvc;

    // Тестуємо доступ до публічних ресурсів
    @Test
    public void testPublicAccess() throws Exception {
        mockMvc.perform(get("/api/animals/public/"))
                .andExpect(status().isOk());  // Має бути доступний для всіх
    }

    // Тестуємо доступ до приватних ресурсів для користувача з роллю ADMIN
    @Test
    @WithMockUser(roles = "ADMIN")
    public void testPrivateAccessForAdmin() throws Exception {
        mockMvc.perform(get("/api/animals/private/"))
                .andExpect(status().isOk());  // Доступно для ADMIN
    }

    // Тестуємо доступ до приватних ресурсів для користувача без ролі ADMIN
    @Test
    @WithMockUser(roles = "USER")
    public void testPrivateAccessForNonAdmin() throws Exception {
        mockMvc.perform(get("/api/animals/private/"))
                .andExpect(status().isForbidden());  // Доступ заборонено для звичайного користувача
    }

    // Тестуємо доступ до H2 Console без аутентифікації
    @Test
    public void testH2ConsoleAccess() throws Exception {
        mockMvc.perform(get("/h2-console/"))
                .andExpect(status().isOk());  // Доступно без аутентифікації
    }

    // Тестуємо доступ до інших сторінок з аутентифікацією
    @Test
    public void testDefaultAuthRequired() throws Exception {
        mockMvc.perform(get("/api/animals/private/"))
                .andExpect(status().isUnauthorized());  // Без аутентифікації доступ заборонений
    }
}
