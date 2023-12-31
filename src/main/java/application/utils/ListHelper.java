package application.utils;

import java.util.ArrayList;
import java.util.List;

import application.database.EntityDao;
import application.interfaces.IEntityName;

public class ListHelper<T> {
  public List<T> getSelectedList(List<String> strings, Class<T> entityClass) {
    List<T> objects = new ArrayList<>();
    for(String string: strings) {
      EntityDao<T> dao = new EntityDao<>(entityClass);
      objects.add(dao.findObject(string));
    }
    return objects;
  }

  public static <E extends IEntityName> boolean isAtList(List<String> list, E checkingObject) {
    boolean flag = false;
    for(String object: list) {
      if(object.equals(checkingObject.getName())) {
        flag = true;
        break;
      }
    }
    return flag;
  }
}
