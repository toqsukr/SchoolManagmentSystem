package application.graphic.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import application.database.EntityDao;
import application.interfaces.IEntityFrame;

public class DeleteEntity<T, E extends IEntityFrame<T>> extends ToolButton  {
    public DeleteEntity(Class<T> entityClass, E parentWindow) {
    super("Удалить", "images/remove.png");
    this.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        List<T> objects = parentWindow.getObjectsToDelete();
        if(objects.size() > 0) {
          String message = "Вы действительно хотите удалить выбранную(ые) запись(и)?";
          int result = JOptionPane.showConfirmDialog(null,
                  message,
                  "Подтверждение действия",
                  JOptionPane.YES_NO_OPTION,
                  JOptionPane.QUESTION_MESSAGE);
          if (result == JOptionPane.YES_OPTION) {
            EntityDao<T> dao = new EntityDao<>(entityClass);
            for(T object: objects) {
              dao.deleteObject(object);
            }
            parentWindow.setTable();
          }
        }
      }
    });
  }
}
