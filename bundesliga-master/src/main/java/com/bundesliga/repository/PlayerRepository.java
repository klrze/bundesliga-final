package com.bundesliga.repository;

import com.bundesliga.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query(value = "SELECT * FROM players ORDER BY name ASC", nativeQuery = true)
    List<Player> getAllItemsSortedAlphabetically();

}
