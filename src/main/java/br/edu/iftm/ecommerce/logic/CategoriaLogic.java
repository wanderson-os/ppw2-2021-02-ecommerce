package br.edu.iftm.ecommerce.logic;

import br.edu.iftm.ecommerce.model.Categoria;
import br.edu.iftm.ecommerce.repository.CategoriaRepository;
import br.edu.iftm.ecommerce.util.StringUtil;
import br.edu.iftm.ecommerce.util.exception.ErroNegocioException;
import br.edu.iftm.ecommerce.util.exception.ErroSistemaException;
import java.util.List;
import javax.inject.Inject;

public class CategoriaLogic implements CrudLogic<Categoria>{

    @Inject
    private CategoriaRepository reporitory;
    
    @Override
    public Categoria salvar(Categoria entidade) throws ErroSistemaException, ErroNegocioException {
        if(StringUtil.isEmpty(entidade.getNome())) {
            throw new ErroNegocioException("Informe o nome.");
        }
        return this.reporitory.save(entidade);
    }

    @Override
    public void remover(Categoria entidade) throws ErroSistemaException, ErroNegocioException {
        this.reporitory.remove(entidade.getId());
    }

    @Override
    public Categoria buscarPorId(Categoria entidade) throws ErroSistemaException, ErroNegocioException {
        return this.reporitory.findByID(entidade.getId());
    }

    @Override
    public List<Categoria> buscar(Categoria entidade) throws ErroSistemaException, ErroNegocioException {
        return this.reporitory.list();
    }
    
}
