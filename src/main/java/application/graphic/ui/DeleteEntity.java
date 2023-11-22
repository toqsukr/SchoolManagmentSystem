package application.graphic.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import application.database.EntityDao;
import application.interfaces.IEntityFrame;

public class DeleteEntity<T, E extends IEntityFrame<T>> extends ToolButton  {
    public DeleteEntity(Class<T> entityClass, E parentWindow) {
    super("Удалить", "images/remove.png");
    this.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        EntityDao<T> dao = new EntityDao<>(entityClass);
        List<T> objects = parentWindow.getObjectsToDelete();
        for(T object: objects) {
          dao.deleteObject(object);
        }
        parentWindow.setTable();
      }
    });
  }
}
