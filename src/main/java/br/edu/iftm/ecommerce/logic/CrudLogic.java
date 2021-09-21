package br.edu.iftm.ecommerce.logic;

import java.util.List;

public interface CrudLogic<E> {
    
    // <>
//    criar
//    atualizar
//    deletar
//    buscar
    public E salvar(E entidade);
    public void remover(E entidade);
    public List<E> buscar(E entidade);
    
}
