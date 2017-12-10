package connectsql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import model.ImportReceipt;

public class ConnectReceipt_manager_supplier extends ConnectMysql {
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
	public ResultSet getData_Receipt_manager_supplier(){
        ResultSet result = null;
        String sqlCommand = "select * from " + tablereceipt_manager_supplier;
        Statement st ;
        try {
            st = (Statement) connection.createStatement();
            result = st.executeQuery(sqlCommand);
            System.out.println("GetData receipt_manager_supplier Correct ");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectReceipt_manager_supplier.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Select ERROR \n" + ex.toString());
        }
        return result;
    }
    public void insertDB_Receipt_manager_supplier(ImportReceipt i){
        String sqlCommand = "insert into "+ tablereceipt_manager_supplier +" value(? ,? ,? ,?)";
        PreparedStatement pst = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            pst = connection.prepareStatement(sqlCommand);
            pst.setInt(1, i.getCode());
            pst.setInt(2, i.getImporter().getIdNumber());
            pst.setInt(3, i.getSupplier().getIdNumber());
            pst.setString(4, sdf.format(date));
            
            int row = pst.executeUpdate();
            if(row>0){
            	 JOptionPane.showMessageDialog(null, "Add Receipt_manager_supplier successful");
            }else{
            	JOptionPane.showMessageDialog(null, "Insert Receipt_manager_supplier ERROR", "alert", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectReceipt_manager_supplier.class.getName()).log(Level.SEVERE, null, ex);
        	JOptionPane.showMessageDialog(null, "Insert Receipt_manager_supplier ERROR", "alert", JOptionPane.ERROR_MESSAGE);
            System.out.println("Insert Import_ReceiptERROR");
        }
    }
}
