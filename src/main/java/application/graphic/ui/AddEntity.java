package application.graphic.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import application.database.EntityDao;
import application.interfaces.IAddFrame;

public class AddEntity<T> extends JButton {
  public AddEntity(String name, Class<T> entityClass, IAddFrame<T> parentWindow) {
    super(name);
    this.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        EntityDao<T> dao = new EntityDao<>(entityClass);
        T object = parentWindow.getObjectToAdd();
        dao.saveObject(object);
        parentWindow.clearFields();
        parentWindow.closeOperation();
      }
    });
  }
}