/**
 * 
 */
package dz.com.cerist.artisanat.web.jsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import javax.faces.bean.ViewScoped;

import dz.com.cerist.artisanat.commons.utils.FacesUtils;
import dz.com.cerist.artisanat.entite.Users;
import dz.com.cerist.artisanat.service.IUserService;



@ManagedBean(name = "authenticateAction")
@ViewScoped
public class AuthenticateAction implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5460535295334757718L;

	private String userEmail;
	
	private String password;

    /**
     * Injected user bean used for getting current logged in user. Needed when
     * user post comment about item.
     */
	@ManagedProperty(value="#{userBean}")
    private UserBean userBean;

    /** User service remote ejb. */
    @ManagedProperty(value="#{iUserService}")
    private IUserService iUserService;


    
    
	/**
     * @return true if user exists and password is correct and false otherwise.
     */
    public String authenticate() {
        Users users = iUserService.findUserByEmail(userEmail);
        if (users == null) {
            FacesUtils.error("user.login.message.notExists");
            return null;
        } else {
            if (users.getPassword().equals(password)) {
                FacesUtils.info("user.login.message.success");
                userBean.loginUser(users);
               
                return "/index?faces-redirect=true";
            } else {
            	FacesUtils.error("user.login.message.wrongPassword");
                return null;
            }
        }
    }

	

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public UserBean getUserBean() {
		return userBean;
	}



	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}



	public IUserService getiUserService() {
		return iUserService;
	}



	public void setiUserService(IUserService iUserService) {
		this.iUserService = iUserService;
	}



	




}
