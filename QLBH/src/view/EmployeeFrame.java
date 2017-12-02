package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connectsql.Connectproduct;
import control.FindData;
import control.LoadDatatoTable;
import control.RemmeberAccount;
import model.Employee;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class EmployeeFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUser;
	private JTextField textToday;
	private JTextField input_product;
	private JTable tableproduct;
	private JComboBox<String> comboproduct;
	private Employee employee;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public EmployeeFrame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 1021, 658);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Ng\u01B0\u1EDDi d\u00F9ng");
		
		textUser = new JTextField();
		textUser.setColumns(10);
		textUser.setText(RemmeberAccount.getUserlogin());
		
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
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("T\u00ECm ki\u1EBFm h\u00E0ng h\u00F3a", null, panel, null);
		
		JLabel label = new JLabel("Tìm kiếm theo");
		
		comboproduct = new JComboBox<String>();
		comboproduct.setModel(new DefaultComboBoxModel<String>(new String[] {"ID", "Tên mặt hàng", "Nơi sản xuất", "Ngày sản xuất", "Hạn sử dụng "}));
		
		input_product = new JTextField();
		input_product.setColumns(10);
		
		JButton findproduct = new JButton("Tìm kiếm");
		findproduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finddataActionPerformed(e);
			}
		});
		
		JButton showallproduct = new JButton("Xem tất cả");
		showallproduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowallproductActionPerformed(e);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(176)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboproduct, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(input_product, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(findproduct, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(104)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(showallproduct, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 790, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(96, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(75)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(comboproduct, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(findproduct, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(input_product, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)))
					.addGap(40)
					.addComponent(showallproduct, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(64, Short.MAX_VALUE))
		);
		
		tableproduct = new JTable();
		tableproduct.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 h\u00E0ng h\u00F3a", "T\u00EAn m\u1EB7t h\u00E0ng", "Gi\u00E1 m\u1EB7t h\u00E0ng", "N\u01A1i s\u1EA3n xu\u1EA5t", "Ng\u00E0y s\u1EA3n xu\u1EA5t", "H\u1EA1n S\u1EED d\u1EE5ng", "S\u1ED1 l\u01B0\u1EE3ng"
			}
		));
		scrollPane.setViewportView(tableproduct);
		panel.setLayout(gl_panel);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Xu\u1EA5t kho", null, panel_2, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Xuất kho online", null, panel_1, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("B\u00E1o c\u00E1o", null, panel_3, null);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
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
					.addComponent(btnexit, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
				.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 995, GroupLayout.PREFERRED_SIZE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(textUser, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNgy, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(textToday, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnlogout)
						.addComponent(btnexit))
					.addGap(6)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 580, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	protected void finddataActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
        if(input_product.getText().equals("")){
            JOptionPane.showMessageDialog(null,"You must enter inputtext and select values of combobox");
        }else{
        	FindData find = new FindData(comboproduct.getSelectedIndex(), input_product, tableproduct);
        	find.finddata_product();
        }
		
	}
	//show all product Btn
	protected void ShowallproductActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Connectproduct connectproduct = new Connectproduct();
		connectproduct.Connect();
		LoadDatatoTable load = new LoadDatatoTable(tableproduct);
		load.Loaddatatotable_product(connectproduct.getData_product());
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
