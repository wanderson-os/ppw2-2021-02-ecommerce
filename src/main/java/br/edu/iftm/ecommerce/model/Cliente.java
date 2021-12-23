package br.edu.iftm.ecommerce.model;

import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

public class Cliente {

    private Integer id;
    @Getter
    @Setter
    private String nome;
    @Getter
    @Setter
    private String sobrenome;
    
}
