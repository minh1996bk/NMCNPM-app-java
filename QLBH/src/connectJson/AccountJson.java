package connectJson;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.Account;
import model.Employee;

public class AccountJson {

  
  /**
   * Insert new account to database
   * @param account
   */
  public static void insertAccount(Account account) {
    Gson gson = new Gson();
    
    try {
      ConnectServer.postObject(Setup.LINK, "saveJsonAccount", gson.toJson(account));
    } catch (IOException e) {

      e.printStackTrace();
    }
  }
  
  /**
   * Update an account in database
   * @param account
   */
  public static void updateAccount(Account account) {
    Gson gson = new Gson();
    
    try {
      ConnectServer.postObject(Setup.LINK, "updateJsonAccount", gson.toJson(account));
    } catch (IOException e) {

      e.printStackTrace();
    }
  }
  
  /**
   * Get all account from database
   * 
   */
  public static ArrayList<Account> getAccount(){
    Gson gson = new Gson();
    
    return gson.fromJson(
        ConnectServer.getAllObject(Setup.LINK, "getJsonAccounts"), 
        new TypeToken<ArrayList<Account>>() {}.getType());
  }
  
  /**
   * Login app java
   * @param account
   * @return employee
   */
  public static Employee login(Account account) {
	  Gson gson = new Gson();
	  String string = null;
	  try {
		 string = ConnectServer.postObject(Setup.LINK, "loginApp", gson.toJson(account));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return gson.fromJson(string, new TypeToken<Employee>() {}.getType());
  }
}
