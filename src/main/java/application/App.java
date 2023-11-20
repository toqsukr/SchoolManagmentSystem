package application;
import entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class App 
{
		public static void main( String[] args )
    {
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("ss_persistence");
				EntityManager em = emf.createEntityManager();

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