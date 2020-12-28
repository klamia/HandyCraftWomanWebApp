/**
 * CommentAction.java
 * Created: 8:55:17 PM Jul 30, 2008
 */
package dz.com.cerist.artisanat.web.jsf;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import dz.com.cerist.artisanat.commons.paging.Pager;
import dz.com.cerist.artisanat.commons.paging.StandartPager;
import dz.com.cerist.artisanat.entite.Comment;
import dz.com.cerist.artisanat.entite.Item;
import dz.com.cerist.artisanat.entite.Users;
import dz.com.cerist.artisanat.service.ICommentService;
import dz.com.cerist.artisanat.service.IItemService;



/**
 * Component for browsing loaded comments, adding new comments, voting for
 * valuable comments and other comments related stuff.
 * 
 * @author Ignas
 * 
 */
@ManagedBean(name = "commentAction")
@ViewScoped
public class CommentAction implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Constant for number of comments per page. */
    private static final int COMMENTS_NUMBER_PER_PAGE = 5;

    /** Comment service remote ejb. */
    @ManagedProperty(value="#{iCommentService}")
    private ICommentService iCommentService;

    /** Item service remote ejb. */
    @ManagedProperty(value="#{iItemService}")
    private IItemService iItemService;

    /**
     * Injected user bean used for getting current logged in user. Needed when
     * user post comment about item.
     */
    @ManagedProperty(value="#{userBean}")
    private UserBean userBean;

    /**
     * Page request parameter. Used in all comment tab to identify which is
     * current page of comments.
     */
    private Integer page;

    /** Item id request parameter. Used to load selected item. */
    private Long itemId;

    /** New comment about item. */
    private Comment comment;

    /** Loaded selected item. */
    private Item item;

    

	/**
     * Is invoked on creation of this component.
     */
    public void init() {
        item = iItemService.getItemById(itemId);
        System.out.println("AAAAAAAAAAA " + item.getId());
        comment = new Comment();
    }

    /**
     * Loads comments for current item. It uses variables item and page to
     * decide which item and which page of comments to show. This is seam
     * factory method.
     */
    public List<Comment> getComments() {
        return iCommentService.getItemComments(item, page, CommentAction.COMMENTS_NUMBER_PER_PAGE);
    }

    /**
     * Gets comment for filling its values and saving new comment to database.
     * 
     * @return New comment
     */
    public Comment getComment() {
        return comment;
    }

    /**
     * Adding new comment to database.
     */
    public void addComment() {
        comment.setItem(item);
        comment.setUser(getCurrentLoggedInUser());
        comment.setCommentedOn(new Date());
        iCommentService.saveComment(comment);
        comment = new Comment();
    }

    /**
     * Getter of {@link Pager}.
     * 
     * @return {@link Pager} for paging comments in all comments subtab.
     */
    public Pager getCommentsPager() {
        return new StandartPager(page != null ? page : 1,
                CommentAction.COMMENTS_NUMBER_PER_PAGE, iCommentService.getItemCommentsCount(item).intValue());
    }

    // TODO do it.
    /**
     * Vote if comment was valuable.
     * 
     * @param wasValuable
     */
    public void wasCommentValuable(Boolean wasValuable) {
        // TODO Auto-generated method stub
    }

    /**
     * Logged user getter.
     * 
     * @return Current logged in user.
     */
   public Users getCurrentLoggedInUser() {
        Users currentUser = userBean.getUser();
        return currentUser;
    }


   public ICommentService getiCommentService() {
		return iCommentService;
	}

	public void setiCommentService(ICommentService iCommentService) {
		this.iCommentService = iCommentService;
	}

	public IItemService getiItemService() {
		return iItemService;
	}

	public void setiItemService(IItemService iItemService) {
		this.iItemService = iItemService;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

}
