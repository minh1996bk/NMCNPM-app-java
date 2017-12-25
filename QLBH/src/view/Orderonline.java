package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connectJson.OrderJson;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.Order;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import model.Product;
import model.Status;
public class Orderonline extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private Order order;
	private EmployeeFrame frame;
	/**
	 * Launch the application.
	 */
  private JButton btnStatus;
  private JButton btnCancel;


	/**
	 * Create the frame.
	 * @param ff 
	 * @param order 
	 */
	public Orderonline(EmployeeFrame ff, Order order) {
	  this.order = order;
	  this.frame = ff;
	  JFrame f = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 955, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblAdrress = new JLabel("Adrress1");
		lblAdrress.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblAddress = new JLabel("Address2");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel(order.getName());
		
		JLabel label_5 = new JLabel(order.getPhone());
		
		JLabel label_6 = new JLabel(order.getEmail());
		
		JLabel label_7 = new JLabel(order.getCompanyName());
		
		JLabel label_8 = new JLabel(order.getAddress1());
		
		JLabel label_9 = new JLabel(order.getAddress2());
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        f.dispose();
      }
    });
		JLabel lblNewLabel_2 = new JLabel("Total");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label = new JLabel("" + order.countTotal());
		
		btnStatus = new JButton("Status");
		
		btnCancel = new JButton("Cancel");
		
		
		JLabel lblNewLabel_3 = new JLabel("Khách hàng");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblAdrress, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCompanyName, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPhone, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
					.addGap(16))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(320, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(btnStatus)
					.addGap(18)
					.addComponent(btnCancel)
					.addGap(390))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(746, Short.MAX_VALUE)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(13))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(35)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(label, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnCancel)
								.addComponent(btnStatus)
								.addComponent(btnNewButton)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(64)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblPhone, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
									.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
									.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblCompanyName, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(lblAdrress, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
									.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		
		table = new JTable();
		display(order.getProducts());
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		displayStatusButton();
		
		btnCancel.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        order.setStatus(Status.canceled);
        try {
          ArrayList<Order> arrayList = new ArrayList<>();
          arrayList.add(order);
          OrderJson.updateOrder(arrayList);
        } catch (IOException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
        
      }
    });
		
		btnStatus.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Status s = order.getStatus();
        if (s.equals(Status.waiting)) {
          order.setStatus(Status.accepted);
          btnStatus.setText("Ship");
        }
        
        if (s.equals(Status.accepted)) {
          order.setStatus(Status.shipping);
          btnStatus.setText("Complete");
        }
        
        if (s.equals(Status.shipping)) {
          order.setStatus(Status.completed);
          btnStatus.setVisible(false);
        }
        
        try {
          ArrayList<Order> arrayList = new ArrayList<>();
          arrayList.add(order);
          OrderJson.updateOrder(arrayList);
        } catch (IOException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
        frame.displayOrders(frame.subOrders);
      }
    });
	}
	
	private void display(ArrayList<Product> products) {
	  String[] columnNames = {"ID", "Product Name", "Amount", "Price"};
	  MyModel model = new MyModel(columnNames);
	  
	  for (Product p : products) {
	    String[] row = {"" + p.getIdNumber(), p.getName(), "" + p.getTotal(), "" + p.getPrice()};
	    model.addRow(row);
	  }
	  table.setModel(model);
	}
	
	private void displayStatusButton() {
	  if (order.getStatus().equals(Status.waiting)) {
	    btnStatus.setText("Accept");
	  } else if (order.getStatus().equals(Status.accepted)) {
	    btnStatus.setText("Ship");
	  } else if (order.getStatus().equals(Status.shipping)) {
	    btnStatus.setText("Complete");
	  } else {
      btnStatus.setVisible(false);
      btnCancel.setVisible(false);
    } 
 	}
}
