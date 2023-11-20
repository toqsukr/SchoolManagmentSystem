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
            List<T> list = App.em.createQuery("FROM " + entityClass.getSimpleName(), entityClass)
                                 .getResultList();
            return list;
        } catch (HibernateException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
            return null;
        }
    }

    public T findObject(int id) {
        T object = App.em.find(entityClass, id);
        return object;
    }

    public T findObject(String id) {
        T object = App.em.find(entityClass, id);
        return object;
    }

    public void saveObject(T object) {
        try {
            App.em.persist(object);
        } catch (HibernateException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }

    public void updateObject(T object) {
        try {
            App.em.merge(object);
        } catch (HibernateException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }

    public void deleteObject(T object) {
        try {
            if (App.em.contains(object)) {
                App.em.remove(object);
            } else {
                Object identifier = App.em.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(object);
                T attachedObject = App.em.find(entityClass, identifier);
                if (attachedObject != null) {
                    App.em.remove(attachedObject);
                }
            }
        } catch (HibernateException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }

    public void clearTable() {
        try {
            App.em.createQuery("DELETE FROM " + entityClass.getSimpleName()).executeUpdate();
        } catch (HibernateException exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }
}
