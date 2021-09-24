package br.edu.iftm.ecommerce.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @EqualsAndHashCode.Include
    private Integer id;
    private String nome;
    private String senha;
    private String email;
    private Date dataCadastro;
    
}
