package connectsql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.Statement;

import model.Account;

public class Connectsave extends ConnectMysql{
	public int checkid(ResultSet rs){
		int id = 0;
		try {
			while(rs.next()){
				try {
					if(id == rs.getInt(1)) break;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				id++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id+1;
	}

    public ResultSet getData_save(){
        ResultSet result = null;
        String sqlCommand= "select * from " + tablesave;
        Statement st;
        try {
            st = (Statement) connection.createStatement();
            result = st.executeQuery(sqlCommand);
            System.out.println("GetData Correct in tableaccount");
      
        } catch (SQLException ex) {
            Logger.getLogger(Connectsave.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Select ERROR \n" + ex.toString());
        }
        return result;
    }
	
    public void insertDB_savetable(Account ad, int i){
        String sqlCommand = "insert into "+ tablesave +" value(? ,?, ?, ?)";
        PreparedStatement pst = null;
       
        try {
            pst = connection.prepareStatement(sqlCommand);
            pst.setInt(1,i);
            pst.setString(2, ad.getTaiKhoan());
            pst.setString(3, ad.getMatKhau());
            pst.setInt(4, ad.getId());
            int row = pst.executeUpdate();
            if(row > 0){
                System.out.println("Inserted to DataBase");
            }else{
                System.out.println("Insert Error");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connectsave.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
