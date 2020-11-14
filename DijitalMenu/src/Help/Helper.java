package Help;

import javax.swing.JOptionPane;

public class Helper {
	
	public static void showMsg(String str) {
		String msg;
		
		switch(str) {
		case "fill":
			msg = "Lütfen tüm alanlarý doldurunuz. Varsayýlan kullanýcý adý: admin varsayýlan þifre:0000";
			break;
		default:
			msg = str;
			
		}
		
		JOptionPane.showMessageDialog(null, msg,"Mesaj", JOptionPane.INFORMATION_MESSAGE);
	}

}
