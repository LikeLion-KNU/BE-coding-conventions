package knu.likelion12.BE_Session.domain.member.dto.response;


import knu.likelion12.BE_Session.domain.member.entity.Member;
import lombok.Builder;

@Builder
public record MemberResponse(
        Long memberId, String email, String role,
        String name, boolean expired, boolean locked
) {
    public static MemberResponse from(Member member) {
        return MemberResponse.builder()
                .memberId(member.getMemberId())
                .email(member.getEmail())
                .role(member.getRole().name())
                .name(member.getName())
                .expired(member.isAccountExpired())
                .locked(member.isAccountLocked())
                .build();
    }
}