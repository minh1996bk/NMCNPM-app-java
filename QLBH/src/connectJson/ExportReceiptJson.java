package connectJson;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.ExportReceipt;

public class ExportReceiptJson {
  
  /**
   * Get all export receipt form database
   * @return
   */
  public static ArrayList<ExportReceipt> getExportReceipt(){
    
    Gson gson = new Gson();
    
    return gson.fromJson(
        ConnectServer.getAllObject(Setup.LINK, "getJsonExportReceiptes"), 
        new TypeToken<ArrayList<ExportReceipt>>() {}.getType());
  }
  
  /**
   * insert new export receipt to database
   * @param exportReceipt
   */
  public static void insertExportReceipt(ExportReceipt exportReceipt) {
    Gson gson = new Gson();
    
    try {
      ConnectServer.postObject(Setup.LINK, "saveJsonExportReceipt", gson.toJson(exportReceipt));
    } catch (IOException e) {
      
      e.printStackTrace();
    }
  }
  
  /**
   * Update export receipt in database
   * @param exportReceipts
   */
  public static void updateExportReceipt(ArrayList<ExportReceipt> exportReceipts) {
    Gson gson = new Gson();
    
    try {
      ConnectServer.postObject(Setup.LINK, "updateJsonExportReceipt", gson.toJson(exportReceipts));
    } catch (IOException e) {
      
      e.printStackTrace();
    }
  }
  
  
  
  
  
}
