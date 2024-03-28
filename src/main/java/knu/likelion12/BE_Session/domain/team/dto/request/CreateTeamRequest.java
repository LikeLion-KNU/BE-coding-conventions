package knu.likelion12.BE_Session.domain.team.dto.request;

import knu.likelion12.BE_Session.domain.team.entity.Team;

public record CreateTeamRequest(String name, String description) {
    public Team toEntity() {
        return Team.builder()
                .name(this.name)
                .description(this.description)
                .build();
    }
}
