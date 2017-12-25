package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlJson.CheckImformation;
import model.Manager;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Addcommissionformanager extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField manager_commission;
	private Manager manager; 
	private Updateemployee frame;

	/**
	 * Create the frame.
	 */
	public Addcommissionformanager(Manager manager,Updateemployee frame) {
		this.setManager(manager);
		this.frame = frame;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 371, 133);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Tr\u1EE3 c\u1EA5p");
		
		manager_commission = new JTextField();
		manager_commission.setColumns(10);
		
		JLabel label = new JLabel("***(1-10)");
		
		JButton btnNewButton = new JButton("L\u01B0u");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SaveActionperformed(arg0);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(manager_commission, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(manager_commission, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	//save
	protected void SaveActionperformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		CheckImformation check = new  CheckImformation();

		if(manager_commission.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Please enter all imformation");
		}else {
			if(check.isNotCommission(manager_commission.getText())) {
				return;
			}else {
//				//employee ->manager,employee is not exist in employee_manager table
//				if(connectemployee.Checkidinemployee_manager(connectemployee.getData_employee(), manager.getIdNumber())) {
//				  
//					manager.setCommission(Integer.parseInt(manager_commission.getText()));
//					
//					//chuyen tu employee sang manager thi can insert vao commission va cap nhat lai bang employee 
//					connectemployee.UpdateEmployee(manager.getIdNumber(), manager);
//					connectemployee.insertDB_employeemanager(manager);
//					
//					
//					
//				}else {//manager->employee ,manager is exist in employee_manager table
//				  
//					manager.setCommission(Integer.parseInt(manager_commission.getText()));
//					
//					//chuyen tu manager sang employee thi can delete commission va cap nhat lai bang employee
//					connectemployee.UpdateEmployee(manager.getIdNumber(), manager);
//					connectemployee.UpdateEmployee_manager(manager.getIdNumber(), manager);
//				}	
				frame.setEnabled(true);
				this.dispose();
			}
		}
	}

  public Manager getManager() {
    return manager;
  }

  public void setManager(Manager manager) {
    this.manager = manager;
  }
}
