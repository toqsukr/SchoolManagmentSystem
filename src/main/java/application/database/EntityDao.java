package application.database;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;

import application.App;

public class EntityDao<T> {
    private Class<T> entityClass;

    public EntityDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public List<T> getAll() throws HibernateException {
        try {
            App.em.getTransaction().begin();
            List<T> list = App.em.createQuery("FROM " + entityClass.getSimpleName(), entityClass)
                                 .getResultList();
            App.em.getTransaction().commit();
            return list;

        } catch (HibernateException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
            return null;
        }
    }

    public T findObject(int id) {
        App.em.getTransaction().begin();
        T object = App.em.find(entityClass, id);
        App.em.getTransaction().commit();
        return object;
    }

    public T findObject(String id) {
        App.em.getTransaction().begin();
        T object = App.em.find(entityClass, id);
        App.em.getTransaction().commit();
        return object;
    }

    public void saveObject(T object) {
        try {
            App.em.getTransaction().begin();
            App.em.persist(object);
            App.em.getTransaction().commit();
        } catch (HibernateException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }

    public void updateObject(T object) {
        try {
            App.em.getTransaction().begin();
            App.em.merge(object);
            App.em.getTransaction().commit();
        } catch (HibernateException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }

    public void deleteObject(T object) {
        try {
            App.em.getTransaction().begin();
            if (App.em.contains(object)) {
                App.em.remove(object);
            } else {
                Object identifier = App.em.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(object);
                T attachedObject = App.em.find(entityClass, identifier);
                if (attachedObject != null) {
                    App.em.remove(attachedObject);
                }
            }
            App.em.getTransaction().commit();
        } catch (HibernateException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }

    public void clearTable() {
        try {
            App.em.getTransaction().begin();
            App.em.createQuery("DELETE FROM " + entityClass.getSimpleName()).executeUpdate();
            App.em.getTransaction().commit();
        } catch (HibernateException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }
}
