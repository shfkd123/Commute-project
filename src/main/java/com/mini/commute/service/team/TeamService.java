package com.mini.commute.service.team;

import com.mini.commute.domain.team.Team;
import com.mini.commute.domain.team.TeamRepository;
import com.mini.commute.dto.team.TeamCreateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
