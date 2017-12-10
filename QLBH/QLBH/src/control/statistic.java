package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import connectsql.ConnectImport_receipt;
import connectsql.Connectemployee;
import connectsql.Connectexport_receipt;

public class statistic {
	private JTable table;
	private JMonthChooser month;
	private JYearChooser year;
	public statistic(JTable table,JMonthChooser month,JYearChooser year) {
		this.table = table;
		this.month = month;
		this.year = year;
	}
	//statistic_import funtion with table , month year
	public void Statistic_Import() {
		ConnectImport_receipt connectImport_receipt = new ConnectImport_receipt();
		connectImport_receipt.Connect();
		ResultSet rs = connectImport_receipt.getData_importforstsatistic();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		Object os[]={"Mã hàng hóa","Tên mặt hàng","Ngày nhập kho","Tổng tiền"};
		model.setColumnCount(4);
        model.setColumnIdentifiers(os);
		try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            
			while(rs.next()){
				Object row[] = new Object[4];
				row[0] = rs.getInt(1);
				row[1] = rs.getObject(2);
				row[2] = rs.getDate(3);
				row[3] = rs.getInt(4)*rs.getInt(5);
				String str = sdf.format(rs.getDate(3));
				int y = Integer.parseInt(str.substring(0, 4));
				int m = Integer.parseInt(str.substring(5,7));
				if(m == (month.getMonth()+1) && y==year.getYear()) {
					model.addRow(row);
				}
			}
			if(model.getRowCount()==0) {
				JOptionPane.showMessageDialog(null,"No acion in this month");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Funtion Statistic_Import ERROR");
			e.printStackTrace();
		}
	}
	//salary of employee funtion with table , month year
	public void Statistic_Salary() {
		// TODO Auto-generated method stub
		Connectemployee connectemployee = new Connectemployee();
		connectemployee.Connect();
		int values = 0;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		Object os[]={"Tên nhân viên","Giới tính","Ngày sinh","Tiền lương"};
		model.setColumnCount(4);
        model.setColumnIdentifiers(os);
        //get default salary;
        ResultSet rs_defaultsalary = connectemployee.getData_defaultSalary();
        try {
			while(rs_defaultsalary.next()) {
				values = rs_defaultsalary.getInt(1);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        //getdata employee
        ResultSet rs_employee = connectemployee.getdata_statistic_Salary();
        try {
			while(rs_employee.next()) {
				Object row[] = new Object[4];
				row[0] = rs_employee.getObject(1);
				row[1] = rs_employee.getObject(2);
				row[2] = rs_employee.getDate(3);
				if(rs_employee.getString(5).equals("manager")) {
					row[3] = (rs_employee.getInt(4)+rs_employee.getInt(6))* values;
				}else {
					row[3] = rs_employee.getInt(4) * values;
				}
				model.addRow(row);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	// exportoffline_statistic funtion with table month year
	public void statistic_exportoff() {
		// TODO Auto-generated method stub
		Connectexport_receipt connectexport_receipt = new  Connectexport_receipt();
		connectexport_receipt.Connect();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		Object os[]={"Mã hàng hóa","Tên nhân viên","Thời gian","Tên hàng","Tổng tiền"};
		model.setColumnCount(6);
        model.setColumnIdentifiers(os);
        ResultSet rs = connectexport_receipt.getData_exportdetails();
        try {
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			while(rs.next()) {
				Object row[] = new Object[5];
				row[0] = rs.getInt(1);
				row[1]= rs.getString(2);
				row[2] = rs.getDate(3);
				row[3]= rs.getString(4);
				row[4]= rs.getInt(5)* rs.getInt(6);
				String str = sdf.format(rs.getDate(3));
				int y = Integer.parseInt(str.substring(0, 4));
				int m = Integer.parseInt(str.substring(5,7));
				if(m == (month.getMonth()+1) && y==year.getYear()) {
					model.addRow(row);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
