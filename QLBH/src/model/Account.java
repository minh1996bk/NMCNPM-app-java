package model;


public class Account {
	   private int id;
       private String TaiKhoan;
       private String MatKhau;

   public Account(String TaiKhoan, String MatKhau) {
       this.TaiKhoan = TaiKhoan;
       this.MatKhau = MatKhau;
   }

   public Account() {
   }
   
   public String getTaiKhoan() {
       return TaiKhoan;
   }

   public void setTaiKhoan(String TaiKhoan) {
       this.TaiKhoan = TaiKhoan;
   }

   public String getMatKhau() {
       return MatKhau;
   }

   public void setMatKhau(String MatKhau) {
       this.MatKhau = MatKhau;
   }

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}
}