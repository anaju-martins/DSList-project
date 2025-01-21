package com.anajumartins.dslist.services;

import com.anajumartins.dslist.dto.GameListDTO;
import com.anajumartins.dslist.entities.GameList;
import com.anajumartins.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//precisa ser registrado como componente do sistema
@Component
public class GameListService {

    //Injetar um gamerepository
    @Autowired
    private GameListRepository gameListRepository;


    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        //o resultado da consulta vai ser convertido para uma lista
        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
        return dto;

    }
}
