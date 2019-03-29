package airport.entity;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Escale {
	
	@EmbeddedId
	private EscalePk key;
	@Temporal(TemporalType.TIME)
	private Date heureDepart;
	@Temporal(TemporalType.TIME)
	private Date heureArrivee;
	
	public EscalePk getKey() {
		return key;
	}
	public void setKey(EscalePk key) {
		this.key = key;
	}
	public Date getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}
	public Date getHeureArrivee() {
		return heureArrivee;
	}
	public void setHeureArrivee(Date heureArrivee) {
		this.heureArrivee = heureArrivee;
	}
	public Escale() {
		super();
	}
	public Escale(EscalePk key, Date heureDepart, Date heureArrivee) {
		super();
		this.key = key;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
	}
	
	

}
