package hu.unideb.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface BrainrotController {
    @GetMapping("/api/brainrot")
    ResponseEntity<byte[]> getBrainrot();
}
