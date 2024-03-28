package knu.likelion12.BE_Session.domain.auth.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record Token(
        @NotNull String grantType,
        @NotNull String accessToken
) {
}