package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Product;

public class LoadDatatoTable {
	private JTable table;
	private JTextField textfield;
	private Product product;

	public LoadDatatoTable() {
		
	}
	public LoadDatatoTable(JTable table ,JTextField textField) {
		this.setTable(table);
		this.setTextfield(textField);
	}
	public LoadDatatoTable(JTable table) {
		this.table = table;
	}
	
	public LoadDatatoTable(Product product,JTable table) {
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
    public void Loaddatatotable_employee(ResultSet rs){
        ((DefaultTableModel)table.getModel()).setNumRows(0);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        try {
            while(rs.next()){
                Object row[] = new Object[8];
                row[0]= rs.getInt(1);
                row[1]= rs.getString(2);
                row[2]= rs.getString(3);
                row[3]= rs.getString(4);
                row[4]= rs.getString(5);
                row[5]= rs.getString(6);
                row[6]= rs.getInt(7);
                row[7]= rs.getString(8);
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadDatatoTable.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Loadata function ERROR");
        }
    }
    //load from database
    public void Loaddatatotable_product(ResultSet rs){
        ((DefaultTableModel)table.getModel()).setNumRows(0);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        try {
            while(rs.next()){
                Object row[] = new Object[7];
                row[0]= rs.getInt(1);
                row[1]= rs.getObject(2);
                row[2]= rs.getInt(3);
                row[3]= rs.getObject(4);
                row[4]= rs.getObject(5);
                row[5]= rs.getObject(6);
                row[6]= rs.getInt(7);
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadDatatoTable.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Loadata function ERROR");
        }
    }
    //load from database
    public void Loaddatatotable_Import(ResultSet rs){
        ((DefaultTableModel)table.getModel()).setNumRows(0);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        try {
            while(rs.next()){
                Object row[] = new Object[9];
                row[0]= rs.getObject(1);
                row[1]= rs.getObject(2);
                row[2]= rs.getObject(3);
                row[3]= rs.getObject(4);
                row[4]= rs.getObject(5);
                row[5]= rs.getObject(6);
                row[6]= rs.getObject(7);
                row[7]= rs.getObject(8);
                row[8]= rs.getObject(9);
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadDatatoTable.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Loadata function ERROR");
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
        row[3]= product.getProducer();
        row[4]= product.getProduceTime();
        row[5]= product.getExpireTime();
        row[6]= product.getTotal();
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
	public void Loaddatatotable_Export(ResultSet rs) {
		// TODO Auto-generated method stub
        ((DefaultTableModel)table.getModel()).setNumRows(0);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        try {
            while(rs.next()){
                Object row[] = new Object[6];
                row[0]= rs.getObject(1);
                row[1]= rs.getObject(2);
                row[2]= rs.getObject(3);
                row[3]= rs.getObject(4);
                row[4]= rs.getObject(5);
                row[5]= rs.getObject(6);
  
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadDatatoTable.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Loadata function ERROR");
        }
	}

}
