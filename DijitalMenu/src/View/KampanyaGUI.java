package View;
import Help.DBConnection;
import Main.Menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KampanyaGUI extends JFrame {

    private JPanel xw;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    KampanyaGUI frame = new KampanyaGUI();
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
    public KampanyaGUI() {
        setBackground(Color.LIGHT_GRAY);
        setTitle("KAMPANYALAR");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 720, 420);
        xw = new JPanel();
        xw.setBackground(Color.WHITE);
        xw.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(xw);
        xw.setLayout(null);

        DBConnection db = new DBConnection();
        Connection c = db.connDb();

        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM kampanyalar");
            int i = 0;
            JToggleButton[] btnKampanyalist = new JToggleButton[50];
            int[] dizi = new int[50];
            String[] dizi2 = new String[50];
            int h1 = 1;
            int h,w=-190;
            while (rs.next()) {
            	btnKampanyalist[i] = new JToggleButton(rs.getString("kampanya_adi")+"("+rs.getInt("kampanya_fiyati")+" TL)");
                dizi[i] = rs.getInt("kampanya_fiyati");
                dizi2[i] = rs.getString("kampanya_adi");
                if (i % 3 == 0) {
                    System.out.println("ok");
                    h1 = 1;
                    w+=200;
                }
                
               h = h1 * 10;
                
               btnKampanyalist[i].setBounds(w, h, 190, 88);
                xw.add(btnKampanyalist[i]);
               final int p = i;
                btnKampanyalist[i].addActionListener(new ActionListener() {
                	
                    public void actionPerformed(ActionEvent arg0) {
                    	System.out.println(btnKampanyalist[p].getText());
                       try {
						Statement st2 = c.createStatement();
						st2.executeUpdate("INSERT INTO sepet (yemekadi,yemekfiyati) VALUES ('"+dizi2[p]+"','"+dizi[p]+"')");
					} catch (SQLException e) {					
						e.printStackTrace();
					}
                       
                    }
                });
                i++;
                h1+=10;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KampanyaGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JButton btnBackButton = new JButton("Geri");
        btnBackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new Menu().setVisible(true);
                hide();
            }
        });
        btnBackButton.setBounds(611, 10, 85, 21);
        xw.add(btnBackButton);
    }
}