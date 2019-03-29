package airport.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("E")
// @NamedQueries({
//		@NamedQuery(name = "Formateur.findAllWithEnseingementsAndSalle", query = "select distinct f from Formateur f left join fetch f.matieresEnseignees me left join fetch me.key.matiere left join fetch f.salle ") })

public class ClientEl extends Client{


	@Column(name = "titre")
	@Enumerated(EnumType.ORDINAL)
	private TitrePhysique titre;
	@Column(name = "siret")
	private String prenom;

	
	public ClientEl() {

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



}

