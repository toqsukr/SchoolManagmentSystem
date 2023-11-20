package application;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import entities.*;


public class App 
{

		public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ss_persistence");
		public static EntityManager em = emf.createEntityManager();
		public static void main( String[] args ) {
				em.getTransaction().begin();
				Klass klass = new Klass("1308");
				em.persist(klass);

				Subject subject = new Subject("Pravo");
				em.persist(subject);

				Student student = new Student("Alek", "Tinkoff", klass);
				em.persist(student);

				Teacher teacher = new Teacher("Ivan", "Nuzhnov", subject);
				em.persist(teacher);

				em.getTransaction().commit();
		}
}