package model;


public class Account {
	   private int id_employee;
     private String user_name;
     private String password;

   public Account(String TaiKhoan, String MatKhau) {
       this.user_name = TaiKhoan;
       this.password = MatKhau;
   }

   public Account() {
   }
   
   public String getTaiKhoan() {
       return user_name;
   }

   public void setTaiKhoan(String TaiKhoan) {
       this.user_name = TaiKhoan;
   }

   public String getMatKhau() {
       return password;
   }

   public void setMatKhau(String MatKhau) {
       this.password = MatKhau;
   }

public int getId() {
	return id_employee;
}

public void setId(int id) {
	this.id_employee = id;
}
}
