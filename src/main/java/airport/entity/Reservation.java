package airport.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "reservation")
@SequenceGenerator(name = "seqReservation", sequenceName = "seq_reservation", initialValue = 100, allocationSize = 1)
@NamedQuery(name = "Reservation.findAllWithPassagerAndVol",
query = "select r from Reservation r left join fetch r.vol left join fetch r.passager")
public class Reservation {
	@Id
	@Column(name = "id_reservation", length = 150, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqReservation")
	private long id;
	@Column(name = "date_reservation", length = 150, nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date;
	@Column(name = "num_reservation", length = 150, nullable = false)
	private Integer numero;
	@Version
	private int version;
	@ManyToOne
	private Client client;
	@ManyToOne
	private Passager passager;
	@ManyToOne
	private Vol vol;

	public Reservation() {

	}

	public Reservation(Date date, Integer numero) {

		this.date = date;
		this.numero = numero;
	}

	public Reservation(Integer numero) {

		this.numero = numero;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Passager getPassager() {
		return passager;
	}

	public void setPassager(Passager passager) {
		this.passager = passager;
	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Reservation other = (Reservation) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
