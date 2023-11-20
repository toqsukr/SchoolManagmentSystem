package application;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import application.graphic.MainMenu;

public class App 
{
		public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ss_persistence");
		public static EntityManager em = emf.createEntityManager();
		public static MainMenu mainMenu = new MainMenu();
		public static void main( String[] args ) {
				mainMenu.showWindow();
		}
}