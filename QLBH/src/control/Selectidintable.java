package control;
import javax.swing.JTable;

import connectsql.Connectproduct;

public class Selectidintable {
	public static int getID(JTable table) {
		Connectproduct con = new Connectproduct();
		con.Connect();
		CheckImformation check = new CheckImformation();
		int id = con.SelectID(con.getData_product());
		int row = table.getModel().getRowCount();
		if(row == 0) {
			id = con.SelectID(con.getData_product());
		}
		else {
			id =con.SelectID(con.getData_product()); 
			while(true) {
				if(check.CheckProductID_inimporttable(String.valueOf(id), table)) {
					id++;
				}else {
					return id;
				}
			}
		}	
		return id;
	}

}

	