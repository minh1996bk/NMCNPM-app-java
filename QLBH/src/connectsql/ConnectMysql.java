package connectsql;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.Connection;

public class ConnectMysql {
    
    private final static String url = "jdbc:mysql://localhost:3306/supermarket_app_web";
    private final static String user = "root";
    private final static String password = "tranhuy1";
    public Connection connection;
    public final static String tableaccount = "account";
    public final static String tableuserlogin = "userlogin_history";
    public final static String tablesave = "save";
    public final static String tableemployee = "employee";
    public final static String tableproduct = "product";
    public final static String tableemployee_manager = "employee_manager";
    public final static String tablesupplier = "supplier";
    public final static String tableimport_receipt = "import_receipt";
    public final static String tablereceipt_manager_supplier = "receipt_manager_supplier";
    public void Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(url,user,password);
            System.out.println("CONNECT SUCCESS");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectMysql.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("CLASS NOT FOUND!");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectMysql.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("CONNECT ERROR!");
        }
    }
    
}
