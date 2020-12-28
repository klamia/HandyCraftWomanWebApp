package dz.com.cerist.artisanat.web.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import dz.com.cerist.artisanat.entite.Capacitephys;

import dz.com.cerist.artisanat.service.ICapacitephysService;


@ManagedBean(name = "capacitephysConverter")
@RequestScoped
public class CapacitephysConverter implements Converter {

	@ManagedProperty(name = "iCapacitephysService", value = "#{iCapacitephysService}")
	private ICapacitephysService iCapacitephysService;

	public ICapacitephysService getiCapacitephysService() {
		return iCapacitephysService;
	}

	public void setiCapacitephysService(ICapacitephysService iCapacitephysService) {
		this.iCapacitephysService = iCapacitephysService;
	}

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
		if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                
                return iCapacitephysService.getCapacitephysbyId(Long.valueOf(submittedValue));
                
               
            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid capacite physique"));
            }
        }

       
       
    }
	
	@Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		if (value == null || value.equals("")) {
            return "";
        } else {
        	return ((Capacitephys) value).getId().toString();      
        }
        
    }


}
