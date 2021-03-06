package dz.com.cerist.artisanat.web.jsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;

import dz.com.cerist.artisanat.entite.Artisanes;








@ManagedBean(name ="compteEnCoursBean")
@SessionScoped
public class CompteEnCoursBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8601729166934092194L;


	public CompteEnCoursBean(){
		
	}
	
	
	private String username;

	private Artisanes artisane;
	
	private Boolean loggedIn=false; 
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Boolean getLoggedIn() {
		return loggedIn;
	}




	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	
	
	public Artisanes getArtisane() {
		return artisane;
	}
	public void setArtisane(Artisanes artisane) {
		this.artisane = artisane;
	}
	
	
	public String toString() {
	    return String.format("CompteEnCoursBean[%s]", getUsername() );
	  }
	

}
