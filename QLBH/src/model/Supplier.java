package model;

public class Supplier {
  private int id;
  private String name;
  private String address;
  private String mail;
  private String phone_no;
  
  public Supplier() {
    
  }
  public Supplier(int idNumber,String name, String address, String email, String phone) {
	  this.id = idNumber;
	  this.name = name;
	  this.address = address;
	  this.mail = email;
	  this.phone_no = phone;
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
  
  public String getAddress() {
    return address;
  }
  
  public void setAddress(String address) {
    this.address = address;
  }
  
  public String getEmail() {
    return mail;
  }

  public void setEmail(String email) {
    this.mail = email;
  }

  public String getPhoneNumber() {
    return phone_no;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phone_no = phoneNumber;
  }
  
  /**
   * Method convert attributes of an instance of Supplier Class to String[].
   * @return String[]
   */
  
  public String[] toArrayString() {
    String[] array = {"" + this.id, this.address, this.name, this.mail, this.phone_no};
    return array;
  }

 
}
