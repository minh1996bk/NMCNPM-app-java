package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExportReceipt {
  private int code;
  private Employee employee;
  private LinkedHashMap<Product, Integer[]> listItem;
  private Date time;
  
  public ExportReceipt() {
    
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public LinkedHashMap<Product, Integer[]> getListItem() {
    return listItem;
  }

  public void setListItem(LinkedHashMap<Product, Integer[]> listItem) {
    this.listItem = listItem;
  }


  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }
  
  public boolean containsProductId(Product pro) {
    boolean check = false;
    Product product;
    for (Map.Entry<Product, Integer[]> pair : this.listItem.entrySet()) {
      product = pair.getKey();
      if (product.getIdNumber() == pro.getIdNumber()) {
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
    Product product;
    for (Map.Entry<Product, Integer[]> pair : this.listItem.entrySet()) {
      product = pair.getKey();
      writer.write("" + product.getIdNumber());
      writer.write("++++");
      writer.write(product.getName());
      writer.write("++++");
      writer.write("" + pair.getValue()[0]);
      writer.write("++++");
      writer.write("" + pair.getValue()[1]);
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
}
