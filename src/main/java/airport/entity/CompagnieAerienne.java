package airport.entity;

import java.util.Set;

import javax.persistence.*;


@Entity
@SequenceGenerator(name = "seqCompagnie", sequenceName = "seq_compagnie", initialValue = 100, allocationSize = 1)
public class CompagnieAerienne {
	@Id
	@Column(name="id_compagnie")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCompagnie")
	private Long id;
	@Column(length = 50, nullable = false)
	private String nom;
	@OneToMany(mappedBy="key.compagnie")
	private Set<CompagnieAerienneVol> vols;
	
	
	
	
	public CompagnieAerienne(String nom) {
		super();
		this.nom = nom;
	}
	public CompagnieAerienne() {
		super();
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
	public Set<CompagnieAerienneVol> getVols() {
		return vols;
	}
	public void setVols(Set<CompagnieAerienneVol> vols) {
		this.vols = vols;
	}


	
	
	
	

}
