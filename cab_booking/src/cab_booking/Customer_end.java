package cab_booking;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Customer_end extends JFrame {

	private static final ActionListener ActionListener = null;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_end frame = new Customer_end();
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
	public Customer_end() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnTraveller = new JButton("TRAVELLER ");
		btnTraveller.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnTraveller.setBounds(91, 101, 220, 50);
		contentPane.add(btnTraveller);
		btnTraveller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CE_Traveller_Authen ce1=new CE_Traveller_Authen();
				ce1.setVisible(true);
			}
		});
		
		
		JLabel lblChooseCustomerType = new JLabel("CHOOSE CUSTOMER TYPE  :::  ");
		lblChooseCustomerType.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblChooseCustomerType.setForeground(Color.BLACK);
		lblChooseCustomerType.setBounds(72, 35, 277, 37);
		contentPane.add(lblChooseCustomerType);
	}

}
