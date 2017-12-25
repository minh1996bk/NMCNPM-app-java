package controlJson;

import connectJson.AccountJson;
import model.Account;

public class AccountControl {
	public static Account GetAccount(String account , String pass) {
		Account nick = new Account();
		for(Account acc : AccountJson.getAccount()) {
			if(acc.getTaiKhoan().equals(account)&& acc.getMatKhau().equals(pass)) {
				nick.setId(acc.getId());
				nick.setTaiKhoan(acc.getTaiKhoan());
				nick.setMatKhau(acc.getMatKhau());
			}
		}
		return nick;
	}
}
