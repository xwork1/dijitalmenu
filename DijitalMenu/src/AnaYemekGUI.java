
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

public class AnaYemekGUI extends JFrame {

	private JPanel xw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnaYemekGUI frame = new AnaYemekGUI();
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
	public AnaYemekGUI() {
		setBackground(Color.LIGHT_GRAY);
		setTitle("ANA YEMEKLER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 420);
		xw = new JPanel();
		xw.setBackground(Color.WHITE);
		xw.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(xw);
		xw.setLayout(null);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("IZGARA");
		tglbtnNewToggleButton.setBounds(10, 10, 190, 88);
		xw.add(tglbtnNewToggleButton);
		
		JToggleButton tglbtnNewToggleButton_1 = new JToggleButton("KEBAB");
		tglbtnNewToggleButton_1.setBounds(10, 114, 190, 88);
		xw.add(tglbtnNewToggleButton_1);
		
		JToggleButton tglbtnNewToggleButton_1_1 = new JToggleButton("TANDIR");
		tglbtnNewToggleButton_1_1.setBounds(210, 114, 190, 88);
		xw.add(tglbtnNewToggleButton_1_1);
		
		JToggleButton tglbtnNewToggleButton_1_2 = new JToggleButton("KUÞBAÞI");
		tglbtnNewToggleButton_1_2.setBounds(210, 10, 190, 88);
		xw.add(tglbtnNewToggleButton_1_2);
		
		JButton btnNewButton = new JButton("Geri");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 new Menu().setVisible(true);
				 hide();
			}
		});
		btnNewButton.setBounds(611, 10, 85, 21);
		xw.add(btnNewButton);
	}
}
