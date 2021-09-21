package br.edu.iftm.ecommerce.bean;

import br.edu.iftm.ecommerce.logic.CrudLogic;
import br.edu.iftm.ecommerce.model.Cliente;
import br.edu.iftm.ecommerce.util.JSFUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class CrudBean<E, L extends CrudLogic<E>> extends JSFUtil{

    private EstadoDaTela estadoDaTela = EstadoDaTela.BUSCAR;
    private E entidade;
    private List<E> entidades = new ArrayList<>();
    private L logic;
    
    public enum EstadoDaTela {
        BUSCAR,
        INSERIR,
        ATUALIZAR
    }

    public void novo(){
        this.estadoDaTela = EstadoDaTela.INSERIR;
    }
    
    public void salvar(){
        this.logic.salvar(entidade);
        buscar();
    }
    
    public void buscar() {
        this.estadoDaTela = EstadoDaTela.BUSCAR;
    }
    
    public EstadoDaTela getEstadoDaTela() {
        return estadoDaTela;
    }

    public void setEstadoDaTela(EstadoDaTela estadoDaTela) {
        this.estadoDaTela = estadoDaTela;
    }

    public E getEntidade() {
        return entidade;
    }

    public void setEntidade(E entidade) {
        this.entidade = entidade;
    }

    public List<E> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<E> entidades) {
        this.entidades = entidades;
    }
    
    
}
