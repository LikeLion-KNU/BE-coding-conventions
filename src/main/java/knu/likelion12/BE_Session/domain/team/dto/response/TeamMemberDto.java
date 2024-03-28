package knu.likelion12.BE_Session.domain.team.dto.response;

import lombok.Builder;

@Builder
public record TeamMemberDto(Long memberId, String name) {
}
