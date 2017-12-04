package view;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import connectsql.ConnectImport_receipt;
import connectsql.ConnectReceipt_manager_supplier;
import connectsql.Connectsupplier;
import control.CheckImformation;
import control.Export;
import control.Getimportactiontotable;
import control.Insertbigdata;
import control.LoadDatatoTable;
import control.Selectidintable;
import model.ImportReceipt;
import model.Manager;
import model.Product;
import model.Supplier;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.Desktop;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class AddImportReceipt1 extends JFrame {
	private Manager manager;
	private Supplier supplier;
	private ImportReceipt importreceipt;
	private static int money=0;
	private ManagerFrame frame;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField product_name;
	private JTextField product_price;
	private JTextField product_producer;
	private JTextField product_total;
	private JDateChooser product_expiredate;
	private JDateChooser product_producedate;
	private JTextField supplier_name;
	private JTextField supplier_address;
	private JTextField supplier_mail;
	private JTextField supplier_phone;
	private JTable table;
	private JButton btnAddproduct;
	private JButton btnUpdateproduct;
	private JButton btnDeleteproduct;
	private JLabel total_1;
	private JButton btnprintimport;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AddImportReceipt1(Manager manager ,ManagerFrame frame) {
		this.manager = manager;
		this.frame = frame;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 1005, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("T\u00EAn m\u1EB7t h\u00E0ng");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblGiMtHng = new JLabel("Gi\u00E1 m\u1EB7t h\u00E0ng");
		lblGiMtHng.setHorizontalAlignment(SwingConstants.CENTER);
		
		product_name = new JTextField();
		product_name.setColumns(10);
		
		product_price = new JTextField();
		product_price.setColumns(10);
		
		JLabel lblNiSnXut = new JLabel("N\u01A1i s\u1EA3n xu\u1EA5t");
		lblNiSnXut.setHorizontalAlignment(SwingConstants.CENTER);
		
		product_producer = new JTextField();
		product_producer.setColumns(10);
		
		JLabel lblNgySnXut = new JLabel("Ng\u00E0y s\u1EA3n xu\u1EA5t");
		lblNgySnXut.setHorizontalAlignment(SwingConstants.CENTER);
		
		product_producedate = new JDateChooser();
		
		JLabel lblHnSDng = new JLabel("H\u1EA1n s\u1EED d\u1EE5ng");
		lblHnSDng.setHorizontalAlignment(SwingConstants.CENTER);
		
		product_expiredate = new JDateChooser();
		
		JLabel lblSLng = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
		lblSLng.setHorizontalAlignment(SwingConstants.CENTER);
		
		product_total = new JTextField();
		product_total.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nh\u00E0 cung \u1EE9ng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnAddproduct = new JButton("Th\u00EAm");
		btnAddproduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAddproductActionperformed(arg0);
			}
		});
		
		btnUpdateproduct = new JButton("S\u1EEDa");
		btnUpdateproduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateproductActionperformed(e);
			}
		});
	
		btnDeleteproduct = new JButton("X\u00F3a");
		btnDeleteproduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteproductActionperformed(e);
			}
		});
		
		JLabel lblTn = new JLabel("T\u00EAn");
		lblTn.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblaCh = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblaCh.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblGmail = new JLabel("Gmail");
		lblGmail.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblSinThoi = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lblSinThoi.setHorizontalAlignment(SwingConstants.CENTER);
		
		supplier_name = new JTextField();
		supplier_name.setColumns(10);
		
		supplier_address = new JTextField();
		supplier_address.setColumns(10);
		
		supplier_mail = new JTextField();
		supplier_mail.setColumns(10);
		
		supplier_phone = new JTextField();
		supplier_phone.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("T\u1ED5ng gi\u00E1 tr\u1ECB:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnImportproduct = new JButton("Nh\u1EADp kho");
		btnImportproduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnImportproductActionPerformed(e);
			}
		});
		
		JButton btnExit = new JButton("Tho\u00E1t");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExitActionperformed(e);
			}
		});
		
		total_1 = new JLabel("");
		
		btnprintimport = new JButton("In hóa đơn");
		btnprintimport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnprintimportActionPerformed(arg0);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblGiMtHng, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(product_name, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
								.addComponent(product_price, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNiSnXut, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(product_producer, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNgySnXut, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(product_producedate, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblHnSDng, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(product_expiredate, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnAddproduct)
								.addComponent(lblSLng, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addComponent(btnUpdateproduct, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnDeleteproduct, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
								.addComponent(product_total, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTn, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(supplier_name, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblaCh, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(supplier_address, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblGmail, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(supplier_mail, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblSinThoi, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnImportproduct)
								.addComponent(supplier_phone, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 690, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(26)
									.addComponent(btnprintimport, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(total_1, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 501, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(total_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnprintimport, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(product_name)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblGiMtHng, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(product_price, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNiSnXut, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(product_producer, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(product_producedate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNgySnXut, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblHnSDng, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(product_expiredate, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSLng, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(product_total, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addGap(13)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAddproduct)
								.addComponent(btnUpdateproduct)
								.addComponent(btnDeleteproduct))
							.addGap(18)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTn, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(supplier_name, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblaCh, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(supplier_address, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblGmail, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(supplier_mail, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSinThoi, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(supplier_phone, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(btnImportproduct, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 m\u1EB7t h\u00E0ng", "T\u00EAn m\u1EB7t h\u00E0ng", "Gi\u00E1 m\u1EB7t h\u00E0ng", "N\u01A1i s\u1EA3n xu\u1EA5t", "Ng\u00E0y s\u1EA3n xu\u1EA5t", "H\u1EA1n s\u1EED d\u1EE5ng", "S\u1ED1 l\u01B0\u1EE3ng"
			}
		));
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
	
	protected void btnprintimportActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JTable tableofemployee = new JTable();
		java.util.Date today = new java.util.Date();
		//get all import action of this manager and conver to table
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(today);
		Getimportactiontotable importaction = new Getimportactiontotable(manager, date);
		tableofemployee = importaction.getdata();
		String sum = String.valueOf(importaction.Sumofall());
		if (tableofemployee.getRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "No importing of you on today", "Notification", JOptionPane.WARNING_MESSAGE );
			return;
		}
		String name = "Các sản phẩm nhập kho và tổng giá trị";
		JFileChooser fcs = new JFileChooser();
		if (fcs.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			String path = fcs.getSelectedFile().getAbsolutePath();
			if (Export.printreport(tableofemployee, path, name, manager.getName(),sum )) {
				JOptionPane.showMessageDialog(null, "Successful !");
				try {
					Desktop.getDesktop().open(new File(path + ".pdf"));
				} catch (IOException ex) {
					Logger.getLogger(AddImportReceipt1.class.getName()).log(Level.SEVERE, null, ex);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Print ERROR !");
			}
		}
	}

	//btn import
	protected void btnImportproductActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		CheckImformation check = new CheckImformation();
		Connectsupplier connectsupplier = new Connectsupplier();
		connectsupplier.Connect();
		ConnectImport_receipt connectimport = new ConnectImport_receipt();
		connectimport.Connect();
		ConnectReceipt_manager_supplier crmp = new ConnectReceipt_manager_supplier();
		crmp.Connect();
		if(supplier_name.getText().equals("")|| supplier_mail.getText().equals("") || supplier_address.getText().equals("")||supplier_phone.getText().equals("")){
			JOptionPane.showMessageDialog(this, "Please enter all imformation of supplier");
		}

		else {
			if(check.isNotPhoneNumber(supplier_phone.getText())) {
				return;
			}
			else {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				Insertbigdata insertall = new Insertbigdata(table);
				supplier = new model.Supplier(connectsupplier.SelectID(connectsupplier.getData_supplier()),supplier_name.getText(),supplier_address.getText(),supplier_mail.getText(),supplier_phone.getText());
				//set values for importreceipt
				ImportReceipt ir = new ImportReceipt();
				ir.setCode(connectimport.SelectID(connectimport.getData_importReceipt()));
				ir.setImporter(manager);
				ir.setSupplier(supplier);
				ir.setArray(new Product(table,table.getRowCount()).ConvertToLArraylist());
				//insert to product
				insertall.insertProducts();
				//insert to supplier
				connectsupplier.insertDB_Supplier(supplier);
				//insert to receipt_manager_supplier
				crmp.insertDB_Receipt_manager_supplier(ir);
				//insert to import_receipt 
				insertall.insertImportReceipt(ir);
				model.setNumRows(0);
				product_name.setText("");product_price.setText("");product_expiredate.setDate(null);product_producedate.setDate(null);;product_producedate.setToolTipText("");product_producer.setText("");product_total.setText("");
			}	
		}
	}
	protected void btnExitActionperformed(ActionEvent e) {
		// TODO Auto-generated method stub
		frame.setEnabled(true);
		this.dispose();
	}
	//remove row in table
	protected void btnDeleteproductActionperformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "You must select a row to remove");
		}else {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.removeRow(row);
			money = money-Integer.parseInt(product_price.getText())*Integer.parseInt(product_total.getText());
			total_1.setText(String.valueOf(money)+"VND");
		}
	}

	//updateproduct in table
	protected void btnUpdateproductActionperformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "You must select a row to update");
		}
		else {
			Product product = new Product(table,row);
			product=product.Converttoproduct();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.removeRow(row);
			product_name.setText(product.getName());
			product_price.setText(String.valueOf(product.getPrice()));
			product_producer.setText(product.getProducer());
			product_producedate.setDate(product.getProduceTime());
			product_expiredate.setDate(product.getExpireTime());
			product_total.setText(String.valueOf(product.getTotal()));
			money = money-Integer.parseInt(product_price.getText())*Integer.parseInt(product_total.getText());
			total_1.setText(String.valueOf(money)+"VND");
		}
	}
	//addproduct to Jtable
	protected void btnAddproductActionperformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(product_name.getText().equals("")||product_price.getText().equals("")||product_producer.getText().equals("")||product_expiredate.getDate()==null||product_producedate.getDate()==null) {
			JOptionPane.showMessageDialog(this, "You must enter all information");
		}else {
			CheckImformation check = new CheckImformation();

			if(check.isNotNumeric(product_price.getText())||check.isNotNumeric(product_total.getText())) {
				return;
			}else {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String date1 = sdf.format(product_producedate.getDate());
				String date2 = sdf.format(product_expiredate.getDate());
				Product product = new Product(Selectidintable.getID(table),product_name.getText(),Integer.parseInt(product_price.getText()),product_producer.getText(),Date.valueOf(date1),Date.valueOf(date2),Integer.parseInt(product_total.getText()));
				if(!check.CheckProductInTable(product.getName(),String.valueOf(product.getPrice()), String.valueOf(product.getProduceTime()), table)) {
					money = money+Integer.parseInt(product_price.getText())*Integer.parseInt(product_total.getText());
					total_1.setText(String.valueOf(money)+"VND");
				}
				LoadDatatoTable load = new LoadDatatoTable(product,table);
				load.Loaddatatotable();
			}
		}
	}

	/**
	 * @return the importreceipt
	 */
	public ImportReceipt getImportreceipt() {
		return importreceipt;
	}

	/**
	 * @param importreceipt the importreceipt to set
	 */
	public void setImportreceipt(ImportReceipt importreceipt) {
		this.importreceipt = importreceipt;
	}
}
