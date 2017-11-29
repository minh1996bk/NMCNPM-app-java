package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JTable;
import java.sql.Date;

public class Product {
  private int idNumber;
  private String name;
  private int price;
  private String producer;
  private Date produceTime;
  private Date expireTime;
  private int total;
  private JTable table;
  private int row;
  
  public Product() {
    
  }
  public Product(int idNumber,String name,int price,String producer, Date produceTime,Date expireTime , int total){
	  this.idNumber = idNumber;
	  this.name = name;
	  this.price = price;
	  this.producer = producer;
	  this.produceTime = produceTime;
	  this.expireTime = expireTime;
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

  public String getProducer() {
    return producer;
  }

  public void setProducer(String producer) {
    this.producer = producer;
  }

  public Date getProduceTime() {
    return produceTime;
  }

  public void setProduceTime(Date produceTime) {
    this.produceTime = produceTime;
  }

  public Date getExpireTime() {
    return expireTime;
  }

  public void setExpireTime(Date expireTime) {
    this.expireTime = expireTime;
  }
  
  /**
   * Method convert attributes of an instance of Product Class to String[].
   * @return String[]
   */
  
  public String[] toArrayString() {
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    String[] array = {"" + this.idNumber, this.name, "" + this.price, this.producer, 
        df.format(this.produceTime), df.format(this.expireTime)};
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
	    pr.setProducer(String.valueOf(table.getModel().getValueAt(row,3)));
	    pr.setTotal(Integer.parseInt(String.valueOf(table.getModel().getValueAt(row,6))));
		pr.setProduceTime(Date.valueOf(String.valueOf(table.getModel().getValueAt(row,4))));
		pr.setExpireTime(Date.valueOf(String.valueOf(table.getModel().getValueAt(row,5))));
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
		    pr.setProducer(String.valueOf(table.getModel().getValueAt(i,3)));
		    pr.setTotal(Integer.parseInt(String.valueOf(table.getModel().getValueAt(i,6))));
			pr.setProduceTime(Date.valueOf(String.valueOf(table.getModel().getValueAt(i,4))));
			pr.setExpireTime(Date.valueOf(String.valueOf(table.getModel().getValueAt(i,5))));
			arraylist.add(i, pr);
			i++;
		}
	    return arraylist;
	}
}

