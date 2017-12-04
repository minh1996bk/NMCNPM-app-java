package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import connectsql.Connectproduct;
import control.CheckImformation;
import model.Product;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class Updateproduct extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField product_name;
	private JTextField product_price;
	private JTextField product_producer;
	private JTextField product_total;
	private JDateChooser product_producedate;
	private JDateChooser product_expiredate;
	
	private Product product;
	private ManagerFrame frame;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Updateproduct() {
		
	}
	public Updateproduct(Product product , ManagerFrame frame) {
		this.product = product;
		this.frame = frame;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(this);
		setBounds(100, 100, 540, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn m\u1EB7t h\u00E0ng");
		
		product_name = new JTextField();
		product_name.setColumns(10);
		product_name.setText(product.getName());
		
		JLabel lblGi = new JLabel("Gi\u00E1 ");
		
		product_price = new JTextField();
		product_price.setColumns(10);
		product_price.setText(String.valueOf(product.getPrice()));
		
		JLabel lblNiSnXut = new JLabel("N\u01A1i s\u1EA3n xu\u1EA5t");
		
		product_producer = new JTextField();
		product_producer.setColumns(10);
		product_producer.setText(product.getProducer());
		
		JLabel lblNg = new JLabel("Ng\u00E0y s\u1EA3n xu\u1EA5t");
		
		JLabel lblHnSDng = new JLabel("H\u1EA1n s\u1EED d\u1EE5ng");
		
		product_expiredate = new JDateChooser();
		product_expiredate.setDate(product.getExpireTime());
		
		JLabel lblSLng = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
		
		product_total = new JTextField();
		product_total.setColumns(10);
		product_total.setText(String.valueOf(product.getTotal()));
		
		product_producedate = new JDateChooser();
		product_producedate.setDate(product.getProduceTime());
		
		JButton btnNewButton = new JButton("L\u01B0u");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnSaveproductActionPerformed(e);
			}
		});
		
		JButton btnThot = new JButton("Tho\u00E1t");
		btnThot.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnexitActionPerformed(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(89)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSLng, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNiSnXut, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblHnSDng, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNg, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblGi, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
							.addGap(0)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnThot, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
								.addComponent(product_price, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
								.addComponent(product_name, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
								.addComponent(product_producer, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
								.addComponent(product_producedate, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addComponent(product_expiredate, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addComponent(product_total, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(110, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(82)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
						.addComponent(product_name, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGi, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(product_price, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNiSnXut, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(product_producer, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(product_producedate, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNg, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(product_expiredate, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHnSDng, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSLng, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(product_total, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnThot, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(61))
		);
		contentPane.setLayout(gl_contentPane);
	}
	protected void btnexitActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		frame.setEnabled(true);;
		this.dispose();
	}
	protected void btnSaveproductActionPerformed(ActionEvent e) {
		Connectproduct connectemproduct = new Connectproduct();
		connectemproduct.Connect();
		if(product_name.getText().equals("")||product_price.getText().equals("")||product_producer.getText().equals("")||product_producedate.getDate() == null||product_expiredate.getDate() == null) {
			JOptionPane.showMessageDialog(this, "You must fill all imformation!");
		}else {
			CheckImformation check = new CheckImformation();
			if(check.isNotNumeric(product_price.getText())||check.isNotNumeric(product_total.getText())) {
				return;
			}else {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String date1 = sdf.format(product_producedate.getDate());
				String date2 = sdf.format(product_expiredate.getDate());
				Product pr = new Product();
				pr.setIdNumber(product.getIdNumber());
				pr.setName(product_name.getText());
				pr.setPrice(Integer.parseInt(product_price.getText()));
				pr.setProducer(product_producer.getText());
				pr.setProduceTime(Date.valueOf(date1));
				pr.setExpireTime(Date.valueOf(date2));
				pr.setTotal(Integer.parseInt(product_total.getText()));
				connectemproduct.UpdateProduct(pr.getIdNumber(), pr);
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
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
}
