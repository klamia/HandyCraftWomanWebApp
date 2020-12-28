package dz.com.cerist.artisanat.entite;

import java.io.Serializable;
import javax.persistence.*;



import java.util.List;



/**
 * The persistent class for the "ROLES" database table.
 * 
 */
@Entity
@Table(name="roles")
@NamedQueries({
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r "),
@NamedQuery(name = "Role.findById", query = "SELECT r FROM Role r WHERE r.coderole = :coderole"),
@NamedQuery(name = "Role.findByName", query = "SELECT r FROM Role r WHERE r.intitulerole = :intitulerole")

})
public class Role implements Serializable {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 8531050511559731145L;

	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="code_role")
	private Integer coderole;
	@Basic(optional = false)
	@Column(name = "version")
	@Version
	private Integer version;
	@Basic(optional = false)
	@Column(name="intitule_role")
	private String intitulerole;

	@OneToMany(mappedBy="role", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Comptes> comptes;
	
	
	
	
	public Role(){
		
	}

	/**
	 */
	

	public Integer getCoderole() {
		return coderole;
	}


	public void setCoderole(Integer coderole) {
		this.coderole = coderole;
	}



	public String getIntitulerole() {
		return intitulerole;
	}


	public void setIntitulerole(String intitulerole) {
		this.intitulerole = intitulerole;
	}

	

	public List<Comptes> getComptes() {
		return comptes;
	}

	public void setComptes(List<Comptes> comptes) {
		this.comptes = comptes;
	}

	
	
	
	
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	@Override
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("coderole=[").append(coderole).append("] ");
		buffer.append("intitulerole=[").append(intitulerole).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coderole == null) ? 0 : coderole.hashCode());
		return result;
	}

	/**
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Role))
			return false;
		Role equalCheck = (Role) obj;
		if ((coderole == null && equalCheck.coderole != null) || (coderole != null && equalCheck.coderole == null))
			return false;
		if (coderole != null && !coderole.equals(equalCheck.coderole))
			return false;
		return true;
	}
	

}