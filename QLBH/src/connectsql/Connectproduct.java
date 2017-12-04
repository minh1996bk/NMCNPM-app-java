package connectsql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import model.Product;

public class Connectproduct extends ConnectMysql {
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
	public ResultSet getData_product(){
        ResultSet result = null;
        String sqlCommand = "select * from " + tableproduct;
        Statement st ;
        try {
            st = (Statement) connection.createStatement();
            result = st.executeQuery(sqlCommand);
            System.out.println("GetData product Correct ");
        } catch (SQLException ex) {
            Logger.getLogger(Connectproduct.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Select ERROR \n" + ex.toString());
        }
        return result;
    }
	public void insertDB_product(Product p){
		String sqlCommand = "insert into "+ tableproduct +" value(? ,? ,? ,? ,? ,?, ? )";
		PreparedStatement pst = null;
	    try {
	    	pst = connection.prepareStatement(sqlCommand);
	        pst.setInt(1, p.getIdNumber());
	        pst.setString(2, p.getName());
	        pst.setInt(3, p.getPrice());
	        pst.setString(4, p.getProducer());
	        pst.setString(5, String.valueOf(p.getProduceTime()));
	        pst.setString(6, String.valueOf(p.getExpireTime()));
	        pst.setInt(7, p.getTotal());
	            
	        int row = pst.executeUpdate();
	        if(row>0){
	            JOptionPane.showMessageDialog(null, "Insert product successful");
	            }else{
	            	JOptionPane.showMessageDialog(null, "Insert product ERROR", "alert", JOptionPane.ERROR_MESSAGE);
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(Connectproduct.class.getName()).log(Level.SEVERE, null, ex);
            	JOptionPane.showMessageDialog(null, "Insert product ERROR", "alert", JOptionPane.ERROR_MESSAGE);
	            System.out.println("Insert product ERROR");
	        }
	    }
	public void UpdateProduct(int id, Product p) {
			// TODO Auto-generated method stub
			String sqlCommand="update "+tableproduct+" set name ='"+p.getName()+"', price ='"+p.getPrice()+"', producer ='"+p.getProducer()+"', produce_date ='"+p.getProduceTime()+"' , total ='"+p.getTotal()+"' where id ='"+id+"'";
			Statement st;
		try {
			st=(Statement) connection.createStatement();
			st.execute(sqlCommand);
			System.out.println("Update Product successful");
			JOptionPane.showMessageDialog(null, "Update Product Successful");
			}
		catch(SQLException ex) {
			System.out.println("Update product ERROR");
			Logger.getLogger(Connectproduct.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	public Boolean CheckSurviralProduct(Product product, ResultSet rs) {
		try {
			while(rs.next()) {
				if(product.getName().toLowerCase().equals(rs.getString(2).toLowerCase())&& product.getPrice()==rs.getInt(3) && String.valueOf(product.getProduceTime()).equals(rs.getString(5))) {
					JOptionPane.showMessageDialog(null, product.getName()+"You imported.Product is exist");
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Function CheckSurviralProduct ERROR");
		}
		return false;
	}
		//get total with id
	public int getTotal(int id) {
		Connectproduct con = new Connectproduct();
		con.Connect();
		ResultSet rs = con.getData_product();
		int total = 0;
		try {
			while(rs.next()) { 
				if(id == rs.getInt(1)){
					total = rs.getInt(7);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
	public void UpdateProduct(int id, int total) {
			// TODO Auto-generated method stub
		String sqlcommand = "update "+ tableproduct+ " set total = '" +total+ "' where id = '"+id+"' ";
		Statement st;
		try {
			st = (Statement) connection.createStatement();
			st.execute(sqlcommand);
			System.out.println("Update Product successful");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Update product ERROR");
			e.printStackTrace();
		}
	}
}
