package airport.entity;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Client")
@SequenceGenerator(name = "seqClient", sequenceName = "seq_client", initialValue = 100, allocationSize = 1)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING, length = 1)
@NamedQueries({ @NamedQuery(name = "Client.findAll", query = "select c from Client c"),
	@NamedQuery(name="Client.findByVille", query = "select c from Client c where c.adresse.ville=:ville")
})
public abstract class Client {
	@Id
	@Column(name = "id_client")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqClient")
	private Long id;
	@Column(name = "nom", length = 150, nullable = false)
	private String nom;
	@Column(name = "numeroTel")
	private Integer numeroTel;
	@Column(name = "numeroFax")
	private Integer numeroFax;
	@Column(name = "email", length = 150)
	private String email;
	@Embedded
	private Adresse adresse;

	@OneToOne
	@JoinColumn(name="id_login")
	private Login login;
	
	@OneToMany(mappedBy="client")
	private Set<Reservation> reservations;
	
	@Version
	private int version;



	public Client(String nom, Integer numeroTel, Integer numeroFax, String email, Adresse adresse,
			Set<Reservation> reservations, int version) {
		super();
		this.nom = nom;
		this.numeroTel = numeroTel;
		this.numeroFax = numeroFax;
		this.email = email;
		this.adresse = adresse;
		this.reservations = reservations;
		this.version = version;
	}
	
	






	public Client(String nom, Integer numeroTel, String email, Adresse adresse, Login login) {
		super();
		this.nom = nom;
		this.numeroTel = numeroTel;
		this.email = email;
		this.adresse = adresse;
		this.login = login;
	}








	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public Integer getNumeroTel() {
		return numeroTel;
	}



	public void setNumeroTel(Integer numeroTel) {
		this.numeroTel = numeroTel;
	}



	public Integer getNumeroFax() {
		return numeroFax;
	}



	public void setNumeroFax(Integer numeroFax) {
		this.numeroFax = numeroFax;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Adresse getAdresse() {
		return adresse;
	}



	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}



	public Set<Reservation> getReservations() {
		return reservations;
	}



	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}



	public int getVersion() {
		return version;
	}



	public void setVersion(int version) {
		this.version = version;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	public Client() {
		super();
	}

	
	
}

