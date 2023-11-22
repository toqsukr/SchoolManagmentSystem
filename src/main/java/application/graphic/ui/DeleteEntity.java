package application.graphic.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import application.database.EntityDao;
import application.interfaces.IEntityName;

public class DeleteEntity<T extends IEntityName, E extends EntityFrame<T>> extends JButton  {
    public DeleteEntity(String name, Class<T> entityClass, E parentWindow) {
    super(name);
    this.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        EntityDao<T> dao = new EntityDao<>(entityClass);
        T object = parentWindow.getObjectToDelete();
        dao.deleteObject(object);
      }
    });
  }
}
