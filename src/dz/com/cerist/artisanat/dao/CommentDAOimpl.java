package dz.com.cerist.artisanat.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dz.com.cerist.artisanat.entite.Comment;
import dz.com.cerist.artisanat.entite.Item;

@Repository("iCommentDao")
@Transactional
public class CommentDAOimpl implements ICommentDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2009588187812626246L;

	@PersistenceContext(unitName = "ArtisanaPU")
	private EntityManager em;
	
	/** Count number of comment by item query constant. */
    private static final String COUNT_COMMENTS_BY_ITEM_QUERY = "Comment.count";

    /** Find comments by item query constant. */
    private static final String FIND_COMMENTS_BY_ITEM_QUERY = "Comment.findByItemId";
	
	
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void saveComment(Comment comment) {
		em.persist(comment);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getItemComments(Item item, int page, int commentsPerPage) {
		Query query = em.createNamedQuery(CommentDAOimpl.FIND_COMMENTS_BY_ITEM_QUERY);
        query.setParameter("id", item.getId());
        query.setFirstResult((page - 1) * commentsPerPage);
        query.setMaxResults(commentsPerPage);
        return query.getResultList();
	}

	@Override
	public Long getItemCommentsCount(Item item) {
		Query query = em.createNamedQuery(CommentDAOimpl.COUNT_COMMENTS_BY_ITEM_QUERY);
        query.setParameter("id", item.getId());
        return (Long) query.getSingleResult();
	}

}
