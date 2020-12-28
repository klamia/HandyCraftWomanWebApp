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
@Table(name="couleur")
@NamedQueries({
    @NamedQuery(name = "Couleurs.findAll", query = "SELECT cr FROM Couleurs cr"),
    @NamedQuery(name = "Couleurs.findById", query = "SELECT cr FROM Couleurs cr WHERE cr.id = :id"),
    @NamedQuery(name = "Couleurs.findByNom", query = "SELECT cr FROM Couleurs cr WHERE cr.intitule = :intitule")})


public class Couleurs implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2812018754470306888L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
	
	@Basic(optional = false)
	@Column(name="intitule")
	private String intitule;

	public Couleurs() {
		
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
