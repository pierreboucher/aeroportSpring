package airport.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "login")
@SequenceGenerator(name = "seqLogin", sequenceName = "seq_login", initialValue = 100, allocationSize = 1)
public class Login {

	@Id
	@Column(name = "idLogin")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqLogin")
	private long id;
	private String login;
	private String motDePasse;
	@OneToOne(mappedBy="login")
	private Client client;
	
	
	
	public Login() {
		
	}
	
	
	public Login(long id, String login, String motDePasse) {
		super();
		this.id = id;
		this.login = login;
		this.motDePasse = motDePasse;
	}
	public Login(String login, String motDePasse) {
		super();
	
		this.login = login;
		this.motDePasse = motDePasse;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	
	
}



