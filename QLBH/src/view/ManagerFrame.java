package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import control.CheckImformation;
import control.Export;
import control.FindData;
import control.LoadDatatoTable;
import control.RemmeberAccount;
import control.statistic;
import model.Employee;
import model.Manager;
import model.Product;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import connectsql.ConnectImport_receipt;
import connectsql.Connectaccount;
import connectsql.Connectemployee;
import connectsql.Connectproduct;

import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

public class ManagerFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField text_account;
	private JTextField input;
	private JTable table;
	private JTextField inputp;
	private JTable table_1;
	private JTable table_employee;
	private JTable table_product;
	private JTextField employee_name;
	private JTextField employee_adress;
	private JTextField employee_phone;
	private JTextField employee_salary;
	private JDateChooser employee_birth;
	private JComboBox<String> employee_male;
	private JComboBox<String> employee_position;
	private JComboBox<String> combox_employee;
	private JTextField product_name;
	private JTextField product_price;
	private JTextField product_producer;
	private JTextField textTime;
	private JDateChooser product_producedate;
	private JDateChooser product_expiredate;
	private JComboBox<String > combox_product;
	private JTextField employee_commission;
	private JTable importtable;
	private JDateChooser dateimport;
	private JTable table_statistic;
	private JComboBox<String> combox_statistic;
	private JMonthChooser monthChooser;
	private JYearChooser yearChooser;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public ManagerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 875, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JLabel lblNgiDng = new JLabel("Ng\u01B0\u1EDDi d\u00F9ng");
		
		text_account = new JTextField();
		text_account.setColumns(10);
		text_account.setText(RemmeberAccount.getUserlogin());
		
		JButton btnNewButton = new JButton("Đăng xuất");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnlogoutactionperformed(arg0);
			}
		});
		
		JButton btnNewButton_5 = new JButton("Thoát");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnexitactionperformed(e);
			}
		});
		//Load time to textfield
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
		String day = sdf.format(date);
		JLabel lblThiGian = new JLabel("Thời Gian");
		textTime = new JTextField();
		textTime.setColumns(10);
		textTime.setText(day);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNgiDng, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(text_account, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblThiGian, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textTime, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(btnNewButton_5, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(185))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 853, GroupLayout.PREFERRED_SIZE)
					.addGap(176))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNgiDng, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addComponent(text_account, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton)
							.addComponent(btnNewButton_5))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblThiGian, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addComponent(textTime, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE))
		);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("T\u00ECm ki\u1EBFm", null, panel, null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(tabbedPane_1, GroupLayout.PREFERRED_SIZE, 855, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(96, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane_1, GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
		);
		
		JPanel panel_6 = new JPanel();
		tabbedPane_1.addTab("Nh\u00E2n Vi\u00EAn", null, panel_6, null);
		tabbedPane_1.setEnabledAt(0, true);
		
		JLabel lblNewLabel = new JLabel("T\u00ECm ki\u1EBFm theo");
		
		combox_employee = new JComboBox<String>();
		combox_employee.setModel(new DefaultComboBoxModel<String>(new String[] {"ID", "T\u00EAn nh\u00E2n vi\u00EAn", "Gi\u1EDBi t\u00EDnh ", "\u0110\u1ECBa Ch\u1EC9", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i"}));
		
		input = new JTextField();
		input.setColumns(10);
		
		JButton btnFindEmployee = new JButton("T\u00ECm ki\u1EBFm");
		btnFindEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnFindemployeeActionPerformed(arg0);
			}
		});
		
		JButton btnNewButton_2 = new JButton("Xem t\u1EA5t c\u1EA3");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnShowalldatainEmployeeTableActionPerformed(arg0);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(54)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_6.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(combox_employee, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(input, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(btnFindEmployee)))
					.addContainerGap(223, Short.MAX_VALUE))
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap(70, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 713, GroupLayout.PREFERRED_SIZE)
					.addGap(67))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(69)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
							.addComponent(input, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnFindEmployee, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
							.addComponent(combox_employee, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)))
					.addGap(45)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
					.addGap(27))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "T\u00EAn nh\u00E2n vi\u00EAn", "Gi\u1EDBi t\u00EDnh", "Ng\u00E0y sinh", "\u0110\u1ECBa ch\u1EC9", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "H\u1EC7 s\u1ED1 l\u01B0\u01A1ng", "V\u1ECB tr\u00ED"
			}
		));
		scrollPane.setViewportView(table);
		panel_6.setLayout(gl_panel_6);
		
		JPanel panel_7 = new JPanel();
		tabbedPane_1.addTab("H\u00E0ng h\u00F3a", null, panel_7, null);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00ECm ki\u1EBFm theo");
		
		combox_product = new JComboBox<String>();
		combox_product.setModel(new DefaultComboBoxModel<String>(new String[] {"ID", "Tên mặt hàng", "Nơi sản xuất", "Ngày sản xuất", "Hạn sử dụng "}));

		inputp = new JTextField();
		inputp.setColumns(10);
		
		JButton btnfindproduct = new JButton("T\u00ECm ki\u1EBFm");
		btnfindproduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnfindProductActionPerformed(arg0);
			}
		});
		
		JButton btnNewButton_4 = new JButton("Xem t\u1EA5t c\u1EA3");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addGap(53)
					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 729, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_7.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(combox_product, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(inputp, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnfindproduct, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addGap(73)
					.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
						.addComponent(combox_product, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(inputp, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnfindproduct, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
					.addGap(34))
		);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "T\u00EAn m\u1EB7t h\u00E0ng", "Gi\u00E1", "N\u01A1i s\u1EA3n xu\u1EA5t", "Ng\u00E0y s\u1EA3n xu\u1EA5t", "H\u1EA1n s\u1EED d\u1EE5ng", "S\u1ED1 l\u01B0\u1EE3ng"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class<?>[] columnTypes = new Class<?>[] {
				Integer.class, String.class, Integer.class, String.class, String.class, Object.class, Integer.class
			};
			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(table_1);
		panel_7.setLayout(gl_panel_7);
		panel.setLayout(gl_panel);
		tabbedPane.setEnabledAt(0, true);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Qu\u1EA3n l\u00FD nh\u00E2n vi\u00EAn", null, panel_1, null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JLabel lblNewLabel_2 = new JLabel("T\u00EAn nh\u00E2n Vi\u00EAn ");
		
		JLabel lblGiiTnh = new JLabel("Gi\u1EDBi t\u00EDnh");
		
		JLabel lblaCh = new JLabel("\u0110\u1ECBa Ch\u1EC9");
		
		JLabel lblNgySinh = new JLabel("Ng\u00E0y sinh");
		
		employee_name = new JTextField();
		employee_name.setColumns(10);
		
		employee_adress = new JTextField();
		employee_adress.setColumns(10);
		
		JLabel lblSinThoi = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		
		JLabel lblLng = new JLabel("Hệ số lương");
		
		JLabel lblVTr = new JLabel("V\u1ECB tr\u00ED");
		
		employee_phone = new JTextField();
		employee_phone.setColumns(10);
		
		employee_salary = new JTextField();
		employee_salary.setColumns(10);
		
		employee_birth = new JDateChooser();
		
		JButton button_2 = new JButton("C\u1EADp nh\u1EADt");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BtnUpdateInAddEmployeeActionPerformed(e);
			}
		});
		
		JButton button_3 = new JButton("Th\u00EAm");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AddEmployeeActionPerform(e);
			}
		});
		
		JButton btnSa = new JButton("S\u1EEDa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnupdateemployeeActionPerformed(e);
			}
		});
		
		employee_male = new JComboBox<String>();
		employee_male.setModel(new DefaultComboBoxModel<String>(new String[] {"men", "women"}));
		
		employee_position = new JComboBox<String>();
		employee_position.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(employee_position.getSelectedItem().equals("employee")) {
					employee_commission.setEnabled(false);
				}else {
					employee_commission.setEnabled(true);
				}
			}
		});
		employee_position.setModel(new DefaultComboBoxModel<String>(new String[] {"", "employee", "manager"}));
		
		JButton CreatAccout = new JButton("Thêm tài khoản");
		CreatAccout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCreatAccoutActionPerformed(arg0);
			}
		});
		
		JLabel lblTrCp = new JLabel("Tiền cổ phần");
		
		employee_commission = new JTextField();
		employee_commission.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(lblGiiTnh, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED))
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
												.addComponent(lblaCh, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(lblNgySinh, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
											.addGap(6))))
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
										.addComponent(employee_name, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
										.addComponent(employee_adress))
									.addComponent(employee_male, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
									.addComponent(employee_birth, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblTrCp, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblVTr, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
									.addComponent(lblLng, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
									.addComponent(lblSinThoi, GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
								.addGap(18)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
									.addComponent(employee_phone, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
									.addComponent(employee_salary, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
									.addComponent(employee_position, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(employee_commission, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
								.addGap(77)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
									.addComponent(CreatAccout, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
									.addComponent(btnSa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(button_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGap(163))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 813, GroupLayout.PREFERRED_SIZE)
								.addGap(128)))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(19)
					.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(employee_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(employee_male, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblGiiTnh, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(employee_phone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSinThoi, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblLng, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addComponent(employee_salary, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(employee_adress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblaCh, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNgySinh, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblTrCp, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
												.addComponent(employee_commission, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addComponent(employee_birth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
									.addComponent(employee_position, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblVTr, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnSa, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(CreatAccout, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		
		table_employee = new JTable();
		table_employee.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "T\u00EAn nh\u00E2n vi\u00EAn", "Gi\u1EDBi t\u00EDnh", "\u0110\u1ECBa ch\u1EC9", "Ng\u00E0y sinh", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "H\u1EC7 s\u1ED1 l\u01B0\u01A1ng", "V\u1ECB tr\u00ED"
			}
		));
		scrollPane_2.setViewportView(table_employee);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Qu\u1EA3n l\u00FD h\u00E0ng h\u00F3a", null, panel_2, null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		
		JLabel lblTnMtHng = new JLabel("T\u00EAn m\u1EB7t h\u00E0ng ");
		
		product_name = new JTextField();
		product_name.setColumns(10);
		
		JLabel lblGi = new JLabel("Gi\u00E1 ");
		
		product_price = new JTextField();
		product_price.setColumns(10);
		
		JLabel lblNiSnXut = new JLabel("N\u01A1i s\u1EA3n xu\u1EA5t");
		
		product_producer = new JTextField();
		product_producer.setColumns(10);
		
		JLabel lblNgySnXut = new JLabel("Ng\u00E0y s\u1EA3n xu\u1EA5t");
		
		product_producedate = new JDateChooser();
		
		JLabel lblHnSnXut = new JLabel("H\u1EA1n s\u1EA3n xu\u1EA5t");
		
		product_expiredate = new JDateChooser();
		
		JButton btnUpdateProduct = new JButton("S\u1EEDa");
		btnUpdateProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnUpdateProductActionperformed(arg0);
			}
		});
		
		JButton btnLoadproduct = new JButton("C\u1EADp nh\u1EADt");
		btnLoadproduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnloadproductActionPerformed(arg0);
			}
		});
		
		JButton btnNhpKho = new JButton("Nhập kho");
		btnNhpKho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnImportActionPerformed(arg0);
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(64)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblTnMtHng, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGi, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNiSnXut, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(product_producer, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnUpdateProduct, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(gl_panel_2.createSequentialGroup()
											.addComponent(product_price, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblHnSnXut, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(product_expiredate, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel_2.createSequentialGroup()
											.addComponent(product_name, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblNgySnXut, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(product_producedate, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)))
									.addGap(61)
									.addComponent(btnNhpKho, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))))
						.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 706, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLoadproduct, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(193, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(59)
					.addComponent(btnLoadproduct)
					.addGap(18)
					.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNgySnXut, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(product_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTnMtHng, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(product_price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGi, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHnSnXut, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(product_producer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNiSnXut, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(product_producedate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(product_expiredate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(12)
							.addComponent(btnNhpKho, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnUpdateProduct, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(67, Short.MAX_VALUE))
		);
		
		table_product = new JTable();
		table_product.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "T\u00EAn m\u1EB7t h\u00E0ng", "Gi\u00E1", "N\u01A1i s\u1EA3n xu\u1EA5t", "Ng\u00E0y s\u1EA3n xu\u1EA5t", "H\u1EA1n s\u1EED d\u1EE5ng", "S\u1ED1 l\u01B0\u1EE3ng"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class<?>[] columnTypes = new Class<?>[] {
				Integer.class, String.class, Integer.class, String.class, String.class, String.class, Integer.class
			};
			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_3.setViewportView(table_product);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Qu\u1EA3n l\u00FD nh\u1EADp kho", null, panel_3, null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		
		JButton btnShowallimport = new JButton("Xem toàn bộ");
		btnShowallimport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnshowallimportActionperformed(arg0);
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("Nhập kho ngày");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		dateimport = new JDateChooser();
		
		JButton btnTmKim = new JButton("Tìm kiếm");
		btnTmKim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				findimportActionPerformed(arg0);
			}
		});
		
		JButton btnNewButton_8 = new JButton("In ra file");
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(90)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_3.createSequentialGroup()
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(dateimport, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addGap(31)
									.addComponent(btnTmKim, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnShowallimport, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(21)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButton_8)
								.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 803, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING, false)
							.addComponent(dateimport, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
						.addComponent(btnTmKim, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addComponent(btnShowallimport, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_8, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		importtable = new JTable();
		importtable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 h\u00F3a \u0111\u01A1n", "Ng\u01B0\u1EDDi nh\u1EADp", "Nh\u00E0 cung c\u1EA5p", "Ng\u00E0y nh\u1EADp", "M\u1EB7t h\u00E0ng", "S\u1ED1 l\u01B0\u1EE3ng ", "Gi\u00E1", "Ng\u00E0y s\u1EA3n xu\u1EA5t ", "H\u1EA1n s\u1EED d\u1EE5ng"
			}
		));
		scrollPane_4.setViewportView(importtable);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Qu\u1EA3n l\u00FD xu\u1EA5t kho", null, panel_4, null);
		
		JLabel lblNewLabel_4 = new JLabel("Xuất Kho Ngày");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		
		JButton btnNewButton_3 = new JButton("Tìm kiếm");
		
		JButton btnNewButton_6 = new JButton("Xem tất cả");
		
		JScrollPane scrollPane_5 = new JScrollPane();
		
		JButton btnNewButton_1 = new JButton("In ra file ");
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(78)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_6, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(dateChooser_1, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnNewButton_1)
							.addComponent(scrollPane_5, GroupLayout.PREFERRED_SIZE, 696, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(74, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(59)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(dateChooser_1, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(btnNewButton_6, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_5, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_4.setLayout(gl_panel_4);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Th\u1ED1ng k\u00EA", null, panel_5, null);
		
		JLabel lblNewLabel_5 = new JLabel("Thống kê theo");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		
		combox_statistic = new JComboBox<String>();
		combox_statistic.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Tổng số tiền phụ phí trong một tháng", "Tổng số tiền nhập kho trong một tháng ", "Tổng số tiền xuất kho trong một tháng", "Doanh thu trong một tháng"}));
		
		JButton btnStatistic = new JButton("Thống kê");
		btnStatistic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnStasiticActionperformed(arg0);
			}
		});
		
		JScrollPane scrollPane_6 = new JScrollPane();
		
		monthChooser = new JMonthChooser();
		
		yearChooser = new JYearChooser();
		
		JButton btnExporttoExcelFile = new JButton("Xuất file excel");
		btnExporttoExcelFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnExporttoExcelFileActionperformed(arg0);
			}
		});
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGap(182)
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_5.createSequentialGroup()
									.addComponent(combox_statistic, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnStatistic, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(yearChooser, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
									.addComponent(monthChooser, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))))
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGap(116)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnExporttoExcelFile)
								.addComponent(scrollPane_6, GroupLayout.PREFERRED_SIZE, 585, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(147, Short.MAX_VALUE))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(65)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnStatistic, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
						.addComponent(combox_statistic, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(monthChooser, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(yearChooser, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_6, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExporttoExcelFile, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		GroupLayout gl_yearChooser = new GroupLayout(yearChooser);
		gl_yearChooser.setHorizontalGroup(
			gl_yearChooser.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_yearChooser.createSequentialGroup()
					.addComponent(yearChooser.getSpinner(), GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(148, Short.MAX_VALUE))
		);
		gl_yearChooser.setVerticalGroup(
			gl_yearChooser.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_yearChooser.createSequentialGroup()
					.addComponent(yearChooser.getSpinner(), GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		yearChooser.setLayout(gl_yearChooser);
		
		table_statistic = new JTable();
		scrollPane_6.setViewportView(table_statistic);
		panel_5.setLayout(gl_panel_5);
		contentPane.setLayout(gl_contentPane);
	}
	//btn export to excel 
	protected void btnExporttoExcelFileActionperformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Export export = new Export();
		Object[] options = { "OK", "CANCEL" };
		int choose = JOptionPane.showOptionDialog(this, "Do you want to export excel file?", "Warning",
		JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
		null, options, options[0]);
		if(choose == JOptionPane.OK_OPTION){
			export.ExporttoExcel(table_statistic);
		}
	}
	//stastitic actionperformed
	protected void btnStasiticActionperformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		statistic stt = new statistic(table_statistic, monthChooser, yearChooser);
		if(combox_statistic.getSelectedIndex()==1) {
			
		}
		if(combox_statistic.getSelectedIndex()==2) {
			stt.Statistic_Import();
		}
		if(combox_statistic.getSelectedIndex()==3) {
			
		}
		if(combox_statistic.getSelectedIndex()==4) {
			
		}
	}
	//find import depend on date
	protected void findimportActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
        if(dateimport.getDate()== null){
            JOptionPane.showMessageDialog(null,"You must choose date");
        }else{
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        	String str = sdf.format(dateimport.getDate());
        	FindData find = new FindData( importtable,str);
        	find.finddata_Import();
        }
		
	}
	//show all import 
	protected void btnshowallimportActionperformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		ConnectImport_receipt connectImport_receipt = new ConnectImport_receipt();
		connectImport_receipt.Connect();
		LoadDatatoTable load = new LoadDatatoTable(importtable);
		load.Loaddatatotable_Import(connectImport_receipt.getData_importdetails());
	}
	//btnImportAction
	protected void btnImportActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Connectemployee con = new Connectemployee();
		con.Connect();
		int id = RemmeberAccount.TakeoutAccountlogin().getId();
		Manager manager = new Manager();
		manager = manager.Converttomanager(con.getData_employee(id));
		AddImportReceipt1 ir = new AddImportReceipt1(manager,this); 
		this.setEnabled(false);
		ir.setVisible(true);		
	}
	//find product
	protected void btnfindProductActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
        if(inputp.getText().equals("")){
            JOptionPane.showMessageDialog(null,"You must enter inputtext and select values of combobox");
        }else{
        	FindData find = new FindData(combox_product.getSelectedIndex(), inputp, table_1);
        	find.finddata_product();
        }
	}

	// Update and fix product
	protected void btnUpdateProductActionperformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		int row = table_product.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "You must select a row to update");
		}
		else {
			Product product = new Product(table_product ,row);
			product = product.Converttoproduct();
			Updateproduct update= new Updateproduct(product,this);
			this.setEnabled(false);
			update.setVisible(true);
		}
	}
	//Load data in producttable to Jtable
	protected void btnloadproductActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Connectproduct connectproduct = new Connectproduct();
		connectproduct.Connect();
		LoadDatatoTable load = new LoadDatatoTable(table_product);
		load.Loaddatatotable_product(connectproduct.getData_product());
	}
	// FindEmployee Button  depend on combox and input 
	protected void btnFindemployeeActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
        if(input.getText().equals("")){
            JOptionPane.showMessageDialog(null,"You must enter inputtext and select values of combobox");
        }else{
        	FindData find = new FindData(combox_employee.getSelectedIndex(), input, table);
        	find.finddata_employee();
        }
	}
	//show all data in employeetable
	protected void btnShowalldatainEmployeeTableActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Connectemployee connectemployee = new Connectemployee();
		connectemployee.Connect();
		LoadDatatoTable load = new LoadDatatoTable(table);
		load.Loaddatatotable_employee(connectemployee.getData_employee());
		
	}
	//button CreatAccount for Employee
	protected void btnCreatAccoutActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int row = table_employee.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "You must select a row to update");
		}
		else {
			Connectaccount connectacount = new Connectaccount();
			connectacount.Connect();
			int id = (int) table_employee.getModel().getValueAt(row, 0);
			if(connectacount.ChecksuvirvalofAccount(connectacount.getData_account(), id)) {
				return;
			}else {
				AddAccountforEmployee addaccount = new AddAccountforEmployee(id , this); 
				this.setEnabled(false);
				addaccount.setVisible(true);
			}	
		}
	}
	
	//button updateEmployee
	protected void btnupdateemployeeActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = table_employee.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(this, "You must select a row to update");
		}
		else {
			Employee employee = new Employee(table_employee ,row);
			employee = employee.ConverttoEmployee();
			Updateemployee update= new Updateemployee(employee,this);
			this.setEnabled(false);
			update.setVisible(true);
		}
	}
	//button exit
	protected void btnexitactionperformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
		
	}

	//Loaddata to table in personnel management
	protected void BtnUpdateInAddEmployeeActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Connectemployee connectemployee = new Connectemployee();
		connectemployee.Connect();
		LoadDatatoTable load = new LoadDatatoTable(table_employee);
		load.Loaddatatotable_employee(connectemployee.getData_employee());
		
	}

	//AddEmpoyee Button
	protected void AddEmployeeActionPerform(ActionEvent e) {
		// TODO Auto-generated method stub
		Connectemployee connectemployee = new Connectemployee();
		connectemployee.Connect();
		if(employee_name.getText().equals("")||employee_adress.getText().equals("")||employee_phone.getText().equals("")||employee_salary.getText().equals("")||employee_birth.getDate() == null||employee_position.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(this, "You must enter all information");
		}else {
			CheckImformation check = new CheckImformation();
			if(check.isNotPhoneNumber(employee_phone.getText())||check.isNotNumeric(employee_salary.getText())) {
				return;
			}
			else {
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String date = sdf.format(employee_birth.getDate());
				int id = connectemployee.SelectID(connectemployee.getData_employee());
				String male = String.valueOf(employee_male.getSelectedItem());
				String position = String.valueOf(employee_position.getSelectedItem());
				if(String.valueOf(employee_position.getSelectedItem()).equals("employee")){
					Employee employee = new Employee(id,employee_name.getText(),male,Date.valueOf(date),employee_adress.getText(),employee_phone.getText(),Integer.parseInt(employee_salary.getText()),position);
					connectemployee.insertDB_employee(employee);
				}
				if(String.valueOf(employee_position.getSelectedItem()).equals("manager")&& !check.isNotCommission(employee_commission.getText())){
					Manager manager = new Manager(id,employee_name.getText(),male,Date.valueOf(date),employee_adress.getText(),employee_phone.getText(),Integer.parseInt(employee_salary.getText()),position,Integer.parseInt(employee_commission.getText()));
					connectemployee.insertDB_employee(manager);
					connectemployee.insertDB_employeemanager(manager);
				}
			}	
		}
		
	}
	//Logout Button
	protected void btnlogoutactionperformed(ActionEvent arg0) {
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
