package com.mini.commute.service.team;

import com.mini.commute.domain.team.Team;
import com.mini.commute.domain.team.TeamRepository;
import com.mini.commute.dto.team.request.TeamCreateRequest;
import com.mini.commute.dto.team.response.TeamListInterface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeamService {


    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Transactional
    public void saveTeam(TeamCreateRequest request) throws IllegalAccessException {
        teamRepository.save(new Team(request.getName()));
    }

    @Transactional(readOnly = true)
    public List<TeamListInterface> getTeamList() {
        return teamRepository.findByTeamAndTeamManager();
    }
}
