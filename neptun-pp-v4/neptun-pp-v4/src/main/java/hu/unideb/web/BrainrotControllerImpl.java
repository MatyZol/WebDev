package hu.unideb.web;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Objects;

@RestController
public class BrainrotControllerImpl
        implements BrainrotController {

    @Override
    public ResponseEntity<byte[]> getBrainrot() {
        final var headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        try {
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(IOUtils.toByteArray(
                            Objects.requireNonNull(
                                    getClass().getResourceAsStream(
                                            "/img.png"
                                    ))
                    ));
        } catch (Exception e) {
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }
}
