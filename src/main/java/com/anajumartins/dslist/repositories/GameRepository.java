package com.anajumartins.dslist.repositories;

import com.anajumartins.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> { //tipo da entidade e o tipo do id da entidade
    //aproveitando o fw que já tem todas as operações básicas, inclusive a busca por id (consulta no banco de dados)
}
