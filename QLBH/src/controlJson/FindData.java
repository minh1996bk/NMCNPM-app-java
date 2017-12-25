package controlJson;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Employee;
import model.ExportReceipt;
import model.ImportReceipt;
import model.Order;
import model.Product;
import model.Status;

public class FindData {
		private int combox;
		private JTextField input;
		private JTable table;
		private String str;
		private String STR;

		public FindData() {
			
		}
		public FindData(int i , JTextField input ,JTable table) {
			this.setCombox(i);
			this.setInput(input);
			this.setTable(table);
		}
		public FindData(JTextField input , JTable table) {
			this.input = input;
			this.table = table;
		}
		public FindData(JTable table, String str) {
			this.table = table;
			this.str = str;
		}
		public FindData(JTable table, String name ,String date ) {
			this.table = table;
			this.str = name;
			this.STR = date;
		}
		/**
		 * @return the combox
		 */
		public int getCombox() {
			return combox;
		}
		/**
		 * @param combox the combox to set
		 */
		public void setCombox(int combox) {
			this.combox = combox;
		}
		/**
		 * @return the table
		 */
		public JTable getTable() {
			return table;
		}
		/**
		 * @param table the table to set
		 */
		public void setTable(JTable table) {
			this.table = table;
		}
		/**
		 * @return the input
		 */
		public JTextField getInput() {
			return input;
		}
		/**
		 * @param input the input to set
		 */
		public void setInput(JTextField input) {
			this.input = input;
		}
	    //funtion find data in employee table with select = select combobox
	    public void finddata_employee(ArrayList<Employee> employees){
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setNumRows(0);
	        String str = input.getText().toLowerCase();
	        while(str.contains(" ")){
	            str = str.replaceAll(" ", "");
	        }
	        for(Employee employee : employees) {
	        	if(combox == 0) {
	        		if(String.valueOf(employee.getIdNumber()).equals(str)){
	        			 Object row[] = new Object[8];
	                        row[0]= employee.getIdNumber();
	                        row[1]= employee.getName();
	                        row[2]= employee.getSex();
	                        row[3]= employee.getDateOfBirth();
	                        row[4]= employee.getAddress();
	                        row[5]= employee.getPhoneNumber();
	                        row[6]= employee.getCoefficientsSalary();
	                        row[7]= employee.getPosition();
	                        model.addRow(row);
	        		}
	        	}if(combox == 2){
                    if(employee.getSex().toLowerCase().contains(str)){
	        			 Object row[] = new Object[8];
	                        row[0]= employee.getIdNumber();
	                        row[1]= employee.getName();
	                        row[2]= employee.getSex();
	                        row[3]= employee.getDateOfBirth();
	                        row[4]= employee.getAddress();
	                        row[5]= employee.getPhoneNumber();
	                        row[6]= employee.getCoefficientsSalary();
	                        row[7]= employee.getPosition();
	                        model.addRow(row);
                    }
                }if(combox == 1){
                    if(employee.getName().toLowerCase().contains(str)){
	        			 Object row[] = new Object[8];
	                        row[0]= employee.getIdNumber();
	                        row[1]= employee.getName();
	                        row[2]= employee.getSex();
	                        row[3]= employee.getDateOfBirth();
	                        row[4]= employee.getAddress();
	                        row[5]= employee.getPhoneNumber();
	                        row[6]= employee.getCoefficientsSalary();
	                        row[7]= employee.getPosition();
	                        model.addRow(row);
                    }    
                }if(combox == 3){
                    if(employee.getAddress().toLowerCase().contains(str)){
	        			 Object row[] = new Object[8];
	                        row[0]= employee.getIdNumber();
	                        row[1]= employee.getName();
	                        row[2]= employee.getSex();
	                        row[3]= employee.getDateOfBirth();
	                        row[4]= employee.getAddress();
	                        row[5]= employee.getPhoneNumber();
	                        row[6]= employee.getCoefficientsSalary();
	                        row[7]= employee.getPosition();
	                        model.addRow(row);
                    }    
                } if(combox == 4){
                    if(employee.getPhoneNumber().toLowerCase().equals(str)){
	        			 Object row[] = new Object[8];
	                        row[0]= employee.getIdNumber();
	                        row[1]= employee.getName();
	                        row[2]= employee.getSex();
	                        row[3]= employee.getDateOfBirth();
	                        row[4]= employee.getAddress();
	                        row[5]= employee.getPhoneNumber();
	                        row[6]= employee.getCoefficientsSalary();
	                        row[7]= employee.getPosition();
	                        model.addRow(row);
                    }    
                }    
            }
	    }
	        
