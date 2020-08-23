
package cab_booking;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class CE_Traveller_Authen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CE_Traveller_Authen frame = new CE_Traveller_Authen();
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
	public CE_Traveller_Authen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CE_Traveller_Lg clgn = new CE_Traveller_Lg();
				clgn.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(125, 55, 167, 56);
		contentPane.add(btnNewButton);
		
		JButton btnSignup = new JButton("SIGNUP");
		btnSignup.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSignup.setBounds(125, 151, 167, 56);
		contentPane.add(btnSignup);
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CE_Traveller_Sup clgn = new CE_Traveller_Sup();
				clgn.setVisible(true);
			}
		});
		
		
		JLabel lblTraveller = new JLabel("TRAVELLER");
		lblTraveller.setBounds(10, 11, 56, 14);
		contentPane.add(lblTraveller);
		
		
		
	}
}
