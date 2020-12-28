package dz.com.cerist.artisanat.dao;


import dz.com.cerist.artisanat.entite.Users;
import dz.com.cerist.artisanat.entite.UserConfirmation;

public interface IUserDao {

	 /**
     * Saves new user.
     * 
     * @param users
     *            User to save.
     */
    Users saveUser(Users users);

    /**
     * Updates user information.
     * 
     * @param users
     *            User to update.
     */
    Users updateUser(Users users);

    /**
     * Finds user by unique id.
     * 
     * @param uniqueId
     *            Unique id.
     * @return User found.
     */
    Users findUserByUniqueId(String uniqueId);

    /**
     * Finds user by email.
     * 
     * @param email
     *            User email.
     * @return User found.
     */
    Users findUserByEmail(String email);

    /**
     * Saves user registration confirmation.
     * 
     * @param confirmation
     *            Confirmation to save.
     */
    void saveUserConfirmation(UserConfirmation confirmation);

    /**
     * Finds user registratio confirmation by user.
     * 
     * @param users
     *            User.
     * @return User registration confirmation.
     */
    UserConfirmation findConfirmationByUser(Users users);

    /**
     * Saves new user address.
     * 
     * @param address
     *            Address to save.
     */
   /* void saveUserAddress(User user, Address address);	*/
	
	
}
