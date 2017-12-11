package control;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connectsql.ConnectImport_receipt;
import model.Manager;

public class Getimportactiontotable {
	private Manager manager;
	private String date;
	
	public  Getimportactiontotable(Manager manager,String date) {
		this.manager = manager;
		this.date = date;
	}
	
	public JTable getdata() {
		ConnectImport_receipt con = new ConnectImport_receipt();
		con.Connect();
		JTable table = new JTable();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setColumnCount(7);
		Object os[] = {	"M\u00E3 m\u1EB7t h\u00E0ng", "T\u00EAn m\u1EB7t h\u00E0ng", "Gi\u00E1 m\u1EB7t h\u00E0ng","S\u1ED1 l\u01B0\u1EE3ng"};
		model.setColumnIdentifiers(os);
		ResultSet rs = con.getData_importofmanager(manager.getIdNumber(), date); 
		try {
			while(rs.next()) {
				Object row[] = new Object[4];
				row[0] = rs.getObject(1);
				row[1] = rs.getObject(2);
				row[2] = rs.getObject(3);
				row[3] = rs.getObject(4);
				model.addRow(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return table;
	}
	
	public int Sumofall() {
		ConnectImport_receipt con = new ConnectImport_receipt();
		con.Connect();
		int sum = 0;
		ResultSet rs = con.getData_importofmanager(manager.getIdNumber(), date); 
		try {
			while(rs.next()) {
				sum+= Integer.parseInt(rs.getString(3))*Integer.parseInt(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Sum ERROR");
			e.printStackTrace();
		}
		return sum;
	}
}
