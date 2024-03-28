package knu.likelion12.BE_Session.domain.auth.controller;

import jakarta.validation.Valid;
import knu.likelion12.BE_Session.domain.auth.dto.request.LoginRequest;
import knu.likelion12.BE_Session.domain.auth.dto.response.LoginResponse;
import knu.likelion12.BE_Session.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest requestBody) {
        LoginResponse response = authService.login(requestBody);
        String authorization = response.token().grantType() + " " + response.token().accessToken();

        return ResponseEntity
                .status(HttpStatus.OK)
                .header(HttpHeaders.AUTHORIZATION, authorization)
                .body(response);
    }
}
