package controlJson;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import connectJson.ImportReceiptJson;
import model.ImportReceipt;
import model.Manager;
import model.Product;

public class Getimportactiontotable {
	private Manager manager;
	private String date;
	
	public  Getimportactiontotable(Manager manager,String date) {
		this.manager = manager;
		this.date = date;
	}
	
	public JTable getdata() {
		JTable table = new JTable();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setColumnCount(7);
		Object os[] = {	"M\u00E3 m\u1EB7t h\u00E0ng", "T\u00EAn m\u1EB7t h\u00E0ng", "Gi\u00E1 m\u1EB7t h\u00E0ng","S\u1ED1 l\u01B0\u1EE3ng"};
		model.setColumnIdentifiers(os);
		for(ImportReceipt importReceipt: ImportReceiptJson.getImportReceipt()) {
			if(importReceipt.getImporter().getIdNumber()== manager.getIdNumber() && importReceipt.getTime().equals(date)){
				for(Product product: importReceipt.getArray()) {
					Object row[] = new Object[4];
					row[0] = product.getIdNumber();
					row[1] = product.getName();
					row[2] = product.getPrice();
					row[3] = product.getTotal();
					model.addRow(row);
				}
			}
		}
		return table;
	}
	
	public int Sumofall() {
		int sum = 0;
		for(ImportReceipt importReceipt: ImportReceiptJson.getImportReceipt()) {
			if(importReceipt.getImporter().getIdNumber()== manager.getIdNumber() && importReceipt.getTime().equals(date)){
				for(Product product: importReceipt.getArray()) {
					sum+=product.getPrice()*product.getTotal();
				}
			}
		}
		return sum;
	}
}
