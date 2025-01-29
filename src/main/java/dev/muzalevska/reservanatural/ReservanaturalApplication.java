package dev.muzalevska.reservanatural;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;

// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ReservanaturalApplication {

	// http://localhost:8080/h2-console

	public static void main(String[] args) {
		
	// PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    // String hashedPassword = passwordEncoder.encode("password");
    // System.out.println(hashedPassword);

	// argfile dev.muzalevska.reservanatural.ReservanaturalApplication 
	// $2a$10$NcT4BjfW8k41MKg4qRC.MuYwGc7m3znEzjWWxI559Y7JYafGNJdM2

			SpringApplication.run(ReservanaturalApplication.class, args);
	}


		//class PasswordTest {
		//     public static void main(String[] args) {
		//         BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		//         String rawPassword = "password";
		//         String encodedPassword = encoder.encode(rawPassword);
		//         System.out.println("Encoded password: " + encodedPassword);
		//         System.out.println("Matches: " + encoder.matches(rawPassword, "$2a$10$NcT4BjfW8k41MKg4qRC.MuYwGc7m3znEzjWWxI559Y7JYafGNJdM2"));
		//     }
		//}
}
