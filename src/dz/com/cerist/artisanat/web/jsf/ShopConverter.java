package dz.com.cerist.artisanat.web.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;


import dz.com.cerist.artisanat.entite.Shop;
import dz.com.cerist.artisanat.service.IShopService;

@ManagedBean(name = "shopConverter")
@RequestScoped
public class ShopConverter implements Converter {

	@ManagedProperty(name = "iShopService", value = "#{iShopService}")
	private IShopService iShopService;

	
	
	
	
	public IShopService getiShopService() {
		return iShopService;
	}

	public void setiShopService(IShopService iShopService) {
		this.iShopService = iShopService;
	}

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
		if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                
                return iShopService.getShopbyId(Long.valueOf(submittedValue));
                
               
            } catch(NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Shop"));
            }
        }

       
       
    }
	
	@Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		if (value == null || value.equals("")) {
            return "";
        } else {
        	return ((Shop) value).getId().toString();      
        }
        
    }


}
