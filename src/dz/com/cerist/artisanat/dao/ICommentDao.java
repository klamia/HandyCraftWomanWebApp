package dz.com.cerist.artisanat.dao;

import java.util.List;

import dz.com.cerist.artisanat.entite.Comment;
import dz.com.cerist.artisanat.entite.Item;

public interface ICommentDao {


    /**
     * Saves a new comment.
     * 
     * @param comment
     */
    void saveComment(Comment comment);

    /**
     * Gets gets pageable item comments.
     * 
     * @param item
     *            Item whose comments are loaded.
     * @param page
     *            Page number of comments.
     * @param commentsPerPage
     *            Number of comments per page.
     * @return List of comments.
     */
    List<Comment> getItemComments(Item item, int page, int commentsPerPage);

    /**
     * Gets total number of comments item has.
     * 
     * @param item
     *            Item whose comments are counted.
     * @return Number of comments.
     */
    Long getItemCommentsCount(Item item);

}
