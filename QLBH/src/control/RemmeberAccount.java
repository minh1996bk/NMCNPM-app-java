package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import connectsql.ConnectUser_login;
import connectsql.Connectsave;
import model.Account;

public class RemmeberAccount {
	//saveAccount if User click saveCheckbox
	public static void SaveAccount(Account ad) {
		Connectsave connectsave = new Connectsave();
		connectsave.Connect();
		int i = connectsave.checkid(connectsave.getData_save());
		connectsave.insertDB_savetable(ad, i);
	}
	public static Account TakeoutAccountlogin(){
		Account admin = new Account();
		ConnectUser_login connectUser_login = new ConnectUser_login();
		connectUser_login.Connect();
		ResultSet rs = connectUser_login.getData_Userlogin();
		try {
			while(rs.next()){
					admin.setTaiKhoan(rs.getString(3));
					admin.setId(Integer.parseInt(rs.getString(1)));
					admin.setMatKhau("");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;
	}
	
	public static String getUserlogin(){
		String str = null;
		ConnectUser_login connectUser_login = new ConnectUser_login();
		connectUser_login.Connect();
		ResultSet rs = connectUser_login.getData_Userlogin();
		try {
			while(rs.next()) {
				str = rs.getString(3);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	public static Account TakeAccountsave() {
		// TODO Auto-generated method stub
		Account admin = new Account();
		Connectsave connectsave = new Connectsave();
		connectsave.Connect();
		ResultSet rs = connectsave.getData_save();
		try {
			while(rs.next()){
					admin.setTaiKhoan(rs.getString(2));
					admin.setId(rs.getInt(4));
					admin.setMatKhau(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;
	}
	
}
