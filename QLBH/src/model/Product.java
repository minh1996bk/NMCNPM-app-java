package model;

import java.util.ArrayList;
import javax.swing.JTable;


public class Product {
  private int idNumber;
  private String name;
  private int price;
  private int total;
  private JTable table;
  private int row;
  
  public Product() {
    
  }
  public Product(int idNumber,String name,int price, int total){
	  this.idNumber = idNumber;
	  this.name = name;
	  this.price = price;
	  this.total = total;
  }

  public Product(JTable table, int row) {

	  this.table = table;
	  this.setRow(row);
}
public int getIdNumber() {
    return idNumber;
  }

  public void setIdNumber(int idNumber) {
    this.idNumber = idNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  
  /**
   * Method convert attributes of an instance of Product Class to String[].
   * @return String[]
   */
  
  public String[] toArrayString() {
    String[] array = {"" + this.idNumber, this.name, "" + this.price,};
    return array;
  }

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}
	/**
	 * @param row the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}
	public Product Converttoproduct(){
		Product pr = new Product();
	    pr.setIdNumber( Integer.parseInt(String.valueOf(table.getModel().getValueAt(row, 0))));
	    pr.setName((String.valueOf( table.getModel().getValueAt(row,1)))); 
	    pr.setPrice((Integer.parseInt(String.valueOf( table.getModel().getValueAt(row,2)))));
	    pr.setTotal(Integer.parseInt(String.valueOf(table.getModel().getValueAt(row,3))));
	    return pr;
	}
	
	public ArrayList<Product> ConvertToLArraylist(){
		ArrayList<Product > arraylist = new ArrayList<>();
		
		int i = 0;
		while(i< row) {
			Product pr = new Product();
		    pr.setIdNumber( Integer.parseInt(String.valueOf(table.getModel().getValueAt(i, 0))));
		    pr.setName((String.valueOf( table.getModel().getValueAt(i,1)))); 
		    pr.setPrice((Integer.parseInt(String.valueOf( table.getModel().getValueAt(i,2)))));
		    pr.setTotal(Integer.parseInt(String.valueOf(table.getModel().getValueAt(i,3))));
			arraylist.add(i, pr);
			i++;
		}
	    return arraylist;
	}
}

