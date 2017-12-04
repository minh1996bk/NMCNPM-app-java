package connectsql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Statement;
import model.ExportReceipt;

public class Connectexport_receipt extends ConnectMysql{
	//getdata in export_receipt table
	public ResultSet getData_exportreceipt(){
        ResultSet result = null;
        String sqlCommand = "select * from " + tableexport_receipt;
        Statement st ;
        try {
            st = (Statement) connection.createStatement();
            result = st.executeQuery(sqlCommand);
            System.out.println("GetData export_receipt Correct ");
        } catch (SQLException ex) {
            Logger.getLogger(Connectexport_receipt.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Select ERROR \n" + ex.toString());
        }
        return result;
    }
	//select Id for export_receipt
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
	
    public void insertDB_exportreceipt(ExportReceipt e){
        String sqlCommand = "insert into "+ tableexport_receipt +" value(? ,? ,? )";
        PreparedStatement pst = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(e.getTime());
        try {
            pst = connection.prepareStatement(sqlCommand);
            pst.setInt(1, e.getCode());
            pst.setInt(2, e.getEmployee().getIdNumber());
            pst.setString(3 ,date);
           
            int row = pst.executeUpdate();
            if(row>0){
                System.out.println("Inserted to DataBase");
                JOptionPane.showMessageDialog(null, "Add export_receipt successful");
            }else{
                System.out.println("Insert Error");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connectexport_receipt.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("InsertExport_receipt ERROR");
        }
    }
	public ResultSet getData_exportdetails() {
		// TODO Auto-generated method stub
		ResultSet result = null;
        String sqlCommand = "select export_receipt.id_receipt , employee.name , export_receipt.date , product.name , receipt_item.amount , receipt_item.price  from " + tableexport_receipt+","+tableemployee+","+tableproduct+","+tablereceipt_item+ " where export_receipt.id_receipt = receipt_item.id_receipt and export_receipt.id_employee = employee.id and receipt_item.id_product =product.id ";
        Statement st ;
        try {
            st = (Statement) connection.createStatement();
            result = st.executeQuery(sqlCommand);
            System.out.println("GetData export_receipt details Correct ");
        } catch (SQLException ex) {
            Logger.getLogger(Connectexport_receipt.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Select ERROR \n" + ex.toString());
        }
        return result;
	}
}
