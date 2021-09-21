package br.edu.iftm.ecommerce.bean;

import br.edu.iftm.ecommerce.logic.ClienteLogic;
import br.edu.iftm.ecommerce.logic.UsuarioLogic;
import br.edu.iftm.ecommerce.model.Usuario;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class UsuarioBean extends CrudBean<Usuario, UsuarioLogic> {

    @Override
    public void novo() {
        super.novo();
        setEntidade(new Usuario());
        addInfo("Criando um novo usuario");
    }
    
    
    
}
