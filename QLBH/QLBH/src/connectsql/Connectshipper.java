package connectsql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import model.Employee;

public class Connectshipper extends ConnectMysql{
	
	public ResultSet getData_shipper(){
        ResultSet result = null;
        String sqlCommand = "select * from " + tableshipper;
        Statement st ;
        try {
            st = (Statement) connection.createStatement();
            result = st.executeQuery(sqlCommand);
            System.out.println("GetData shipper Correct ");
        } catch (SQLException ex) {
            Logger.getLogger(Connectshipper.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Select ERROR \n" + ex.toString());
        }
        return result;
    }
	public int SelectID(ResultSet rs) {
		int count=1;
		try {
			while(rs.next()) {
				if(count == rs.getInt(1)){
					count++;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("SelectId ERROR");
		}
		return count;
	}
	   public void insertDB_shipper(Employee e){
	        String sqlCommand = "insert into "+ tableemployee +" value(?)";
	        PreparedStatement pst = null;
	        
	        try {
	            pst = connection.prepareStatement(sqlCommand);
	            pst.setInt(1, e.getIdNumber());
	            int row = pst.executeUpdate();
	            if(row>0){
	                System.out.println("Inserted to DataBase");
	                JOptionPane.showMessageDialog(null, "Add shipper successful");
	            }else{
	                System.out.println("Insert Error");
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(Connectshipper.class.getName()).log(Level.SEVERE, null, ex);
	            System.out.println("InsertShipper ERROR");
	        }
	    }
	    
}
