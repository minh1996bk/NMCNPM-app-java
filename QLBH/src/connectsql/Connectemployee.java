package connectsql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;
import model.Employee;
import model.Manager;


	public class Connectemployee extends ConnectMysql{
	//getdata in employee table
	public ResultSet getData_employee(){
        ResultSet result = null;
        String sqlCommand = "select * from " + tableemployee;
        Statement st ;
        try {
            st = (Statement) connection.createStatement();
            result = st.executeQuery(sqlCommand);
            System.out.println("GetData Employee Correct ");
        } catch (SQLException ex) {
            Logger.getLogger(Connectemployee.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Select ERROR \n" + ex.toString());
        }
        return result;
    }
	//getdata defaut salary
	public ResultSet getData_defaultSalary(){
        ResultSet result = null;
        String sqlCommand = "select * from " + tableDefaultSalary;
        Statement st ;
        try {
            st = (Statement) connection.createStatement();
            result = st.executeQuery(sqlCommand);
            System.out.println("GetData defaultSalary Correct ");
        } catch (SQLException ex) {
            Logger.getLogger(Connectemployee.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Select ERROR \n" + ex.toString());
        }
        return result;
    }
	//select Id for Emloyee
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
	public ResultSet getData_employee(int id){
        ResultSet result = null;
        String sqlCommand = "select * from " + tableemployee+" where id ='"+id+"'";
        Statement st ;
        try {
            st = (Statement) connection.createStatement();
            result = st.executeQuery(sqlCommand);
            System.out.println("GetData Employee Correct ");
        } catch (SQLException ex) {
            Logger.getLogger(Connectemployee.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Select ERROR \n" + ex.toString());
        }
        return result;
    }
	
    public void insertDB_employee(Employee e){
        String sqlCommand = "insert into "+ tableemployee +" value(? ,? ,? ,? ,? ,? ,? ,?)";
        PreparedStatement pst = null;
        
        try {
            pst = connection.prepareStatement(sqlCommand);
            pst.setInt(1, e.getIdNumber());
            pst.setString(2, e.getName());
            pst.setString(3, e.getSex());
            pst.setString(4, String.valueOf(e.getDateOfBirth()));
            pst.setString(5, e.getAddress());
            pst.setString(6, e.getPhoneNumber());
            pst.setInt(7, e.getCoefficientsSalary());
            pst.setString(8, e.getPosition());
            
            int row = pst.executeUpdate();
            if(row>0){
                System.out.println("Inserted to DataBase");
                JOptionPane.showMessageDialog(null, "Add Employee successful");
            }else{
                System.out.println("Insert Error");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connectemployee.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("InsertEmployee ERROR");
        }
    }
    
    public void insertDB_employee(Manager e){
        String sqlCommand = "insert into "+ tableemployee +" value(? ,? ,? ,? ,? ,? ,? ,?)";
        PreparedStatement pst = null;
        
        try {
            pst = connection.prepareStatement(sqlCommand);
            pst.setInt(1, e.getIdNumber());
            pst.setString(2, e.getName());
            pst.setString(3, e.getSex());
            pst.setString(4, String.valueOf(e.getDateOfBirth()));
            pst.setString(5, e.getAddress());
            pst.setString(6, e.getPhoneNumber());
            pst.setInt(7, e.getCoefficientsSalary());
            pst.setString(8, e.getPosition());
            
            int row = pst.executeUpdate();
            if(row>0){
                System.out.println("Inserted to DataBase");
                JOptionPane.showMessageDialog(null, "Add Manager successful");
            }else{
                System.out.println("Insert Error");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connectemployee.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("InsertEmployee ERROR");
        }
    }
    public void insertDB_employeemanager(Manager m){
        String sqlCommand = "insert into "+ tableemployee_manager +" value(? ,?)";
        PreparedStatement pst = null;
        
        try {
            pst = connection.prepareStatement(sqlCommand);
            pst.setInt(1, m.getIdNumber());
            pst.setInt(2, m.getCommission());

            
            int row = pst.executeUpdate();
            if(row>0){
                System.out.println("Inserted to DataBase");
                JOptionPane.showMessageDialog(null, "Add Manager successful");
            }else{
                System.out.println("Insert Error");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connectemployee.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Insert Employee_Manager ERROR");
        }
    }
	public void UpdateEmployee(int id, Employee employee) {
		// TODO Auto-generated method stub
		String sqlCommand="update "+tableemployee+" set name ='"+employee.getName()+"', sex ='"+employee.getSex()+"', birth_date ='"+employee.getDateOfBirth()+"', address ='"+employee.getAddress()+"', phone_no ='"+employee.getPhoneNumber()+"', coefficient_salary ='"+ employee.getCoefficientsSalary()+"', position ='"+employee.getPosition()+"' where id ='"+id+"'";
		Statement st;
		try {
		    st=(Statement) connection.createStatement();
		    st.execute(sqlCommand);
		    System.out.println("UpdateEmployee successful");
		    JOptionPane.showMessageDialog(null, "Update Employee Successful");
		    }
		catch (SQLException ex) {
			System.out.println("UpdateEmployee ERROR");
			Logger.getLogger(Connectemployee.class.getName()).log(Level.SEVERE, null, ex);
		   	}
	}
	public void UpdateEmployee(int id, Manager m) {
		// TODO Auto-generated method stub
		String sqlCommand="update "+tableemployee+" set name ='"+m.getName()+"', sex ='"+m.getSex()+"', birth_date ='"+m.getDateOfBirth()+"', address ='"+m.getAddress()+"', phone_no ='"+m.getPhoneNumber()+"', coefficient_salary ='"+ m.getCoefficientsSalary()+"', position ='"+m.getPosition()+"' where id ='"+id+"'";
		Statement st;
		try {
		    st=(Statement) connection.createStatement();
		    st.execute(sqlCommand);
		    System.out.println("UpdateEmployee successful");
		    JOptionPane.showMessageDialog(null, "Update Employee Successful");
		    }
		catch (SQLException ex) {
			System.out.println("UpdateManager ERROR");
			Logger.getLogger(Connectemployee.class.getName()).log(Level.SEVERE, null, ex);
		   	}
	}
	
	public void UpdateEmployee_manager(int id, Manager m) {
		// TODO Auto-generated method stub
		String sqlCommand="update "+tableemployee_manager+" set commission ='"+m.getCommission()+"' where id_manager ='"+id+"'";
		Statement st;
		try {
		    st=(Statement) connection.createStatement();
		    st.execute(sqlCommand);
		    System.out.println("UpdateEmployee_manager successful");
		    JOptionPane.showMessageDialog(null, "Update Employee_manager Successful");
		    }
		catch (SQLException ex) {
			System.out.println("UpdateManager ERROR");
			Logger.getLogger(Connectemployee.class.getName()).log(Level.SEVERE, null, ex);
		   	}
	}

	public void inserDB_shipper(Employee employee) {
		// TODO Auto-generated method stub
		String sqlcommand = "insert into "+tableshipper+" value(?)";
		PreparedStatement pst;
		try {
			pst = connection.prepareStatement(sqlcommand);
			pst.setInt(1, employee.getIdNumber());
			System.out.println("insert into shipper successful");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("insert into shipper error");
			e.printStackTrace();
		}
		
	}
	public ResultSet getdata_statistic_Salary() {
        ResultSet result = null;
        String sqlCommand = "select employee.name ,employee.sex ,employee.birth_date, employee.coefficient_salary, employee.position, employee_manager.commission from " + tableemployee +" left join "+ tableemployee_manager+" on employee.id = employee_manager.id_manager";
        Statement st ;
        try {
            st = (Statement) connection.createStatement();
            result = st.executeQuery(sqlCommand);
            System.out.println("GetData Employee and Employee_Manager Correct ");
        } catch (SQLException ex) {
            Logger.getLogger(Connectemployee.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Select ERROR \n" + ex.toString());
        }
        return result;
	}
	public void Deletecommission(int idNumber) {
		// TODO Auto-generated method stub
		String sqlcommand = "delete  from "+tableemployee_manager+" where id_manager = '"+idNumber+"'";
		Statement st;
		try {
			st =(Statement) connection.createStatement();
			st.executeUpdate(sqlcommand);
			JOptionPane.showMessageDialog(null, "Delete in employee_manager successful");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean Checkidinemployee_manager(ResultSet rs ,int i) {
		try {
			while(rs.next()) {
				if(i == rs.getInt(1)) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
