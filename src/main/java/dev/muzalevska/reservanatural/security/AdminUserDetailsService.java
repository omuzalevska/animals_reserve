package dev.muzalevska.reservanatural.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AdminUserDetailsService {

    private final PasswordEncoder passwordEncoder;

    public AdminUserDetailsService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        System.out.println("AdminUserDetailsService is loading...");// test
        UserDetails admin = User.withUsername("admin")
            .password(passwordEncoder.encode("password")) // Генеруємо 
            //.password("$2a$10$NcT4BjfW8k41MKg4qRC.MuYwGc7m3znEzjWWxI559Y7JYafGNJdM2") // password
            .roles("ADMIN")
            .build();

        return new InMemoryUserDetailsManager(admin);
    }

    // @Bean
    // public UserDetailsService userDetailsService() {
    //     UserDetails admin = User.withUsername("admin")
    //         //.password("$2a$10$XhFQO5cP1uI8JzJbZGvebOrklWz9vi.FOqAxqjL9bq7XeQFgVCzXa") // "password" 
    //         .password("$2a$10$NcT4BjfW8k41MKg4qRC.MuYwGc7m3znEzjWWxI559Y7JYafGNJdM2")
    //         //.password("YWRtaW46cGFzc3dvcmQ=")
    //         .roles("ADMIN")
    //         // .hasAuthority("ROLE_ADMIN")
    //         .build();
    //     return new InMemoryUserDetailsManager(admin);
    // }
}

// package dev.muzalevska.reservanatural.security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;

// @Configuration
// public class AdminUserDetailsService {

//     private final PasswordEncoder passwordEncoder;

//     public AdminUserDetailsService(PasswordEncoder passwordEncoder) {
//         this.passwordEncoder = passwordEncoder;
//     }

//     @Bean
//     public UserDetailsService userDetailsService() {
//         System.out.println("AdminUserDetailsService is loading...");// test
//         UserDetails admin = User.withUsername("admin")
//             .password(passwordEncoder.encode("password")) // Генеруємо 
//             //.password("$2a$10$NcT4BjfW8k41MKg4qRC.MuYwGc7m3znEzjWWxI559Y7JYafGNJdM2") // password
//             .roles("ADMIN")
//             .build();

//         return new InMemoryUserDetailsManager(admin);
//     }

//     // @Bean
//     // public UserDetailsService userDetailsService() {
//     //     UserDetails admin = User.withUsername("admin")
//     //         //.password("$2a$10$XhFQO5cP1uI8JzJbZGvebOrklWz9vi.FOqAxqjL9bq7XeQFgVCzXa") // "password" 
//     //         .password("$2a$10$NcT4BjfW8k41MKg4qRC.MuYwGc7m3znEzjWWxI559Y7JYafGNJdM2")
//     //         //.password("YWRtaW46cGFzc3dvcmQ=")
//     //         .roles("ADMIN")
//     //         // .hasAuthority("ROLE_ADMIN")
//     //         .build();
//     //     return new InMemoryUserDetailsManager(admin);
//     // }
// }
