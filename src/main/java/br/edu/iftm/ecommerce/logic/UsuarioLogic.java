package br.edu.iftm.ecommerce.logic;

import br.edu.iftm.ecommerce.model.Usuario;
import br.edu.iftm.ecommerce.util.exception.ErroNegocioException;
import br.edu.iftm.ecommerce.util.exception.ErroSistemaException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioLogic implements CrudLogic<Usuario>{

    private List<Usuario> usuarios = new ArrayList<>();
    private Integer id = 1;
    
    @Override
    public Usuario salvar(Usuario entidade) throws ErroSistemaException, ErroNegocioException{
        if("".equals(entidade.getNome())) {
            throw new ErroNegocioException("Por favor informe o nome.");
        }
        entidade.setId(this.id++);
        this.usuarios.add(entidade);
        return entidade;
    }

    @Override
    public void remover(Usuario entidade) throws ErroSistemaException, ErroNegocioException{
        this.usuarios.remove(entidade);
    }

    @Override
    public Usuario buscarPorId(Usuario entidade) throws ErroSistemaException, ErroNegocioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Usuario> buscar(Usuario entidade) throws ErroSistemaException, ErroNegocioException {
        return this.usuarios;
    }

    
}
