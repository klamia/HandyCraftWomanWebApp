package dz.com.cerist.artisanat.web.jsf;

import java.io.IOException;
import java.io.Serializable;






import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;



import org.springframework.security.core.AuthenticationException;







@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 2868742783741899100L;

	

	private String username;
    private String password;
//    private Boolean loggedIn=false; 
   
   
 
    @ManagedProperty(name="compteEnCoursBean", value="#{compteEnCoursBean}")
	private CompteEnCoursBean compteEnCoursBean;

    
    
    

 // ActionEvent actionEvent
    
    
    public void login() throws IOException, ServletException {
		
		
		
		try {
			
			
			String url = "/j_spring_security_check?j_username=" + username + "&j_password=" + password;
			System.out.println(username);
			
			ExternalContext context = FacesContext.getCurrentInstance()
					.getExternalContext();

			/*RequestDispatcher dispatcher = ((ServletRequest) context
					.getRequest())
					.getRequestDispatcher("/j_spring_security_check");*/
			
			RequestDispatcher dispatcher = ((ServletRequest) context
					.getRequest())
					.getRequestDispatcher(url);
			
			dispatcher.forward((ServletRequest) context.getRequest(),
					(ServletResponse) context.getResponse());
			
		
			FacesContext.getCurrentInstance().responseComplete();
              
			
			
			compteEnCoursBean.setUsername(username);
			compteEnCoursBean.setLoggedIn(true);
			System.out.println(compteEnCoursBean);
			
			
			
			/*
			Comptes compte = iCompteService.getCompteByLogin(username);
			System.out.println(compte);
			artisaneEnCours=compte.getArtisane();
			artisaneEnCoursBean.setArtisaneEnCours(artisaneEnCours);
			System.out.println(artisaneEnCoursBean);
		 
			
			*/
			
				
			
		} catch (AuthenticationException ex) {
			System.out.println("Login Failed");
			FacesContext.getCurrentInstance()
					.addMessage(
							"formLogin",
							new FacesMessage(FacesMessage.SEVERITY_WARN,
									"Login Failed",
									"User Name and Password Not Match!"));

			//return null;
		}
	}

	
    

	public String getUsername() {
	        return username;
	    }
	 
	public void setUsername(String username) {
        this.username = username;
    }
 

		public CompteEnCoursBean getCompteEnCoursBean() {
		return compteEnCoursBean;
	}

	public void setCompteEnCoursBean(CompteEnCoursBean compteEnCoursBean) {
		this.compteEnCoursBean = compteEnCoursBean;
	}

		
	 
	    public String getPassword() {
	        return password;
	    }
	 
	    public void setPassword(String password) {
	        this.password = password;
	    }




		




		


		


		



		



		

		
		
		

		
        



}
