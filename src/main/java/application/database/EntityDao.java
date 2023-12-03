package application.database;

import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

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
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (HibernateException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
            em.getTransaction().rollback();
        }
    }

    public void updateObject(T object) {
        try {
            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();
        } catch (HibernateException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
            em.getTransaction().rollback();
        }
    }

    public void deleteObject(T object) {
        try {
            em.getTransaction().begin();
            if (em.contains(object)) {
                em.remove(object);
            } else {
                Object identifier = em.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(object);
                T attachedObject = em.find(entityClass, identifier);
                if (attachedObject != null) {
                    em.remove(attachedObject);
                }
            }
            em.getTransaction().commit();
        } catch (HibernateException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
            em.getTransaction().rollback();
        }
    }

    public void clearTable() {
        try {
            em.getTransaction().begin();
            em.createQuery("DELETE FROM " + entityClass.getSimpleName()).executeUpdate();
            em.getTransaction().commit();
        } catch (HibernateException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
            em.getTransaction().rollback();
        }
    }

    public List<T> getWithParams(String hql, Map<String, Object> params) {
        try {
            em.getTransaction().begin();
            TypedQuery<T> query = em.createQuery(hql, entityClass);
    
            // Устанавливаем параметры запроса из Map
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
    
            List<T> filteredList = query.getResultList();
            em.getTransaction().commit();
            return filteredList;
        } catch (HibernateException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
            em.getTransaction().rollback();
            return null;
        }
    }
}
