package dz.com.cerist.artisanat.web.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;


import dz.com.cerist.artisanat.entite.Langages;
import dz.com.cerist.artisanat.service.ILangageService;



@ManagedBean(name = "langageConverter")
@RequestScoped
public class LangageConverter implements Converter {

	
	@ManagedProperty(name = "iLangageService", value = "#{iLangageService}")
	private ILangageService iLangageService;
	
	public ILangageService getiLangageService() {
		return iLangageService;
	}

	public void setiLangageService(ILangageService iLangageService) {
		this.iLangageService = iLangageService;
	}

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
		if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                
                return iLangageService.getLangagebyId(Long.valueOf(submittedValue));
                
               
            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid langage"));
            }
        }

       
       
    }
	
	@Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		if (value == null || value.equals("")) {
            return "";
        } else {
        	return ((Langages) value).getId().toString();      
        }
        
    }
}
