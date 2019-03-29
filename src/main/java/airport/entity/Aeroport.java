package airport.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "seqAeroport", sequenceName = "seq_aeroport", initialValue = 100, allocationSize = 1)
public class Aeroport {
	@Id
	@Column(name = "id_aeroport")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAeroport")
	private Long id;
	private String nom;
	@OneToMany(mappedBy="arrivee")
	private Set<Vol> arrivees; // vols qui arrivent
	@OneToMany(mappedBy="depart")
	private Set<Vol> departs; // vols au depart
	@OneToMany(mappedBy="key.aeroport")
	private Set<Escale> escales; //vols qui font escales
	@OneToMany(mappedBy="key.aeroport")
	private Set<Connecter> villes; //les villes desservies par l'aeroport

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

	public Set<Vol> getArrivees() {
		return arrivees;
	}

	public void setArrivees(Set<Vol> arrivees) {
		this.arrivees = arrivees;
	}

	public Set<Vol> getDeparts() {
		return departs;
	}

	public void setDeparts(Set<Vol> departs) {
		this.departs = departs;
	}

	
	public Aeroport() {
		super();
	}

	public Set<Escale> getEscales() {
		return escales;
	}

	public void setEscales(Set<Escale> escales) {
		this.escales = escales;
	}

	public Set<Connecter> getVilles() {
		return villes;
	}

	public void setVilles(Set<Connecter> villes) {
		this.villes = villes;
	}

	public Aeroport(String nom) {
		super();
		this.nom = nom;
	}

	public Aeroport(String nom, Set<Connecter> villes) {
		super();
		this.nom = nom;
		this.villes = villes;
	}



	
	


}
