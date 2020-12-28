package dz.com.cerist.artisanat.web.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import dz.com.cerist.artisanat.entite.Diplomes;
import dz.com.cerist.artisanat.service.IDiplomeService;

@ManagedBean(name = "diplomeConverter")
@RequestScoped
public class DiplomeConverter implements Converter {

	
	@ManagedProperty(name = "iDiplomeService", value = "#{iDiplomeService}")
	private IDiplomeService iDiplomeService;

	public IDiplomeService getiDiplomeService() {
		return iDiplomeService;
	}

	public void setiDiplomeService(IDiplomeService iDiplomeService) {
		this.iDiplomeService = iDiplomeService;
	}

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
		if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                
                return iDiplomeService.getDiplomebyId(Long.valueOf(submittedValue));
                
               
            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid diplome"));
            }
        }

       
       
    }
	
	@Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		if (value == null || value.equals("")) {
            return "";
        } else {
        	return ((Diplomes) value).getId().toString();      
        }
        
    }



}
