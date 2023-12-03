package application.interfaces;

import java.util.List;

public interface IEntityFrame<T> {
  public void initTable();
  public List<T> getSelectedObjects();
}
