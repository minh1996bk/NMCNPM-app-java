package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import connectJson.AccountJson;
import controlJson.CheckImformation;
import model.Account;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;


public class AddAccountforEmployee extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textAccount;
	private JTextField textPass;
	private int id;
	private ManagerFrame frame;
	private JButton btnThot;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public AddAccountforEmployee(int id ,ManagerFrame frame) {
		this.setId(id) ;
		this.setFrame(frame);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 466, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("T\u00E0i kho\u1EA3n");
		
		textAccount = new JTextField();
		textAccount.setColumns(10);
		
		JLabel lblMtKhu = new JLabel("M\u1EADt Kh\u1EA9u");
		
		textPass = new JTextField();
		textPass.setColumns(10);
		
		JButton btnSaveAccount = new JButton("L\u01B0u");
		btnSaveAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSaveAccountactionPerformed(arg0);
			}
		});
		
		btnThot = new JButton("Thoát");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnThotActionperformed(arg0);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(62)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textAccount, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblMtKhu, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnSaveAccount, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnThot, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
								.addComponent(textPass, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(103, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(76)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textAccount)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMtKhu, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(textPass, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSaveAccount, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnThot, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(66))
		);
		contentPane.setLayout(gl_contentPane);
	}
	protected void btnThotActionperformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		frame.setEnabled(true);
		this.dispose();
	}
	//btnsave
	protected void btnSaveAccountactionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		CheckImformation check = new CheckImformation();
		if(textAccount.getText().equals("")||textPass.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "You must fill account and pass");
		}else {
			if(check.Checkaccount(AccountJson.getAccount(), textAccount, textPass)) {
				JOptionPane.showMessageDialog(this, "Account is existent.Please Creat other Account");
			}else {
				Account account = new Account();
				account.setId(id);
				account.setTaiKhoan(textAccount.getText());
				account.setMatKhau(textPass.getText());
				AccountJson.insertAccount(account);
				frame.setEnabled(true);
				this.dispose();
			}
		}	
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

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
}