	    //funtion find data in product table ,depends on name
	    public void finddata_nameproduct(ArrayList<Product> products){
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setNumRows(0);
//	        Connectproduct connectproduct = new Connectproduct();
//	        connectproduct.Connect();
	        String str = input.getText().toLowerCase();
	        while(str.contains(" ")){
	            str = str.replaceAll(" ", "");
	        }
	        for(Product product : products){
	        	if(product.getName().toLowerCase().contains(str)) {
	        		 Object row[] = new Object[5];
                     row[0]= product.getIdNumber();
                     row[1]= product.getName();
                     row[2]= product.getPrice();
                     row[3]= product.getTotal();
                     row[4]= product.getType();
                     model.addRow(row);
	        	}
	        }
	    }
	    //funtion find data in producttable with combo = values of combobox

	    public void finddata_product(ArrayList<Product> products){
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setNumRows(0);
	        String str = input.getText().toLowerCase();
	        while(str.contains(" ")){
	            str = str.replaceAll(" ", "");
	        }
	        for(Product product : products) {
	        	if(combox == 0){
                    if(String.valueOf(product.getIdNumber()).toLowerCase().equals(str)){
   	        		 Object row[] = new Object[5];
                     row[0]= product.getIdNumber();
                     row[1]= product.getName();
                     row[2]= product.getPrice();
                     row[3]= product.getTotal();
                     row[4]= product.getType();
                     model.addRow(row);
                    }
                }if(combox == 1){
                    if(product.getName().toLowerCase().contains(str)){
   	        		 Object row[] = new Object[5];
                     row[0]= product.getIdNumber();
                     row[1]= product.getName();
                     row[2]= product.getPrice();
                     row[3]= product.getTotal();
                     row[4]= product.getType();
                     model.addRow(row);
                    }
                }    
	        }
	    }
	    public void finddata_Import_date(ArrayList<ImportReceipt> importReceipts){
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setNumRows(0);
	        for(ImportReceipt importreceipt : importReceipts) {
	        	if(str.equals(importreceipt.getTime())){
	        		for(Product product : importreceipt.getArray()) {
	        			 Object row[] = new Object[7];
		                    row[0]= importreceipt.getCode();
		                    row[1]= importreceipt.getImporter().getName();
		                    row[2]= importreceipt.getSupplier().getName();
		                    row[3]= importreceipt.getTime();
		                    row[4]= product.getName();
		                    row[5]= product.getTotal();
		                    row[6]= product.getPrice();
		                    model.addRow(row);
	        		}
	        	}
	        }
	        if(model.getRowCount()==0) {
				JOptionPane.showMessageDialog(null,"No action on this day");
			}
	    }
	    
		/**
		 * @return the date
		 */
		public String getDate() {
			return str;
		}
		/**
		 * @param date the date to set
		 */
		public void setDate(String str) {
			this.str = str;
		}
		public void finddata_Import_name(ArrayList<ImportReceipt> importReceipts) {
			// TODO Auto-generated method stub
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setNumRows(0);
	        for(ImportReceipt importreceipt:importReceipts) {
	        	if(importreceipt.getImporter().getName().toLowerCase().equals(str.toLowerCase())) {
	        		for(Product product : importreceipt.getArray()) {
	        			 Object row[] = new Object[7];
		                    row[0]= importreceipt.getCode();
		                    row[1]= importreceipt.getImporter().getName();
		                    row[2]= importreceipt.getSupplier().getName();
		                    row[3]= importreceipt.getTime();
		                    row[4]= product.getName();
		                    row[5]= product.getTotal();
		                    row[6]= product.getPrice();
		                    model.addRow(row);
	        		}
	        	}
	        }
			if(model.getRowCount()==0) {
				JOptionPane.showMessageDialog(null,"no action");
			}
		}
		
