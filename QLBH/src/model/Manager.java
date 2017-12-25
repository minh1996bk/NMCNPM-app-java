package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Manager extends Employee {
  private int commission;
  
  public Manager() {
    
  }
  public Manager(int idNumber,String name,String sex,String birth,String address,String phone,int salary,String position, int commission) {
	  super(idNumber, name, sex, birth, address, phone, salary, position);
	  this.commission = commission;
  }
  public int getCommission() {
    return commission;
  }

  public void setCommission(int commission) {
    this.commission = commission;
  }

  public int countSalary() {
    return super.countSalary() + this.commission;
  }
  
  /**
   * This method creates a instance of ImportReceipt class.
   * @param supplier instance of Supplier that supplies products
   * @param listItem map contains :
   *      key is a product 
   *      value is Integer[] with amount of product and price of product
   * @return instance of ImportReceipt class
   */
  public Manager Converttomanager(ResultSet rs) {
	  Manager manager = new Manager();
	  try {
		while(rs.next()) {
		manager.setIdNumber(rs.getInt(1));
		manager.setName(rs.getString(2));
		manager.setSex(rs.getString(3));
		manager.setDateOfBirth("2017-12-16");
		manager.setAddress(rs.getString(5));
		manager.setPhoneNumber(rs.getString(6));
		manager.setCoefficientsSalary(rs.getInt(7));
		manager.setPosition(rs.getString(8));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("Funtion convert to manager ERROR");
		e.printStackTrace();
	}
	  
	  return manager;
  }
  
  @Override
  public String[] toArrayString() {
    ResourceBundle b = ResourceBundle.getBundle("view.Label");

    String[] array = super.toArrayString();
    array[7] = b.getString("Manager");
    return array;
  }

}
