package airport.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "seqVol", sequenceName = "seq_vol", initialValue = 100, allocationSize = 1)
@NamedQueries({
	@NamedQuery(name="Vol.findAllFrom",
	query="Select distinct v from Vol v"
			+ " left join fetch v.depart a"
			+ " left join fetch a.villes vi"
			+ " left join fetch vi.key.ville city"
			+ " where city = :city"),
	@NamedQuery(name="Vol.findAllFromDate",
	query="Select distinct v from Vol v"
			+ " left join fetch v.depart a"
			+ " left join fetch a.villes vi"
			+ " left join fetch vi.key.ville city"
			+ " where city = :city and v.dateDepart = :date"),
	@NamedQuery(name="Vol.findAllFromTo",
	query="Select distinct v from Vol v"
			+ " left join fetch v.depart a"
			+ " left join fetch a.villes vi"
			+ " left join fetch vi.key.ville departure"
			+ " left join fetch v.arrivee a2"
			+ " left join fetch a2.villes vi2"
			+ " left join fetch vi2.key.ville arrival"
			+ " where departure = :departure and arrival = :arrival")
})	

public class Vol {
	@Id
	@Column(name = "id_vol")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqVol")
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date dateDepart;
	@Temporal(TemporalType.DATE)
	private Date dateArrivee;
	@Temporal(TemporalType.TIME)
	private Date heureDepart;
	@Temporal(TemporalType.TIME)
	private Date heureArrivee;
	
	@ManyToOne
	private Aeroport arrivee;

	@ManyToOne
	private Aeroport depart;
	
	@OneToMany(mappedBy = "vol")
	private Set<Reservation> reservations;
	
	@OneToMany(mappedBy="key.vol")
	private Set<Escale> escales;
	
	@OneToMany(mappedBy="key.vol")
	private Set<CompagnieAerienneVol> compagnies;

	
	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
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

	public Aeroport getArrivee() {
		return arrivee;
	}

	public void setArrivee(Aeroport arrivee) {
		this.arrivee = arrivee;
	}

	public Aeroport getDepart() {
		return depart;
	}

	public void setDepart(Aeroport depart) {
		this.depart = depart;
	}



	public Set<Escale> getEscales() {
		return escales;
	}

	public void setEscales(Set<Escale> escales) {
		this.escales = escales;
	}

	public Set<CompagnieAerienneVol> getCompagnies() {
		return compagnies;
	}

	public void setCompagnies(Set<CompagnieAerienneVol> compagnies) {
		this.compagnies = compagnies;
	}

	public Vol() {
		super();
	}

	public Vol(Aeroport depart, Aeroport arrivee, Date dateDepart, Date heureDepart, 
			Date dateArrivee,  Date heureArrivee) {
		super();
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
		this.arrivee = arrivee;
		this.depart = depart;

	}

	
	
}
