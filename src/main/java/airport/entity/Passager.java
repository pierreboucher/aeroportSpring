package airport.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "passager")
@SequenceGenerator(name = "seqPassager", sequenceName = "seq_passager", initialValue = 100, allocationSize = 1)
@NamedQueries({
	@NamedQuery(name="Passager.findAllInFlight",
			query="Select distinct p from Passager p"
					+ " left join fetch p.reservations r"
					+ " left join fetch r.vol v"
					+ " where v = :flight")
})	public class Passager {
	@Id
	@Column(name = "id_passager", length = 150, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPassager")
	private long id;
	@Version
	private int version;
	private String nom;
	private String prenom;
	@Embedded
	private Adresse adresse;
	@OneToMany(mappedBy = "passager")
	private Set<Reservation> reservations;

	public Passager() {

	}
	
	


	public Passager(String nom, String prenom, Adresse adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}




	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Passager other = (Passager) obj;
		if (id != other.id)
			return false;
		return true;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	
}
