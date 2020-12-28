package dz.com.cerist.artisanat.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dz.com.cerist.artisanat.commons.utils.PersistenceUtils;

import dz.com.cerist.artisanat.entite.Users;
import dz.com.cerist.artisanat.entite.UserConfirmation;

@Repository("iUserDao")
@Transactional
public class UserDAOimpl implements IUserDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3580095966039178996L;

	@PersistenceContext(unitName = "ArtisanaPU")
	private EntityManager em;
	
	
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	
	/** Find confirmation query constant. */
    private static final String FIND_CONFIRMATION_BY_USER_QUERY = "UserConfirmation.findByUser";

    /** Find user by email query constant. */
    private static final String FIND_USER_BY_EMAIL_QUERY = "User.findByEmail";

    /** Find user by unique id query constant. */
    private static final String FIND_USER_BY_UNIQUE_ID = "User.findByUniqueId";
	
	
	@Override
	public Users saveUser(Users users) {
		em.persist(users);
        return users;
	}

	@Override
	public Users updateUser(Users users) {
		// TODO Auto-generated method stub
		return em.merge(users);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Users findUserByUniqueId(String uniqueId) {
		Query query = em
                .createNamedQuery(UserDAOimpl.FIND_USER_BY_UNIQUE_ID);
        query.setParameter("id", uniqueId);
        return getUniqueUserFromResults(query.getResultList());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Users findUserByEmail(String email) {
		Query query = em
                .createNamedQuery(UserDAOimpl.FIND_USER_BY_EMAIL_QUERY);
        query.setParameter("email", email);
        return getUniqueUserFromResults(query.getResultList());
	}

	@Override
	public void saveUserConfirmation(UserConfirmation confirmation) {
		em.persist(confirmation);

	}

	@Override
	public UserConfirmation findConfirmationByUser(Users users) {
		Query query = em
                .createNamedQuery(UserDAOimpl.FIND_CONFIRMATION_BY_USER_QUERY);
        query.setParameter("user", users);
        return (UserConfirmation) query.getSingleResult();
	}

	/*
	@Override
	public void saveUserAddress(User user, Address address) {
		em.persist(address);
        em.flush();
        user.getUserAddresses().add(address);
        updateUser(user);

	}
*/
	/**
     * Because user has list of addresses to fetch we should use HashSet to get
     * only unique users (because if user have 3 addresses JPA will return 3
     * same users).
     * 
     * @param queryResults
     *            Reuslts of users query with fetched list of addresses.
     * @return Unique user.
     */
    private Users getUniqueUserFromResults(List<Users> queryResults) {
        Set<Users> uniqueUsers = new HashSet<Users>();
        uniqueUsers.addAll(queryResults);
        return (Users) PersistenceUtils.getSingleResult(new ArrayList<Users>(
                uniqueUsers));
    }




}
