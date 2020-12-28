/**
 * RegisterAction.java
 * Created: 12:52:11 PM Jul 25, 2008
 */
package dz.com.cerist.artisanat.web.jsf;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import dz.com.cerist.artisanat.commons.utils.FacesUtils;
import dz.com.cerist.artisanat.commons.utils.PasswordUtils;
import dz.com.cerist.artisanat.commons.utils.UniqueIdGenerator;
import dz.com.cerist.artisanat.entite.Users;
import dz.com.cerist.artisanat.entite.UserConfirmation;
import dz.com.cerist.artisanat.service.IUserService;


/**
 * New user registration component. This class validates new user's data, save
 * it and sends confirmation email.
 * 
 * @author Ignas
 * 
 */
// Was flow scoped in older seam version, just making simlest solution with session scope when updating project
@ManagedBean(name = "registerAction")
@SessionScoped
public class RegisterAction implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8864360246817889010L;

	/** User service remote ejb. */
    private IUserService iUserService;

    /**
     * Injected user bean used for getting user who wants to register.
     */
    @ManagedProperty(value="#{userBean}")
    private UserBean userBean;

    /**
     * User who is going to register. Everyone using system has created user
     * account with user id in it even if they are not registered. They are
     * identified by cookie, and when they register their account status only
     * change to registered.
     */
    private Users users;

    /** User's provided password. */
    private String password;

    /** User's provided password for verification. */
    private String passwordVerification;

    
    public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	/**
     * Is invoked on creation of this component.
     */
    @PostConstruct
    public void create() {
        users = userBean.getUser();
    }

    /**
     * Checks if user with such email already exists.
     * 
     * @return true if email is not duplicated and false otherwise.
     */
    public boolean isNotDuplicate() {
        Users userWithSameEmail = iUserService.findUserByEmail(users.getEmail());
        boolean duplicate = (userWithSameEmail != null);
        if (duplicate) {
            FacesUtils.error("user.registration.error.emailAlreadyExists");
        }
        return !duplicate;
    }

    /**
     * Check if provided password and password verification are equal and valid.
     * 
     * @return true if password is valid and false otherwise.
     */
    public boolean isValid() {
        boolean valid = true;
        if (password == null || password.trim().length() == 0
                || !password.equals(passwordVerification)) {
            FacesUtils.error("user.registration.error.passwordsDoNotMatch");
            valid = false;
        }
        if (users.getEmail() == null || users.getEmail().trim().length() == 0) {
        	FacesUtils.error("user.registration.error.emailEmpty");
            valid = false;
        }
        // TODO: validate password strength
        return valid;
    }

    /**
     * Update registered user's information and save her as registered.
     */
    public void saveUser() {
        // Check if confirmation is not sent to the user
        users.setPassword(PasswordUtils.hashPassword(password));
        users.setUserName(users.getEmail());
        users.setRegistered(Boolean.TRUE);
        iUserService.updateUser(users);
        UserConfirmation userConfirmation = iUserService.findConfirmationByUser(users);
        if (userConfirmation == null) {
            // Create new confirmation
            userConfirmation = new UserConfirmation();
            userConfirmation.setCode(UniqueIdGenerator.getUniqueId());
            userConfirmation.setUser(users);
            iUserService.saveUserConfirmation(userConfirmation);
        }
        
        System.out.println("Send email with confirmation code: " + userConfirmation);
    }

    /**
     * Password verification getter.
     * 
     * @return Password verification.
     */
    public String getPasswordVerification() {
        return passwordVerification;
    }

    /**
     * Password verification setter.
     * 
     * @param passwordVerification
     *            Verification to set.
     */
    public void setPasswordVerification(String passwordVerification) {
        this.passwordVerification = passwordVerification;
    }

    /**
     * Password getter.
     * 
     * @return User password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Password verification setter.
     * 
     * @param password
     *            Password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * User getter.
     * 
     * @return Current user.
     */
    public Users getUser() {
        return users;
    }

    /**
     * Clear user filled form.
     */
    public void clear() {
        users.setFirstName(null);
        users.setLastName(null);
        users.setEmail(null);
        users.setPassword(null);
    }

	public IUserService getiUserService() {
		return iUserService;
	}

	public void setiUserService(IUserService iUserService) {
		this.iUserService = iUserService;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUser(Users users) {
		this.users = users;
	}

    
    
}
