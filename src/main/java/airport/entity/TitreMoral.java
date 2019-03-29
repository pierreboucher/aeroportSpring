package airport.entity;

public enum TitreMoral {

	PR("Privee"), PB("Publique");
	
	private String texte;
	
	private TitreMoral(String texte) {
		this.texte = texte;
	}

	public String getTexte() {
		return texte;
	}
	
}
