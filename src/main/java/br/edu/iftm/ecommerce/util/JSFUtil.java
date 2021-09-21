package br.edu.iftm.ecommerce.util;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSFUtil  implements Serializable {
    
    public void addMensagem(FacesMessage.Severity severity, String sumary, String detail){
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, sumary, detail));
    }
    
    public void addInfo(String sumary, String detail) {
        addMensagem(FacesMessage.SEVERITY_INFO, sumary, detail);
    }
    public void addInfo(String mensagem){
        addInfo("Info", mensagem);
    }
    public void addAviso(String sumary, String detail) {
        addMensagem(FacesMessage.SEVERITY_WARN, sumary, detail);
    }
    public void addAviso(String mensagem){
        addAviso("Aviso", mensagem);
    }
    public void addErro(String sumary, String detail) {
        addMensagem(FacesMessage.SEVERITY_ERROR, sumary, detail);
    }
    public void addErro(String mensagem){
        addErro("Erro", mensagem);
    }
}
