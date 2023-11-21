package application.database;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityDao<T> {
    private Class<T> entityClass;
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ss_persistence");

    private static EntityManager em = emf.createEntityManager();

    public EntityDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public List<T> getAll() throws HibernateException {
        try {
            List<T> list = em.createQuery("FROM " + entityClass.getSimpleName(), entityClass)
                                 .getResultList();
            return list;
        } catch (HibernateException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
            return null;
        }
    }

    public T findObject(int id) {
        T object = em.find(entityClass, id);
        return object;
    }

    public T findObject(String id) {
        T object = em.find(entityClass, id);
        return object;
    }

    public void saveObject(T object) {
        try {
            em.persist(object);
        } catch (HibernateException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }

    public void updateObject(T object) {
        try {
            em.merge(object);
        } catch (HibernateException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }

    public void deleteObject(T object) {
        try {
            if (em.contains(object)) {
                em.remove(object);
            } else {
                Object identifier = em.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(object);
                T attachedObject = em.find(entityClass, identifier);
                if (attachedObject != null) {
                    em.remove(attachedObject);
                }
            }
        } catch (HibernateException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }

    public void clearTable() {
        try {
            em.createQuery("DELETE FROM " + entityClass.getSimpleName()).executeUpdate();
        } catch (HibernateException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }
}
