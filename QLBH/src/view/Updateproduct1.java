package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connectJson.ProductJson;
import controlJson.CheckImformation;
import model.Product;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class Updateproduct1 extends JFrame {
	private Product product;
	private ManagerFrame frame;
	private JButton btnupdateproduct;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField product_name;
	private JTextField product_price;
	private JButton btnexit;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Updateproduct1(Product product,ManagerFrame frame) {
		this.product = product;
		this.frame = frame;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Tên sản phẩm ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		product_name = new JTextField();
		product_name.setColumns(10);
		product_name.setText(product.getName());
		JLabel lblGi = new JLabel("Giá");
		
		product_price = new JTextField();
		product_price.setColumns(10);
		product_price.setText(String.valueOf(product.getPrice()));
		btnupdateproduct = new JButton("Cập nhật");
		btnupdateproduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					btnupdateproductactionperformed(arg0);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		});
		
		btnexit = new JButton("Thoát");
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnexitActionperformed(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(product_name, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblGi, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnupdateproduct, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnexit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(product_price, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(86, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(58)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(product_name)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblGi, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(product_price, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnupdateproduct, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnexit, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(60))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void btnexitActionperformed(ActionEvent e) {
		// TODO Auto-generated method stub
		frame.setEnabled(true);;
		this.dispose();
	}

	protected void btnupdateproductactionperformed(ActionEvent arg0) throws IOException {
		// TODO Auto-generated method stub
//		Connectproduct connectemproduct = new Connectproduct();
//		connectemproduct.Connect();
		if(product_name.getText().equals("")||product_price.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "You must fill all imformation!");
		}else {
			CheckImformation check = new CheckImformation();
			if(check.isNotNumeric(product_price.getText())) {
				return;
			}else {
				product.setName(product_name.getText());
				product.setPrice(Integer.parseInt(product_price.getText()));
				ArrayList<Product> array = new  ArrayList<Product>();
				array.add(product);
				ProductJson.updateProduct(array);
				frame.setEnabled(true);
				this.dispose();
				}
			}
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
