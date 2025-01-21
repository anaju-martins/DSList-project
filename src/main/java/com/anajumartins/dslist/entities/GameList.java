package com.anajumartins.dslist.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "tb_game_list")
public class GameList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public GameList() {

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GameList gameList = (GameList) o;
        return Objects.equals(id, gameList.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