		public void finddata_Import_namedate(ArrayList<ImportReceipt> importReceipts) {
			// TODO Auto-generated method stub
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setNumRows(0);
	        for(ImportReceipt importreceipt:importReceipts) {
	        	if(importreceipt.getImporter().getName().toLowerCase().contains(str.toLowerCase()) && importreceipt.getTime().contains(STR)) {
	        		for(Product product : importreceipt.getArray()) {
	        			 Object row[] = new Object[7];
		                    row[0]= importreceipt.getCode();
		                    row[1]= importreceipt.getImporter().getName();
		                    row[2]= importreceipt.getSupplier().getName();
		                    row[3]= importreceipt.getTime();
		                    row[4]= product.getName();
		                    row[5]= product.getTotal();
		                    row[6]= product.getPrice();
		                    model.addRow(row);
	        		}
	        	}				
	        }
        	if(model.getRowCount()==0) {
				JOptionPane.showMessageDialog(null,"No action with the employee name on this day");
			}
		}
		
		public void finddata_Export_date(ArrayList<ExportReceipt> exportReceipts) {
			// TODO Auto-generated method stub
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setNumRows(0);
	        for(ExportReceipt exportReceipt: exportReceipts) {
	        	if(str.equals(exportReceipt.getTime())) {
	        		for(Product product : exportReceipt.getItem()) {
	        			Object row[] = new Object[9];
	                    row[0]= exportReceipt.getCode();
	                    row[1]= exportReceipt.getEmployee().getName();
	                    row[2]= exportReceipt.getTime();
	                    row[3]= product.getName();
	                    row[4]= product.getTotal();
	                    row[5]= product.getPrice();
	                    model.addRow(row);
	        		}
	        	}
	        }
			if(model.getRowCount()==0) {
				JOptionPane.showMessageDialog(null,"No action on this day");
			}
		}
		
