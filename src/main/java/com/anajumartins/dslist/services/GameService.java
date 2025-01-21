package com.anajumartins.dslist.services;

import com.anajumartins.dslist.dto.GameDTO;
import com.anajumartins.dslist.dto.GameMinDTO;
import com.anajumartins.dslist.entities.Game;
import com.anajumartins.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//precisa ser registrado como componente do sistema
@Component
public class GameService {

    //Injetar um gamerepository
    @Autowired
    private GameRepository gameRepository;

   //Criar um método para buscar por ID
    //Notação para que o método fique transacional (garantir que a operação com o bd vai acontecer)
    @Transactional(readOnly = true) //assegurando que não vai fazer operação de escrita, fica mais rápido
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get(); //recebe um id e retorna objeto
        GameDTO dto = new GameDTO(result); //usar o construtor que fez com o beans
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        //o resultado da consulta vai ser convertido para uma lista
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;

    }
}
