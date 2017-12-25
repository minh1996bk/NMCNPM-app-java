package connectJson;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.Product;

public class ProductJson {
  public static ArrayList<Product> getProduct()
  {
    Gson gson = new Gson();
    
    return gson.fromJson(
        ConnectServer.getAllObject(Setup.LINK, "getJsonProducts"), 
        new TypeToken<ArrayList<Product>>() {}.getType());
  }
  
  /**
   * Insert New product to database.
   * insert into Product () values ()
   * @param products
   * @throws IOException
   */
  public static void insertProduct(ArrayList<Product> products) throws IOException {
    Gson gson = new Gson();
    
    ConnectServer.postObject(Setup.LINK, "saveJsonProducts", gson.toJson(products));
  }
  
  /**
   * Update row product of database
   * 
   * @param products
   * @throws IOException
   */
  public static void updateProduct(ArrayList<Product> products) throws IOException {
    Gson gson = new Gson();
    
    ConnectServer.postObject(Setup.LINK, "updateJsonProducts", gson.toJson(products));
  }
}
