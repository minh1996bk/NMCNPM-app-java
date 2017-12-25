package connectJson;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.Order;

public class OrderJson {
  
  /**
   * Get all order from data base
   * select * from order where 1
   */
  public static ArrayList<Order> getOrder() {
    
    Gson gson = new Gson();
    
    return gson.fromJson(
        ConnectServer.getAllObject(Setup.LINK, "getCart"), 
        new TypeToken<ArrayList<Order>>() {}.getType()
    );
  }
  
  /**
   * Save products to data base
   * @throws IOException 
   */
  public static void updateOrder(ArrayList<Order> orders) throws IOException {
    Gson gson = new Gson();
    
    ConnectServer.postObject(Setup.LINK, "changeStatus", gson.toJson(orders));
  }
}
