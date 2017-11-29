package view;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import connectsql.ConnectImport_receipt;
import connectsql.ConnectReceipt_manager_supplier;
import connectsql.Connectsupplier;
import control.CheckImformation;
import control.Insertbigdata;
import control.LoadDatatoTable;
import control.Selectidintable;
import model.ImportReceipt;
import model.Manager;
import model.Product;
import model.Supplier;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class AddImportReceipt extends JFrame {
	private Manager manager;
	private Supplier supplier;
	private ImportReceipt importreceipt;
	private static int money;
	private ManagerFrame frame;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField product_name;
	private JTextField product_price;
	private JLabel lblNiSnXut;
	private JTextField product_producer;
	private JLabel lblNgySnXut;
	private JLabel lblHnSDng;
	private JTextField product_total;
	private JTextField supplier_name;
	private JLabel lblaCh;
	private JTextField supplier_address;
	private JLabel lblMail;
	private JTextField supplier_mail;
	private JLabel lblSinThoi;
	private JTextField supplier_phone;
	private JButton btnAddProduct;
	private JButton btnUpdateproduct;
	private JLabel lblNewLabel_2;
	private JLabel label;
	private JButton btn_importproduct;
	private JDateChooser product_producedate;
	private JDateChooser product_expiredate;
	private JButton btnXa;
	private JLabel total;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public AddImportReceipt(Manager manager ,ManagerFrame frame) {
		this.setManager(manager);
		this.setFrame(frame);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 1053, 655);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("T\u00EAn m\u1EB7t h\u00E0ng");
		
		product_name = new JTextField();
		product_name.setColumns(10);
		
		JLabel lblGi = new JLabel("Gi\u00E1 m\u1EB7t h\u00E0ng");
		
		product_price = new JTextField();
		product_price.setColumns(10);
		
		lblNiSnXut = new JLabel("N\u01A1i s\u1EA3n xu\u1EA5t");
		
		product_producer = new JTextField();
		product_producer.setColumns(10);
		
		lblNgySnXut = new JLabel("Ng\u00E0y s\u1EA3n xu\u1EA5t");
		
		product_producedate = new JDateChooser();
		
		lblHnSDng = new JLabel("H\u1EA1n s\u1EED d\u1EE5ng");
		
		product_expiredate = new JDateChooser();
		
		JLabel lblSLng = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
		
		product_total = new JTextField();
		product_total.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("M\u1EB7t h\u00E0ng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNhCungCp = new JLabel("Nh\u00E0 cung c\u1EA5p");
		lblNhCungCp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblTnNhCung = new JLabel("T\u00EAn");
		
		supplier_name = new JTextField();
		supplier_name.setColumns(10);
		
		lblaCh = new JLabel("\u0110\u1ECBa ch\u1EC9");
		
		supplier_address = new JTextField();
		supplier_address.setColumns(10);
		
		lblMail = new JLabel("Mail");
		
		supplier_mail = new JTextField();
		supplier_mail.setColumns(10);
		
		lblSinThoi = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		
		supplier_phone = new JTextField();
		supplier_phone.setColumns(10);
		
		btnAddProduct = new JButton("Th\u00EAm");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAddproducttoytableActionperformed(arg0);
			}
		});
		
		btnUpdateproduct = new JButton("S\u1EEDa");
		btnUpdateproduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateProductActionPerformed(arg0);
			}
		});
		
		lblNewLabel_2 = new JLabel("T\u1ED5ng gi\u00E1 tr\u1ECB :");
		
		label = new JLabel("");
		
		btn_importproduct = new JButton("Nh\u1EADp kho");
		btn_importproduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_importproductActionPerformed(e);
			}
		});
		
		btnXa = new JButton("x\u00F3a");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RemoverowintableActionperformed(arg0);
			}
		});
		
		total = new JLabel("");
		
		JButton btnInHan = new JButton("In h\u00F3a \u0111\u01A1n");
		
		JButton btnThot = new JButton("Tho\u00E1t");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnexitactionPerformed(arg0);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNhCungCp, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_1)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
													.addComponent(lblGi, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
													.addComponent(lblNiSnXut, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
													.addComponent(lblNgySnXut, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
													.addComponent(lblHnSDng, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
													.addComponent(lblSLng, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
												.addGap(20))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGap(17)
												.addComponent(btnAddProduct, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.RELATED)))
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(product_total, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
											.addComponent(product_expiredate, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
											.addComponent(product_producedate, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
											.addComponent(product_producer, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
											.addComponent(product_name, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
											.addComponent(product_price, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGap(11)
												.addComponent(btnUpdateproduct, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
												.addGap(18)
												.addComponent(btnXa, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))))
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
											.addComponent(lblSinThoi, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblMail, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblaCh, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblTnNhCung, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
										.addGap(18)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(supplier_phone, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
											.addComponent(supplier_name, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
											.addComponent(supplier_address, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
											.addComponent(supplier_mail, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))))
								.addGap(26)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 722, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(92)
										.addComponent(label, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(26)
										.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
										.addGap(10)
										.addComponent(total, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap()))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btn_importproduct, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnInHan, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnThot, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addGap(23))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 487, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(product_name, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblGi, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(product_price, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNiSnXut, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(product_producer, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(product_producedate, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNgySnXut))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(product_expiredate, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHnSDng, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(product_total, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSLng, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnXa)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnAddProduct)
									.addComponent(btnUpdateproduct)))
							.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
							.addComponent(lblNhCungCp, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTnNhCung, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(supplier_name, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblaCh, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(supplier_address, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMail, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(supplier_mail, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSinThoi, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(supplier_phone, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
						.addComponent(total, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInHan, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnThot, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_importproduct, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 H\u00E0ng", "T\u00EAn m\u1EB7t h\u00E0ng", "Gi\u00E1", "N\u01A1i s\u1EA3n xu\u1EA5t", "Ng\u00E0y s\u1EA3n xu\u1EA5t", "H\u1EA1n s\u1EED d\u1EE5ng", "S\u1ED1 l\u01B0\u1EE3ng"
			}
		));
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
	//exit button
	protected void btnexitactionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		frame.setEnabled(true);
		this.dispose();
	}
	//btn import
	protected void btn_importproductActionPerformed(ActionEvent e) {
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
			//insert to product
			else {
				Insertbigdata insertall = new Insertbigdata(table);
				insertall.insertProducts();
				//insert to supplier
				supplier = new model.Supplier(connectsupplier.SelectID(connectsupplier.getData_supplier()),supplier_name.getText(),supplier_address.getText(),supplier_mail.getText(),supplier_phone.getText());
				connectsupplier.insertDB_Supplier(supplier);
				//set values for importreceipt
				ImportReceipt ir = new ImportReceipt();
				ir.setCode(connectimport.SelectID(connectimport.getData_importReceipt()));
				ir.setImporter(manager);
				ir.setSupplier(supplier);
				ir.setArray(new Product(table,table.getRowCount()).ConvertToLArraylist());
				//insert to receipt_manager_supplier
				crmp.insertDB_Receipt_manager_supplier(ir);
				//insert to import_receipt 
				insertall.insertImportReceipt(ir);
			}	
		}
	}
	//remove row in table
	protected void RemoverowintableActionperformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "You must select a row to remove");
		}else {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.removeRow(row);
			money = money-Integer.parseInt(product_price.getText())*Integer.parseInt(product_total.getText());
			total.setText(String.valueOf(money)+"VND");
		}
	}
	//updateproduct in table
	protected void UpdateProductActionPerformed(ActionEvent arg0) {
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
			total.setText(String.valueOf(money)+"VND");
		}
	}

	//addproduct to Jtable
	protected void btnAddproducttoytableActionperformed(ActionEvent arg0) {
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
					total.setText(String.valueOf(money)+"VND");
				}
				LoadDatatoTable load = new LoadDatatoTable(product,table);
				load.Loaddatatotable();
			}
		}
	}
	
	/**
	 * @return the manager
	 */
	public Manager getManager() {
		return manager;
	}
	/**
	 * @param manager the manager to set
	 */
	public void setManager(Manager manager) {
		this.manager = manager;
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
	/**
	 * @return the frame
	 */
	public ManagerFrame getFrame() {
		return frame;
	}
	/**
	 * @param frame the frame to set
	 */
	public void setFrame(ManagerFrame frame) {
		this.frame = frame;
	}
}
