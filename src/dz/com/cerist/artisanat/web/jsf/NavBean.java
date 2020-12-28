package dz.com.cerist.artisanat.web.jsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;




@ManagedBean(name = "navBean")
@SessionScoped
public class NavBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -431968511904065662L;

	private String page = "/artisane/item/defaultItem";
	
	private String pageVente = "/artisane/vente/defaultVente";

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getPageVente() {
		return pageVente;
	}

	public void setPageVente(String pageVente) {
		this.pageVente = pageVente;
	}
	 
	 


}
