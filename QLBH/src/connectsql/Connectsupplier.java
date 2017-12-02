package connectsql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Statement;
import model.Supplier;

public class Connectsupplier extends ConnectMysql {

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
	
	public ResultSet getData_supplier(){
        ResultSet result = null;
        String sqlCommand = "select * from " + tablesupplier;
        Statement st ;
        try {
            st = (Statement) connection.createStatement();
            result = st.executeQuery(sqlCommand);
            System.out.println("GetData Supplier Correct ");
        } catch (SQLException ex) {
            Logger.getLogger(Connectsupplier.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Select ERROR \n" + ex.toString());
        }
        return result;
    }
	
    public void insertDB_Supplier(Supplier s){
        String sqlCommand = "insert into "+ tablesupplier +" value(? ,? ,? ,? ,?)";
        PreparedStatement pst = null;
        
        try {
            pst = connection.prepareStatement(sqlCommand);
            pst.setInt(1, s.getIdNumber());
            pst.setString(2, s.getName());
            pst.setString(3, s.getAddress());
            pst.setString(4, s.getEmail());
            pst.setString(5, s.getPhoneNumber());
            
            int row = pst.executeUpdate();
            if(row>0){
                JOptionPane.showMessageDialog(null, "Add Supplier successful");
            }else{
            	JOptionPane.showMessageDialog(null, "Insert Supplier ERROR", "alert", JOptionPane.ERROR_MESSAGE);            
            	}
        } catch (SQLException ex) {
            Logger.getLogger(Connectsupplier.class.getName()).log(Level.SEVERE, null, ex);
        	JOptionPane.showMessageDialog(null, "Insert Supplier ERROR", "alert", JOptionPane.ERROR_MESSAGE);            
            System.out.println("Insert Supplier ERROR");
        }
    }
    
	public void UpdateSupplier(int id, Supplier s) {
		// TODO Auto-generated method stub
		String sqlCommand="update "+tablesupplier+" set name ='"+s.getName()+"', address ='"+s.getAddress()+"', mail ='"+s.getEmail()+"', phone_no ='"+s.getPhoneNumber()+"' where id ='"+id+"'";
		Statement st;
		try {
		    st=(Statement) connection.createStatement();
		    st.execute(sqlCommand);
		    System.out.println("UpdateEmployee successful");
		    JOptionPane.showMessageDialog(null, "Update Employee Successful");
		    }
		catch (SQLException ex) {
			System.out.println("UpdateEmployee ERROR");
			Logger.getLogger(Connectsupplier.class.getName()).log(Level.SEVERE, null, ex);
		   	}
	}
}
