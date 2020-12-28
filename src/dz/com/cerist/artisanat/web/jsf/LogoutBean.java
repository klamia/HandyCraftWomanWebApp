package dz.com.cerist.artisanat.web.jsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;





@ManagedBean(name = "logoutBean")
@SessionScoped
public class LogoutBean implements Serializable{
	
	
    private Boolean loggedIn ;
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3568763907831384992L;

	/**
	 * 
	 */
	

	public String logout(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	this.loggedIn=false;
	return "/shops?faces-redirect=true";
	
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	
}

