package br.edu.iftm.ecommerce.logic;

import br.edu.iftm.ecommerce.model.Marca;
import br.edu.iftm.ecommerce.repository.MarcaRepository;
import br.edu.iftm.ecommerce.util.StringUtil;
import br.edu.iftm.ecommerce.util.exception.ErroNegocioException;
import br.edu.iftm.ecommerce.util.exception.ErroSistemaException;
import java.util.List;
import javax.inject.Inject;

public class MarcaLogic implements CrudLogic<Marca>{

    @Inject
    private MarcaRepository reporitory;
    
    @Override
    public Marca salvar(Marca entidade) throws ErroSistemaException, ErroNegocioException {
        if(StringUtil.isEmpty(entidade.getNome())) {
            throw new ErroNegocioException("Informe o nome.");
        }
        return this.reporitory.save(entidade);
    }

    @Override
    public void remover(Marca entidade) throws ErroSistemaException, ErroNegocioException {
        this.reporitory.remove(entidade.getId());
    }

    @Override
    public Marca buscarPorId(Marca entidade) throws ErroSistemaException, ErroNegocioException {
        return this.reporitory.findByID(entidade.getId());
    }

    @Override
    public List<Marca> buscar(Marca entidade) throws ErroSistemaException, ErroNegocioException {
        return this.reporitory.list();
    }
    
}
