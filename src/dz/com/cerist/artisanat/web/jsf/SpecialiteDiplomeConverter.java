package dz.com.cerist.artisanat.web.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;


import dz.com.cerist.artisanat.entite.SpecialiteDiplome;

import dz.com.cerist.artisanat.service.ISpecialiteDiplomeService;

@ManagedBean(name = "specialiteDiplomeConverter")
@RequestScoped
public class SpecialiteDiplomeConverter implements Converter{

	@ManagedProperty(name = "iSpecialiteDiplomeService", value = "#{iSpecialiteDiplomeService}")
	private ISpecialiteDiplomeService iSpecialiteDiplomeService;

	public ISpecialiteDiplomeService getiSpecialiteDiplomeService() {
		return iSpecialiteDiplomeService;
	}

	public void setiSpecialiteDiplomeService(
			ISpecialiteDiplomeService iSpecialiteDiplomeService) {
		this.iSpecialiteDiplomeService = iSpecialiteDiplomeService;
	}

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
		if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                
                return iSpecialiteDiplomeService.getSpecialitebyId(Long.valueOf(submittedValue));
                
               
            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid specialite"));
            }
        }

       
       
    }
	
	@Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		if (value == null || value.equals("")) {
            return "";
        } else {
        	return ((SpecialiteDiplome) value).getId().toString();      
        }
        
    }


}
