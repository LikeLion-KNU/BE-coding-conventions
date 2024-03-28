package knu.likelion12.BE_Session.domain.team.dto.response;

import knu.likelion12.BE_Session.domain.team.entity.Team;
import knu.likelion12.BE_Session.domain.team.entity.TeamMember;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

@Builder
public record TeamResponse(Long teamId, String name, String description, List<TeamMemberDto> teamMemberDto) {
    public static TeamResponse from(Team team, List<TeamMember> teamMembers) {
        List<TeamMemberDto> teamMemberDtos = teamMembers.stream()
                .map(teamMember -> TeamMemberDto.builder()
                        .memberId(teamMember.getMember().getMemberId())
                        .name(teamMember.getMember().getName())
                        .build())
                .collect(Collectors.toList());

        return TeamResponse.builder()
                .teamId(team.getTeamId())
                .name(team.getName())
                .description(team.getDescription())
                .teamMemberDto(teamMemberDtos)
                .build();
    }

    public static TeamResponse from(Team team) {
        return TeamResponse.builder()
                .teamId(team.getTeamId())
                .name(team.getName())
                .description(team.getDescription())
                .build();
    }
}