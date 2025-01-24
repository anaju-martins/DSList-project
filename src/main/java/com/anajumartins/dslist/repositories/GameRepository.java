package com.anajumartins.dslist.repositories;

import com.anajumartins.dslist.entities.Game;
import com.anajumartins.dslist.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//consultas sql são colocadas aqui
public interface GameRepository extends JpaRepository<Game, Long> { //tipo da entidade e o tipo do id da entidade
    //aproveitando o fw que já tem todas as operações básicas, inclusive a busca por id (consulta no banco de dados)
    //condição para funcionar a consulta SQL
    @Query(nativeQuery = true, value = """
		SELECT tb_game.id, tb_game.title, tb_game.game_year AS "year", tb_game.img_url AS imgUrl,
		tb_game.short_description AS shortDescription, tb_belonging.position
		FROM tb_game
		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId
		ORDER BY tb_belonging.position
			""")
    List<GameMinProjection> searchByList(Long listId); //parametro do que preciso para consulta
    //quando usa o nativeQuery o resultado da consulta tem que ser uma interface/ projection
}
