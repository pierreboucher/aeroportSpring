package airport.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Connecter {
	
	@EmbeddedId
	private ConnecterPk key;

	public ConnecterPk getKey() {
		return key;
	}

	public void setKey(ConnecterPk key) {
		this.key = key;
	}

	public Connecter() {
		super();
	}

	public Connecter(ConnecterPk key) {
		super();
		this.key = key;
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
		Connecter other = (Connecter) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
	
	

}
