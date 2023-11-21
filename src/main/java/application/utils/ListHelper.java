package application.utils;

import java.util.ArrayList;
import java.util.List;

import application.database.EntityDao;
import application.interfaces.IEntityDao;

public class ListHelper<T extends IEntityDao<T>> {
  public List<T> getSelectedList(List<String> strings, Class<T> entityClass) {
    List<T> objects = new ArrayList<>();
    for(String string: strings) {
      EntityDao<T> dao = new EntityDao<>(entityClass);
      objects.add(dao.findObject(string));
    }
    return objects;
  }
}
