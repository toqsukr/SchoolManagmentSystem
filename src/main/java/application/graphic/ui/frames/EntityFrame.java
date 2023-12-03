package application.graphic.ui.frames;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.Container;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import application.entities.Person;
import application.graphic.ui.MyTable;
import application.graphic.ui.ToolBar;
import application.graphic.ui.buttons.DeleteEntityButton;
import application.graphic.ui.buttons.ToolButton;
import application.interfaces.IEntityFrame;
import application.utils.ListHelper;
import application.utils.ReportManager;


public abstract class EntityFrame<T extends Person> extends ChildFrame implements IEntityFrame<T> {

  /**
   * This button deletes selected field
   */
  private DeleteEntityButton<T> deleteBtn;

  /**
   * This button forms report
   */
  private ToolButton reportBtn;

  protected final ToolBar toolBar = new ToolBar();

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
  protected final MyTable table;

  /**
   * Creation of the scroll panel
   */
  private final JScrollPane scroll;

  protected final JPanel filterPanel = new JPanel();

  public abstract void initTable();

  public Class<T> entityClass;

  public EntityFrame(String frameName, final String[] _columns, Class<T> _entityClass, MyFrame parent) {
    super(frameName, parent);
    this.setBounds(200, 150, 800, 600);
    this.setResizable(false);
    entityClass = _entityClass;
    columns = _columns; 
    defaultTable = new DefaultTableModel(data, columns);

    table = new MyTable(defaultTable);

    scroll = new JScrollPane(table);

    table.getTableHeader().setReorderingAllowed(false);

    Container container = this.getContentPane();
    container.setLayout(new BorderLayout());


    deleteBtn = new DeleteEntityButton<>(entityClass, this);
    
    reportBtn = new ToolButton("Сделать отчет", "images/report.png");
    reportBtn.addActionListener(new ReportEventListener());
    

    toolBar.add(deleteBtn);
    toolBar.add(reportBtn);

    container.add(toolBar, BorderLayout.NORTH);
    container.add(scroll, BorderLayout.CENTER);
    container.add(filterPanel, BorderLayout.SOUTH);
  }

    public List<T> getSelectedObjects() {
        int[] selectedIndexes = table.getSelectedRows();
        List<String> stringObjects = new ArrayList<>();
        for(int index: selectedIndexes) {
            stringObjects.add(defaultTable.getValueAt(index, 0).toString());
        }
        ListHelper<T> helper = new ListHelper<>();
        return helper.getSelectedList(stringObjects, entityClass);
    }

    private class ReportEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            printReport();
        }
    }

    private void printReport() {
        try {
            float[] columnSizes = new float[columns.length];
            Arrays.fill(columnSizes, 1f);
            ReportManager reportManager = new ReportManager(defaultTable, this, "Отчет\n\n\n\n",
            columnSizes, columns);
            reportManager.printReport();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, exception.getMessage(), "Ошибка формирования отчета",
            JOptionPane.PLAIN_MESSAGE);
        }
    }
}
