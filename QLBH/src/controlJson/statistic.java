package controlJson;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import connectJson.EmployeeJson;
import model.Employee;
import model.ExportReceipt;
import model.ImportReceipt;
import model.Order;
import model.Product;

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
	public void Statistic_Import(ArrayList<ImportReceipt> importReceipts) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		Object os[]={"Mã hàng hóa","Tên mặt hàng","Ngày nhập kho","Tổng tiền"};
		model.setColumnCount(4);
        model.setColumnIdentifiers(os);
        for(ImportReceipt importReceipt: importReceipts) {
        	for(Product product : importReceipt.getArray()){
        		Object row[] = new Object[4];
				row[0] = importReceipt.getCode();
				row[1] = product.getName();
				row[2] = importReceipt.getTime();
				row[3] = product.getPrice()*product.getTotal();
				String str = importReceipt.getTime();
				int y = Integer.parseInt(str.substring(0, 4));
				int m = Integer.parseInt(str.substring(5,7));
				if(m == (month.getMonth()+1) && y==year.getYear()) {
					model.addRow(row);
				}
        	}
        }
		if(model.getRowCount()==0) {
			JOptionPane.showMessageDialog(null,"No acion in this month");
		}
	}
	//salary of employee funtion with table , month year
	public void Statistic_Salary(ArrayList<Employee> employees) {
		
		int values = Integer.parseInt(EmployeeJson.getDefaultSalary());
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		Object os[]={"Tên nhân viên","Giới tính","Ngày sinh","Tiền lương"};
		model.setColumnCount(4);
    model.setColumnIdentifiers(os);
    //get default salary;
    //getdata employee
    for(Employee employee: employees) {
			Object row[] = new Object[4];
			row[0] = employee.getName();
			row[1] = employee.getSex();
			row[2] = employee.getDateOfBirth();
			if(employee.getPosition().equals("manager")) {
				row[3] = (employee.getCoefficientsSalary() + employee.getCoefficientsSalary())* values;
			}else {
				row[3] = employee.getCoefficientsSalary() * values;
			}
			model.addRow(row);
    }
	}
	// exportoffline_statistic funtion with table month year
	public void statistic_exportoff(ArrayList<ExportReceipt> exportReceipts) {
		// TODO Auto-generated method stub
//		Connectexport_receipt connectexport_receipt = new  Connectexport_receipt();
//		connectexport_receipt.Connect();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		Object os[]={"Mã hàng hóa","Tên nhân viên","Thời gian","Tên hàng","Tổng tiền"};
		model.setColumnCount(6);
        model.setColumnIdentifiers(os);
        for(ExportReceipt exportReceipt : exportReceipts) {
        	for(Product product: exportReceipt.getItem()) {
        		Object row[] = new Object[5];
				row[0] = exportReceipt.getCode();
				row[1]= exportReceipt.getEmployee().getName();
				row[2] = exportReceipt.getTime();
				row[3]= product.getName();
				row[4]= product.getTotal() * product.getPrice();
				String str = exportReceipt.getTime();
				int y = Integer.parseInt(str.substring(0, 4));
				int m = Integer.parseInt(str.substring(5,7));
				if(m == (month.getMonth()+1) && y==year.getYear()) {
					model.addRow(row);
				}
        	}
        }
	}
	public void statistic_exportonline(ArrayList<Order> orders) {
		// TODO Auto-generated method stub
//		ConnectOrder_cart connectOrder = new ConnectOrder_cart();
//		connectOrder.Connect();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		Object os[]={"Mã đặt hàng","Tên người mua","Ngày chuyển hàng","Mã hàng","Tên hàng","Tổng tiền"};
		model.setColumnCount(6);
        model.setColumnIdentifiers(os);
        for(Order order: orders) {
        	for(Product product:order.getProducts()) {
        		Object row[] = new Object[6];
        		row[0]= order.getId();
        		row[1]= order.getName();
        		row[2]= order.getUpdatedAt();
        		row[3]= product.getIdNumber();
        		row[4]= product.getName();
        		row[5]= product.getTotal()*product.getPrice();
        		String str = order.getUpdatedAt();
				int y = Integer.parseInt(str.substring(0, 4));
				int m = Integer.parseInt(str.substring(5,7));
				if(m == (month.getMonth()+1) && y==year.getYear()) {
					model.addRow(row);
				}
        	}
        }
	}
}
