package airport.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("P")
// @NamedQueries({
//		@NamedQuery(name = "Formateur.findAllWithEnseingementsAndSalle", query = "select distinct f from Formateur f left join fetch f.matieresEnseignees me left join fetch me.key.matiere left join fetch f.salle ") })

public class ClientPhysique extends Client{



	
	@Column(name = "titre")
	@Enumerated(EnumType.ORDINAL)
	private TitrePhysique titre;
	private String prenom;

	
	public ClientPhysique() {

	}

	
	public ClientPhysique(TitrePhysique titre, String prenom, String nom, Login login, Integer numeroTel, String email, Adresse adresse) {
		super(nom, numeroTel, email, adresse, login);
		this.titre = titre;
		this.prenom = prenom;
	
	}



	public TitrePhysique getTitre() {
		return titre;
	}


	public void setTitre(TitrePhysique titre) {
		this.titre = titre;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


//	public Set<Matiere> getMatieres() {
//		return matieres;
//	}
//
//	public void setMatieres(Set<Matiere> matieres) {
//		this.matieres = matieres;
//	}
}

