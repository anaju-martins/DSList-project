package com.anajumartins.dslist.dto;

import com.anajumartins.dslist.entities.Game;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class GameDTO {

    private Long id;
    private String title;
    private Double score;
    private Integer year;
    private String genre;
    private String platforms;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;


    public GameDTO(Game entity){
        BeanUtils.copyProperties(entity, this);
        //copiar as propriedades da entidade para o dto
    }
}
