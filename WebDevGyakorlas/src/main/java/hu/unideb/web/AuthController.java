package hu.unideb.web;

import hu.unideb.dto.*;
import hu.unideb.model.User;
import hu.unideb.repository.UserRepository;
import hu.unideb.security.JwtUtil;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
@AllArgsConstructor
public class AuthController {

    private final UserRepository repo;
    private final BCryptPasswordEncoder encoder;
    private final JwtUtil jwt;


    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterRequest req) {

        if (repo.existsByUsername(req.username)) {

            return new ResponseEntity("A felhasználónév már foglalt!", HttpStatus.CONFLICT);
        }

        User u = new User();
        u.setUsername(req.username);
        u.setPassword(encoder.encode(req.password));
        repo.save(u);


        return ResponseEntity.ok().build();
    }



    @PostMapping("/login")

    public ResponseEntity<?> login(@RequestBody AuthRequest req) {

        var user = repo.findByUsername(req.username).orElse(null);

        if (user == null || !encoder.matches(req.password, user.getPassword())) {

            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }

        String token = jwt.generateToken(req.username);

        return ResponseEntity.ok(new TokenResponse(token));
    }
}