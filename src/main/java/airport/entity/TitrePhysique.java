package airport.entity;

public enum TitrePhysique {

	M("Monsieur"), MME("Madame"), MLLE("Mademoiselle");
	
	private String texte;
	
	private TitrePhysique(String texte) {
		this.texte = texte;
	}

	public String getTexte() {
		return texte;
	}
	
}

