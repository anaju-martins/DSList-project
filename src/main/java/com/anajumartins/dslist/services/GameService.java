package com.anajumartins.dslist.services;

import com.anajumartins.dslist.dto.GameMinDTO;
import com.anajumartins.dslist.entities.Game;
import com.anajumartins.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//precisa ser registrado como componente do sistema
@Component
public class GameService {

    //Injetar um gamerepository
    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        //o resultado da consulta vai ser convertido para uma lista
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;

    }
}
