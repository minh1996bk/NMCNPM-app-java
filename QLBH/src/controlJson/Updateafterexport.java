package controlJson;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import connectJson.ProductJson;
import model.Product;

public class Updateafterexport {
	private ArrayList<Product> array_Product;
	public Updateafterexport(ArrayList<Product> array_Product) {
		this.array_Product = array_Product;
	}
	public void Updateall() throws IOException {
		ArrayList<Product> arrayAfterExport = new ArrayList<Product>();
		for(Product product : ProductJson.getProduct()) {
			for(Product pr : array_Product) {
				if(product.getIdNumber() == pr.getIdNumber()) {
					int total =  product.getTotal() - pr.getTotal();
					product.setTotal(total);
				}
				arrayAfterExport.add(product);
			}
		}
		ProductJson.updateProduct(arrayAfterExport);
		JOptionPane.showMessageDialog(null, "Updated Succesful");
	}
}
