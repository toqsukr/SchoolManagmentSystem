package application.graphic.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;

import application.interfaces.IEntityName;

public class CheckBoxList<T extends IEntityName> extends JPanel {
    private DefaultListModel<String> listModel;
    private JList<String> checkBoxList;

    public CheckBoxList(List<T> list) {
        setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();

        for(T element: list) {
            listModel.addElement(element.getName());
        }

        checkBoxList = new JList<>(listModel);
        checkBoxList.setCellRenderer(new CheckBoxListCellRenderer());
        checkBoxList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        JScrollPane scrollPane = new JScrollPane(checkBoxList);
        add(scrollPane, BorderLayout.CENTER);
    }

    public List<String> getSelectedItems() {
        return checkBoxList.getSelectedValuesList();
    }

    public void addItem(String item) {
        listModel.addElement(item);
    }

    public void fillCheckbox(T object) {
        for (int i = 0; i < listModel.size(); i++) {
            setItemChecked(i, listModel.get(i).equals(object.getName()));
        }
    }

    public void fillCheckboxes(List<T> objects) {
        for(T object: objects) {
            fillCheckbox(object);
        }
    }

    public void resetCheckBoxes() {
        for (int i = 0; i < listModel.size(); i++) {
            setItemChecked(i, false);
        }
    }

    private void setItemChecked(int index, boolean checked) {
        if (index >= 0 && index < listModel.size()) {
            checkBoxList.getSelectionModel().removeSelectionInterval(index, index);
            if (checked) {
                checkBoxList.addSelectionInterval(index, index);
            }
        }
    }

    // Создаем рендерер для JList, который содержит чекбоксы
    private static class CheckBoxListCellRenderer extends JCheckBox implements ListCellRenderer<String> {
        @Override
        public Component getListCellRendererComponent(JList<? extends String> list, String value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            setComponentOrientation(list.getComponentOrientation());
            setFont(list.getFont());
            setText(value);

            // Устанавливаем состояние чекбокса в соответствии с выбором
            setSelected(isSelected);

            return this;
        }
    }
}