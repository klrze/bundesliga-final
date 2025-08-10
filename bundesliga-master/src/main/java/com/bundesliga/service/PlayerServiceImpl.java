package com.bundesliga.service;

import com.bundesliga.entity.Player;
import com.bundesliga.exception.ResourceNotFound;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.bundesliga.repository.PlayerRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player getById(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Player not found at ID #"));
    }

    @Override
    public List<Player> getByName(String name) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getName().toLowerCase().contains((name.toLowerCase())))
                .collect(Collectors.toList());
    }

    @Override
    public List<Player> getByClub(String club) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getClub().toLowerCase().contains((club.toLowerCase())))
                .collect(Collectors.toList());
    }

    @Override
    public List<Player> getByPos(String position) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getPosition().toLowerCase().contains((position.toLowerCase())))
                .collect(Collectors.toList());
    }

    @Override
    public List<Player> getByNati(String nationality) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getNationality().toLowerCase().contains((nationality.toLowerCase())))
                .collect(Collectors.toList());
    }

    @Override
    public List<Player> getByShirtNum(Long shirtNr) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getShirtNr().equals(shirtNr))
                .collect(Collectors.toList());
    }

    @Override
    public List<Player> getByAlpha() {
        return playerRepository.getAllItemsSortedAlphabetically();
    }
}
