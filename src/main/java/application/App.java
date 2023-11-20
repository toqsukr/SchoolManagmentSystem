package application;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

import database.EntityDao;
import entities.*;


public class App 
{

		public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ss_persistence");
		public static EntityManager em = emf.createEntityManager();
		public static void main( String[] args ) {
				EntityDao<Student> studentDao = new EntityDao<>(Student.class);
				Klass klass = new Klass("1308");
				Student alek = new Student("Alek", "Tinkoff", klass);
				studentDao.saveObject(alek);
				List<Student> students = studentDao.getAll();
				for(Student student: students) {
					System.out.println(student.getName() + " greeting you!");
				}
		}
}