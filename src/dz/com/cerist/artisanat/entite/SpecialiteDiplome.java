/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dz.com.cerist.artisanat.entite;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lamia
 */
@Entity
@Table(name = "specialite_diplome")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SpecialiteDiplome.findAll", query = "SELECT s FROM SpecialiteDiplome s"),
    @NamedQuery(name = "SpecialiteDiplome.findById", query = "SELECT s FROM SpecialiteDiplome s WHERE s.id = :id"),
    @NamedQuery(name = "SpecialiteDiplome.findByIntitule", query = "SELECT s FROM SpecialiteDiplome s WHERE s.intitule = :intitule"),
    @NamedQuery(name = "SpecialiteDiplome.findByDescription", query = "SELECT s FROM SpecialiteDiplome s WHERE s.description = :description")})
public class SpecialiteDiplome implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
	@Column(name = "version")
    @Version
    private Integer version;
    @Basic(optional = false)
    @Column(name = "intitule")
    private String intitule;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "diplome_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Diplomes diplomeID;

    public SpecialiteDiplome() {
    }

    public SpecialiteDiplome(Long id) {
        this.id = id;
    }

    public SpecialiteDiplome(Long id, String intitule, String description) {
        this.id = id;
        this.intitule = intitule;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Diplomes getDiplomeID() {
        return diplomeID;
    }

    public void setDiplomeID(Diplomes diplomeID) {
        this.diplomeID = diplomeID;
    }

    
    
    
    public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpecialiteDiplome)) {
            return false;
        }
        SpecialiteDiplome other = (SpecialiteDiplome) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.com.cerist.artisanat.entite.SpecialiteDiplome[ id=" + id + " ]";
    }
    
}
