package br.edu.iftm.ecommerce.repository;

import br.edu.iftm.ecommerce.model.Produto;

public class ProdutoRepository extends GenericRepository<Produto, Integer> {

    public ProdutoRepository() {
        super(Produto.class);
    }

}
