package br.edu.iftm.ecommerce.bean;

import br.edu.iftm.ecommerce.logic.PermissaoLogic;
import br.edu.iftm.ecommerce.logic.UsuarioLogic;
import br.edu.iftm.ecommerce.model.Permissao;
import br.edu.iftm.ecommerce.model.Usuario;
import br.edu.iftm.ecommerce.util.exception.ErroNegocioException;
import br.edu.iftm.ecommerce.util.exception.ErroSistemaException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class UsuarioBean extends CrudBean<Usuario, UsuarioLogic> {
    
    @Inject
    private UsuarioLogic logic;
    @Inject
    private PermissaoLogic permissaoLogic;

    private List<Permissao> listaDePermissoes;
    private Long ultimaAtualizacao = 0L;
    private Integer frequenciaAtualizacao = 5000;
    
    public UsuarioBean() {
        super(Usuario.class);
    }
    
    @Override
    public UsuarioLogic getLogic() {
        return this.logic;
    }
    
    public List<Permissao> getPemissoes(){
        try {
            long proximaAtualizacao = this.ultimaAtualizacao + this.frequenciaAtualizacao;
            if(proximaAtualizacao < Calendar.getInstance().getTimeInMillis()) {
                this.listaDePermissoes = permissaoLogic.buscar(null);
                this.ultimaAtualizacao = Calendar.getInstance().getTimeInMillis();
            }
            return this.listaDePermissoes;
        } catch (ErroSistemaException ex) {
            addErro(ex);
        } catch (ErroNegocioException ex) {
            addAviso(ex);
        }
        return new ArrayList<>();
    }
    
}
