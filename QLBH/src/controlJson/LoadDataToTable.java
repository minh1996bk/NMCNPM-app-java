package controlJson;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Employee;
import model.ExportReceipt;
import model.ImportReceipt;
import model.Product;
import model.Supplier;

public class LoadDataToTable {
  private JTable table;
  private JTextField textfield;
  private Product product;

  public LoadDataToTable() {
    
  }
  public LoadDataToTable(JTable table ,JTextField textField) {
    this.setTable(table);
    this.setTextfield(textField);
  }
  public LoadDataToTable(JTable table) {
    this.table = table;
  }
  
  public LoadDataToTable(Product product,JTable table) {
    this.table = table;
    this.product = product;
  }

  /**
   * @return the table
   */
  public JTable getTable() {
    return table;
  }
  /**
   * @param table the table to set
   */
  public void setTable(JTable table) {
    this.table = table;
  }
  /**
   * @return the textfield
   */
  public JTextField getTextfield() {
    return textfield;
  }
  /**
   * @param textfield the textfield to set
   */
  public void setTextfield(JTextField textfield) {
    this.textfield = textfield;
  }
  
  
  
  //load empployeetable from database
  public void Loaddatatotable_employee(ArrayList<Employee> employees){
    
      ((DefaultTableModel)table.getModel()).setNumRows(0);
      DefaultTableModel model = (DefaultTableModel) table.getModel();
      for (Employee employee: employees){
          Object row[] = new Object[8];
          row[0]= employee.getIdNumber();
          row[1]= employee.getName();
          row[2]= employee.getSex();
          row[3]= employee.getDateOfBirth();
          row[4]= employee.getAddress();
          row[5]= employee.getPhoneNumber();
          row[6]= employee.getCoefficientsSalary();
          row[7]= employee.getPosition();
          model.addRow(row);
      }
  }
  
  
  
  //load from database
  public void Loaddatatotable_product(ArrayList<Product> products){
      ((DefaultTableModel)table.getModel()).setNumRows(0);
      DefaultTableModel model = (DefaultTableModel) table.getModel();
      for (Product product: products) {
          Object row[] = new Object[5];
          row[0]= product.getIdNumber();
          row[1]= product.getName();
          row[2]= product.getPrice();
          row[3]= product.getTotal();
          row[4] = product.getType();
          model.addRow(row);
      }
  }
  //load from database
  public void Loaddatatotable_Import(ArrayList<ImportReceipt> importReceipts){
      ((DefaultTableModel)table.getModel()).setNumRows(0);
      DefaultTableModel model = (DefaultTableModel) table.getModel();

      for(ImportReceipt importReceipt: importReceipts) {
        for(Product product: importReceipt.getArray()) {
          Object row[] = new Object[7];
          row[0]= importReceipt.getCode();
          row[1]= importReceipt.getImporter().getName();
          row[2]= importReceipt.getSupplier().getName();
          row[3]= importReceipt.getTime();
          row[4]= product.getName();
          row[5]= product.getTotal();
          row[6]= product.getPrice();

          model.addRow(row);          
        }
      }
  }
  //load from your text
  public void Loaddatatotable() {
    CheckImformation check = new CheckImformation();
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    Object row[] = new Object[7];
    row[0]= product.getIdNumber();
      row[1]= product.getName();
      row[2]= product.getPrice();
      row[3]= product.getTotal();
      row[4]= product.getType();
      if(!check.CheckProductInTable(String.valueOf(row[1]), String.valueOf(row[2]),String.valueOf(row[4]), table)) {
        model.addRow(row);
      }
    }
   
  /**
   * @return the product
   */
  public Product getProduct() {
    return product;
  }
  /**
   * @param product the product to set
   */
  public void setProduct(Product product) {
    this.product = product;
  }
  /**
   * @return the money
   */
  public void Loaddatatotable_Export(ArrayList<ExportReceipt> exportReceipts) {
    // TODO Auto-generated method stub
    ((DefaultTableModel)table.getModel()).setNumRows(0);
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    for (ExportReceipt exportReceipt: exportReceipts) {
    	for (Product product: exportReceipt.getItem()) {
	       Object row[] = new Object[6];
	       row[0]= exportReceipt.getCode();
	       row[1]= exportReceipt.getEmployee().getName();
	       row[2]= exportReceipt.getTime();
	       row[3]= product.getName();
	       row[4]= product.getPrice();
	       row[5]= product.getTotal(); 
	       model.addRow(row);
	    }
    }
  }
  public void loaddatatotable_supplier(ArrayList<Supplier> suppliers) {
	    ((DefaultTableModel)table.getModel()).setNumRows(0);
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    for(Supplier supplier: suppliers) {
	    	  Object row[] = new Object[6];
	    	  row[0] = supplier.getIdNumber();
	    	  row[1] = supplier.getName();
	    	  row[2] = supplier.getAddress();
	    	  row[3] = supplier.getEmail();
	    	  row[4] = supplier.getPhoneNumber();
	    	  model.addRow(row);
	    }
  }
}
