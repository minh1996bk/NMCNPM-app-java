package model;

import java.util.ArrayList;

public class Order {
  private int id;
  private String title;
  private ArrayList<Product> products;
  private String name;
  private String phone;
  private String email;
  private String companyName;
  private String address1;
  private String address2;
  private String createdAt;
  private String updatedAt;
  private Status status;
  
  public Order() {
    
  }

  
  
  public Order(int id, String title, ArrayList<Product> products, String name, String phone, String email,
      String companyName, String address1, String address2, String createdAt, String updatedAt, Status status) {
    super();
    this.id = id;
    this.title = title;
    this.products = products;
    this.name = name;
    this.phone = phone;
    this.email = email;
    this.companyName = companyName;
    this.address1 = address1;
    this.address2 = address2;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.status = status;
  }



  public int getId() {
    return id;
  }



  public void setId(int id) {
    this.id = id;
  }



  public String getTitle() {
    return title;
  }



  public void setTitle(String title) {
    this.title = title;
  }



  public ArrayList<Product> getProducts() {
    return products;
  }



  public void setProducts(ArrayList<Product> products) {
    this.products = products;
  }



  public String getName() {
    return name;
  }



  public void setName(String name) {
    this.name = name;
  }



  public String getPhone() {
    return phone;
  }



  public void setPhone(String phone) {
    this.phone = phone;
  }



  public String getEmail() {
    return email;
  }



  public void setEmail(String email) {
    this.email = email;
  }



  public String getCompanyName() {
    return companyName;
  }



  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }



  public String getAddress1() {
    return address1;
  }



  public void setAddress1(String address1) {
    this.address1 = address1;
  }



  public String getAddress2() {
    return address2;
  }



  public void setAddress2(String address2) {
    this.address2 = address2;
  }



  public String getCreatedAt() {
    return createdAt;
  }



  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }



  public String getUpdatedAt() {
    return updatedAt;
  }



  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }



  public Status getStatus() {
    return status;
  }



  public void setStatus(Status status) {
    this.status = status;
  }



  public long countTotal() {
    long total = 0;
    for (Product product : products) {
      total += product.getPrice() * product.getTotal();
    }
    
    return total;
  }
  
}
