package dz.com.cerist.artisanat.entite;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tendance")
@NamedQueries({
    @NamedQuery(name = "Tendances.findAll", query = "SELECT td FROM Tendances td"),
    @NamedQuery(name = "Tendances.findById", query = "SELECT td FROM Tendances td WHERE td.id = :id"),
    @NamedQuery(name = "Tendances.findByNom", query = "SELECT td FROM Tendances td WHERE td.intitule = :intitule")})
public class Tendances implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6011144517490070090L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
	
	@Basic(optional = false)
	@Column(name="intitule")
	private String intitule;

	public Tendances() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}



}
