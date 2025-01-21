package com.anajumartins.dslist.dto;

import com.anajumartins.dslist.entities.Game;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GameMinDTO {


    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO() {

    }
    //criar um gamemindto a partir dos dados do game copiando paga o dta
    public GameMinDTO(Game entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.year = entity.getYear();
        this.imgUrl = entity.getImgUrl();
        this.shortDescription = entity.getShortDescription();
    }
}
