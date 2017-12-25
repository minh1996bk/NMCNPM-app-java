package controlJson;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import connectJson.EmployeeJson;
import model.Account;
import model.Manager;
import model.Product;

public class CheckImformation {
	/**
	 * @return the employee
	 */

	public boolean isNotNumeric(String str)  
	{
	  try  
	  {
		  Integer d = Integer.parseInt(str);
		  if(d <=0 ) {
			  JOptionPane.showMessageDialog(null, str + " is not number");
			  return true;
		  }
	  }  
	  catch(NumberFormatException nfe)  
	  {  
		  JOptionPane.showMessageDialog(null, str + " is not number");
		  return true;
	  }  
	  return false;  
	}
	
	
	public Boolean isNotPhoneNumber(String str) {
		
		  if(str.length()>11||str.length()<10) {
			  JOptionPane.showMessageDialog(null, str+ " is not PhoneNumber");
			  return true;
		  }
		  try  
		  {
			  Integer d = Integer.parseInt(str);
			  System.out.println(d);
		  }  
		  catch(NumberFormatException nfe)  
		  { 
			  JOptionPane.showMessageDialog(null, str+ " is not PhoneNumber");
		    return true;  
		  }
		return false;
	}
	public Boolean isNotCommission(String str) {
		
		  try{  
			  Integer d = Integer.parseInt(str);
			  System.out.println(d);
			  if(Integer.parseInt(str)>10) {
				  JOptionPane.showMessageDialog(null, str+ " is not between 1 and 10");
				  return true;
			  }
		  }  
		  catch(NumberFormatException nfe)  
		  { 
			  JOptionPane.showMessageDialog(null, str+ " is not Commission(1-10)");
		    return true;  
		  }
		return false;
	}
	
	public boolean CheckProductInTable(String str1 ,String str2,String str3,JTable table) {
		int row = table.getRowCount();
		int i=0;
		while(i< row) {
			if(str1.equals(String.valueOf(table.getModel().getValueAt(i, 1))) && str2.equals(String.valueOf(table.getModel().getValueAt(i, 2)))&&str3.equals(String.valueOf(table.getModel().getValueAt(i, 4)))){
				JOptionPane.showMessageDialog(null, "This product is exist in table");
				return true;
			}
			i++;
		}
		return false;
	}
	public boolean CheckProductID_inexporttable(String str1,JTable table) {
		int row = table.getRowCount();
		int i=0;
		while(i< row) {
			if(str1.equals(String.valueOf(table.getModel().getValueAt(i, 1)))) {
				return true;
			}
			i++;
		}
		return false;
	}
	
	public boolean CheckProductID_inimporttable(String str1,JTable table) {
		int row = table.getRowCount();
		int i=0;
		while(i< row) {
			if(str1.equals(String.valueOf(table.getModel().getValueAt(i, 0)))) {
				return true;
			}
			i++;
		}
		return false;
	}
	public Boolean CheckSurviralProduct(Product product, ArrayList<Product> products) {
		for(Product pr :products) {
			if(product.getName().toLowerCase().equals(pr.getName().toLowerCase())&& product.getPrice()==pr.getPrice() && product.getType().equals(product.getType())) {
				int i = JOptionPane.showConfirmDialog(null, product.getName()+"Product is exist.Do you want to import???", "!", JOptionPane.YES_NO_OPTION);
				if(i == JOptionPane.YES_OPTION) {
					return false;
				}else {
					return true;
				}
			}
		}
		return false;
	}
	public Boolean ChecksuvirvalofAccount(ArrayList<Account> accounts , int id) {
		for(Account account : accounts) {
			System.out.println(account.getId());
			if(id == account.getId()){
				return true;
			}
		}
		return false;
	}
	public boolean Checkaccount(ArrayList<Account> accounts, JTextField textAccount, JTextField textPass) {
		// TODO Auto-generated method stub
        Account input = new Account();	
    	input.setTaiKhoan(textAccount.getText());
    	input.setMatKhau(textPass.getText());
    	for(Account account: accounts) {
    		if(input.getTaiKhoan().equals(account.getTaiKhoan())&&input.getMatKhau().equals(account.getMatKhau())) {
    			return true;
    		}
    	}
		return false;
	}
    public boolean CheckManager(Account account) {
    	for(Manager manager: EmployeeJson.getManager()){
    		if(account.getId() == manager.getIdNumber()) {
    			return true;
    		}
    	}
    	return false;
    }
}
