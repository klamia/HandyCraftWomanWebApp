package dz.com.cerist.artisanat.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dz.com.cerist.artisanat.dao.ICommentDao;

import dz.com.cerist.artisanat.entite.Comment;
import dz.com.cerist.artisanat.entite.Item;

@Service("iCommentService")
@Transactional
public class CommentServiceImpl implements ICommentService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7168871285777705890L;

	@Autowired
	private ICommentDao iCommentDao;
	
	public ICommentDao getiCommentDao() {
		return iCommentDao;
	}

	public void setiCommentDao(ICommentDao iCommentDao) {
		this.iCommentDao = iCommentDao;
	}

	@Override
	public void saveComment(Comment comment) {
		iCommentDao.saveComment(comment);

	}

	@Override
	public List<Comment> getItemComments(Item item, int page, int commentsPerPage) {
		
		return iCommentDao.getItemComments(item, page, commentsPerPage);
	}

	@Override
	public Long getItemCommentsCount(Item item) {
		// TODO Auto-generated method stub
		return iCommentDao.getItemCommentsCount(item);
	}

}
