package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class ImportReceipt {
  
  
  
  private int id_receipt;
  private Manager importer;
  private Supplier supplier;
  private ArrayList<Product> items;
  private String date; 
  
  
  
  
  public ImportReceipt() {
    
  }

  public int getCode() {
    return id_receipt;
  }

  public void setCode(int code) {
    this.id_receipt = code;
  }

  public Manager getImporter() {
    return importer;
  }

  public void setImporter(Manager importer) {
    this.importer = importer;
  }

  public Supplier getSupplier() {
    return supplier;
  }

  public void setSupplier(Supplier supplier) {
    this.supplier = supplier;
  }

  public String getTime() {
    return date;
  }

  public void setTime(String time) {
    this.date = time;
  }
  
  
  public void writeToFile(String urlFolder) throws IOException {
    String urlFile = urlFolder + "/" + this.id_receipt + "import.txt";
    FileWriter writer = new FileWriter(urlFile);
    BufferedWriter bwriter = new BufferedWriter(writer);
    writer.write("Receipt ID : " + this.id_receipt);
    writer.write(System.lineSeparator());
    writer.write("Employee Name : " + this.getImporter().getName());
    writer.write(System.lineSeparator());
    writer.write("Supplier Name : " + this.getSupplier().getName());
    writer.write(System.lineSeparator());
    writer.write("Date : ");
    writer.write(this.date.toString());
    writer.write(System.lineSeparator());
    writer.write("Products : ");
    writer.write(System.lineSeparator());
    for (Product p : items) {
      writer.write("" + p.getIdNumber());
      writer.write("++++");
      writer.write(p.getName());
      writer.write("++++");
      writer.write("" + p.getPrice());
      writer.write("++++");
      writer.write("" + p.getTotal());
      writer.write(System.lineSeparator());
    }
    bwriter.close();
  }

/**
 * @return the array
 */
public ArrayList<Product> getArray() {
	return items;
}

/**
 * @param array the array to set
 */
public void setArray(ArrayList<Product> array) {
	this.items = array;
}
 
}
