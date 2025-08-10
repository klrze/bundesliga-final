package com.bundesliga.service;


import com.bundesliga.entity.Player;

import java.util.List;

public interface PlayerService {

    List<Player> getAllPlayers();

    Player getById(Long id);

    List<Player> getByName(String name);

    List<Player> getByClub(String club);

    List<Player> getByPos(String position);

    List<Player> getByNati(String nationality);

    List<Player> getByShirtNum(Long shirtNr);


}
