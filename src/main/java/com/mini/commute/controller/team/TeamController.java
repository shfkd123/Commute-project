package com.mini.commute.controller.team;

import com.mini.commute.dto.team.request.TeamCreateRequest;
import com.mini.commute.dto.team.response.TeamListInterface;
import com.mini.commute.service.team.TeamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/team")
    public List<TeamListInterface> findByTeamAndTeamManager(){
        return teamService.getTeamList();
    }
}
