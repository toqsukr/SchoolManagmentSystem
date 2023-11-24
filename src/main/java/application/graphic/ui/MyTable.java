package application.graphic.ui;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class MyTable extends JTable {

    public MyTable(DefaultTableModel defaultTable) {
        super(defaultTable);

        setDefaultRenderer(Object.class, new CustomCellRenderer());
    }

    @Override
    public boolean isCellEditable(int i, int j) {
        return false;
    }

    public static void clearTable(DefaultTableModel table) {
        int n = table.getRowCount();
        for (int i = 0; i < n; i++) {
            table.removeRow(n - i - 1);
        }
    }

    private static class CustomCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            table.setRowHeight(row, 25); // Установка высоты
            table.getColumnModel().getColumn(column).setPreferredWidth(50); // Установка ширины

            return cell;
        }
    }
}
