package airport.entity;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Entity
@DiscriminatorValue("M")
//@NamedQueries({
// 		@NamedQuery(name = "Formateur.findAllWithEnseingementsAndSalle", query = "select distinct f from Formateur f left join fetch f.matieresEnseignees me left join fetch me.key.matiere left join fetch f.salle ") })

public class ClientMoral extends Client{

	
	@Column(name = "titre")
	@Enumerated(EnumType.ORDINAL)
	private TitreMoral titre;
	@Column(name = "siret")
	private String siret;

	
	public ClientMoral() {

	}

	
	public ClientMoral(TitreMoral titre, String siret, String nom, Login login, Integer numeroTel, String email, Adresse adresse) {
		super(nom, numeroTel, email, adresse, login);
		this.titre = titre;
		this.siret = siret;
	
	}

	public TitreMoral getTitre() {
		return titre;
	}


	public void setTitre(TitreMoral titre) {
		this.titre = titre;
	}


	public String getSiret() {
		return siret;
	}


	public void setSiret(String siret) {
		this.siret = siret;
	}





//	public Set<Matiere> getMatieres() {
//		return matieres;
//	}
//
//	public void setMatieres(Set<Matiere> matieres) {
//		this.matieres = matieres;
//	}
}

