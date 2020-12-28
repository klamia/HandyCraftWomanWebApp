/**
 * UserBean.java
 * Created: Oct 25, 2007 12:25:22 AM
 */
package dz.com.cerist.artisanat.web.jsf;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import dz.com.cerist.artisanat.commons.constants.CommonConstants;
import dz.com.cerist.artisanat.commons.utils.ServletUtils;
import dz.com.cerist.artisanat.commons.utils.UniqueIdGenerator;

import dz.com.cerist.artisanat.entite.Users;
import dz.com.cerist.artisanat.service.IUserService;



/**
 * User related services component. Basically every session has its own user,
 * either it is registered or not registered. If user is not registered it still
 * has {@link Users} entity atached to her. She is identified by unique id set in
 * browser cookie. When she registers the same {@link Users} entity is updated
 * with information provided (phone, address etc.) and entity status changed to
 * registered.
 * 
 * @author Ignas
 * 
 */
@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -150792176134111609L;

	/** User service remote ejb. */
	@ManagedProperty(value="#{iUserService}")
    private IUserService iUserService;

    /** Current user. */
    private Users users;
    private Boolean loggedIn=false;
    
	public IUserService getiUserService() {
		return iUserService;
	}

	public void setiUserService(IUserService iUserService) {
		this.iUserService = iUserService;
	}

	public void setUser(Users users) {
		this.users = users;
	}

	/**
     * Gets current user. If user is not yet presented in session, it tries to
     * get cookie set in browser, identify user and set it to session. If no
     * cookie found it creates new user and sets cookie to its browser.
     */
    @SuppressWarnings("rawtypes")
	public Users getUser() {
        if (users == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            Map cookieMap = facesContext.getExternalContext()
                    .getRequestCookieMap();

            // Get cookie containing user unique id.
            Cookie cookie = (Cookie) cookieMap
                    .get(CommonConstants.COOKIE_PARAM_USER_ID);
            if (cookie == null
                    || cookie.getValue() == null
                    || ServletUtils.getRequest().getAttribute(
                            CommonConstants.REQUEST_PARAM_LOGOUT) == Boolean.TRUE) {
                // if cookie does not exist.
                cookie = UserBean.createNewUserCookie(null);
            }

            String uniqueId = cookie.getValue();
            Users users = iUserService.findUserByUniqueId(uniqueId);
            if (users == null) {
                // Create new user.
                users = new Users();
                users.setUniqueId(uniqueId);
                users.setVisitedOn(new Date());
                users.setRegistered(false);
                users = iUserService.saveUser(users);

            } else {
                // Mark last visited date if user already exists.
                users.setVisitedOn(new Date());
                users = iUserService.updateUser(users);
            }
            // Update cookie value.
            ServletUtils.getResponse().addCookie(cookie);
            this.users = users;
        }
        return users;
    }

    /**
     * Reloads newest data of user from database.
     */
    public void reloadUser() {
        users = iUserService.findUserByUniqueId(users.getUniqueId());
    }

    /*
    public void changeCurrentUserAddress(Address address) {
        user.setShippingAddress(address);
        iUserService.updateUser(user);
    }
*/
    // /**
    // * Resets user.
    // */
    // public void resetUser() {
    // Cookie cookie = UserBean.createNewUserCookie(null);
    // String uniqueId = cookie.getValue();
    //
    // User user = new User();
    // user.setUniqueId(uniqueId);
    // user.setVisitedOn(new Date());
    // user.setRegistered(false);
    // user = userService.saveUser(user);
    //
    // log.debug("User #0 created", user);
    // // Update cookie value.
    // ServletUtils.getResponse().addCookie(cookie);
    // this.user = user;
    // }

    /**
     * 
     * Login user.
     * 
     * @param users
     *            User to login
     */
    public void loginUser(Users users) {
        // TODO: Do something with user which was anonymous before this login
        // Create cookie containing user unique id.
        Cookie cookie = UserBean.createNewUserCookie(users.getUniqueId());
        users.setVisitedOn(new Date());
        iUserService.updateUser(users);
        ServletUtils.getResponse().addCookie(cookie);
        this.users = users;
        this.loggedIn=true;
        System.out.println(loggedIn);
        
    }

    /**
     * Logout current user.
     */
    @SuppressWarnings("rawtypes")
	public void logoutUser() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Map cookieMap = facesContext.getExternalContext().getRequestCookieMap();

        // Get cookie containing user unique id.
        Cookie cookie = (Cookie) cookieMap
                .get(CommonConstants.COOKIE_PARAM_USER_ID);
        if (cookie != null) {
            // TODO set logoff parameter
            cookie.setMaxAge(-CommonConstants.COOKIE_MAX_AGE);
            ServletUtils.getResponse().addCookie(cookie);
        }
        this.loggedIn=false;
    }

    /**
     * Create new cookie for a new user.
     * 
     * @return Newly created Cookie object.
     */
    private static Cookie createNewUserCookie(String userId) {
        Cookie cookie = new Cookie(CommonConstants.COOKIE_PARAM_USER_ID,
                userId != null ? userId : UniqueIdGenerator.getUniqueId());
        HttpServletRequest request = ServletUtils.getRequest();
        cookie.setPath(request.getContextPath());
        cookie.setMaxAge(CommonConstants.COOKIE_MAX_AGE);
        return cookie;
    }

    public Boolean getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    




}
