package application.graphic.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import application.database.EntityDao;
import application.interfaces.IAddObject;
import application.interfaces.IEntityName;

public class AddEntity<T extends IEntityName, E extends IAddObject<T>> extends JButton {
  public AddEntity(String name, Class<T> entityClass, E parentWindow) {
    super(name);
    this.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        EntityDao<T> dao = new EntityDao<>(entityClass);
        T object = parentWindow.getObjectToAdd();
        dao.saveObject(object);
      }
    });
  }
}