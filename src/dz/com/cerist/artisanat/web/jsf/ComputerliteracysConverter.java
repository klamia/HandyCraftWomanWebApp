package dz.com.cerist.artisanat.web.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;


import dz.com.cerist.artisanat.entite.Computerliteracys;
import dz.com.cerist.artisanat.service.IComputerliteracysService;

@ManagedBean(name = "computerliteracysConverter")
@RequestScoped
public class ComputerliteracysConverter implements Converter {

	

	@ManagedProperty(name = "iComputerliteracysService", value = "#{iComputerliteracysService}")
	private IComputerliteracysService iComputerliteracysService;

	
	public IComputerliteracysService getiComputerliteracysService() {
		return iComputerliteracysService;
	}

	public void setiComputerliteracysService(
			IComputerliteracysService iComputerliteracysService) {
		this.iComputerliteracysService = iComputerliteracysService;
	}

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
		if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                
                return iComputerliteracysService.getComputerliteracysbyId(Long.valueOf(submittedValue));
                
               
            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid computer literacy"));
            }
        }

       
       
    }
	
	@Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		if (value == null || value.equals("")) {
            return "";
        } else {
        	return ((Computerliteracys) value).getId().toString();      
        }
        
    }



}
