package dz.com.cerist.artisanat.web.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;


import dz.com.cerist.artisanat.entite.Tendances;

import dz.com.cerist.artisanat.service.ITendanceService;

@ManagedBean(name = "tendanceConverter")
@RequestScoped
public class TendanceConverter implements Converter {

	@ManagedProperty(name = "iTendanceService", value = "#{iTendanceService}")
	private ITendanceService iTendanceService;

	public ITendanceService getiTendanceService() {
		return iTendanceService;
	}

	public void setiTendanceService(ITendanceService iTendanceService) {
		this.iTendanceService = iTendanceService;
	}

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
		if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                
                return iTendanceService.getTendancebyId(Long.valueOf(submittedValue));
                
               
            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid tendance"));
            }
        }

       
       
    }
	
	@Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		if (value == null || value.equals("")) {
            return "";
        } else {
        	return ((Tendances) value).getId().toString();      
        }
        
    }

	
}
