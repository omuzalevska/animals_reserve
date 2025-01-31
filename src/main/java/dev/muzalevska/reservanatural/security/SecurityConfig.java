package dev.muzalevska.reservanatural.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

// import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors(withDefaults())
            .csrf(csrf -> csrf.disable()) // Вимикаємо CSRF для JWT
            .formLogin(form -> form.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
                // Обмежуємо доступ для методів тільки для ролі ADMIN
                .requestMatchers("/api/animals/private/**").hasRole("ADMIN")
                // Публічний доступ для всіх інших методів
                .requestMatchers("/api/animals/public/**").permitAll()
                .requestMatchers(HttpMethod.PUT, "/api/animals/").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/api/animals/").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/animals/").hasRole("ADMIN")
                .anyRequest().authenticated()) // Всі інші запити повинні бути аутентифіковані
            .httpBasic(withDefaults()) // Basic Auth (можна замінити на JWT)
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));
            
            http.headers(header -> header.frameOptions(frame-> frame.sameOrigin()));
       
            return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}