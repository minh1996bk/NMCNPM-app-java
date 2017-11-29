package control;

import java.sql.Date;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import connectsql.ConnectImport_receipt;
import connectsql.Connectproduct;
import model.ImportReceipt;
import model.Product;

public class Insertbigdata {
	private JTable table;
	public Insertbigdata(JTable table) {
		this.setTable(table);
	}
	public Insertbigdata() {
		
	}
	//insert all row in table to producttable
	public void insertProducts() {
		Connectproduct con = new  Connectproduct();
		con.Connect();
		ResultSet rs = con.getData_product();
		int row = table.getRowCount();
		int count = 0;
		while(count<row) {
			Product pr = new Product();
		    pr.setIdNumber( Integer.parseInt(String.valueOf(table.getModel().getValueAt(count, 0))));
		    pr.setName((String.valueOf( table.getModel().getValueAt(count,1)))); 
		    pr.setPrice((Integer.parseInt(String.valueOf( table.getModel().getValueAt(count,2)))));
		    pr.setProducer(String.valueOf(table.getModel().getValueAt(count,3)));
		    pr.setTotal(Integer.parseInt(String.valueOf(table.getModel().getValueAt(count,6))));
			pr.setProduceTime(Date.valueOf(String.valueOf(table.getModel().getValueAt(count,4))));
			pr.setExpireTime(Date.valueOf(String.valueOf(table.getModel().getValueAt(count,5))));
			if(!con.CheckSurviralProduct(pr, rs)) {
				con.insertDB_product(pr);
			}
			count++;
		}
	}
	//insert importreceipt to importreceipt
	public void insertImportReceipt(ImportReceipt importReceipt) {
		ConnectImport_receipt con = new ConnectImport_receipt();
		con.Connect();
		int i = importReceipt.getArray().size();
		int count=0;
		while(count < i) {
			Product p = importReceipt.getArray().get(count);
			con.insertDB_importReceipt(importReceipt, p);
			count++;
		}
		JOptionPane.showMessageDialog(null, "Inserted all to Import receipt");
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
}
