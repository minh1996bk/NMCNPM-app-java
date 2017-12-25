package model;

import java.util.ArrayList;
import javax.swing.JTable;


public class Product {
  private int id;
  private String name;
  private int price;
  private int total;
  private String type;
  
  public Product() {
    
  }
  public Product(int id,String name,int price, int total,String type){
	  this.id = id;
	  this.name = name;
	  this.price = price;
	  this.total = total;
	  this.type = type;
  }


public int getIdNumber() {
    return id;
  }

  public void setIdNumber(int idNumber) {
    this.id = idNumber;
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
    String[] array = {"" + this.id, this.name, "" + this.price,};
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

	public Product Converttoproduct(JTable table, int row){
		Product pr = new Product();
	    pr.setIdNumber( Integer.parseInt(String.valueOf(table.getModel().getValueAt(row, 0))));
	    pr.setName((String.valueOf( table.getModel().getValueAt(row,1)))); 
	    pr.setPrice((Integer.parseInt(String.valueOf( table.getModel().getValueAt(row,2)))));
	    pr.setTotal(Integer.parseInt(String.valueOf(table.getModel().getValueAt(row,3))));
	    pr.setType(String.valueOf(table.getModel().getValueAt(row, 4)));
	    return pr;
	}
	
	public ArrayList<Product> ConvertToLArraylist(JTable table, int row){
		ArrayList<Product > arraylist = new ArrayList<>();
		
		int i = 0;
		while(i< row) {
			Product pr = new Product();
		    pr.setIdNumber( Integer.parseInt(String.valueOf(table.getModel().getValueAt(i, 0))));
		    pr.setName((String.valueOf( table.getModel().getValueAt(i,1)))); 
		    pr.setPrice((Integer.parseInt(String.valueOf( table.getModel().getValueAt(i,2)))));
		    pr.setTotal(Integer.parseInt(String.valueOf(table.getModel().getValueAt(i,3))));
		    pr.setType(String.valueOf(table.getModel().getValueAt(i, 4)));
			arraylist.add(i, pr);
			i++;
		}
	    return arraylist;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
}

