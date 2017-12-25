package connectJson;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Userlogin {
	
	/**
	 * Get all user login from database
	 * @return userlogins
	 */
	public static ArrayList<Userlogin> getUserlogin() {
		Gson gson = new Gson();
		
		return gson.fromJson(ConnectServer.getAllObject(Setup.LINK, "getUserLogins"), 
				new TypeToken<ArrayList<Userlogin>>() {}.getType()
				);
		
	}
	
	/**
	 * @param userlogin
	 */
	public static void insertUserLogin(Userlogin userlogin) {
		Gson gson = new Gson();
		
		try {
			ConnectServer.postObject(Setup.LINK, "saveJsonUserLogin", gson.toJson(userlogin));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
