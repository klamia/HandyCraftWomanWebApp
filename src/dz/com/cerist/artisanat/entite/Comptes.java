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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;





/**
 *
 * @author Lamia
 */
@Entity
@Table(name = "comptes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comptes.findAll", query = "SELECT cpt FROM Comptes cpt"),
    @NamedQuery(name = "Comptes.findById", query = "SELECT cpt FROM Comptes cpt WHERE cpt.id = :id"),
    @NamedQuery(name = "Comptes.findByUsername", query = "SELECT cpt FROM Comptes cpt WHERE cpt.username = :username"),
    @NamedQuery(name = "Comptes.findByPassword", query = "SELECT cpt FROM Comptes cpt WHERE cpt.password = :password"),
    @NamedQuery(name = "Comptes.findByEmail", query = "SELECT cpt FROM Comptes cpt WHERE cpt.email = :email")})
public class Comptes implements Serializable {
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
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
	@Column(name="enabled")
	private Boolean enabled=true;
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="roleId", updatable=false, referencedColumnName="code_role")
	private Role role;

    @OneToOne(mappedBy = "compte", fetch = FetchType.LAZY)
	private Artisanes artisane;
    
    @OneToOne(mappedBy = "compte", fetch = FetchType.LAZY)
	private Clients client;
    
    
    public Comptes() {
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    public Boolean getEnabled() {
		return enabled;
	}


	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}


	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
	
	public Integer getVersion() {
		return version;
	}


	public void setVersion(Integer version) {
		this.version = version;
	}

	
	public Artisanes getArtisane() {
		return artisane;
	}


	public void setArtisane(Artisanes artisane) {
		this.artisane = artisane;
	}


	public Clients getClient() {
		return client;
	}


	public void setClient(Clients client) {
		this.client = client;
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
        if (!(object instanceof Comptes)) {
            return false;
        }
        Comptes other = (Comptes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
    	return String.format("Comptes[%s,%s,%s,%s]", getId(), getRole(), getUsername(), getEmail());
    }
    
}