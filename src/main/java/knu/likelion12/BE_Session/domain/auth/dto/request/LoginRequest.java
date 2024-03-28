package knu.likelion12.BE_Session.domain.auth.dto.request;

import jakarta.validation.constraints.NotNull;

public record LoginRequest(
    @NotNull String email,
    @NotNull String password
) {
}