package com.bundesliga.controller;

import com.bundesliga.dto.BenchStartDTO;
import com.bundesliga.dto.StartPosDTO;
import com.bundesliga.entity.Player;
import com.bundesliga.entity.TeamPlayer;
import com.bundesliga.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bundesliga.service.TeamPlayerService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/team_player")
@AllArgsConstructor
public class TeamPlayerController {

    private TeamPlayerService teamPlayerService;

    @GetMapping
    public ResponseEntity<List<TeamPlayer>> TgetAllPlayers(){
        List<TeamPlayer> players = teamPlayerService.TgetAllPlayers();
        return ResponseEntity.ok(players);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<TeamPlayer> TgetById(@PathVariable("id") Long id) {
        TeamPlayer teamPlayer = teamPlayerService.TgetById(id);
        return ResponseEntity.ok(teamPlayer);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<TeamPlayer>> TgetByName(@PathVariable("name") String name) {
        List<TeamPlayer> teamPlayers = teamPlayerService.TgetByName(name);
        return ResponseEntity.ok(teamPlayers);
    }

    @GetMapping("/club/{club}")
    public ResponseEntity<List<TeamPlayer>> getByClub(@PathVariable("club") String club) {
        List<TeamPlayer> teamPlayers = teamPlayerService.TgetByClub(club);
        return ResponseEntity.ok(teamPlayers);
    }

    @GetMapping("/position/{position}")
    public ResponseEntity<List<TeamPlayer>> getByPos(@PathVariable("position") String position) {
        List<TeamPlayer> teamPlayers = teamPlayerService.TgetByPos(position);
        return ResponseEntity.ok(teamPlayers);
    }

    @GetMapping("/bench_start/{benchStart}")
    public ResponseEntity<List<TeamPlayer>> getByBenchStart(@PathVariable("benchStart") String benchStart) {
        List<TeamPlayer> teamPlayers = teamPlayerService.TgetByBenchStart(benchStart);
        return ResponseEntity.ok(teamPlayers);
    }

    @PostMapping
    public ResponseEntity<TeamPlayer> addTeamPlayer(@RequestBody TeamPlayer teamPlayer) {
        TeamPlayer savedPlayer = teamPlayerService.save(teamPlayer);
        return ResponseEntity.ok(savedPlayer);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteTeamPlayer(@PathVariable("id") Long id) {
        teamPlayerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/start_pos/{id}")
    public ResponseEntity<TeamPlayer> updateStartPos(@PathVariable Long id, @RequestBody StartPosDTO dto) {
        TeamPlayer updatedPlayer = teamPlayerService.updateStartPos(id, dto.getStartPos());
        return ResponseEntity.ok(updatedPlayer);
    }

    @PutMapping("/start_bench/{id}")
    public ResponseEntity<TeamPlayer> updateStartBench(@PathVariable Long id, @RequestBody BenchStartDTO dto) {
        TeamPlayer updatedPlayer = teamPlayerService.updateStartBench(id, dto.getBenchStart());
        return ResponseEntity.ok(updatedPlayer);
    }

    @PostMapping("/assign_position")
    public ResponseEntity<?> assignPosition(@RequestBody StartPosDTO req) {
        try {
            TeamPlayer updated = teamPlayerService.assignPosition(req.getPlayerId(), req.getPosition());
            return ResponseEntity.ok(updated);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(409).body(e.getMessage()); // Conflict error if position taken
        }
    }

    @PostMapping("/unassign_position")
    public ResponseEntity<?> unassignPosition(@RequestBody StartPosDTO req) {
        TeamPlayer updated = teamPlayerService.unassignPosition(req.getPlayerId(), req.getPosition());
        return ResponseEntity.ok(updated);
    }



}
