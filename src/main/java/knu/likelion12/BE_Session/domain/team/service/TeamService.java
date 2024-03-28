package knu.likelion12.BE_Session.domain.team.service;

import knu.likelion12.BE_Session.domain.team.dto.request.CreateTeamRequest;
import knu.likelion12.BE_Session.domain.team.dto.request.JoinTeamRequest;
import knu.likelion12.BE_Session.domain.team.dto.response.TeamResponse;
import knu.likelion12.BE_Session.domain.team.entity.Team;
import knu.likelion12.BE_Session.domain.team.entity.TeamMember;
import knu.likelion12.BE_Session.domain.team.repository.TeamMemberRepository;
import knu.likelion12.BE_Session.domain.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TeamService {
    private final TeamRepository teamRepository;
    private final TeamMemberRepository teamMemberRepository;

    @Transactional
    public TeamResponse createTeam(CreateTeamRequest request) {
        Team team = teamRepository.save(request.toEntity());
//        List<TeamMember> teamMember = teamMemberRepository.findAllByTeam(team);

        return TeamResponse.from(team);
    }

    public void joinTeam(JoinTeamRequest request) {

    }

    @Transactional
    public void deleteTeam(Long teamId) {
        teamRepository.deleteById(teamId);
    }

    public void getAllTeam() {

    }

    public void getTeamDetails() {

    }


}
