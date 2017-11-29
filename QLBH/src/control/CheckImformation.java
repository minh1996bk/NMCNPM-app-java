package control;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class CheckImformation {
	/**
	 * @return the employee
	 */

	public boolean isNotNumeric(String str)  
	{
	  try  
	  {  
	    Integer d = Integer.parseInt(str);  
	    System.out.println(d);
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
	
	public boolean CheckProductInTable(String str1 ,String str2 ,String str3,JTable table) {
		int row = table.getRowCount();
		int i=0;
		while(i< row) {
			if(str1.equals(String.valueOf(table.getModel().getValueAt(i, 1))) && str2.equals(String.valueOf(table.getModel().getValueAt(i, 2)))&&str3.equals(String.valueOf(table.getModel().getValueAt(i, 4)))) {
				JOptionPane.showMessageDialog(null, "This product is exist in table");
				return true;
			}
			i++;
		}
		return false;
	}
}
