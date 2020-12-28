package dz.com.cerist.artisanat.web.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import dz.com.cerist.artisanat.entite.Couleurs;

import dz.com.cerist.artisanat.service.ICouleurService;


@ManagedBean(name = "couleurConverter")
@RequestScoped
public class CouleurConverter implements Converter {

	@ManagedProperty(name = "iCouleurService", value = "#{iCouleurService}")
	private ICouleurService iCouleurService;

	
	
	public ICouleurService getiCouleurService() {
		return iCouleurService;
	}

	public void setiCouleurService(ICouleurService iCouleurService) {
		this.iCouleurService = iCouleurService;
	}

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
		if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                
                return iCouleurService.getCouleurbyId(Long.valueOf(submittedValue));
                
               
            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid couleur"));
            }
        }

       
       
    }
	
	@Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		if (value == null || value.equals("")) {
            return "";
        } else {
        	return ((Couleurs) value).getId().toString();      
        }
        
    }



}
