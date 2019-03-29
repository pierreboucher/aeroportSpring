package airport.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CompagnieAerienneVolPk implements Serializable{
	
	@ManyToOne
	@JoinColumn(name = "id_vol")
	private Vol vol;
	@ManyToOne
	@JoinColumn(name = "id_compagnie")
	private CompagnieAerienne compagnie;

	
	
	public CompagnieAerienneVolPk(Vol vol, CompagnieAerienne compagnie) {
		super();
		this.vol = vol;
		this.compagnie = compagnie;
	}
	public CompagnieAerienneVolPk() {
		super();
	}
	public Vol getVol() {
		return vol;
	}
	public void setVol(Vol vol) {
		this.vol = vol;
	}
	public CompagnieAerienne getCompagnie() {
		return compagnie;
	}
	public void setCompagnie(CompagnieAerienne compagnie) {
		this.compagnie = compagnie;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((compagnie == null) ? 0 : compagnie.hashCode());
		result = prime * result + ((vol == null) ? 0 : vol.hashCode());
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
		CompagnieAerienneVolPk other = (CompagnieAerienneVolPk) obj;
		if (compagnie == null) {
			if (other.compagnie != null)
				return false;
		} else if (!compagnie.equals(other.compagnie))
			return false;
		if (vol == null) {
			if (other.vol != null)
				return false;
		} else if (!vol.equals(other.vol))
			return false;
		return true;
	}
	
	

}
