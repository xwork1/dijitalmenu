package Help;

import javax.swing.JOptionPane;

public class Helper {
	
	public static void showMsg(String str) {
		String msg;
		
		switch(str) {
		case "fill":
			msg = "L�tfen t�m alanlar� doldurunuz. Varsay�lan kullan�c� ad�: admin varsay�lan �ifre:0000";
			break;
		default:
			msg = str;
			
		}
		
		JOptionPane.showMessageDialog(null, msg,"Mesaj", JOptionPane.INFORMATION_MESSAGE);
	}

}
