package br.edu.iftm.ecommerce.logic;

import br.edu.iftm.ecommerce.model.Produto;
import br.edu.iftm.ecommerce.model.Produto;
import br.edu.iftm.ecommerce.repository.ProdutoRepository;
import br.edu.iftm.ecommerce.util.exception.ErroNegocioException;
import br.edu.iftm.ecommerce.util.exception.ErroSistemaException;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class ProdutoLogic implements CrudLogic<Produto>{

    @Inject
    private ProdutoRepository repository;
    
    @Override
    public Produto salvar(Produto entidade) throws ErroSistemaException, ErroNegocioException{
        
        
        if("".equals(entidade.getNome())) {
            throw new ErroNegocioException("Por favor informe o nome.");
        }
        if (entidade.getDataCriacao() == null) {
            entidade.setDataCriacao(new Date());
        }
        
        entidade = this.repository.save(entidade);
        return entidade;
    }

    @Override
    public void remover(Produto entidade) throws ErroSistemaException, ErroNegocioException{
        this.repository.remove(entidade.getId());
    }

    @Override
    public Produto buscarPorId(Produto entidade) throws ErroSistemaException, ErroNegocioException {
        return this.repository.findByID(entidade.getId());
    }
    
    @Override
    public List<Produto> buscar(Produto entidade) throws ErroSistemaException, ErroNegocioException {
        return this.repository.list();
    }

    
}
