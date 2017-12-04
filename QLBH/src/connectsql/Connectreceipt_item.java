package connectsql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mysql.jdbc.Statement;
import model.ExportReceipt;
import model.Product;

public class Connectreceipt_item extends ConnectMysql{
	//getdata in receipt_item
	public ResultSet getData_receiptitem(){
        ResultSet result = null;
        String sqlCommand = "select * from " + tablereceipt_item;
        Statement st ;
        try {
            st = (Statement) connection.createStatement();
            result = st.executeQuery(sqlCommand);
            System.out.println("GetData ReceiptItem Correct ");
        } catch (SQLException ex) {
            Logger.getLogger(Connectreceipt_item.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Select ERROR \n" + ex.toString());
        }
        return result;
    }
	//getdata in receipt_item depends on id
	public ResultSet getData_receiptitem(int id){
        ResultSet result = null;
        String sqlCommand = "select * from " + tablereceipt_item+ " where id_receipt = '"+id+"'";
        Statement st ;
        try {
            st = (Statement) connection.createStatement();
            result = st.executeQuery(sqlCommand);
            System.out.println("GetData ReceiptItem depend on id Correct ");
        } catch (SQLException ex) {
            Logger.getLogger(Connectreceipt_item.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Select ERROR \n" + ex.toString());
        }
        return result;
    }
	public int getPrice(ResultSet rs) {
		int price = 0;
		try {
			while(rs.next()) {
				price += Integer.parseInt(rs.getString(3))*Integer.parseInt(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return price;
	}
	//select Id for receipt_item
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
	//insert receipt_item
    public void insertDB_Receiptitem(ExportReceipt exp,Product pr){
        String sqlCommand = "insert into "+ tablereceipt_item+" value(? ,? ,? ,?)";
        PreparedStatement pst = null;
        
        try {
            pst = connection.prepareStatement(sqlCommand);
            pst.setInt(1, exp.getCode());
            pst.setInt(2, pr.getIdNumber());
            pst.setInt(3, pr.getPrice());
            pst.setInt(4, pr.getTotal());
            
            int row = pst.executeUpdate();
            if(row>0){
                System.out.println("Inserted to DataBase");
            }else{
                System.out.println("Insert Error");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connectreceipt_item.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Insert Receipt item ERROR");
        }
    }
}
