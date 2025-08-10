package com.bundesliga.service;

import com.bundesliga.entity.TeamPlayer;
import com.bundesliga.exception.ResourceNotFound;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.bundesliga.repository.TeamPlayerRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TeamPlayerServiceImpl implements TeamPlayerService {

    private TeamPlayerRepository teamPlayerRepository;
    @Override
    public List<TeamPlayer> TgetAllPlayers() {
        return teamPlayerRepository.findAll();
    }

    @Override
    public TeamPlayer TgetById(Long id) {
         return teamPlayerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Player not found at ID #"));
    }

    @Override
    public List<TeamPlayer> TgetByName(String name) {
        return teamPlayerRepository.findAll().stream()
                .filter(player -> player.getName().toLowerCase().contains((name.toLowerCase())))
                .collect(Collectors.toList());
    }

    @Override
    public List<TeamPlayer> TgetByClub(String club) {
        return teamPlayerRepository.findAll().stream()
                .filter(player -> player.getClub().toLowerCase().contains((club.toLowerCase())))
                .collect(Collectors.toList());
    }

    @Override
    public List<TeamPlayer> TgetByPos(String position) {
        return teamPlayerRepository.findAll().stream()
                .filter(player -> player.getPosition().toLowerCase().contains((position.toLowerCase())))
                .collect(Collectors.toList());
    }

    @Override
    public List<TeamPlayer> TgetByNati(String nationality) {
        return List.of();
    }

    @Override
    public List<TeamPlayer> TgetByShirtNum(Long shirtNr) {
        return List.of();
    }

    @Override
    public List<TeamPlayer> TgetByBenchStart(String benchStart) {
        return teamPlayerRepository.findAll().stream()
                .filter(player -> player.getBenchStart().toLowerCase().contains((benchStart.toLowerCase())))
                .collect(Collectors.toList());
    }

    @Override
    public TeamPlayer save(TeamPlayer teamPlayer) {
        return teamPlayerRepository.save(teamPlayer);
    }

    @Override
    public void delete(Long id) {
        TeamPlayer teamPlayer = teamPlayerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Player not found: " + id)
        );

        teamPlayerRepository.deleteById(id);
    }

    @Override
    public TeamPlayer updateStartPos(Long id, String startPosition) {
        TeamPlayer player = teamPlayerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Player not found"));

        player.setStartPosition(startPosition);
        return teamPlayerRepository.save(player);
    }

    @Override
    public TeamPlayer updateStartBench(Long id, String benchStart) {
        TeamPlayer player = teamPlayerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Player not found"));

        player.setBenchStart(benchStart);
        return teamPlayerRepository.save(player);
    }

    @Override
    public TeamPlayer assignPosition(Long playerId, String position) {
        position = position.toUpperCase();

        List<TeamPlayer> playersWithPosition = teamPlayerRepository.findByStartPosition(position);
        boolean takenByAnother = playersWithPosition.stream()
                .anyMatch(p -> !p.getId().equals(playerId));

        if (takenByAnother) {
            throw new IllegalStateException("Position '" + position + "' is already assigned to another player.");
        }

        TeamPlayer player = teamPlayerRepository.findById(playerId)
                .orElseThrow(() -> new IllegalArgumentException("Player not found"));

        player.setStartPosition(position);
        return teamPlayerRepository.save(player);
    }

    @Override
    public TeamPlayer unassignPosition(Long playerId, String position) {
        TeamPlayer player = teamPlayerRepository.findById(playerId)
                .orElseThrow(() -> new IllegalArgumentException("Player not found"));

        if (position.equalsIgnoreCase(player.getStartPosition())) {
            player.setStartPosition(null);
            return teamPlayerRepository.save(player);
        }
        return player;
    }


}
