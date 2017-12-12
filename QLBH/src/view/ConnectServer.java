package view;
import java.util.ArrayList;
import java.util.Date;

import model.Order;
import model.Product;
import model.Status;
public class ConnectServer {
  public static ArrayList<Order> getOrders(Date from, Date to) {
    Product p = new Product();
    p.setIdNumber(1);
    p.setName("Ao so mi");
    p.setPrice(10);
    p.setTotal(2);
    Product p1 = new Product();
    p1.setIdNumber(10);
    p1.setName("Quan bo");
    p1.setPrice(2000);
    p1.setTotal(2);
    
    ArrayList<Product> products = new ArrayList<>();
    products.add(p1);
    products.add(p);
    
    Order o = new Order(1, "chuyen nhanh ho bo cai", products, "Nguyen Dinh Minh", "0974066924", "minh1996bk@gmail.com", "ha noi", "hay tay", 
        "dm", "dm", "dm", Status.waiting);
  

    Order o1 = new Order(2, "chuyen nhanh ho bo cai", products, "Nguyen Dinh Minh", "0974066924", "minh1996bk@gmail.com", "ha noi", "hay tay", 
        "dm", "dm", "dm", Status.accepted);

    Order o2 = new Order(3, "chuyen nhanh ho bo cai", products, "Nguyen Dinh Minh", "0974066924", "minh1996bk@gmail.com", "ha noi", "hay tay", 
        "dm", "dm", "dm", Status.shipping);
    Order o3 = new Order(4, "chuyen nhanh ho bo cai", products, "Nguyen Dinh Minh", "0974066924", "minh1996bk@gmail.com", "ha noi", "hay tay", 
        "dm", "dm", "dm", Status.canceled);
    
    ArrayList<Order> orders = new ArrayList<>();
    orders.add(o);
    orders.add(o1);
    orders.add(o2);
    orders.add(o3);
    System.out.println("ok");
    return orders;
  }
  
  public static void saveChangedOrder(Order order) {
    System.out.println("ChangedOrderSaved");
  }
}
