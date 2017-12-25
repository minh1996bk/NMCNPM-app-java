package controlJson;
import java.util.ArrayList;

import javax.swing.JTable;
import connectJson.ProductJson;
import model.Product;

public class Selectidintable {
	public static int getID(JTable table) {
		ArrayList<Product> array = ProductJson.getProduct();
		CheckImformation check = new CheckImformation();
		int id = SelectId.SelectID_product(array);
		int row = table.getModel().getRowCount();
		if(row == 0) {
			return id;
		}
		else {
			id = SelectId.SelectID_product(array); 
			while(true) {
				if(check.CheckProductID_inimporttable(String.valueOf(id), table)) {
					id++;
				}else {
					return id;
				}
			}
		}	
	}

}

	