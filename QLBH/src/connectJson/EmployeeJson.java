package connectJson;

import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Employee;
import model.Manager;

public class EmployeeJson {
  
  /**
   * Get all employee from database
   * @return
   */
  public static ArrayList<Employee> getEmployee(){
    Gson gson = new Gson();
    
    return gson.fromJson(
        ConnectServer.getAllObject(Setup.LINK, "getJsonEmployees"), 
        new TypeToken<ArrayList<Employee>>() {}.getType());
  }
  
  /**
   * Insert new employee to database
   * insert into ..
   * @param employees
   */
  public static void insertEmployee(ArrayList<Employee> employees) {
     Gson gson = new Gson();
     
     try {
      ConnectServer.postObject(Setup.LINK, "saveJsonEmployees", gson.toJson(employees));
    } catch (IOException e) {
      
      e.printStackTrace();
    }
  }
  
  /**
   * Update employees in database
   * @param employees
   */
  public static void updateEmployee(ArrayList<Employee> employees) {
    Gson gson = new Gson();
    
    try {
      ConnectServer.postObject(Setup.LINK, "updateJsonEmployees", gson.toJson(employees));
    } catch (IOException e) {
      
      e.printStackTrace();
    }
  }
  
  /**
   * Get all managers form database
   * @return
   */
  public static ArrayList<Manager> getManager() {
	  Gson gson = new Gson();
	  
	  return gson.fromJson(ConnectServer.getAllObject(Setup.LINK, "getJsonManagers"),
			  new TypeToken<ArrayList<Manager>>() {}.getType()
			  );
  }
  
  /**
   * Update a manager in database
   * @param manager
   */
  public static void updateManager(Manager manager) {
	  Gson gson = new Gson();
	  
	  try {
		ConnectServer.postObject(Setup.LINK, "updateJsonManager", gson.toJson(manager));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  /**
   * Insert new manager to database
   * @param manager
   */
  public static void insertManager(Manager manager) {
	  Gson gson = new Gson();
	  
	  try {
		ConnectServer.postObject(Setup.LINK, "saveJsonManager", gson.toJson(manager));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  public static Manager getManagerById(int id) {
    
    Gson gson = new Gson();
    
    String result = null;
    
    try {
      result = ConnectServer.postObject(Setup.LINK, "getManagerById", String.valueOf(id));
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return gson.fromJson(result, new TypeToken<Manager>() {}.getType());
  }
  
  public static String getDefaultSalary() {
    return ConnectServer.getAllObject(Setup.LINK, "getDefaultSalary");
  }
  
  
}
