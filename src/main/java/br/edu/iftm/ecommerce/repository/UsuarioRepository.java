package br.edu.iftm.ecommerce.repository;

import br.edu.iftm.ecommerce.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class UsuarioRepository implements Serializable {
    
    @Inject
    private EntityManager entityManager;
    
    public Usuario salvar(Usuario entidade){
        this.entityManager.getTransaction().begin();
        entidade = this.entityManager.merge(entidade);
        this.entityManager.getTransaction().commit();
        return entidade;
    }
    
    public List<Usuario> listar(){
        List<Usuario> usuarios = this.entityManager.createQuery("select u from Usuario u").getResultList();
        return usuarios;
    }
    
}
