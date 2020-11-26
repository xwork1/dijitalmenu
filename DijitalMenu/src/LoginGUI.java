import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JTree;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.JProgressBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import Help.*;
import java.sql.*;
import java.util.logging.Level;



public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField fld_Fiyati;
	private JTextField fld_Urunadi;
	private DBConnection conn = new  DBConnection();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u00DCR\u00DCN ADI");
		lblNewLabel.setBounds(203, 14, 80, 29);
		contentPane.add(lblNewLabel);
		
		fld_Urunadi = new JTextField();
		fld_Urunadi.setColumns(10);
		fld_Urunadi.setBounds(180, 54, 136, 29);
		contentPane.add(fld_Urunadi);
		
		JLabel lblNewLabel_1 = new JLabel("F\u0130YATI");
		lblNewLabel_1.setBounds(401, 15, 56, 26);
		contentPane.add(lblNewLabel_1);
		
		fld_Fiyati = new JTextField();
		fld_Fiyati.setBounds(349, 51, 136, 29);
		contentPane.add(fld_Fiyati);
		fld_Fiyati.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("KATEGOR\u0130");
		lblNewLabel_2.setBounds(33, 15, 80, 26);
		contentPane.add(lblNewLabel_2);
		
		Connection con = conn.connDb();		
		JComboBox UrunBox = new JComboBox();
		try {		
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * From kategori");
			while(rs.next()) {
				String kategori_id = rs.getString("kategori_id");
				UrunBox.addItem(kategori_id);				
			}
		} catch (SQLException e) {
			
			}					
		UrunBox.setBounds(10, 57, 136, 23);           
		contentPane.add(UrunBox);
		
		JButton btnUrunEkle = new JButton("EKLE");
		btnUrunEkle.setBounds(510, 54, 103, 23);
		contentPane.add(btnUrunEkle);
		
        btnUrunEkle.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
        DBConnection db = new DBConnection();
        Connection c = db.connDb();
        try {

            String kategori = UrunBox.getSelectedItem().toString();
            Statement st = c.createStatement();
            ResultSet rs2 = st.executeQuery("SELECT * FROM kategori where kategori_id = '" + kategori + "'");
            int kategori_id = 0;
            while (rs2.next()) {
                kategori_id = rs2.getInt("id");
            }
            Statement st2 = c.createStatement();
            st2.executeUpdate("INSERT INTO yemekler (yemekAdi,fiyati,kategori_id) VALUES ('" + fld_Urunadi.getText() + "','" + fld_Fiyati.getText() + "','" + kategori_id + "')");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
                        
     }                  
 });
		
		JButton btnBack = new JButton("Geri");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu frame=new Menu();
			    frame.setVisible(true);
			    dispose();
			}

		});
		btnBack.setBounds(661, 14, 69, 23);
		contentPane.add(btnBack);
				
	}
}
