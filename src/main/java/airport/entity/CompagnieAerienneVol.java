package airport.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class CompagnieAerienneVol {
	
	@EmbeddedId
	private CompagnieAerienneVolPk key;
	private String numero;

	public CompagnieAerienneVolPk getKey() {
		return key;
	}

	public void setKey(CompagnieAerienneVolPk key) {
		this.key = key;
	}

	public CompagnieAerienneVol() {
		super();
	}

	
	
	public CompagnieAerienneVol(CompagnieAerienneVolPk key, String numero) {
		super();
		this.key = key;
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
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
		CompagnieAerienneVol other = (CompagnieAerienneVol) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	

}
