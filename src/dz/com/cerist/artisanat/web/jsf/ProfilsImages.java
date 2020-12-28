package dz.com.cerist.artisanat.web.jsf;



import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;


import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.model.DefaultStreamedContent;


import dz.com.cerist.artisanat.entite.Item;

import dz.com.cerist.artisanat.service.IItemService;




@ManagedBean(name = "profilsImages")
@RequestScoped
public class ProfilsImages implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = -2042053293822044789L;

	/*
	
	@ManagedProperty(name="iProduitService", value="#{iProduitService}")
	private IProduitService iProduitService;

	private DefaultStreamedContent image;
	
	public DefaultStreamedContent getImage() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        }
        else {
            // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
        	String produitId  = context.getExternalContext().getRequestParameterMap().get("produitId");
            System.out.println(produitId);
        	Produits produit = iProduitService.getProduitbyId(Long.valueOf(produitId)) ; 
        	System.out.println(produit);
            image = new DefaultStreamedContent(new ByteArrayInputStream(produit.getImageProduit()));
            System.out.println(image);
           return image;
        }
    }
	
	*/
	
	
	@ManagedProperty(name="iItemService", value="#{iItemService}")
	private IItemService iItemService;

	private DefaultStreamedContent image;
	
	public DefaultStreamedContent getImage() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        }
        else {
            // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
        	String itemId  = context.getExternalContext().getRequestParameterMap().get("itemId");
        	System.out.println(itemId);
        	Item item = iItemService.getItemById(Long.valueOf(itemId)) ; 
        	System.out.println(item);
            
        	image = new DefaultStreamedContent(new ByteArrayInputStream(item.getImageProduit()));
            System.out.println(image);
           return image;
        }
    }
	
	
	
	
	public void setImage(DefaultStreamedContent image) {
		this.image = image;
	}




	public IItemService getiItemService() {
		return iItemService;
	}




	public void setiItemService(IItemService iItemService) {
		this.iItemService = iItemService;
	}



	
	
	
/*
	public IProduitService getiProduitService() {
		return iProduitService;
	}




	public void setiProduitService(IProduitService iProduitService) {
		this.iProduitService = iProduitService;
	}
	

*/

}
