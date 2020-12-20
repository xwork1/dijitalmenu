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
		setBackground(SystemColor.window);
		setResizable(false);
		setTitle("Dijital Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 420);
		xw = new JPanel();
		xw.setBackground(Color.WHITE);
		xw.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(xw);
		xw.setLayout(null);
		
		JTabbedPane xw_tabpanel = new JTabbedPane(JTabbedPane.TOP);
		xw_tabpanel.setBounds(10, 10, 696, 372);
		xw_tabpanel.setToolTipText("");
		xw_tabpanel.setBackground(Color.WHITE);
		xw.add(xw_tabpanel);
		
		JPanel xw_panel = new JPanel();
		xw_panel.setBackground(Color.WHITE);
		xw_panel.setToolTipText("");
		xw_tabpanel.addTab("Menü", null, xw_panel, null);
		xw_panel.setLayout(null);
		
		JButton eturunleri = new JButton("ET URUNLERI");
		Image img = new ImageIcon(this.getClass().getResource("/et.png")).getImage();
		eturunleri.setIcon(new ImageIcon(img));
		eturunleri.setBounds(10, 10, 135, 127);
		eturunleri.setForeground(Color.BLACK);
		eturunleri.setBackground(Color.WHITE);
		xw_panel.add(eturunleri);
		eturunleri.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new EtlerGUI().show();
            }
        });
		
		
		JButton btnGarson = new JButton("Garson Cagir");
		btnGarson.setBackground(Color.WHITE);
		btnGarson.setBounds(444, 10, 205, 42);
		xw_panel.add(btnGarson);
		
		JButton btnPay = new JButton("Odeme Yap");
		btnPay.setBackground(Color.WHITE);
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnPay.setBounds(444, 62, 205, 42);
		xw_panel.add(btnPay);
		
		JButton btnWatch = new JButton("Siparis izle");
		btnWatch.setBackground(Color.WHITE);
		btnWatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnWatch.setBounds(444, 114, 205, 42);
		xw_panel.add(btnWatch);
		
		JButton btnTatli = new JButton("TATLILAR");
		btnTatli.setForeground(Color.BLACK);
		btnTatli.setBackground(Color.WHITE);
		btnTatli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
	            new TatliGUI().show();
			}
		});
		btnTatli.setBounds(278, 10, 135, 127);
		xw_panel.add(btnTatli);
		
		JButton btnDrink = new JButton("ICECEKLER");
		btnDrink.setForeground(Color.BLACK);
		btnDrink.setBackground(Color.WHITE);
		btnDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
	            new IcecekGUI().show();
			}
		});
		btnDrink.setBounds(10, 136, 135, 127);
		xw_panel.add(btnDrink);
		
		JButton btnAraSicak = new JButton("ARA SICAK");
		btnAraSicak.setBackground(Color.WHITE);
		btnAraSicak.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
            new ArasicakGUI().show();
		}
	});
		btnAraSicak.setBounds(278, 136, 135, 127);
		xw_panel.add(btnAraSicak);
		
		JButton btnSalata = new JButton("SALATALAR");
		btnSalata.setForeground(Color.BLACK);
		btnSalata.setBackground(Color.WHITE);
		btnSalata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
                new SalataGUI().show();
			}
		});
		btnSalata.setBounds(144, 136, 135, 127);
		xw_panel.add(btnSalata);
		
		JButton btnDeniz = new JButton("DENIZ URUNLERI");
		btnDeniz.setForeground(Color.BLACK);
		btnDeniz.setBounds(144, 10, 135, 127);
		btnDeniz.setBackground(Color.WHITE);
		xw_panel.add(btnDeniz);
		btnDeniz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new BalikGUI().show();
            }
        });
		
		JButton btnKmpny = new JButton("Kampanyalar");
		btnKmpny.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
                new KampanyaGUI().show();
			}
		});
		btnKmpny.setBackground(Color.WHITE);
		btnKmpny.setBounds(444, 166, 205, 42);
		xw_panel.add(btnKmpny);
		
		JButton btnSepet = new JButton("Sepetim");
		btnSepet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
                new SepetGUI().show();
			}
		});
		btnSepet.setBackground(Color.WHITE);
		btnSepet.setBounds(444, 221, 205, 42);
		xw_panel.add(btnSepet);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		xw_tabpanel.addTab("Yetkili", null, panel, null);
		panel.setLayout(null);
		
		fld_user = new JTextField();
		fld_user.setBounds(214, 90, 252, 33);
		fld_user.setToolTipText("");
		fld_user.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		fld_user.setColumns(10);
		fld_user.setBackground(Color.WHITE);
		panel.add(fld_user);
		
		fld_pass = new JPasswordField();
		fld_pass.setBounds(214, 165, 252, 32);
		panel.add(fld_pass);
		
		JTextPane txt_username = new JTextPane();
		txt_username.setBounds(118, 90, 97, 33);
		txt_username.setBackground(Color.WHITE);
		txt_username.setEnabled(false);
		txt_username.setEditable(false);
		txt_username.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_username.setText("Yetkili Giris");
		panel.add(txt_username);
		
		JTextPane txt_pass = new JTextPane();
		txt_pass.setBounds(166, 165, 49, 32);
		txt_pass.setBackground(Color.WHITE);
		txt_pass.setEnabled(false);
		txt_pass.setEditable(false);
		txt_pass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txt_pass.setText("Sifre:");
		panel.add(txt_pass);
		
		JButton btnLogin = new JButton("Giris Yap");
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
