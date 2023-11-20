package database;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;

import entities.Student;
import application.App;

public class StudentDao {

    public List<Student> getAllStudents() throws HibernateException {
        try {
            App.em.getTransaction().begin();
            List<Student> students = App.em.createQuery("FROM Student", Student.class).getResultList();
            App.em.getTransaction().commit();
            return students;

        } catch (HibernateException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
            return null;
        }
    }

    public Student findstudent(int id) {
        App.em.getTransaction().begin();
        Student student = App.em.find(Student.class, id);
        App.em.getTransaction().commit();
        return student;
    }

    public void saveStudent(Student student) {
        try {
            App.em.getTransaction().begin();
            App.em.persist(student);
            App.em.getTransaction().commit();
        } catch (HibernateException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }

    public void updateStudent(Student student) {
        try {
            App.em.getTransaction().begin();
            App.em.merge(student);
            App.em.getTransaction().commit();
        } catch (HibernateException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }

    public void deleteStudent(Student student) {
        try {
            App.em.getTransaction().begin();
            App.em.createQuery("DELETE FROM Student r WHERE studentID = :id", null).setParameter("id", student.getStudentID())
                    .executeUpdate();
            App.em.getTransaction().commit();
        } catch (HibernateException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }

    public void clearStudents() {
        try {
            App.em.getTransaction().begin();
            App.em.createQuery("DELETE FROM Student").executeUpdate();
            App.em.getTransaction().commit();
        } catch (HibernateException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }
}
