package com.bundesliga.controller;


import com.bundesliga.entity.Player;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bundesliga.service.PlayerService;

import java.util.List;

@RestController
@RequestMapping("/api/player")
@AllArgsConstructor
public class PlayerController {

    private PlayerService playerService;

    // POST Mapping - Adding players

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers(){
        List<Player> players = playerService.getAllPlayers();
        return ResponseEntity.ok(players);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Player> getById(@PathVariable("id") Long id) {
        Player player = playerService.getById(id);
        return ResponseEntity.ok(player);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Player>> getByName(@PathVariable("name") String name) {
        List<Player> players = playerService.getByName(name);
        return ResponseEntity.ok(players);
    }

    @GetMapping("/club/{club}")
    public ResponseEntity<List<Player>> getByClub(@PathVariable("club") String club) {
        List<Player> players = playerService.getByClub(club);
        return ResponseEntity.ok(players);
    }

    @GetMapping("/position/{position}")
    public ResponseEntity<List<Player>> getByPos(@PathVariable("position") String position) {
        List<Player> players = playerService.getByPos(position);
        return ResponseEntity.ok(players);
    }

    @GetMapping("/nation/{nationality}")
    public ResponseEntity<List<Player>> getByNati(@PathVariable("nationality") String nationality) {
        List<Player> players = playerService.getByNati(nationality);
        return ResponseEntity.ok(players);
    }

    @GetMapping("/shirt/{shirtNr}")
    public ResponseEntity<List<Player>> getByShirtNum(@PathVariable("shirtNr") Long shirtNr) {
        List<Player> players = playerService.getByShirtNum(shirtNr);
        return ResponseEntity.ok(players);
    }

}