package com.mini.commute.controller.team;

import com.mini.commute.dto.team.TeamCreateRequest;
import com.mini.commute.service.team.TeamService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/team/save")
    public void saveTeam(@RequestBody TeamCreateRequest request) throws IllegalAccessException {
        teamService.saveTeam(request);
    }
}
