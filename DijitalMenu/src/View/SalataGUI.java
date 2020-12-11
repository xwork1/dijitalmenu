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

public class SalataGUI extends JFrame {

    private JPanel xw;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SalataGUI frame = new SalataGUI();
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
    public SalataGUI() {
        setBackground(Color.LIGHT_GRAY);
        setTitle("SALATALAR");
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
            ResultSet rs = st.executeQuery("SELECT * FROM yemekler where kategori_id = '" + 3 + "'");
            int i = 0;
            JToggleButton[] btnSalatalist = new JToggleButton[50];
            int h1 = 1;
            int h,w=-190;
            while (rs.next()) {
            	btnSalatalist[i] = new JToggleButton(rs.getString("yemekAdi")+"("+rs.getInt("fiyati")+")");
               
                if (i % 3 == 0) {
                    System.out.println("ok");
                    h1 = 1;
                    w+=200;
                }
                
               h = h1 * 10;
                
               btnSalatalist[i].setBounds(w, h, 190, 88);
                xw.add(btnSalatalist[i]);
                i++;
                h1+=10;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalataGUI.class.getName()).log(Level.SEVERE, null, ex);
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