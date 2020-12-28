package dz.com.cerist.artisanat.web.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;


import dz.com.cerist.artisanat.entite.Centresinterets;

import dz.com.cerist.artisanat.service.ICentresinteretsService;

@ManagedBean(name = "centresinteretsConverter")
@RequestScoped
public class CentresinteretsConverter implements Converter{

	@ManagedProperty(name = "iCentresinteretsService", value = "#{iCentresinteretsService}")
	private ICentresinteretsService iCentresinteretsService;

	public ICentresinteretsService getiCentresinteretsService() {
		return iCentresinteretsService;
	}

	public void setiCentresinteretsService(
			ICentresinteretsService iCentresinteretsService) {
		this.iCentresinteretsService = iCentresinteretsService;
	}
	
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
		if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                
                return iCentresinteretsService.getInteretbyId(Long.valueOf(submittedValue));
                
               
            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid interet"));
            }
        }

       
       
    }
	
	@Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		if (value == null || value.equals("")) {
            return "";
        } else {
        	return ((Centresinterets) value).getId().toString();      
        }
        
    }

}
