package com.brzozowski.demo.token;

import com.brzozowski.demo.token.dto.TokenValidation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static io.vavr.API.*;
import static io.vavr.Predicates.is;

@RestController
@RequestMapping("/api/tokens")
class TokenResource {

    @GetMapping
    TokenValidation validateToken(@RequestParam String token) {
        return Match(token).of(
                Case($(is("VALID")), () -> new TokenValidation.TokenValid("1")),
                Case($(), () -> TokenValidation.TokenInvalid.INSTANCE)
        );
    }
}
