package connectsql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;
import model.ImportReceipt;
import model.Product;

public class ConnectImport_receipt extends ConnectMysql {
	
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
	public ResultSet getData_importReceipt(){
        ResultSet result = null;
        String sqlCommand = "select * from " + tableimport_receipt;
        Statement st ;
        try {
            st = (Statement) connection.createStatement();
            result = st.executeQuery(sqlCommand);
            System.out.println("GetData import_receipt Correct ");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectImport_receipt.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Select ERROR \n" + ex.toString());
        }
        return result;
    }
	public ResultSet getData_importdetails() {
        ResultSet result = null;
        String sqlCommand = "select import_receipt.id_receipt , employee.name , supplier.name , receipt_manager_supplier.date ,product.name , product.total ,product.price,product.produce_date,product.expire_date from " + tableimport_receipt +","+tablereceipt_manager_supplier+","+tableproduct+","+tablesupplier+","+tableemployee_manager+","+tableemployee+ " where import_receipt.id_receipt = receipt_manager_supplier.id_receipt and import_receipt.id_product = product.id and receipt_manager_supplier.id_supplier=supplier.id and receipt_manager_supplier.id_manager = employee_manager.id_manager and employee_manager.id_manager =employee.id ";
        Statement st ;
        try {
            st = (Statement) connection.createStatement();
            result = st.executeQuery(sqlCommand);
            System.out.println("GetData import_receipt details Correct ");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectImport_receipt.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Select ERROR \n" + ex.toString());
        }
        return result;
	}
	public ResultSet getData_importforstsatistic() {
        ResultSet result = null;
        String sqlCommand = "select product.name, receipt_manager_supplier.date , product.total ,product.price from " + tableimport_receipt +","+tablereceipt_manager_supplier+","+tableproduct+ " where import_receipt.id_receipt = receipt_manager_supplier.id_receipt and import_receipt.id_product = product.id ";
        Statement st ;
        try {
            st = (Statement) connection.createStatement();
            result = st.executeQuery(sqlCommand);
            System.out.println("GetData import_receipt details Correct ");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectImport_receipt.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Select ERROR \n" + ex.toString());
        }
        return result;
	}
    public void insertDB_importReceipt(ImportReceipt i, Product p){
        String sqlCommand = "insert into "+ tableimport_receipt +" value(? ,? ,? ,?)";
        PreparedStatement pst = null;
        
        try {
            pst = connection.prepareStatement(sqlCommand);
            pst.setInt(1, i.getCode());
            pst.setInt(2, p.getIdNumber());
            pst.setInt(3, p.getTotal());
            pst.setInt(4,p.getPrice());
            
            int row = pst.executeUpdate();
            if(row>0){
                JOptionPane.showMessageDialog(null, "Insert successful");
            }else{
            	JOptionPane.showMessageDialog(null, "Insert ERROR", "alert", JOptionPane.ERROR_MESSAGE);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectImport_receipt.class.getName()).log(Level.SEVERE, null, ex);
        	JOptionPane.showMessageDialog(null, "Insert ERROR", "alert", JOptionPane.ERROR_MESSAGE);
            System.out.println("Insert Import_ReceiptERROR");
        }
    }
}
