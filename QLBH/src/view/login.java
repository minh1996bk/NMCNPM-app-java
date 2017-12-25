package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import connectJson.AccountJson;
import connectJson.OrderJson;
import controlJson.AccountControl;
import controlJson.CheckImformation;
import model.Account;
import model.Employee;
import model.Order;
import model.Userlogin;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Stack;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField text_account;
	private JPasswordField text_pass;
	private JCheckBox checksave;
	
	public static Stack<String> save_textaccount = new Stack<String>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(this);
		setTitle("login");
		setLocationRelativeTo(this);
		setBounds(100, 100, 546, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("T\u00E0i Kho\u1EA3n ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		text_account = new JTextField();
		text_account.setColumns(10);
		if(!save_textaccount.empty()) {
			text_account.setText(save_textaccount.pop().toString());
		}
		
		text_pass = new JPasswordField();
		JButton btnlogin = new JButton("\u0110\u0103ng Nh\u1EADp");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					btnloginActionperformed(arg0);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		checksave = new JCheckBox("Lưu tài khoản");
		checksave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				checksaveMouseclicked(arg0);
			}
		});
		
		JLabel lblMtKhu = new JLabel("M\u1EADt Kh\u1EA9u");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(76)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMtKhu, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(checksave, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
							.addComponent(btnlogin))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(text_account)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(text_pass, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 2, Short.MAX_VALUE)))))
					.addGap(131))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(143, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(text_account)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMtKhu, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
						.addComponent(text_pass, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnlogin, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(checksave))
					.addGap(67))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void checksaveMouseclicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(checksave.isSelected()) {
			save_textaccount.add(text_account.getText());
		}
	}

	public void btnloginActionperformed(ActionEvent arg0) throws SQLException {
	CheckImformation check = new CheckImformation();
    if(text_account.getText().equals("") || String.valueOf(text_pass.getPassword()).equals("")){
        JOptionPane.showMessageDialog(rootPane, "You must enter account and password");
    }else { 
    		if(check.Checkaccount(AccountJson.getAccount(),text_account, text_pass)){
	    		//get data and save to 
	    		Userlogin userlogin = new Userlogin();
	            Date day = new Date();
	            SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
	            String date = sdf.format(day);
	            //Take account with account and pass
	            Account account = AccountControl.GetAccount(text_account.getText(), String.valueOf(text_pass.getPassword()));
	            //set an save to user login
	            userlogin.setId(account.getId());
	            userlogin.setAccount(account.getTaiKhoan());
	            userlogin.setTime(date);
	            /*
	             * t can ham insert vao user login 1 đối tượng (không phải array) thay cho ham insert bên dưới
	             */
	            //ConnectMySQL.insertDB_account(userlogin);
	            
	            //Check position to login Frame
            	Employee employee = AccountJson.login(account);
            	if(employee == null){
            	JOptionPane.showMessageDialog(rootPane, "This Account is not exist");
            	} else if (employee.getPosition().equals("manager")) {
	            	ManagerFrame main = new ManagerFrame(employee);
	            	main.setVisible(true);
	            	this.dispose();
            	} else {
	            	ArrayList<Order> orders = OrderJson.getOrder();
	            	EmployeeFrame main = new EmployeeFrame(employee, orders);
	            	main.setVisible(true);
	            	this.dispose();
            	}
        	}else {
        		JOptionPane.showMessageDialog(rootPane, "This Account is not exist");
        	}
        }	
	}
	
	
}
