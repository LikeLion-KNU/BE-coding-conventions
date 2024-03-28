package knu.likelion12.BE_Session.domain.team.repository;

import knu.likelion12.BE_Session.domain.team.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
