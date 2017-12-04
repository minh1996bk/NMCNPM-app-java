package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import connectsql.ConnectImport_receipt;
import connectsql.Connectemployee;
import connectsql.Connectexport_receipt;
import connectsql.Connectproduct;

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
    public void finddata_employee(){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        Connectemployee Connectemployee = new Connectemployee();
        Connectemployee.Connect();
        String str = input.getText().toLowerCase();
        while(str.contains(" ")){
            str = str.replaceAll(" ", "");
        }
        ResultSet rs = Connectemployee.getData_employee();
        try {
            while(rs.next()){
                if(combox == 0){
                    if(String.valueOf(rs.getObject(1)).toLowerCase().contains(str)){
                        Object row[] = new Object[8];
                        row[0]= rs.getObject(1);
                        row[1]= rs.getObject(2);
                        row[2]= rs.getObject(3);
                        row[3]= rs.getObject(4);
                        row[4]= rs.getObject(5);
                        row[5]= rs.getObject(6);
                        row[6]= rs.getObject(7);
                        row[7]= rs.getObject(8);
                        model.addRow(row);
                    }
                }if(combox == 2){
                    if(String.valueOf(rs.getObject(3)).toLowerCase().contains(str)){
                        Object row[] = new Object[8];
                        row[0]= rs.getObject(1);
                        row[1]= rs.getObject(2);
                        row[2]= rs.getObject(3);
                        row[3]= rs.getObject(4);
                        row[4]= rs.getObject(5);
                        row[5]= rs.getObject(6);
                        row[6]= rs.getObject(7);
                        row[7]= rs.getObject(8);
                        model.addRow(row);
                    }
                }if(combox == 1){
                    if(String.valueOf(rs.getObject(2)).toLowerCase().contains(str)){
                        Object row[] = new Object[8];
                        row[0]= rs.getObject(1);
                        row[1]= rs.getObject(2);
                        row[2]= rs.getObject(3);
                        row[3]= rs.getObject(4);
                        row[4]= rs.getObject(5);
                        row[5]= rs.getObject(6);
                        row[6]= rs.getObject(7);
                        row[7]= rs.getObject(8);
                        model.addRow(row);
                    }    
                }if(combox == 3){
                    if(String.valueOf(rs.getObject(5)).toLowerCase().contains(str)){
                        Object row[] = new Object[8];
                        row[0]= rs.getObject(1);
                        row[1]= rs.getObject(2);
                        row[2]= rs.getObject(3);
                        row[3]= rs.getObject(4);
                        row[4]= rs.getObject(5);
                        row[5]= rs.getObject(6);
                        row[6]= rs.getObject(7);
                        row[7]= rs.getObject(8);
                        model.addRow(row);
                    }    
                } if(combox == 4){
                    if(String.valueOf(rs.getObject(6)).toLowerCase().contains(str)){
                        Object row[] = new Object[8];
                        row[0]= rs.getObject(1);
                        row[1]= rs.getObject(2);
                        row[2]= rs.getObject(3);
                        row[3]= rs.getObject(4);
                        row[4]= rs.getObject(5);
                        row[5]= rs.getObject(6);
                        row[6]= rs.getObject(7);
                        row[7]= rs.getObject(8);
                        model.addRow(row);
                    }    
                }    
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connectemployee.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Finddata function ERROR ");
        } 
    }
    //funtion find data in product table ,depends on name
    public void finddata_nameproduct(){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        Connectproduct connectproduct = new Connectproduct();
        connectproduct.Connect();
        String str = input.getText().toLowerCase();
        while(str.contains(" ")){
            str = str.replaceAll(" ", "");
        }
        ResultSet rs = connectproduct.getData_product();
        try {
            while(rs.next()){
                    if(String.valueOf(rs.getObject(2)).toLowerCase().contains(str)){
                        Object row[] = new Object[7];
                        row[0]= rs.getObject(1);
                        row[1]= rs.getObject(2);
                        row[2]= rs.getObject(3);
                        row[3]= rs.getObject(4);
                        row[4]= rs.getObject(5);
                        row[5]= rs.getObject(6);
                        row[6]= rs.getObject(7);
                        model.addRow(row);
                    }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connectproduct.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Finddata function ERROR ");
        } 
    }
    //funtion find data in producttable with combo = values of combobox

    public void finddata_product(){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        Connectproduct connectproduct = new Connectproduct();
        connectproduct.Connect();
        String str = input.getText().toLowerCase();
        while(str.contains(" ")){
            str = str.replaceAll(" ", "");
        }
        ResultSet rs = connectproduct.getData_product();
        try {
            while(rs.next()){
                if(combox == 0){
                    if(String.valueOf(rs.getObject(1)).toLowerCase().contains(str)){
                        Object row[] = new Object[7];
                        row[0]= rs.getObject(1);
                        row[1]= rs.getObject(2);
                        row[2]= rs.getObject(3);
                        row[3]= rs.getObject(4);
                        row[4]= rs.getObject(5);
                        row[5]= rs.getObject(6);
                        row[6]= rs.getObject(7);
                        model.addRow(row);
                    }
                }if(combox == 1){
                    if(String.valueOf(rs.getObject(2)).toLowerCase().contains(str)){
                        Object row[] = new Object[7];
                        row[0]= rs.getObject(1);
                        row[1]= rs.getObject(2);
                        row[2]= rs.getObject(3);
                        row[3]= rs.getObject(4);
                        row[4]= rs.getObject(5);
                        row[5]= rs.getObject(6);
                        row[6]= rs.getObject(7);
                        model.addRow(row);
                    }
                }if(combox == 2){
                    if(String.valueOf(rs.getObject(4)).toLowerCase().contains(str)){
                        Object row[] = new Object[7];
                        row[0]= rs.getObject(1);
                        row[1]= rs.getObject(2);
                        row[2]= rs.getObject(3);
                        row[3]= rs.getObject(4);
                        row[4]= rs.getObject(5);
                        row[5]= rs.getObject(6);
                        row[6]= rs.getObject(7);
                        model.addRow(row);
                    }    
                }if(combox == 3){
                    if(String.valueOf(rs.getObject(5)).toLowerCase().contains(str)){
                        Object row[] = new Object[7];
                        row[0]= rs.getObject(1);
                        row[1]= rs.getObject(2);
                        row[2]= rs.getObject(3);
                        row[3]= rs.getObject(4);
                        row[4]= rs.getObject(5);
                        row[5]= rs.getObject(6);
                        row[6]= rs.getObject(7);
                        model.addRow(row);
                    }    
                } if(combox == 4){
                    if(String.valueOf(rs.getObject(6)).toLowerCase().contains(str)){
                        Object row[] = new Object[7];
                        row[0]= rs.getObject(1);
                        row[1]= rs.getObject(2);
                        row[2]= rs.getObject(3);
                        row[3]= rs.getObject(4);
                        row[4]= rs.getObject(5);
                        row[5]= rs.getObject(6);
                        row[6]= rs.getObject(7);
                        model.addRow(row);
                    }    
                }    
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connectproduct.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Finddata function ERROR ");
        } 
    }
    public void finddata_Import_date(){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        ConnectImport_receipt connectImport_receipt = new ConnectImport_receipt();
        connectImport_receipt.Connect();
        ResultSet rs = connectImport_receipt.getData_importdetails();
        try {
			while(rs.next()) {
				if(str.equals(rs.getObject(4))){
                    Object row[] = new Object[9];
                    row[0]= rs.getObject(1);
                    row[1]= rs.getObject(2);
                    row[2]= rs.getObject(3);
                    row[3]= rs.getObject(4);
                    row[4]= rs.getObject(5);
                    row[5]= rs.getObject(6);
                    row[6]= rs.getObject(7);
                    row[7]= rs.getObject(8);
                    row[8]= rs.getObject(9);
                    model.addRow(row);
				}
			}
			if(model.getRowCount()==0) {
				JOptionPane.showMessageDialog(null,"no action on this day");
			}
		} catch (SQLException e) {
			System.out.println("Function finddata Import ERROR");
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public void finddata_Import_name() {
		// TODO Auto-generated method stub
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        ConnectImport_receipt connectImport_receipt = new ConnectImport_receipt();
        connectImport_receipt.Connect();
        ResultSet rs = connectImport_receipt.getData_importdetails();
        try {
			while(rs.next()) {
				if(String.valueOf(rs.getObject(2)).toLowerCase().contains(str.toLowerCase())){
                    Object row[] = new Object[9];
                    row[0]= rs.getObject(1);
                    row[1]= rs.getObject(2);
                    row[2]= rs.getObject(3);
                    row[3]= rs.getObject(4);
                    row[4]= rs.getObject(5);
                    row[5]= rs.getObject(6);
                    row[6]= rs.getObject(7);
                    row[7]= rs.getObject(8);
                    row[8]= rs.getObject(9);
                    model.addRow(row);
				}
			}
			if(model.getRowCount()==0) {
				JOptionPane.showMessageDialog(null,"no action");
			}
		} catch (SQLException e) {
			System.out.println("Function finddata Import ERROR");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void finddata_Import_namedate() {
		// TODO Auto-generated method stub
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        ConnectImport_receipt connectImport_receipt = new ConnectImport_receipt();
        connectImport_receipt.Connect();
        ResultSet rs = connectImport_receipt.getData_importdetails();
        try {
			while(rs.next()) {
				if(String.valueOf(rs.getObject(2)).toLowerCase().contains(str.toLowerCase()) && String.valueOf(rs.getObject(4)).toLowerCase().contains(STR.toLowerCase())){
                    Object row[] = new Object[9];
                    row[0]= rs.getObject(1);
                    row[1]= rs.getObject(2);
                    row[2]= rs.getObject(3);
                    row[3]= rs.getObject(4);
                    row[4]= rs.getObject(5);
                    row[5]= rs.getObject(6);
                    row[6]= rs.getObject(7);
                    row[7]= rs.getObject(8);
                    row[8]= rs.getObject(9);
                    model.addRow(row);
				}
			}
			if(model.getRowCount()==0) {
				JOptionPane.showMessageDialog(null,"no action");
			}
		} catch (SQLException e) {
			System.out.println("Function finddata Import ERROR");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void finddata_Export_date() {
		// TODO Auto-generated method stub
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        Connectexport_receipt connectExport_receipt = new Connectexport_receipt();
        connectExport_receipt.Connect();
        ResultSet rs = connectExport_receipt.getData_exportdetails();
        try {
			while(rs.next()) {
				if(str.equals(rs.getObject(3))){
                    Object row[] = new Object[9];
                    row[0]= rs.getObject(1);
                    row[1]= rs.getObject(2);
                    row[2]= rs.getObject(3);
                    row[3]= rs.getObject(4);
                    row[4]= rs.getObject(5);
                    row[5]= rs.getObject(6);
                    model.addRow(row);
				}
			}
			if(model.getRowCount()==0) {
				JOptionPane.showMessageDialog(null,"no action on this day");
			}
		} catch (SQLException e) {
			System.out.println("Function finddata export ERROR");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void finddata_Export_name() {
		// TODO Auto-generated method stub
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        Connectexport_receipt connectexport_receipt = new Connectexport_receipt();
        connectexport_receipt.Connect();
        ResultSet rs = connectexport_receipt.getData_exportdetails();
        try {
			while(rs.next()) {
				if(String.valueOf(rs.getObject(2)).toLowerCase().contains(str.toLowerCase())){
                    Object row[] = new Object[6];
                    row[0]= rs.getObject(1);
                    row[1]= rs.getObject(2);
                    row[2]= rs.getObject(3);
                    row[3]= rs.getObject(4);
                    row[4]= rs.getObject(5);
                    row[5]= rs.getObject(6);

                    model.addRow(row);
				}
			}
			if(model.getRowCount()==0) {
				JOptionPane.showMessageDialog(null,"no action");
			}
		} catch (SQLException e) {
			System.out.println("Function finddata Export ERROR");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void finddata_Export_namedate() {
		// TODO Auto-generated method stub
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        Connectexport_receipt connectexport_receipt = new Connectexport_receipt();
        connectexport_receipt.Connect();
        ResultSet rs = connectexport_receipt.getData_exportdetails();
        try {
			while(rs.next()) {
				if(String.valueOf(rs.getObject(2)).toLowerCase().contains(str.toLowerCase()) && String.valueOf(rs.getObject(3)).toLowerCase().contains(STR.toLowerCase())){
                    Object row[] = new Object[9];
                    row[0]= rs.getObject(1);
                    row[1]= rs.getObject(2);
                    row[2]= rs.getObject(3);
                    row[3]= rs.getObject(4);
                    row[4]= rs.getObject(5);
                    row[5]= rs.getObject(6);
                    model.addRow(row);
				}
			}
			if(model.getRowCount()==0) {
				JOptionPane.showMessageDialog(null,"no action");
			}
		} catch (SQLException e) {
			System.out.println("Function finddata export ERROR");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
