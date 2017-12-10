package model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.ResourceBundle;

import javax.swing.JTable;

public class Employee {
  private int idNumber;
  private String name;
  private String sex;
  private Date dateOfBirth;
  private String address;
  private String phoneNumber;
  private int coefficientsSalary;
  private ArrayList<WorkHistory> workHistory;
  private static final int DEFAULT_SALARY = 1000000;
  private String position;
  private JTable table;
  private int row;
   
  public Employee() {
	  
  }
  
  public Employee (int idNumber,String name,String sex,Date birth,String address,String phone,int salary,String position) {
	  this.idNumber = idNumber;
	  this.name = name;
	  this.sex = sex;
	  this.dateOfBirth = birth;
	  this.address= address;
	  this.phoneNumber=phone;
	  this.coefficientsSalary = salary;
	  this.position=position;
  }
  public Employee(JTable table, int row) {
	  this.table= table;
	  this.row = row;
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

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public int getCoefficientsSalary() {
    return coefficientsSalary;
  }

  public void setCoefficientsSalary(int coefficientsSalary) {
    this.coefficientsSalary = coefficientsSalary;
  }

  public int getDefaultSalary() {
    return DEFAULT_SALARY;
  }

  public ArrayList<WorkHistory> getWorkHistory() {
    return workHistory;
  }

  public void setWorkHistory(ArrayList<WorkHistory> workHistory) {
    this.workHistory = workHistory;
  }
  
  public int countSalary() {
    return coefficientsSalary * this.getDefaultSalary();
  }
  
  /**
   * Method convert attributes of an instance of Employee Class to String[].
   * @return String[]
   */
  
  public String[] toArrayString() {
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    ResourceBundle b = ResourceBundle.getBundle("view.Label");

    String[] array = {"" + this.idNumber, this.name, this.sex, 
        df.format(this.dateOfBirth), this.address, this.phoneNumber, "" + this.coefficientsSalary, 
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
  public Employee ConverttoEmployee(){
      	Employee em = new Employee();
          em.setIdNumber( Integer.parseInt(String.valueOf(table.getModel().getValueAt(row, 0))));
          em.setName((String.valueOf( table.getModel().getValueAt(row,1)))); 
          em.setSex((String.valueOf( table.getModel().getValueAt(row,2))));
          em.setDateOfBirth((Date.valueOf(String.valueOf(table.getModel().getValueAt(row,3)))));
          em.setAddress((String.valueOf( table.getModel().getValueAt(row,4))));
          em.setPhoneNumber((String.valueOf( table.getModel().getValueAt(row,5))));
          em.setCoefficientsSalary((Integer.parseInt(String.valueOf(table.getModel().getValueAt(row,6)))));
          em.setPosition((String.valueOf( table.getModel().getValueAt(row,7))));
      return em;
  }
}
