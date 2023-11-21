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

    // Метод для получения выбранных элементов из списка
    public List<String> getSelectedItems() {
        return checkBoxList.getSelectedValuesList();
    }

    // Добавление элемента в список
    public void addItem(String item) {
        listModel.addElement(item);
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