package br.edu.iftm.ecommerce.logic;

import br.edu.iftm.ecommerce.model.Cliente;
import br.edu.iftm.ecommerce.util.exception.ErroNegocioException;
import br.edu.iftm.ecommerce.util.exception.ErroSistemaException;
import java.util.List;

public class ClienteLogic implements CrudLogic<Cliente>{

    @Override
    public Cliente salvar(Cliente entidade) throws ErroSistemaException, ErroNegocioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Cliente entidade) throws ErroSistemaException, ErroNegocioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente buscarPorId(Cliente entidade) throws ErroSistemaException, ErroNegocioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> buscar(Cliente entidade) throws ErroSistemaException, ErroNegocioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
