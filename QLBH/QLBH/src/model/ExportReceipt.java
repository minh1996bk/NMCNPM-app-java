package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class ExportReceipt {
  private int code;
  private Employee employee;
  private ArrayList<Product> item;
  private Date time;
  
  public ExportReceipt() {
    
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }


  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }
  
  public boolean containsProductId(Product pro) {
    boolean check = false;
    for (Product pair : this.item) {
      if (pair.getIdNumber() == pro.getIdNumber()) {
        check = true;
        break;
      }
    }
    return check;
  }

  public void writeToFile(String urlFolder) throws IOException {
    String urlFile = urlFolder + "/" + this.code + "export.txt";
    FileWriter writer = new FileWriter(urlFile);
    BufferedWriter bwriter = new BufferedWriter(writer);
    writer.write("Receipt ID : " + this.code);
    writer.write(System.lineSeparator());
    writer.write("Employee Name : " + this.getEmployee().getName());
    writer.write(System.lineSeparator());
    writer.write("Date : ");
    writer.write(this.time.toString());
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