		public void finddata_Export_name(ArrayList<ExportReceipt> exportReceipts) {
			// TODO Auto-generated method stub
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setNumRows(0);
	        for(ExportReceipt exportReceipt: exportReceipts) {
	        	if(str.toLowerCase().equals(exportReceipt.getEmployee().getName().toLowerCase())) {
	        		for(Product product : exportReceipt.getItem()) {
	        			Object row[] = new Object[9];
	                    row[0]= exportReceipt.getCode();
	                    row[1]= exportReceipt.getEmployee().getName();
	                    row[2]= exportReceipt.getTime();
	                    row[3]= product.getName();
	                    row[4]= product.getTotal();
	                    row[5]= product.getPrice();
	                    model.addRow(row);
	        		}
	        	}
	        }
			if(model.getRowCount()==0) {
				JOptionPane.showMessageDialog(null,"No action on this day");
			}
		}
		public void finddata_Export_namedate(ArrayList<ExportReceipt> exportReceipts) {
			// TODO Auto-generated method stub
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setNumRows(0);
	        for(ExportReceipt exportReceipt: exportReceipts) {
	        	if(str.toLowerCase().equals(exportReceipt.getEmployee().getName().toLowerCase()) && STR.equals(exportReceipt.getTime())) {
	        		for(Product product : exportReceipt.getItem()) {
	        			Object row[] = new Object[9];
	                    row[0]= exportReceipt.getCode();
	                    row[1]= exportReceipt.getEmployee().getName();
	                    row[2]= exportReceipt.getTime();
	                    row[3]= product.getName();
	                    row[4]= product.getTotal();
	                    row[5]= product.getPrice();
	                    model.addRow(row);
	        		}
	        	}
	        }
			if(model.getRowCount()==0) {
				JOptionPane.showMessageDialog(null,"No action with the employee on this day");
			}
		}
		//funtion find data depends on status
		public void finddata_export_online(ArrayList<Order> orders) {
			if(str.equals("")){ 
				JOptionPane.showMessageDialog(null, "Please choose status");
			}
			if(str.equals("all")){
				DefaultTableModel model = (DefaultTableModel) table.getModel();
		        model.setNumRows(0);
		        for(Order order: orders){
		        	for(Product product : order.getProducts()) {
		        		Object row[] = new Object[10];
	                    row[0]= order.getId();
	                    row[1]= order.getName();
	                    row[2]= order.getPhone();
	                    row[3]= order.getAddress1();
	                    row[4]= order.getEmail();
	                    row[5]= order.getCreatedAt();
	                    row[6]= product.getIdNumber();
	                    row[7]= product.getTotal();
	                    row[8]= product.getType();
	                    row[9] = order.getStatus();
	                    model.addRow(row);
		        	}
		        }
			}
			if(str.equals("waiting")) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
		        model.setNumRows(0);
		        for(Order order: orders){
		        	if(order.getStatus().equals(Status.waiting)) {
			        	for(Product product : order.getProducts()) {
			        		Object row[] = new Object[10];
		                    row[0]= order.getId();
		                    row[1]= order.getName();
		                    row[2]= order.getPhone();
		                    row[3]= order.getAddress1();
		                    row[4]= order.getEmail();
		                    row[5]= order.getCreatedAt();
		                    row[6]= product.getIdNumber();
		                    row[7]= product.getTotal();
		                    row[8]= product.getType();
		                    row[9] = order.getStatus();
		                    model.addRow(row);
			        	}
		        	}
		        }
	        	if(table.getModel().getRowCount()==0) {
                	JOptionPane.showMessageDialog(null, "Empty");
                }
			}
			if(str.equals("accepted")) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
		        model.setNumRows(0);
		        for(Order order: orders){
		        	if(order.getStatus().equals(Status.accepted)) {
			        	for(Product product : order.getProducts()) {
			        		Object row[] = new Object[10];
		                    row[0]= order.getId();
		                    row[1]= order.getName();
		                    row[2]= order.getPhone();
		                    row[3]= order.getAddress1();
		                    row[4]= order.getEmail();
		                    row[5]= order.getCreatedAt();
		                    row[6]= product.getIdNumber();
		                    row[7]= product.getTotal();
		                    row[8]= product.getType();
		                    row[9] = order.getStatus();
		                    model.addRow(row);
			        	}
		        	}
		        }
	        	if(table.getModel().getRowCount()==0) {
                	JOptionPane.showMessageDialog(null, "Empty");
                }
			}
			if(str.equals("shipping")) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
		        model.setNumRows(0);
		        for(Order order: orders){
		        	if(order.getStatus().equals(Status.shipping)) {
			        	for(Product product : order.getProducts()) {
			        		Object row[] = new Object[10];
		                    row[0]= order.getId();
		                    row[1]= order.getName();
		                    row[2]= order.getPhone();
		                    row[3]= order.getAddress1();
		                    row[4]= order.getEmail();
		                    row[5]= order.getCreatedAt();
		                    row[6]= product.getIdNumber();
		                    row[7]= product.getTotal();
		                    row[8]= product.getType();
		                    row[9] = order.getStatus();
		                    model.addRow(row);
			        	}
		        	}
		        }
	        	if(table.getModel().getRowCount()==0) {
                	JOptionPane.showMessageDialog(null, "Empty");
                }
			}
			if(str.equals("canceled")) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
		        model.setNumRows(0);
		        for(Order order: orders){
		        	if(order.getStatus().equals(Status.canceled)) {
			        	for(Product product : order.getProducts()) {
			        		Object row[] = new Object[10];
		                    row[0]= order.getId();
		                    row[1]= order.getName();
		                    row[2]= order.getPhone();
		                    row[3]= order.getAddress1();
		                    row[4]= order.getEmail();
		                    row[5]= order.getCreatedAt();
		                    row[6]= product.getIdNumber();
		                    row[7]= product.getTotal();
		                    row[8]= product.getType();
		                    row[9] = order.getStatus();
		                    model.addRow(row);
			        	}
		        	}
		        }
	        	if(table.getModel().getRowCount()==0) {
                	JOptionPane.showMessageDialog(null, "Empty");
                }
			}
			if(str.equals("completed")) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
		        model.setNumRows(0);
		        for(Order order: orders){
		        	if(order.getStatus().equals(Status.completed)) {
			        	for(Product product : order.getProducts()) {
			        		Object row[] = new Object[10];
		                    row[0]= order.getId();
		                    row[1]= order.getName();
		                    row[2]= order.getPhone();
		                    row[3]= order.getAddress1();
		                    row[4]= order.getEmail();
		                    row[5]= order.getCreatedAt();
		                    row[6]= product.getIdNumber();
		                    row[7]= product.getTotal();
		                    row[8]= product.getType();
		                    row[9] = order.getStatus();
		                    model.addRow(row);
			        	}
		        	}
		        }
	        	if(table.getModel().getRowCount()==0) {
                	JOptionPane.showMessageDialog(null, "Empty");
                }
			}
		}
}
