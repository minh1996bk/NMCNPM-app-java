package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import connectsql.Connectexport_receipt;
import connectsql.Connectproduct;
import connectsql.Connectreceipt_item;
import control.CheckImformation;
import control.Export;
import control.FindData;
import control.Insertbigdata;
import control.LoadDatatoTable;
import control.Updateafterexport;
import model.Employee;
import model.ExportReceipt;
import model.Product;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Desktop;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
public class EmployeeFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane1;
	private JTextField textUser;
	private JTextField textToday;
	private Employee employee;
	private JTextField product_input;
	private JTable tableallproduct;
	private JTable tableexport;
	private JButton btnaddexport;
	private JButton btndeletexport;
	private JButton btnfindproduct;
	private JButton btnexport;
	private JTextField textFrom;
	private JTextField textTo;
	private JTextField textfind;
	private JTable table;
	
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public EmployeeFrame(Employee e) {
		this.employee = e;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 1083, 692);
		contentPane1 = new JPanel();
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane1);
		
		JLabel lblNewLabel = new JLabel("Ng\u01B0\u1EDDi d\u00F9ng");
		
		textUser = new JTextField();
		textUser.setColumns(10);
		textUser.setText(e.getName());
		JLabel lblNgy = new JLabel("Ng\u00E0y");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		textToday = new JTextField();
		textToday.setColumns(10);
		textToday.setText(sdf.format(new Date()));
		
		JButton btnlogout = new JButton("\u0110\u0103ng xu\u1EA5t");
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnlogoutActionperformed(arg0);
			}
		});
		
		JButton btnexit = new JButton("Tho\u00E1t");
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnexitActionperformed(e);
			}
		});
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Xu\u1EA5t kho", null, panel_2, null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblTnMtHng = new JLabel("Tên mặt hàng");
		lblTnMtHng.setHorizontalAlignment(SwingConstants.CENTER);
		lblTnMtHng.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		product_input = new JTextField();
		product_input.setColumns(10);
		
		btnfindproduct = new JButton("Tìm kiếm");
		btnfindproduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnfindproductActionperformed(arg0);
			}
		});
		
		btnexport = new JButton("Xuất kho");
		btnexport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnexportActionPerformed(e);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_1 = new JLabel("Danh sách xuất kho");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnaddexport = new JButton("Thêm");
		btnaddexport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnaddexportactionperformed();
			}
		});
		
		btndeletexport = new JButton("Xóa");
		btndeletexport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btndeletexportActionperformed(e);
			}
		});
		
		JButton btnshowall = new JButton("Xem toàn bộ");
		btnshowall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnshowallActionPerformed(arg0);
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblTnMtHng, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(product_input, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addComponent(btnfindproduct)
							.addGap(30)
							.addComponent(btnshowall, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_panel_2.createSequentialGroup()
										.addComponent(btnaddexport, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btndeletexport, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGap(140)
									.addComponent(btnexport, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 652, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnfindproduct, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addComponent(product_input, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
							.addComponent(lblTnMtHng, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
							.addComponent(btnshowall, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
					.addGap(12)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnaddexport, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(btndeletexport, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnexport, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 533, GroupLayout.PREFERRED_SIZE)))
		);
		
		tableexport = new JTable();
		tableexport.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 h\u00E0ng", "T\u00EAn m\u1EB7t h\u00E0ng", "Gi\u00E1 ", "S\u1ED1 l\u01B0\u1EE3ng"
			}
		));
		scrollPane.setViewportView(tableexport);
		
		tableallproduct = new JTable();
		tableallproduct.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 h\u00E0ng ", "T\u00EAn m\u1EB7t h\u00E0ng", "Gi\u00E1 m\u1EB7t h\u00E0ng", "S\u1ED1 l\u01B0\u1EE3ng"
			}
		));
		scrollPane_1.setViewportView(tableallproduct);
		panel_2.setLayout(gl_panel_2);
		
		JPanel contentPane = new JPanel();
		/////
	    
		/////
		tabbedPane.addTab("Xuất kho online", null, contentPane, null);
		
		JLabel lblNewLabel_2 = new JLabel("From");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		textFrom = new JTextField();
		textFrom.setColumns(10);
		
		JLabel lblTo = new JLabel("to");
		lblTo.setHorizontalAlignment(SwingConstants.CENTER);
		
		textTo = new JTextField();
		textTo.setColumns(10);
		
		
		JComboBox<String> statusCombox = new JComboBox<String>();
		
		JButton btnUpdate = new JButton("Update");
		
		textfind = new JTextField();
		textfind.setColumns(10);
		
		JButton btnFind = new JButton("Find");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textFrom, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblTo, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textTo, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(statusCombox, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnUpdate)
							.addGap(33)
							.addComponent(textfind, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(btnFind, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(50)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 954, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(textFrom, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
							.addComponent(btnFind, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblTo, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addComponent(textTo, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addComponent(statusCombox, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addComponent(textfind, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
					.addGap(44)
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
					.addGap(70))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Time", "Total", "Customer ", "Status"
			}
		));
		scrollPane_2.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		GroupLayout gl_contentPane1 = new GroupLayout(contentPane1);
		gl_contentPane1.setHorizontalGroup(
			gl_contentPane1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane1.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(textUser, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNgy, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(textToday, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addGap(420)
					.addComponent(btnlogout)
					.addGap(6)
					.addComponent(btnexit, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(63, Short.MAX_VALUE))
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
		);
		gl_contentPane1.setVerticalGroup(
			gl_contentPane1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane1.createSequentialGroup()
					.addGroup(gl_contentPane1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(textUser, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNgy, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(textToday, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnlogout)
						.addComponent(btnexit))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE))
		);
		contentPane1.setLayout(gl_contentPane1);
		
		Connectproduct con = new Connectproduct();
		con.Connect();
		LoadDatatoTable load = new LoadDatatoTable(tableallproduct);
		load.Loaddatatotable_product(con.getData_product());
	}
	//btnexport
	protected void btnexportActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Connectexport_receipt connecter = new Connectexport_receipt();
		connecter.Connect();
		Connectreceipt_item conitem = new Connectreceipt_item();
		conitem.Connect();
		Insertbigdata insertall = new Insertbigdata(tableexport);
		if(tableexport.getRowCount() == 0) {
			JOptionPane.showMessageDialog(this, "No product in table");
		}else {
			ExportReceipt exp = new ExportReceipt();
			exp.setCode(connecter.SelectID(connecter.getData_exportreceipt()));
			exp.setEmployee(employee);
			exp.setTime(new Date());
			//insert export_product
			connecter.insertDB_exportreceipt(exp);
			//insert all item to receipt_item
			insertall.insertallreceipt_item(exp);
			//update product
			Updateafterexport updateall =  new Updateafterexport(tableexport);
			updateall.Updateall();
			//print 
			JFileChooser fcs = new JFileChooser();
			String Customer = JOptionPane.showInputDialog("Customer name: ");
			ResultSet rs = conitem.getData_receiptitem(exp.getCode());
			int price = conitem.getPrice(rs);
			if (fcs.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				String path = fcs.getSelectedFile().getAbsolutePath();
				if (Export.printforcustomer(tableexport, path, Customer, String.valueOf(price))) {
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
		//delete all in export
		((DefaultTableModel)tableexport.getModel()).setNumRows(0);
		//lupdate table product
		Connectproduct connectp = new Connectproduct();
		connectp.Connect();
		LoadDatatoTable load = new LoadDatatoTable(tableallproduct);
		load.Loaddatatotable_product(connectp.getData_product());
	}
	//btndelete in exporttable
	protected void btndeletexportActionperformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int row[] = tableexport.getSelectedRows();
		if(row.length == 0) {
			JOptionPane.showMessageDialog(this, "You must choose row in export table");
		}else {
			int count = 0;
			while(count < row.length) {
				((DefaultTableModel)tableexport.getModel()).removeRow(row[count]);
				count ++;
			}
		}
	}
	//btnaddexport
	protected void btnaddexportactionperformed() {
		// TODO Auto-generated method stub
		CheckImformation check = new CheckImformation();
		int row[] = tableallproduct.getSelectedRows();
		if(row.length == 0) {
			JOptionPane.showMessageDialog(this, "You must choose row in product table");
		}else {
			int count = 0;
			while(count< row.length) {
				Object ob[] = new Object[4];
				Product pr = new Product(tableallproduct, row[count]);
				pr =pr.Converttoproduct();
				String amount = JOptionPane.showInputDialog("Amount of" + pr.getName()+ " : " );
				if(check.isNotNumeric(amount)) {
					JOptionPane.showMessageDialog(this, amount + " is not number.Please export again");
					break;
				}
				if(Integer.parseInt(amount)> pr.getTotal()) {
					JOptionPane.showMessageDialog(this, "Storage is not enough this product.Please export again");
					break;
				}
				if(check.CheckProductID_inexporttable(String.valueOf(pr.getIdNumber()), tableexport)) {
					JOptionPane.showMessageDialog(this, "This product is exist");
					count++;
				}else {
					ob[0] = pr.getIdNumber();
					ob[1] = pr.getName();
					ob[2] = pr.getPrice();
					ob[3] = Integer.parseInt(amount);
					((DefaultTableModel)tableexport.getModel()).addRow(ob);
					count++;
				}
			}
		}
	}
	//btnshowallproduct
	protected void btnshowallActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Connectproduct con = new Connectproduct();
		con.Connect();
		LoadDatatoTable load = new LoadDatatoTable(tableallproduct);
		load.Loaddatatotable_product(con.getData_product());
	}
	//btn findproduct
	protected void btnfindproductActionperformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(product_input.getText().equals("")){
			JOptionPane.showMessageDialog(this, "You must enter name product");
		}else {
			FindData find  = new FindData(product_input,tableallproduct);
			find.finddata_nameproduct();
		}
	}
	//exitbtn
	protected void btnexitActionperformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}
	//logout button
	protected void btnlogoutActionperformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object[] options = { "OK", "CANCEL" };
		int choose = JOptionPane.showOptionDialog(this, "Do you want to logout?", "Warning",
		JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
		null, options, options[0]);
		if(choose == JOptionPane.OK_OPTION){
		login login = new login();
		login.setVisible(true);
		this.dispose();
		}
	}
}
