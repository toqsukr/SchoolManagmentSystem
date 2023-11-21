package application.graphic.ui;

import javax.swing.table.DefaultTableModel;

public class MyTable {
  public static void clearTable(DefaultTableModel table) {
        int n = table.getRowCount();
        for (int i = 0; i < n; i++) {
            table.removeRow(n - i - 1);
        }
    }
}
