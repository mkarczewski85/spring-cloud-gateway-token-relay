package dev.karczewski.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/token")
public class TokenController {

    @GetMapping("/decode")
    public Mono<Map<String, Object>> decodeToken(@AuthenticationPrincipal Jwt jwt) {
        return Mono.just(Map.of(
                "claims", jwt.getClaims(),
                "headers", jwt.getHeaders(),
                "tokenValue", jwt.getTokenValue()
        ));
    }

    @GetMapping("/decode-claims")
    public Mono<Map<String, Object>> decodeTokenClaims(@AuthenticationPrincipal Jwt jwt) {
        return Mono.just(jwt.getClaims());
    }

    @GetMapping("/decode-full")
    public Mono<Jwt> decodeTokenFull(@AuthenticationPrincipal Jwt jwt) {
        return Mono.just(jwt);
    }
}
