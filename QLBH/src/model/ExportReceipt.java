package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ExportReceipt {
  
  private int id_receipt;
  
  private Employee employee;
  
  private ArrayList<Product> item;
  
  private String date;
  
  
  
  
  
  public ExportReceipt() {
    
  }

  public int getCode() {
    return id_receipt;
  }

  public void setCode(int code) {
    this.id_receipt = code;
  }


  public String getTime() {
    return date;
  }

  public void setTime(String time) {
    this.date = time;
  }
  

  public void writeToFile(String urlFolder) throws IOException {
    String urlFile = urlFolder + "/" + this.id_receipt + "export.txt";
    FileWriter writer = new FileWriter(urlFile);
    BufferedWriter bwriter = new BufferedWriter(writer);
    writer.write("Receipt ID : " + this.id_receipt);
    writer.write(System.lineSeparator());
    writer.write("Employee Name : " + this.getEmployee().getName());
    writer.write(System.lineSeparator());
    writer.write("Date : ");
    writer.write(this.date.toString());
    writer.write(System.lineSeparator());
    writer.write("Products : ");
    writer.write(System.lineSeparator());
    for (Product pair : this.item) {
      writer.write("" + pair.getIdNumber());
      writer.write("++++");
      writer.write(pair.getName());
      writer.write("++++");
      writer.write("" + pair.getPrice());
      writer.write("++++");
      writer.write("" + pair.getTotal());
      writer.write(System.lineSeparator());
    }
    bwriter.close();
  }

/**
 * @return the employee
 */
public Employee getEmployee() {
	return employee;
}

/**
 * @param employee the employee to set
 */
public void setEmployee(Employee employee) {
	this.employee = employee;
}

/**
 * @return the item
 */
public ArrayList<Product> getItem() {
	return item;
}

/**
 * @param item the item to set
 */
public void setItem(ArrayList<Product> item) {
	this.item = item;
}
}
