package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connectJson.SupplierJson;
import controlJson.CheckImformation;
import controlJson.SelectId;
import model.Supplier;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Addsupplier extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField supplier_name;
	private JTextField supplier_address;
	private JTextField supplier_email;
	private JTextField supplier_phone;
	private JButton btnAddsupplier;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Addsupplier() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Nhà cung cấp");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		supplier_name = new JTextField();
		supplier_name.setColumns(10);
		
		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setHorizontalAlignment(SwingConstants.CENTER);
		
		supplier_address = new JTextField();
		supplier_address.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		
		supplier_email = new JTextField();
		supplier_email.setColumns(10);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setHorizontalAlignment(SwingConstants.CENTER);
		
		supplier_phone = new JTextField();
		supplier_phone.setColumns(10);
		
		btnAddsupplier = new JButton("Thêm");
		btnAddsupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAddsupplierActionperformed(arg0);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(73)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(supplier_email, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblaCh, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(supplier_address, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(supplier_name, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblSinThoi, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnAddsupplier, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
								.addComponent(supplier_phone, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(97, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(65)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(supplier_name, Alignment.LEADING)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblaCh, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(supplier_address, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(supplier_email, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSinThoi, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(supplier_phone, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addComponent(btnAddsupplier, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(105, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	/**
	 * 
	 * add supplier
	 * @param arg0
	 */
	protected void btnAddsupplierActionperformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(supplier_address.getText().equals("")||supplier_name.getText().equals("")||supplier_email.getText().equals("")||supplier_phone.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "You must enter all imformation");
		}else {
			CheckImformation check = new CheckImformation();
			if(check.isNotPhoneNumber(supplier_phone.getText())) {
				JOptionPane.showMessageDialog(this, supplier_phone.getText() + " is not phone number");
			}else {
				Supplier supplier = new model.Supplier(SelectId.SelectID_supplier(SupplierJson.getSupplier()),supplier_name.getText(),supplier_address.getText(),supplier_email.getText(),supplier_phone.getText());
				SupplierJson.insertSupplier(supplier);
				JOptionPane.showMessageDialog(this, "Add supplier succesful");
				supplier_address.setText("");supplier_email.setText("");supplier_phone.setText("");supplier_name.setText("");
			}
		}
	}
}
