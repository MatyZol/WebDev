// src/main/java/hu/unideb/web/AuthController.java
package hu.unideb.web;

import hu.unideb.dto.*;
import hu.unideb.model.User;
import hu.unideb.repository.UserRepository;
import hu.unideb.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; // Import hozzáadása
import org.springframework.http.ResponseEntity; // Import hozzáadása
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired private UserRepository repo;
    @Autowired private BCryptPasswordEncoder encoder;
    @Autowired private JwtUtil jwt;


    @PostMapping("/register")
    // Visszatérési érték módosítva: TokenResponse helyett ResponseEntity<Void>
    public ResponseEntity<Void> register(@RequestBody RegisterRequest req) {
        // Helyes ellenőrzés
        if (repo.existsByUsername(req.username)) {
            // 409 Conflict a hibaüzenettel
            return new ResponseEntity("A felhasználónév már foglalt!", HttpStatus.CONFLICT);
        }

        User u = new User();
        u.setUsername(req.username);
        u.setPassword(encoder.encode(req.password));
        repo.save(u);

        // KIVÉVE: A token generálás és visszaküldés a regisztrációból!
        // String token = jwt.generateToken(req.username);

        // Visszatérési érték: 200 OK (vagy 201 Created) üres törzzsel
        return ResponseEntity.ok().build();
    }

//    @PostMapping("/register")
//    // Visszatérési típus módosítása ResponseEntity-re a megfelelő HTTP státuszhoz
//    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
//        if (repo.existsByUsername(req.username)) {
//            // Helyes RESTful hibakezelés: 409 Conflict (Már létező erőforrás)
//            return new ResponseEntity<>("User already exists", HttpStatus.CONFLICT);
//        }
//
//        User u = new User();
//        u.setUsername(req.username);
//        u.setPassword(encoder.encode(req.password));
//        repo.save(u);
//
//        String token = jwt.generateToken(req.username);
//        // Sikeres válasz: 200 OK és egy JSON objektum a tokennel, amit a frontend vár
//        return ResponseEntity.ok(new TokenResponse(token));
//    }

    @PostMapping("/login")
    // Visszatérési típus módosítása ResponseEntity-re
    public ResponseEntity<?> login(@RequestBody AuthRequest req) {
        // FindByUsername.orElseThrow() helyett használjunk ellenőrzést, 
        // hogy ne dobjon kivételt a Spring.
        var user = repo.findByUsername(req.username).orElse(null);

        if (user == null || !encoder.matches(req.password, user.getPassword())) {
            // 401 Unauthorized a hibás felhasználónév/jelszó esetén
            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }

        String token = jwt.generateToken(req.username);
        // Sikeres válasz: 200 OK és egy JSON objektum a tokennel
        return ResponseEntity.ok(new TokenResponse(token));
    }
}