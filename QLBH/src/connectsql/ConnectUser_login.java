package connectsql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.Statement;

public class ConnectUser_login extends ConnectMysql{
    public ResultSet getData_Userlogin(){
        ResultSet result = null;
        String sqlCommand= "select * from " + tableuserlogin;
        Statement st;
        try {
            st = (Statement) connection.createStatement();
            result = st.executeQuery(sqlCommand);
            System.out.println("GetData Correct in tableUser_login");
      
        } catch (SQLException ex) {
            Logger.getLogger(ConnectUser_login.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Select ERROR \n" + ex.toString());
        }
        return result;
    }
}
