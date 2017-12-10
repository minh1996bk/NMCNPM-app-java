package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
public class ImportReceipt {
  private int code;
  private Manager importer;
  private Supplier supplier;
  private ArrayList<Product> array;
  private Date time; 
  public ImportReceipt() {
    
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
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

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }
  
  
  public void writeToFile(String urlFolder) throws IOException {
    String urlFile = urlFolder + "/" + this.code + "import.txt";
    FileWriter writer = new FileWriter(urlFile);
    BufferedWriter bwriter = new BufferedWriter(writer);
    writer.write("Receipt ID : " + this.code);
    writer.write(System.lineSeparator());
    writer.write("Employee Name : " + this.getImporter().getName());
    writer.write(System.lineSeparator());
    writer.write("Supplier Name : " + this.getSupplier().getName());
    writer.write(System.lineSeparator());
    writer.write("Date : ");
    writer.write(this.time.toString());
    writer.write(System.lineSeparator());
    writer.write("Products : ");
    writer.write(System.lineSeparator());
    for (Product p : array) {
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
	return array;
}

/**
 * @param array the array to set
 */
public void setArray(ArrayList<Product> array) {
	this.array = array;
}
 
}
