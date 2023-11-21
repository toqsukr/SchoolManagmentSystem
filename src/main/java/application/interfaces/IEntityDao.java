package application.interfaces;

import application.database.EntityDao;

public interface IEntityDao<T> {
    static <T> EntityDao<T> getEntityDao(Class<T> entityClass) {
        return new EntityDao<>(entityClass);
    }
}
