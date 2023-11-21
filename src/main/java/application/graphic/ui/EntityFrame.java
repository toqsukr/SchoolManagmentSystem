package application.graphic.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.lang.reflect.InvocationTargetException;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import application.graphic.AddGUI;


public abstract class EntityFrame<T extends AddGUI> extends ChildFrame {
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

  private JTextField searchNameField;

  private JComboBox<String> comboSearchKlass = new JComboBox<>();

  private final ToolBar toolBar = new ToolBar();

  /**
   * Table column names
   */
  private String[] columns;

  /**
   * Fields of the table
   */
  private String[][] data = {};

  /**
   * The table model storing displaying data
   */  
  protected DefaultTableModel defaultTable;


  /**
   * Create the table
   */
  private final JTable table;

  /**
   * Creation of the scroll panel
   */
  private final JScrollPane scroll;

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

  private Class<T> entityClass;

  private T addObject;

  public abstract void setTable();

  public EntityFrame(String frameName, String searchName, final String[] _columns, Class<T> _entityClass, MyFrame parent) {
    super(frameName, parent);
    this.setBounds(200, 150, 800, 600);
    this.setResizable(false);
    entityClass = _entityClass;
    columns = _columns; 
    defaultTable = new DefaultTableModel(data, columns);

    try {
        addObject = entityClass.getDeclaredConstructor(EntityFrame.class).newInstance(this);
    } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
        e.printStackTrace();
    }

    table = new JTable(defaultTable) {
        @Override
        public boolean isCellEditable(int i, int j) {
            return j != 0 && getEditingPermit();
        }
    };

    scroll = new JScrollPane(table);

    table.getTableHeader().setReorderingAllowed(false);

    Container container = this.getContentPane();
    container.setLayout(new BorderLayout());

    searchBtn.setBackground(new Color(0xDFD9D9D9, false));
    clearInputBtn.setBackground(new Color(0xDFD9D9D9, false));
    disruptInputBtn.setBackground(new Color(0xDFD9D9D9, false));


    searchNameField = new JTextField(searchName, 20);

    searchNameField.setMargin(new Insets(2, 2, 3, 0));

    searchBtn.setMargin(new Insets(1, 6, 1, 6));

    disruptInputBtn.setMargin(new Insets(1, 6, 1, 6));

    clearInputBtn.setMargin(new Insets(1, 6, 1, 6));

    filterPanel.add(searchNameField);
    filterPanel.add(comboSearchKlass);
    filterPanel.add(searchBtn);
    filterPanel.add(clearInputBtn);
    filterPanel.add(disruptInputBtn);

    addBtn = new AddButton<T>(addObject);
    deleteBtn = new ToolButton("Удалить", "images/remove.png");
    editBtn = new ToolButton("Редактировать", "images/edit.png");
    reportBtn = new ToolButton("Сделать отчет", "images/report.png");

    toolBar.addButton(addBtn);
    toolBar.addButton(deleteBtn);
    toolBar.addButton(editBtn);
    toolBar.addButton(reportBtn);

    container.add(toolBar, BorderLayout.NORTH);
    container.add(scroll, BorderLayout.CENTER);
    container.add(filterPanel, BorderLayout.SOUTH);
  }
}
