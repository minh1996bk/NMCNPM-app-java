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

import controlJson.CheckImformation;
import controlJson.Export;
import controlJson.Getimportactiontotable;
import controlJson.LoadDataToTable;
import controlJson.SelectId;
import controlJson.Selectidintable;
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

import connectJson.ImportReceiptJson;
import connectJson.SupplierJson;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

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
	private JTextField product_total;
	private JTable table;
	private JButton btnAddproduct;
	private JButton btnUpdateproduct;
	private JButton btnDeleteproduct;
	private JLabel total_1;
	private JButton btnprintimport;
	private JLabel lblMtHng;
	private JLabel lblThLoi;
	private JComboBox<String> product_type;
	private ArrayList<Supplier> suppliers;
	/**
	 * Launch the application.
	 */
  private JComboBox<String> supllierCombobox;

	/**
	 * Create the frame.
	 */
	public AddImportReceipt1(Manager manager ,ManagerFrame frame) {
	  this.suppliers = SupplierJson.getSupplier();
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
		
		JLabel lblNewLabel_2 = new JLabel("T\u1ED5ng gi\u00E1 tr\u1ECB:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnImportproduct = new JButton("Nh\u1EADp kho");
		btnImportproduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btnImportproductActionPerformed(e);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
		
		lblMtHng = new JLabel("Mặt hàng");
		lblMtHng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblThLoi = new JLabel("Thể loại");
		lblThLoi.setHorizontalAlignment(SwingConstants.CENTER);
		
		product_type = new JComboBox<String>();
		product_type.setModel(new DefaultComboBoxModel<String>(new String[] {"", "mens ", "womens ", "kids", "shoes", "bags"}));
		
		
		supllierCombobox = new JComboBox<String>();
		setupSupplier(supllierCombobox);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addComponent(product_name, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(lblGiMtHng, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
													.addGap(18)
													.addComponent(product_price, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(lblSLng, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(product_type, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
															.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(btnUpdateproduct, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(btnDeleteproduct, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
															.addComponent(product_total, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)))))
											.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblMtHng, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnAddproduct)
										.addComponent(lblThLoi, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(35)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(supllierCombobox, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnImportproduct))
							.addGap(142)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 690, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnprintimport, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
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
							.addContainerGap()
							.addComponent(lblMtHng, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(product_name, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(product_price, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGiMtHng, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(product_total, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSLng, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblThLoi, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(product_type, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAddproduct)
								.addComponent(btnUpdateproduct)
								.addComponent(btnDeleteproduct))
							.addGap(18)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(supllierCombobox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(43)
							.addComponent(btnImportproduct, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 m\u1EB7t h\u00E0ng", "T\u00EAn m\u1EB7t h\u00E0ng", "Gi\u00E1 m\u1EB7t h\u00E0ng", "S\u1ED1 l\u01B0\u1EE3ng", "Th\u1EC3 lo\u1EA1i"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
	//btn printreceipt
	protected void btnprintimportActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JTable tableofemployee = new JTable();
		java.util.Date today = new java.util.Date();
		//get all import action of this manager and convert to table
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
	protected void btnImportproductActionPerformed(ActionEvent e) throws IOException {
		// TODO Auto-generated method stub
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		if(table.getModel().getRowCount()==0) {
			JOptionPane.showMessageDialog(this,"You must add product");
		}else {
			if (suppliers == null || suppliers.isEmpty()) {
			  JOptionPane.showMessageDialog(this, "You must choose producer");
			  return;
			}
			//set values for importreceipt
			ImportReceipt ir = new ImportReceipt();
			ir.setCode(SelectId.SelectID_importreceipt(ImportReceiptJson.getImportReceipt()));
			ir.setImporter(manager);
			ir.setSupplier(suppliers.get(supllierCombobox.getSelectedIndex()));
			ir.setArray(new Product().ConvertToLArraylist(table,table.getRowCount()));
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			ir.setTime(dateFormat.format(new Date()));
			
			ImportReceiptJson.insertImportReceipt(ir);
			model.setNumRows(0);
			product_name.setText("");product_price.setText("");product_total.setText("");
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
			Product product = new Product();
			product=product.Converttoproduct(table,row);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.removeRow(row);
			product_name.setText(product.getName());
			product_price.setText(String.valueOf(product.getPrice()));
			product_total.setText(String.valueOf(product.getTotal()));
			money = money-Integer.parseInt(product_price.getText())*Integer.parseInt(product_total.getText());
			total_1.setText(String.valueOf(money)+"VND");
		}
	}
	//addproduct to Jtable
	protected void btnAddproductActionperformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(product_name.getText().equals("")||product_price.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "You must enter all information");
		}else {
			CheckImformation check = new CheckImformation();

			if(check.isNotNumeric(product_price.getText())||check.isNotNumeric(product_total.getText())) {
				return;
			}else {
				Product product = new Product(Selectidintable.getID(table),product_name.getText(),Integer.parseInt(product_price.getText()),Integer.parseInt(product_total.getText()),String.valueOf(product_type.getSelectedItem()));
				if(!check.CheckProductInTable(product.getName(),String.valueOf(product.getPrice()),String.valueOf(product.getType()), table)) {
					money = money+Integer.parseInt(product_price.getText())*Integer.parseInt(product_total.getText());
					total_1.setText(String.valueOf(money)+"VND");
				}
				LoadDataToTable load = new LoadDataToTable(product, table);
				load.Loaddatatotable();
			}
		}
	}
	
	/**
	 * Set id and name of suplliers for combobox
	 * get data supplier from server by json
	 */
	public void setupSupplier(JComboBox<String> supplierCmb) {
	  ComboBoxModel<String> model;
	  if (suppliers == null || suppliers.size() == 0) {
	    String[] items= {"No producer"};
	    model = new DefaultComboBoxModel<>(items);
	  } else {
	    Vector<String> items = new Vector<>();
	    for (Supplier supplier: suppliers) {
	      items.add(supplier.getIdNumber() + "-" + supplier.getName());
	    }
	    model = new DefaultComboBoxModel<>(items);
	    
	  }
	  supplierCmb.setModel(model);
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
	 * @return the supplier
	 */
	public Supplier getSupplier() {
		return supplier;
	}

	/**
	 * @param supplier the supplier to set
	 */
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
}
