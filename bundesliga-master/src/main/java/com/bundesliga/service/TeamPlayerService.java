package com.bundesliga.service;
import com.bundesliga.entity.TeamPlayer;

import java.util.List;
import java.util.Optional;


public interface TeamPlayerService {

    List<TeamPlayer> TgetAllPlayers();

    TeamPlayer TgetById(Long id);

    List<TeamPlayer> TgetByName(String name);

    List<TeamPlayer> TgetByClub(String club);

    List<TeamPlayer> TgetByPos(String position);

    List<TeamPlayer> TgetByNati(String nationality);

    List<TeamPlayer> TgetByShirtNum(Long shirtNr);

    List<TeamPlayer> TgetByBenchStart(String benchStart);

    TeamPlayer save(TeamPlayer teamPlayer);

    void delete(Long id);

    TeamPlayer updateStartPos(Long id, String startPosition);

    TeamPlayer updateStartBench(Long id, String benchStart);
    TeamPlayer assignPosition(Long playerId, String position);
    TeamPlayer unassignPosition(Long playerId, String position);
}
