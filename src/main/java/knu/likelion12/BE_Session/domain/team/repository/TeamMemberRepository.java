package knu.likelion12.BE_Session.domain.team.repository;

import knu.likelion12.BE_Session.domain.team.entity.Team;
import knu.likelion12.BE_Session.domain.team.entity.TeamMember;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {
    @EntityGraph(attributePaths = "member")
    List<TeamMember> findAllByTeam(Team team);
}
