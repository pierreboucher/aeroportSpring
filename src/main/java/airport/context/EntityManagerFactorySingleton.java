package airport.context;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
	private static EntityManagerFactory emf=null;
	
	private EntityManagerFactorySingleton() {
		
	}
	
	public static EntityManagerFactory getInstance() {
		
		if(emf==null) {
			emf=Persistence.createEntityManagerFactory("airport"); //attention a bien avoir ici le mm nom que dans le persistence.xml
		}
		return emf;
		
	}
	
	public static void destroy() {
		if(emf!=null) {
			emf.close();
			emf=null;
		}
	}

}
