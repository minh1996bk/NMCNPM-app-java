package view;

import javax.swing.table.DefaultTableModel;

public class MyModel extends DefaultTableModel {
  public MyModel(String[] columnNames) {
    super(columnNames, 0);
  }
  
  @Override
  public boolean isCellEditable(int row, int column) {
    // TODO Auto-generated method stub
    return false;
  }
}
