package com.anajumartins.dslist.repositories;

import com.anajumartins.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface GameListRepository extends JpaRepository<GameList, Long> { //tipo da entidade e o tipo do id da entidade
    //aproveitando o fw que já tem todas as operações básicas, inclusive a busca por id (consulta no banco de dados)
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
    void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);
}
