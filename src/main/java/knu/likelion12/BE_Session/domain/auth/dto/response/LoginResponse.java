package knu.likelion12.BE_Session.domain.auth.dto.response;

import jakarta.validation.constraints.NotNull;
import knu.likelion12.BE_Session.domain.member.dto.response.MemberResponse;
import knu.likelion12.BE_Session.domain.member.entity.Member;
import lombok.Builder;

@Builder
public record LoginResponse(
        @NotNull MemberResponse memberResponse,
        @NotNull Token token
) {
    public static LoginResponse from(Member member, Token token) {
        return LoginResponse.builder()
                .memberResponse(MemberResponse.from(member))
                .token(token)
                .build();
    }
}