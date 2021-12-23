package br.edu.iftm.ecommerce.repository;

import br.edu.iftm.ecommerce.model.Marca;

public class MarcaRepository  extends GenericRepository<Marca, Integer>{

    public MarcaRepository() {
        super(Marca.class);
    }
}
