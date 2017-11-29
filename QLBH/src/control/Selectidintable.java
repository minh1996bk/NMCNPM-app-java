package control;
import javax.swing.JTable;

import connectsql.Connectproduct;

public class Selectidintable {
	public static int getID(JTable table) {
		Connectproduct con = new Connectproduct();
		con.Connect();
		int id = con.SelectID(con.getData_product());
		int count = 0;
		int row = table.getModel().getRowCount();
		id = con.SelectID(con.getData_product());
		while(count <row) {
			if(id == Integer.parseInt(String.valueOf(table.getModel().getValueAt(count, 0)))) {
				id++;
			}
			count ++;
		}	
		return id;
	}
}
