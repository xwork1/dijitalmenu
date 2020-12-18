package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
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
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import Help.*;
import Main.Menu;

import java.sql.*;
import java.util.logging.Level;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.awt.Color;



public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private DBConnection conn = new  DBConnection();
	private JTextField fld_Urunadi;
	private JTextField fld_Fiyati;
	private JTable table_yemekler;
	private DefaultTableModel yemekModel = new DefaultTableModel();
	private Object[] yemekData = {"ID","Yemek Adý","Fiyati"};
	
	public void guncelle() throws SQLException {
		
		Connection con = conn.connDb();
		Statement st3 = con.createStatement();
        ResultSet rs3 = st3.executeQuery("SELECT * FROM yemekler order by id DESC LIMIT 1");
        
		while(rs3.next()){
			yemekData[0] = rs3.getInt("id");
			yemekData[1] = rs3.getString("yemekAdi");
			yemekData[2] = rs3.getString("fiyati");
			yemekModel.addRow(yemekData);
		}
		table_yemekler.setModel(yemekModel);
	}
	
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
		
		JTabbedPane xw = new JTabbedPane(JTabbedPane.TOP);
		xw.setBackground(Color.WHITE);
		xw.setBounds(10, 14, 734, 302);
		contentPane.add(xw);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		xw.addTab("Ürün ekle", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u00DCR\u00DCN ADI");
		lblNewLabel.setBounds(605, 5, 107, 13);
		panel.add(lblNewLabel);
		
		fld_Urunadi = new JTextField();
		fld_Urunadi.setBounds(605, 28, 96, 19);
		fld_Urunadi.setColumns(10);
		panel.add(fld_Urunadi);
		
		JLabel lblNewLabel_1 = new JLabel("FIYATI");
		lblNewLabel_1.setBounds(605, 57, 107, 13);
		panel.add(lblNewLabel_1);
		
		fld_Fiyati = new JTextField();
		fld_Fiyati.setBounds(605, 80, 96, 19);
		fld_Fiyati.setColumns(10);
		panel.add(fld_Fiyati);
		
		JLabel lblNewLabel_2 = new JLabel("KATEGORI");
		lblNewLabel_2.setBounds(605, 109, 107, 13);
		panel.add(lblNewLabel_2);
		
		JButton btnUrunSil = new JButton("S\u0130L");
		
		btnUrunSil.setBounds(605, 192, 74, 21);
		panel.add(btnUrunSil);
		
		JScrollPane xw_scrollYemekler = new JScrollPane();
		xw_scrollYemekler.setBounds(0, 0, 584, 275);
		panel.add(xw_scrollYemekler);
		
		table_yemekler = new JTable();
		xw_scrollYemekler.setViewportView(table_yemekler);	
		
		
		Connection con4 = conn.connDb();
    try {
    		
    		Statement st = con4.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM yemekler");
            yemekModel.setColumnCount(0);
            yemekModel.setRowCount(0);
        	yemekModel.setColumnIdentifiers(yemekData);
    		yemekData = new Object[3];
    		while(rs.next()){
    			yemekData[0] = rs.getInt("id");
    			yemekData[1] = rs.getString("yemekAdi");
    			yemekData[2] = rs.getString("fiyati");
    			yemekModel.addRow(yemekData);
    		}
    		table_yemekler.setModel(yemekModel);
    	
	} catch (Exception e) {
	}
    	
    
	Connection con1 = conn.connDb();		
	JComboBox UrunBox = new JComboBox();
	try {		
		Statement stm = con1.createStatement();
		ResultSet rs = stm.executeQuery("SELECT * From kategori");
		while(rs.next()) {
			String kategori_id = rs.getString("kategori_id");
			UrunBox.addItem(kategori_id);				
		}
	} catch (SQLException e) {
		
		}					
	UrunBox.setBounds(605, 132, 96, 19);
	panel.add(UrunBox);
	
	JButton btnUrunEkle = new JButton("EKLE");
	btnUrunEkle.setBounds(605, 161, 74, 21);
	panel.add(btnUrunEkle);
	
	JButton btnBack = new JButton("Geri");
	btnBack.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			new Menu().setVisible(true);
            hide();
		}
	});
	btnBack.setBounds(605, 246, 74, 19);
	panel.add(btnBack);
	
	
    btnUrunEkle.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent arg0) {
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
        guncelle();
	
    } catch (SQLException ex) {
        java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
    			}
                    
    		}                  
    	});
    btnUrunSil.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Connection con2 = conn.connDb();
			DefaultTableModel model = (DefaultTableModel) table_yemekler.getModel();
	        int row = table_yemekler.getSelectedRow();
	        int eve = (int) table_yemekler.getModel().getValueAt(row, 0);
	        try {
	        	Statement sorgu = con2.createStatement();
	        	sorgu.executeUpdate("DELETE FROM yemekler where id= "+eve);
	        	model.removeRow(table_yemekler.getSelectedRow());
	        }catch(Exception e) {
	        	System.out.println(e);
	        }
			
		}
	});
	}
}
