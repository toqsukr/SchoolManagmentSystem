package application.graphic.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class EntityFrame extends JFrame {
    /**
     * This button performs a search
     */
    private JButton searchBtn = new JButton("Искать");

    /**
     * This button performs a clear search inputs
     */
    private JButton clearInputBtn = new JButton("Очистить");

    /**
     * This button performs a disrupt values of search inputs
     */
    private JButton disruptInputBtn = new JButton("Сбросить фильтр");

    /**
     * This button adds new field into table
     */
    private ToolButton addBtn;

    /**
     * This button deletes selected field
     */
    private ToolButton deleteBtn;

    /**
     * This button allows you to edit selected field
     */
    private ToolButton editBtn;

    /**
     * This button forms report
     */
    private ToolButton reportBtn;


    private JComboBox<String> comboTeam = new JComboBox<>();

    private static final JTextField searchNameField = new JTextField("Имя учителя", 17);

    private JComboBox<String> searchTeam = new JComboBox<>();

    private JComboBox<String> comboAge = new JComboBox<>();

    private final ToolBar toolBar = new ToolBar();

    /**
     * Table column names
     */
    private final String[] columns = { "ID", "Имя", "Фамилия" };

    /**
     * Fields of the table
     */
    private String[][] data = {};

    /**
     * The table model storing displaying data
     */
    private DefaultTableModel racerTable = new DefaultTableModel(data, columns);


    /**
     * Create the table
     */
    private final JTable racers = new JTable(racerTable) {
        @Override
        public boolean isCellEditable(int i, int j) {
            return j != 0 && getEditingPermit();
        }
    };

    /**
     * Creation of the scroll panel
     */
    private final JScrollPane scroll = new JScrollPane(racers);

    /**
     * This panel store 2 inputs and search button
     */
    private final JPanel filterPanel = new JPanel();

    /***
     * Variable storing table edit status
     */
    private boolean editingPermit = false;

    private boolean getEditingPermit() {
        return editingPermit;
    }

  public EntityFrame(String name) {
    super(name);
    this.setBounds(200, 150, 800, 600);
    this.setResizable(false);

    racers.getTableHeader().setReorderingAllowed(false);

    Container container = this.getContentPane();
    container.setLayout(new BorderLayout());

    searchBtn.setBackground(new Color(0xDFD9D9D9, false));
    clearInputBtn.setBackground(new Color(0xDFD9D9D9, false));
    disruptInputBtn.setBackground(new Color(0xDFD9D9D9, false));

    searchNameField.setMargin(new Insets(2, 2, 3, 0));

    searchBtn.setMargin(new Insets(1, 6, 1, 6));

    disruptInputBtn.setMargin(new Insets(1, 6, 1, 6));

    clearInputBtn.setMargin(new Insets(1, 6, 1, 6));

    filterPanel.add(searchNameField);
    filterPanel.add(searchTeam);
    filterPanel.add(searchBtn);
    filterPanel.add(clearInputBtn);
    filterPanel.add(disruptInputBtn);

    addBtn = new ToolButton("Добавить");
    deleteBtn = new ToolButton("Удалить");
    editBtn = new ToolButton("Редактировать");
    reportBtn = new ToolButton("Сделать отчет");

    toolBar.addButton(addBtn);
    toolBar.addButton(deleteBtn);
    toolBar.addButton(editBtn);
    toolBar.addButton(reportBtn);

    container.add(toolBar, BorderLayout.NORTH);
    container.add(scroll, BorderLayout.CENTER);
    container.add(filterPanel, BorderLayout.SOUTH);
  }

  public void toggleVisible() {
    this.setVisible(!this.isVisible());
  }
}
