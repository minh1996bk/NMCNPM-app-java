package connectJson;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.Supplier;

public class SupplierJson {
  
  /**
   * Get all supplier from database
   * @return suppliers
   */
  public static ArrayList<Supplier> getSupplier(){
    
    Gson gson = new Gson();
    
    return gson.fromJson(ConnectServer.getAllObject(Setup.LINK, "getJsonSuppliers"), 
        new TypeToken<ArrayList<Supplier>>() {}.getType());
  }
  
  public static void insertSupplier(Supplier supplier) {
    Gson gson = new Gson();
    
    try {
      ConnectServer.postObject(Setup.LINK, "saveJsonSupplier", gson.toJson(supplier));
    } catch (IOException e) {
      
      e.printStackTrace();
    }
  }
}
