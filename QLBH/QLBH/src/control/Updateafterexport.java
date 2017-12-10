package control;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import connectsql.Connectproduct;

public class Updateafterexport {
	private JTable tableexport;
	public Updateafterexport(JTable tableexport) {
		this.tableexport = tableexport;
	}
	public void Updateall() {
		Connectproduct connectP = new Connectproduct();
		connectP.Connect();
		int row = tableexport.getRowCount();
		int count = 0;
		while(count <row) {
			int id = Integer.parseInt(String.valueOf(tableexport.getModel().getValueAt(count,0)));
			int total = connectP.getTotal(id) -Integer.parseInt(String.valueOf(tableexport.getModel().getValueAt(count,3)));
			connectP.UpdateProduct(id, total);
			count++;
		}
		JOptionPane.showMessageDialog(null, "Updated Succesful");
	}
}
