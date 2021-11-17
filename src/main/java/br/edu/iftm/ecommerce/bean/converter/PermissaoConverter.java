package br.edu.iftm.ecommerce.bean.converter;

import br.edu.iftm.ecommerce.model.Permissao;
import br.edu.iftm.ecommerce.util.JSFUtil;
import br.edu.iftm.ecommerce.util.StringUtil;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Permissao.class, value = "permissaoConverter")
public class PermissaoConverter extends JSFUtil implements Converter<Permissao>{

    @Override
    public Permissao getAsObject(FacesContext fc, UIComponent uic, String idString) {
       if(StringUtil.isEmpty(idString)){
           return null;
       }
        Permissao permissao = 
                    (Permissao)uic.getAttributes().get("permissao_"+idString);
       return permissao;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Permissao permissao) {
        if(permissao != null && permissao.getId() != null){
            uic.getAttributes().put("permissao_"+permissao.getId(), permissao);
            return permissao.getId().toString();
        }
        return null;
    }
    
}
