package connectsql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.jdbc.Statement;

import model.Account;
import model.Userlogin;


public class Connectaccount extends ConnectMysql {
	
    public ResultSet getData_account(){
        ResultSet result = null;
        String sqlCommand= "select * from " + tableaccount;
        Statement st;
        try {
            st = (Statement) connection.createStatement();
            result = st.executeQuery(sqlCommand);
            System.out.println("GetData Correct in tableaccount");
      
        } catch (SQLException ex) {
            Logger.getLogger(Connectaccount.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Select ERROR \n" + ex.toString());
        }
        return result;
    }
    public ResultSet getData_account(String account,String pass){
        ResultSet result = null;
        String sqlCommand="select * from "+tableaccount+" where user_name='"+account+"' and password='"+pass+"'";       
        Statement st;
        try {
            st = (Statement) connection.createStatement();
            result = st.executeQuery(sqlCommand);
            System.out.println("GetData Correct in tableaccount");
      
        } catch (SQLException ex) {
            Logger.getLogger(Connectaccount.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Select ERROR \n" + ex.toString());
        }
        return result;
    }   
    public boolean Checkaccount(ResultSet rs,JTextField text, JPasswordField pass ){     
        Account input = new Account();	
    	input.setTaiKhoan(text.getText());
        
        char[] p = pass.getPassword();
        input.setMatKhau(String.valueOf(p));        
    	try {
            while(rs.next()){	
            	if(input.getTaiKhoan().equals(rs.getString(2)) &&
                    input.getMatKhau().equals(rs.getString(3))){
                    System.out.println("Login");
                    return true;
                    }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connectaccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public Boolean ChecksuvirvalofAccount(ResultSet rs,int id) {
    	try {
            while(rs.next()){	
            	if(id == rs.getInt(1)) {
                    JOptionPane.showMessageDialog(null, "thisId is created account before");
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connectaccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public void insertDB_account(Userlogin al){
        String sqlCommand = "insert into "+ tableuserlogin +" value(? ,?, ?)";
        PreparedStatement pst = null;
       
        try {
            pst = connection.prepareStatement(sqlCommand);
            pst.setInt(1, al.getId());
            pst.setString(2, al.getTime());
            pst.setString(3, al.getAccount());

            int row = pst.executeUpdate();
            if(row > 0){
                System.out.println("Inserted to DataBase");
            }else{
                System.out.println("Insert Error");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connectaccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insertDB_account(Account al){
        String sqlCommand = "insert into "+ tableaccount +" value(? ,?, ?)";
        PreparedStatement pst = null;
       
        try {
            pst = connection.prepareStatement(sqlCommand);
            pst.setInt(1, al.getId());
            pst.setString(2, al.getTaiKhoan());
            pst.setString(3, al.getMatKhau());

            int row = pst.executeUpdate();
            if(row > 0){
                System.out.println("Inserted to DataBase");
                JOptionPane.showMessageDialog(null, "Insert successful");
            }else{
                System.out.println("Insert Error");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connectaccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet getdata_EmployeeAccount(String account, String pass){
        ResultSet result = null;
        String sqlCommand="select user_name ,password, employee.position from "+tableaccount+","+tableemployee+" where account.id_employee =employee.id and user_name='"+account+"' and password='"+pass+"'";       
        Statement st;
        try {
            st = (Statement) connection.createStatement();
            result = st.executeQuery(sqlCommand);
            System.out.println("GetData Correct in tableaccount");
      
        } catch (SQLException ex) {
            Logger.getLogger(Connectaccount.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Select ERROR \n" + ex.toString());
        }
        return result;
    }
    //checkManager
    public boolean CheckManager(ResultSet rs ) {
    	try {
    		while(rs.next()) {
			if(rs.getString(3).equals("manager"))return true;
    		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("CheckManager ERROR");
		}
    	return false;
    }
	public boolean Checkaccount(ResultSet rs, JTextField textAccount, JTextField textPass) {
		// TODO Auto-generated method stub
        Account input = new Account();	
    	input.setTaiKhoan(textAccount.getText());
    	input.setMatKhau(textPass.getText());
    	try {
            while(rs.next()){	
            	if(input.getTaiKhoan().equals(rs.getString(2)) &&
                    input.getMatKhau().equals(rs.getString(3))){
                    return true;
                    }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connectaccount.class.getName()).log(Level.SEVERE, null, ex);
        }
		return false;
	}
}
