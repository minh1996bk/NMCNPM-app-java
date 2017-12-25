package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javax.swing.JTable;

public class Employee {
  private int id;
  private String name;
  private String sex;
  private String birth_date;
  private String address;
  private String phone_no;
  private int coefficient_salary;
  private static final int DEFAULT_SALARY = 1000000;
  private String position;

  public Employee() {
	  
  }
  
  public Employee (int idNumber,String name,String sex,String birth,String address,String phone,int salary,String position) {
	  this.id = idNumber;
	  this.name = name;
	  this.sex = sex;
	  this.birth_date = birth;
	  this.address= address;
	  this.phone_no=phone;
	  this.coefficient_salary = salary;
	  this.position=position;
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

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getDateOfBirth() {
    return birth_date;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.birth_date = dateOfBirth;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhoneNumber() {
    return phone_no;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phone_no = phoneNumber;
  }

  public int getCoefficientsSalary() {
    return coefficient_salary;
  }

  public void setCoefficientsSalary(int coefficientsSalary) {
    this.coefficient_salary = coefficientsSalary;
  }

  public int getDefaultSalary() {
    return DEFAULT_SALARY;
  }

  
  public int countSalary() {
    return coefficient_salary * this.getDefaultSalary();
  }
  
  /**
   * Method convert attributes of an instance of Employee Class to String[].
   * @return String[]
   */
  
  public String[] toArrayString() {
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    ResourceBundle b = ResourceBundle.getBundle("view.Label");

    String[] array = {"" + this.id, this.name, this.sex, 
        df.format(this.birth_date), this.address, this.phone_no, "" + this.coefficient_salary, 
        b.getString("Employee")};
    return array;
  }

/**
 * @return the position
 */
  public String getPosition() {
	return position;
  }

/**
 * @param position the position to set
 */
  public void setPosition(String position) {
	this.position = position;
  }
  public Employee ConverttoEmployee(JTable table, int row){
      	Employee em = new Employee();
          em.setIdNumber( Integer.parseInt(String.valueOf(table.getModel().getValueAt(row, 0))));
          em.setName((String.valueOf( table.getModel().getValueAt(row,1)))); 
          em.setSex((String.valueOf( table.getModel().getValueAt(row,2))));
          em.setDateOfBirth((String.valueOf(String.valueOf(table.getModel().getValueAt(row,3)))));
          em.setAddress((String.valueOf( table.getModel().getValueAt(row,4))));
          em.setPhoneNumber((String.valueOf( table.getModel().getValueAt(row,5))));
          em.setCoefficientsSalary((Integer.parseInt(String.valueOf(table.getModel().getValueAt(row,6)))));
          em.setPosition((String.valueOf( table.getModel().getValueAt(row,7))));
      return em;
  }
}
