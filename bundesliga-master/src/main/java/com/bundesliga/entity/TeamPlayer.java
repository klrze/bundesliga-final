package com.bundesliga.entity;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "team_players")
public class TeamPlayer {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "age")
    private Long age;

    @Column(name = "height")
    private double height;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "place_of_birth")
    private String placeOfBirth;

    @Column(name = "price")
    private Double price;

    @Column(name = "max_price")
    private Double maxPrice;

    @Column(name = "position")
    private String position;

    @Column(name = "shirt_nr")
    private Long shirtNr;

    @Column(name = "foot")
    private String foot;

    @Column(name = "club")
    private String club;

    @Column(name = "contract_expires")
    private LocalDate contractExpires;

    @Column(name = "joined_club")
    private LocalDate joinDate;

    @Column(name = "player_agent")
    private String playerAgent;

    @Column(name = "outfitter")
    private String outfitter;

    @Column(name = "benchStart")
    @JsonSetter(nulls = Nulls.SKIP)
    private String benchStart = "bench";

    @Column(name = "startPosition", nullable = true, unique = true)
    private String startPosition;

}
