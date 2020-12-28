package dz.com.cerist.artisanat.web.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;


import dz.com.cerist.artisanat.entite.Category;
import dz.com.cerist.artisanat.service.ICategorieService;


@ManagedBean(name = "categorieConverter")
@RequestScoped
public class CategorieConverter implements Converter {

	@ManagedProperty(name = "iCategorieService", value = "#{iCategorieService}")
	private ICategorieService iCategorieService;
	
	
	public ICategorieService getiCategorieService() {
		return iCategorieService;
	}

	public void setiCategorieService(ICategorieService iCategorieService) {
		this.iCategorieService = iCategorieService;
	}

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
		if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                
                return iCategorieService.getCategoriebyId(Long.valueOf(submittedValue));
                
               
            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid langage"));
            }
        }

       
       
    }
	
	@Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		if (value == null || value.equals("")) {
            return "";
        } else {
        	return ((Category) value).getId().toString();      
        }
        
    }

}
