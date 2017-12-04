package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

import connectsql.Connectemployee;
import control.CheckImformation;
import model.Employee;
import model.Manager;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Updateemployee extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField employee_name;
	private JTextField employee_address;
	private JTextField employee_phone;
	private JTextField employee_consalary;
	private JComboBox<String> employee_male;
	private JDateChooser employee_birth;
	private JComboBox<String> employee_position;
	
	private Employee employee;
	private ManagerFrame frame;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */

	public Updateemployee(Employee employee,ManagerFrame frame) {
		this.employee = employee;
		this.frame = frame;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(this);
		setBounds(100, 100, 560, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EAn nh\u00E2n vi\u00EAn");
		
		employee_name = new JTextField();
		employee_name.setColumns(10);
		employee_name.setText(this.employee.getName());
		
		JLabel lblGiiTnh = new JLabel("Gi\u1EDBi t\u00EDnh");
		
		employee_male = new JComboBox<String>();
		employee_male.setModel(new DefaultComboBoxModel<String>(new String[] {"men", "women"}));
		employee_male.setSelectedItem(this.employee.getSex());
		
		JLabel lblNgySinh = new JLabel("Ng\u00E0y sinh");
		
		employee_birth = new JDateChooser();
		employee_birth.setDate(this.employee.getDateOfBirth());
		
		JLabel lblaCh = new JLabel("\u0110\u1ECBa ch\u1EC9");
		
		employee_address = new JTextField();
		employee_address.setColumns(10);
		employee_address.setText(this.employee.getAddress());
		
		JLabel lblSinThoi = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		
		employee_phone = new JTextField();
		employee_phone.setColumns(10);
		employee_phone.setText(employee.getPhoneNumber());
		
		JLabel lblLng = new JLabel("H\u1EC7 s\u1ED1 l\u01B0\u01A1ng");
		
		employee_consalary = new JTextField();
		employee_consalary.setColumns(10);
		employee_consalary.setText(String.valueOf(this.employee.getCoefficientsSalary()));
		
		JButton btnNewButton = new JButton("L\u01B0u");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSaveimformationofEmployee(arg0);
			}
		});
		
		JLabel lblVTr = new JLabel("V\u1ECB tr\u00ED");
		
		employee_position = new JComboBox<String>();
		employee_position.setModel(new DefaultComboBoxModel<String>(new String[] {"employee", "manager"}));
		employee_position.setSelectedItem(this.employee.getPosition());
		
		JButton btnThot = new JButton("Tho\u00E1t");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exitbtnActionPerformed(arg0);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(91)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGiiTnh, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNgySinh, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblaCh, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSinThoi, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLng, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblVTr, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnThot, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
						.addComponent(employee_phone, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
						.addComponent(employee_address, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
						.addComponent(employee_name, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
						.addComponent(employee_male, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
						.addComponent(employee_birth, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
						.addComponent(employee_consalary, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
						.addComponent(employee_position, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(107, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(75)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(employee_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(employee_male, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGiiTnh, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(employee_birth, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNgySinh, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblaCh, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(employee_address, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSinThoi, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(employee_phone, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLng, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(employee_consalary, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVTr, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(employee_position, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnThot, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(25))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void exitbtnActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		frame.setEnabled(true);;
		this.dispose();
	}

	protected void btnSaveimformationofEmployee(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Connectemployee connectemployee = new Connectemployee();
		connectemployee.Connect();
		if(employee_name.getText().equals("")||employee_address.getText().equals("")||employee_phone.getText().equals("")||employee_consalary.getText().equals("")||employee_birth.getDate() == null) {
			JOptionPane.showMessageDialog(this, "You must fill all imformation!");
		}else {
			CheckImformation check = new CheckImformation();
			if(check.isNotPhoneNumber(employee_phone.getText())||check.isNotNumeric(employee_consalary.getText())) {
				return;
			}else {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String date = sdf.format(employee_birth.getDate());
				if(employee_position.getSelectedItem().equals("employee")) {
					Employee em = new Employee();
					em.setIdNumber(employee.getIdNumber());
					em.setName(employee_name.getText());
					em.setAddress(employee_address.getText());
					em.setSex(String.valueOf( employee_male.getSelectedItem()));
					em.setDateOfBirth(Date.valueOf(date));
					em.setPhoneNumber(employee_phone.getText());
					em.setCoefficientsSalary(Integer.parseInt(employee_consalary.getText()));
					em.setPosition(String.valueOf(employee_position.getSelectedItem()));
					connectemployee.UpdateEmployee(em.getIdNumber(),em);
					frame.setEnabled(true);
					this.dispose();
					}
				else {
					Manager m = new Manager();
					m.setIdNumber(employee.getIdNumber());
					m.setName(employee_name.getText());
					m.setAddress(employee_address.getText());
					m.setSex(String.valueOf( employee_male.getSelectedItem()));
					m.setDateOfBirth(Date.valueOf(date));
					m.setPhoneNumber(employee_phone.getText());
					m.setCoefficientsSalary(Integer.parseInt(employee_consalary.getText()));
					m.setPosition(String.valueOf(employee_position.getSelectedItem()));
					Addcommissionformanager add = new Addcommissionformanager(m, this);
					this.setEnabled(false);
					add.setVisible(true);
					}
				}
			}
		}



	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
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
