package application;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App 
{
		public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ss_persistence");
		public static EntityManager em = emf.createEntityManager();
		public static void main( String[] args ) {
				
		}
}