package br.edu.iftm.ecommerce.bean.converter;

import br.edu.iftm.ecommerce.model.Marca;
import br.edu.iftm.ecommerce.util.JSFUtil;
import br.edu.iftm.ecommerce.util.StringUtil;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Marca.class, value = "marcaConverter")
public class MarcaConverter extends JSFUtil implements Converter<Marca>{

    @Override
    public Marca getAsObject(FacesContext fc, UIComponent uic, String idString) {
       if(StringUtil.isEmpty(idString)){
           return null;
       }
        Marca marca = 
                    (Marca)uic.getAttributes().get("marca_"+idString);
       return marca;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Marca marca) {
        if(marca != null && marca.getId() != null){
            uic.getAttributes().put("marca_"+marca.getId(), marca);
            return marca.getId().toString();
        }
        return null;
    }
    
}
