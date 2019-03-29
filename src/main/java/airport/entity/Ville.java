package airport.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "seqVille", sequenceName = "seq_ville", initialValue = 100, allocationSize = 1)
public class Ville {
	
	@Id
	@Column(name = "id_ville")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqVille")
	private Long id;
	private String nom;
	@OneToMany(mappedBy="key.ville")
	private Set<Connecter> aeroports;
	
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



	public Set<Connecter> getAeroports() {
		return aeroports;
	}

	public void setAeroports(Set<Connecter> aeroports) {
		this.aeroports = aeroports;
	}

	public Ville() {
		super();
	}

	public Ville(String nom) {
		super();
		this.nom = nom;
	}
	
	
}
