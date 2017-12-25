package connectJson;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.ImportReceipt;

public class ImportReceiptJson {
  /**
   * Get all import receipt from database
   * @return
   */
  public static ArrayList<ImportReceipt> getImportReceipt(){
    Gson gson = new Gson();
    
    return gson.fromJson(
        ConnectServer.getAllObject(Setup.LINK, "getJsonImportReceiptes"), 
        new TypeToken<ArrayList<ImportReceipt>>() {}.getType());
  }
  
  
  /**
   * insert new import receipt to database
   * @param importReceipt
   */
  public static void insertImportReceipt(ImportReceipt importReceipt) {
    Gson gson = new Gson();
    
    try {
      ConnectServer.postObject(Setup.LINK, "saveJsonImportReceipt", gson.toJson(importReceipt));
    } catch (IOException e) {
      
      e.printStackTrace();
    }
  }
  
  /**
   * Update import receipt in database
   * @param importReceipts
   */
  public static void updateImportReceipt(ArrayList<ImportReceipt> importReceipts) {
    Gson gson = new Gson();
    
    try {
      ConnectServer.postObject(Setup.LINK, "updateJsonImportReceipt", gson.toJson(importReceipts));
    } catch (IOException e) {
      
      e.printStackTrace();
    }
  }
}
