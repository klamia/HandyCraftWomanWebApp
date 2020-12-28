package dz.com.cerist.artisanat.web.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import dz.com.cerist.artisanat.entite.Wilayas;
import dz.com.cerist.artisanat.service.IWilayaService;


@ManagedBean(name = "wilayaConverter")
@RequestScoped
public class WilayaConverter implements Converter{

	@ManagedProperty(name = "iWilayaService", value = "#{iWilayaService}")
	private IWilayaService iWilayaService;

	public IWilayaService getiWilayaService() {
		return iWilayaService;
	}

	public void setiWilayaService(IWilayaService iWilayaService) {
		this.iWilayaService = iWilayaService;
	}
	
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
		if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                
                return iWilayaService.getWilayabyId(Long.valueOf(submittedValue));
                
               
            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid grade"));
            }
        }

       
       
    }
	
	@Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		if (value == null || value.equals("")) {
            return "";
        } else {
        	return ((Wilayas) value).getId().toString();      
        }
        
    }


	
	
}
