package model;

import java.util.ArrayList;

public class Order {
  private int id;
  private String title;
  private ArrayList<Product> cart;
  private String name;
  private String phone;
  private String email;
  private String company_name;
  private String address1;
  private String address2;
  private String created_at;
  private String updated_at;
  private Status status;
  
  public Order() {
    
  }

  
  
  public Order(int id, String title, ArrayList<Product> products, String name, String phone, String email,
      String company_name, String address1, String address2, String created_at, String updated_at, Status status) {
    super();
    this.id = id;
    this.title = title;
    this.cart = products;
    this.name = name;
    this.phone = phone;
    this.email = email;
    this.company_name = company_name;
    this.address1 = address1;
    this.address2 = address2;
    this.created_at = created_at;
    this.updated_at = updated_at;
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
    return cart;
  }



  public void setProducts(ArrayList<Product> products) {
    this.cart = products;
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
    return company_name;
  }



  public void setCompanyName(String companyName) {
    this.company_name = companyName;
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
    return created_at;
  }



  public void setCreatedAt(String createdAt) {
    this.created_at = createdAt;
  }



  public String getUpdatedAt() {
    return updated_at;
  }



  public void setUpdatedAt(String updatedAt) {
    this.updated_at = updatedAt;
  }



  public Status getStatus() {
    return status;
  }



  public void setStatus(Status status) {
    this.status = status;
  }



  public long countTotal() {
    long total = 0;
    for (Product product : cart) {
      total += product.getPrice() * product.getTotal();
    }
    
    return total;
  }

  
}
