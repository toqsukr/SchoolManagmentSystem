package application.interfaces;

import java.util.List;

public interface IEntityFrame<T> {
  public void setTable();
  public List<T> getObjectsToDelete();
}
