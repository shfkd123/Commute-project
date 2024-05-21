package com.mini.commute.domain.team;

import com.mini.commute.dto.team.response.TeamListInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query(value = "SELECT " +
            "t.name AS name, " +
            "COUNT(e.team_id) AS memberCount, " +
            "m.name AS managerName " +
            "FROM team t " +
            "LEFT JOIN employee e ON t.id = e.team_id " +
            "LEFT JOIN employee m ON t.id = m.team_id AND m.role_id = 2 " +
            "GROUP BY t.name, m.name",
            nativeQuery = true)
    List<TeamListInterface> findByTeamAndTeamManager();
}
