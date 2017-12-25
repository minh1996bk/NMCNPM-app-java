package controlJson;

import java.util.ArrayList;
import model.Employee;
import model.ExportReceipt;
import model.ImportReceipt;
import model.Product;
import model.Supplier;

public class SelectId {
	public static int SelectID_employee(ArrayList<Employee> employees) {
		int count=1;
		for(Employee employee : employees){
			if(count == employee.getIdNumber()) {
				count++;
			}
		}
		return count;
	}
	public static int SelectID_product(ArrayList<Product> products) {
		int count=1;
		for(Product product : products){
			if(count == product.getIdNumber()) {
				count++;
			}
		}
		return count;
	}
	public static int SelectID_importreceipt(ArrayList<ImportReceipt> importReceipts) {
		int count=1;
		for(ImportReceipt importReceipt: importReceipts){
			if(count == importReceipt.getCode()) {
				count++;
			}
		}
		return count;
	}
	public static int SelectID_exportreceipt(ArrayList<ExportReceipt> exportReceipts) {
		int count=1;
		for(ExportReceipt exportReceipt: exportReceipts){
			if(count == exportReceipt.getCode()) {
				count++;
			}
		}
		return count;
	}
	public static int SelectID_supplier(ArrayList<Supplier> suppliers) {
		int count=1;
		for(Supplier supplier: suppliers ){
			if(count == supplier.getIdNumber()) {
				count++;
			}
		}
		return count;
	}
}
