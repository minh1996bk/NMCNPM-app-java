package model;

public class Supplier {
  private int idNumber;
  private String name;
  private String address;
  private String email;
  private String phoneNumber;
  
  public Supplier() {
    
  }
  public Supplier(int idNumber,String name, String address, String email, String phone) {
	  this.idNumber = idNumber;
	  this.name = name;
	  this.address = address;
	  this.email = email;
	  this.phoneNumber = phone;
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
  
  public String getAddress() {
    return address;
  }
  
  public void setAddress(String address) {
    this.address = address;
  }
  
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
  
  /**
   * Method convert attributes of an instance of Supplier Class to String[].
   * @return String[]
   */
  
  public String[] toArrayString() {
    String[] array = {"" + this.idNumber, this.address, this.name, this.email, this.phoneNumber};
    return array;
  }

 
}
