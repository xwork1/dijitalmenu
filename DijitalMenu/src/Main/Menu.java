package Main;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Help.DBConnection;
import Help.Helper;

import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import Help.*;
import Model.Yetkili;
import View.ArasicakGUI;
import View.BalikGUI;
import View.EtlerGUI;
import View.IcecekGUI;
import View.KampanyaGUI;
import View.LoginGUI;
import View.SalataGUI;
import View.SepetGUI;
import View.TatliGUI;
import javax.swing.border.BevelBorder;
import java.awt.ComponentOrientation;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.awt.Dimension;


public class Menu extends JFrame {

	
	private JPanel xw;
	private JTextField fld_user;
	private JPasswordField fld_pass;
	private DBConnection conn = new  DBConnection();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	@SuppressWarnings("deprecation")
	public Menu() {
		setResizable(false);
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(new Color(165, 42, 42));
		setTitle("Dijital Menu");
		setBounds(100, 100, 720, 420);
		xw = new JPanel();
		xw.setBackground(new Color(139, 0, 0));
		xw.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(xw);
		xw.setLayout(null);
		
		JTabbedPane xw_tabpanel = new JTabbedPane(JTabbedPane.TOP);
		xw_tabpanel.setBounds(0, 10, 732, 397);
		xw_tabpanel.setToolTipText("");
		xw_tabpanel.setBackground(Color.WHITE);
		xw.add(xw_tabpanel);
		
		JPanel xw_panel = new JPanel();
		xw_panel.setBackground(new Color(165, 42, 42));
		xw_panel.setToolTipText("");
		xw_tabpanel.addTab("Menü", null, xw_panel, null);
		
		JButton eturunleri = new JButton("ET URUNLERI");
		eturunleri.setBounds(10, 10, 135, 127);
		Image img = new ImageIcon(this.getClass().getResource("/et.png")).getImage();
		xw_panel.setLayout(null);
		eturunleri.setIcon(new ImageIcon(img));
		eturunleri.setForeground(Color.BLACK);
		xw_panel.add(eturunleri);
		eturunleri.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new EtlerGUI().show();
            }
        });
		
		
		JButton btnGarson = new JButton("Garson Cagir");
		btnGarson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Helper.showMsg("Sayýn müþterimiz en kýsa sürede garsonumuz sizinle ilgilenecektir.");
			}
		});
		btnGarson.setBounds(444, 10, 205, 42);
		btnGarson.setBackground(new Color(100, 149, 237));
		xw_panel.add(btnGarson);
		
		JButton btnPay = new JButton("Odeme Yap");
		btnPay.setBounds(444, 62, 205, 42);
		btnPay.setBackground(new Color(100, 149, 237));
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		xw_panel.add(btnPay);
		
		JButton btnWatch = new JButton("Siparis izle");
		btnWatch.setBounds(444, 114, 205, 42);
		btnWatch.setBackground(new Color(100, 149, 237));
		btnWatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		xw_panel.add(btnWatch);
		
		JButton btnTatli = new JButton("TATLILAR");
		btnTatli.setBounds(278, 10, 135, 127);
		Image tatliimg = new ImageIcon(this.getClass().getResource("/tatlý.png")).getImage();
		btnTatli.setIcon(new ImageIcon(tatliimg));
		btnTatli.setForeground(Color.BLACK);
		btnTatli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
	            new TatliGUI().show();
			}
		});
		xw_panel.add(btnTatli);
		
		JButton btnDrink = new JButton("ICECEKLER");
		btnDrink.setBounds(10, 136, 135, 127);
		Image drinkimg = new ImageIcon(this.getClass().getResource("/icecek.png")).getImage();
		btnDrink.setIcon(new ImageIcon(drinkimg));
		btnDrink.setForeground(Color.BLACK);
		btnDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
	            new IcecekGUI().show();
			}
		});
		xw_panel.add(btnDrink);
		
		JButton btnAraSicak = new JButton("ARA SICAK");
		btnAraSicak.setBounds(278, 136, 135, 127);
		Image sicaklarimg = new ImageIcon(this.getClass().getResource("/arasýcak.png")).getImage();
		btnAraSicak.setIcon(new ImageIcon(sicaklarimg));
		btnAraSicak.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
            new ArasicakGUI().show();
		}
	});
		xw_panel.add(btnAraSicak);
		
		JButton btnSalata = new JButton("SALATALAR");
		btnSalata.setBounds(144, 136, 135, 127);
		Image salataimg = new ImageIcon(this.getClass().getResource("/salata.png")).getImage();
		btnSalata.setIcon(new ImageIcon(salataimg));
		btnSalata.setForeground(Color.BLACK);
		btnSalata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
                new SalataGUI().show();
			}
		});
		xw_panel.add(btnSalata);
		
		JButton btnDeniz = new JButton("DENIZ URUNLERI");
		btnDeniz.setBounds(144, 10, 135, 127);
		Image balikimg = new ImageIcon(this.getClass().getResource("/balýk.png")).getImage();
		btnDeniz.setIcon(new ImageIcon(balikimg));
		btnDeniz.setForeground(Color.BLACK);
		xw_panel.add(btnDeniz);
		btnDeniz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new BalikGUI().show();
            }
        });
		
		JButton btnKmpny = new JButton("Kampanyalar");
		btnKmpny.setBounds(444, 166, 205, 42);
		btnKmpny.setBackground(new Color(100, 149, 237));
		btnKmpny.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
                new KampanyaGUI().show();
			}
		});
		xw_panel.add(btnKmpny);
		
		JButton btnSepet = new JButton("Sepetim");
		btnSepet.setBounds(444, 221, 205, 42);
		btnSepet.setBackground(new Color(100, 149, 237));
		btnSepet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
                new SepetGUI().show();
			}
		});
		xw_panel.add(btnSepet);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(165, 42, 42));
		xw_tabpanel.addTab("Yetkili", null, panel, null);
		panel.setLayout(null);
		
		fld_user = new JTextField();
		fld_user.setBounds(214, 90, 252, 33);
		fld_user.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		fld_user.setColumns(10);
		fld_user.setBackground(Color.WHITE);
		panel.add(fld_user);
		
		fld_pass = new JPasswordField();
		fld_pass.setBounds(214, 165, 252, 32);
		panel.add(fld_pass);
		
		JTextPane txt_username = new JTextPane();
		txt_username.setForeground(new Color(255, 255, 255));
		txt_username.setBackground(new Color(165, 42, 42));
		txt_username.setBounds(118, 90, 97, 33);
		txt_username.setEnabled(false);
		txt_username.setEditable(false);
		txt_username.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_username.setText("Yetkili Giris");
		panel.add(txt_username);
		
		JTextPane txt_pass = new JTextPane();
		txt_pass.setForeground(new Color(255, 255, 255));
		txt_pass.setBackground(new Color(165, 42, 42));
		txt_pass.setBounds(166, 165, 49, 32);
		txt_pass.setEnabled(false);
		txt_pass.setEditable(false);
		txt_pass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_pass.setText("Sifre:");
		panel.add(txt_pass);
		
		JButton btnLogin = new JButton("Giris Yap");
		btnLogin.setForeground(new Color(100, 149, 237));
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(fld_user.getText().length() == 0 || fld_pass.getText().length() == 0) {
						Helper.showMsg("fill");
					}else {
						
						Connection con = conn.connDb();
						try {
							Statement st = con.createStatement();
							ResultSet rs = st.executeQuery("SELECT * From yetkili");
							while(rs.next()) {
								if(fld_user.getText().equals(rs.getString("username")) && fld_pass.getText().equals(rs.getString("password"))) {
								Yetkili admin = new Yetkili();
								admin.setId(rs.getInt("id"));
								admin.setUsername(rs.getString("username"));
								admin.setPassword(rs.getString("password"));
								admin.setName(rs.getString("logged"));			
								System.out.println(admin.getLogged());		
								dispose();
								new LoginGUI().setVisible(true);
								}else {
									Helper.showMsg("fill3");
								}
							}
							
							
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}				
				}
			});
	
		btnLogin.setBounds(244, 221, 139, 21);
		panel.add(btnLogin);
	}
}
