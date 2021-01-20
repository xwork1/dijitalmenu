package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import Help.*;
import Main.Menu;

import java.sql.*;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;



public class SepetGUI extends JFrame {

	private JPanel contentPane;
	private DBConnection conn = new  DBConnection();
	private JTable table_sepet;
	private DefaultTableModel yemekModel = new DefaultTableModel();
	private Object[] yemekData = {"ID","Yemek Adý","Fiyati"};
	private JTextField textField;
	
	public void guncelle() throws SQLException {
		
		Connection con = conn.connDb();
		Statement st3 = con.createStatement();
        ResultSet rs3 = st3.executeQuery("SELECT * FROM sepet");
        
		while(rs3.next()){
			yemekData[0] = rs3.getInt("sepet_id");
			yemekData[1] = rs3.getString("yemekadi");
			yemekData[2] = rs3.getString("yemekfiyati");
			yemekModel.addRow(yemekData);
		}
		table_sepet.setModel(yemekModel);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SepetGUI frame = new SepetGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public SepetGUI() {
		setUndecorated(true);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 363);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(165, 42, 42));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);	
		contentPane.setLayout(null);
		
		JTabbedPane xw = new JTabbedPane(JTabbedPane.TOP);
		xw.setBackground(Color.WHITE);
		xw.setBounds(10, 14, 734, 302);
		contentPane.add(xw);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBackground(new Color(165, 42, 42));
		xw.addTab("Sepet", null, panel, null);
		panel.setLayout(null);
		
		JButton btnSatinal = new JButton("Siparisi Onayla");
		btnSatinal.setBackground(new Color(100, 149, 237));
		btnSatinal.setForeground(new Color(0, 0, 0));
		btnSatinal.setBounds(594, 10, 125, 21);
		panel.add(btnSatinal);
		
		JScrollPane xw_scrollSepet = new JScrollPane();
		xw_scrollSepet.setBackground(new Color(255, 255, 255));
		xw_scrollSepet.setBounds(0, 0, 584, 275);
		panel.add(xw_scrollSepet);
		
		table_sepet = new JTable();
		xw_scrollSepet.setViewportView(table_sepet);	
		
		
		Connection con4 = conn.connDb();
    try {
    		
    		Statement st = con4.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM sepet");
            yemekModel.setColumnCount(0);
            yemekModel.setRowCount(0);
        	yemekModel.setColumnIdentifiers(yemekData);
    		yemekData = new Object[3];
    		while(rs.next()){
    			yemekData[0] = rs.getInt("sepet_id");
    			yemekData[1] = rs.getString("yemekadi");
    			yemekData[2] = rs.getString("yemekfiyati")+" TL";
    			yemekModel.addRow(yemekData);
    		}
    		table_sepet.setModel(yemekModel);
    	
	} catch (Exception e) {
	}
    						
	JButton btnBack = new JButton("Geri");
	btnBack.setBackground(new Color(100, 149, 237));
	btnBack.setForeground(new Color(0, 0, 0));
	btnBack.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			new Menu().setVisible(true);
            hide();
		}
	});
		btnBack.setBounds(594, 246, 74, 19);
		panel.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("TOPLAM TUTAR");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(604, 40, 104, 33);
		panel.add(lblNewLabel);
		
		Connection con6 = conn.connDb();
		JEditorPane editorPane = new JEditorPane();
		editorPane.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		editorPane.setForeground(new Color(255, 255, 255));
		editorPane.setBackground(new Color(165, 42, 42));
		try {
			Statement st6 = con6.createStatement();
            ResultSet rs = st6.executeQuery("SELECT SUM(yemekfiyati) AS fiyat FROM sepet");
            while(rs.next()) {
    			String yemekfiyati = rs.getString("fiyat")+"TL";
    			editorPane.setText(yemekfiyati);
    		}
		} catch (Exception e) {	
		}
		editorPane.setBounds(614, 69, 94, 33);
		panel.add(editorPane);
		
		JButton btnDelButton = new JButton("Sil");
		btnDelButton.setBackground(new Color(100, 149, 237));
		btnDelButton.setForeground(new Color(0, 0, 0));
		btnDelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con2 = conn.connDb();
				DefaultTableModel model = (DefaultTableModel) table_sepet.getModel();
		        int row = table_sepet.getSelectedRow();
		        int eve = (int) table_sepet.getModel().getValueAt(row, 0);
		        try {
		        	Statement sorgu = con2.createStatement();
		        	sorgu.executeUpdate("DELETE FROM sepet where sepet_id= "+eve);
		        	model.removeRow(table_sepet.getSelectedRow());
		        	ResultSet rs = sorgu.executeQuery("SELECT SUM(yemekfiyati) AS fiyat FROM sepet");
		            while(rs.next()) {
		    			String yemekfiyati = rs.getString("fiyat")+"TL";
		    			editorPane.setText(yemekfiyati);
		    		}
		        }catch(Exception e) {
		        	System.out.println(e);
		        }
				
			
			}
		});
		btnDelButton.setBounds(594, 116, 55, 46);
		panel.add(btnDelButton);
		
		
		
	
    btnSatinal.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Connection con2 = conn.connDb();
	        try {	        
	        	Statement sorgu = con2.createStatement();
	        	sorgu.executeUpdate("DELETE FROM sepet");
	        	Helper.showMsg("fill2");
	        }catch(Exception e) {	        
	        	System.out.println(e);
	        }
	       
		}
	});
	}
}
