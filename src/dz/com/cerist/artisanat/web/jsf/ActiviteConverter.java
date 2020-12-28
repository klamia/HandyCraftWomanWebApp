package dz.com.cerist.artisanat.web.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;


import dz.com.cerist.artisanat.entite.Activites;
import dz.com.cerist.artisanat.service.IActiviteService;


@ManagedBean(name = "activiteConverter")
@RequestScoped
public class ActiviteConverter implements Converter {
	@ManagedProperty(name = "iActiviteService", value = "#{iActiviteService}")
	private IActiviteService iActiviteService;

	public IActiviteService getiActiviteService() {
		return iActiviteService;
	}

	public void setiActiviteService(IActiviteService iActiviteService) {
		this.iActiviteService = iActiviteService;
	}

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
		if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                
                return iActiviteService.getActivitebyId(Long.valueOf(submittedValue));
                
               
            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid activite"));
            }
        }

       
       
    }
	
	@Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		if (value == null || value.equals("")) {
            return "";
        } else {
        	return ((Activites) value).getId().toString();      
        }
        
    }



}
