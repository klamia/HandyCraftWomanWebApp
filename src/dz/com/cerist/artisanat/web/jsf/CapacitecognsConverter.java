package dz.com.cerist.artisanat.web.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import dz.com.cerist.artisanat.entite.Capacitecogns;

import dz.com.cerist.artisanat.service.ICapacitecognsService;


@ManagedBean(name = "capacitecognsConverter")
@RequestScoped
public class CapacitecognsConverter implements Converter {

	@ManagedProperty(name = "iCapacitecognsService", value = "#{iCapacitecognsService}")
	private ICapacitecognsService iCapacitecognsService;

	public ICapacitecognsService getiCapacitecognsService() {
		return iCapacitecognsService;
	}

	public void setiCapacitecognsService(ICapacitecognsService iCapacitecognsService) {
		this.iCapacitecognsService = iCapacitecognsService;
	}
	
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
		if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                
                return iCapacitecognsService.getCapacitecognsbyId(Long.valueOf(submittedValue));
                
               
            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid capacite cognitive"));
            }
        }

       
       
    }
	
	@Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		if (value == null || value.equals("")) {
            return "";
        } else {
        	return ((Capacitecogns) value).getId().toString();      
        }
        
    }

}
