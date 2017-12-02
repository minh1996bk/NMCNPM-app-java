package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import connectsql.ConnectImport_receipt;

public class statistic {
	private JTable table;
	private JMonthChooser month;
	private JYearChooser year;
	public statistic(JTable table,JMonthChooser month,JYearChooser year) {
		this.table = table;
		this.month = month;
		this.year = year;
	}
	public void Statistic_Import() {
		ConnectImport_receipt con = new ConnectImport_receipt();
		con.Connect();
		ResultSet rs = con.getData_importforstsatistic();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		Object os[]={"Tên mặt hàng","Ngày nhập kho","Số lượng","Giá một sản phẩm"};
		model.setColumnCount(4);
        model.setColumnIdentifiers(os);
		try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            
			while(rs.next()){
				Object row[] = new Object[4];
				row[0] = rs.getObject(1);
				row[1] = rs.getDate(2);
				row[2] = rs.getObject(3);
				row[3] = rs.getObject(4);
				String str = sdf.format(rs.getDate(2));
				int y = Integer.parseInt(str.substring(0, 4));
				int m = Integer.parseInt(str.substring(5,7));
				if(m == (month.getMonth()+1) && y==year.getYear()) {
					model.addRow(row);
				}
			}
			if(model.getRowCount()==0) {
				JOptionPane.showMessageDialog(null,"No acion in this month");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Funtion Statistic_Import ERROR");
			e.printStackTrace();
		}
	}
}
