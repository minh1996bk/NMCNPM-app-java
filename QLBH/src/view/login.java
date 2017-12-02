package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connectsql.Connectaccount;
import control.RemmeberAccount;
import model.Account;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField text_account;
	private JPasswordField text_pass;
	private JCheckBox checksave;

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
		
		Account account = RemmeberAccount.TakeAccountsave();
		text_account = new JTextField();
		text_account.setColumns(10);
		text_account.setText(account.getTaiKhoan());
		
		text_pass = new JPasswordField();
		text_pass.setText(account.getMatKhau());
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
		
		checksave = new JCheckBox("L\u01B0u m\u1EADt kh\u1EA9u");
		
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(checksave)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnlogin))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(text_pass, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
								.addComponent(text_account))))
					.addGap(131))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(141, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(text_account)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMtKhu, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
						.addComponent(text_pass, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(checksave)
						.addComponent(btnlogin, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(67))
		);
		contentPane.setLayout(gl_contentPane);
	}

	public void btnloginActionperformed(ActionEvent arg0) throws SQLException {
		Connectaccount ConnectMySQL = new Connectaccount();
        ConnectMySQL.Connect();
        if(text_account.getText().equals("") || String.valueOf(text_pass.getPassword()).equals("")){
            JOptionPane.showMessageDialog(rootPane, "Bạn phải đăng nhập thông tin");
        }else { 
        	if(ConnectMySQL.Checkaccount(ConnectMySQL.getData_account(),text_account, text_pass)){
        		//get data and save to 
        		Userlogin userlogin = new Userlogin();
                Date day = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
                String date = sdf.format(day);
                ResultSet rs = ConnectMySQL.getData_account(text_account.getText(), String.valueOf(text_pass.getPassword()));
                while(rs.next()) {
                	userlogin.setId(rs.getInt(1));
                	userlogin.setAccount(rs.getString(2));
                }
                userlogin.setTime(date);
                ConnectMySQL.insertDB_account(userlogin);
                //Checksave Button is selected
                if(checksave.isSelected()){
                	Account admin = new Account();
                	admin.setId(userlogin.getId());
                	admin.setTaiKhoan(text_account.getText());
                	admin.setMatKhau(String.valueOf(text_pass.getPassword()));
                	RemmeberAccount.SaveAccount(admin);
                }
                //Check position to login Frame
                if(ConnectMySQL.CheckManager(ConnectMySQL.getdata_EmployeeAccount(text_account.getText(), String.valueOf(text_pass.getPassword())))) {
                	ManagerFrame mainm = new ManagerFrame();
                	mainm.setVisible(true);
                	this.dispose();
                }else {
                	EmployeeFrame maine = new EmployeeFrame();
                	maine.setVisible(true);
                	this.dispose();
                }
        	}else {
        		JOptionPane.showMessageDialog(rootPane, "Tài khoản không tồn tại");
        	}
        }	
	}
	
	
}
