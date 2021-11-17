package br.edu.iftm.ecommerce.bean;

import java.io.Serializable;
import java.util.Calendar;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class HelloBean implements Serializable {
    
    private String nome;

    public void dizerOla(){
        long tempoFinal = Calendar.getInstance().getTimeInMillis()+3000;
        while(tempoFinal > Calendar.getInstance().getTimeInMillis()){
            
        }
        FacesContext fc = FacesContext.getCurrentInstance();
        
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ola "+ nome, null);
        
        fc.addMessage(null, fm);

    }
    
    //Metodos get e set
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
