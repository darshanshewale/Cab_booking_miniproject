package cab_booking;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ad_Customer_Detail extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ad_Customer_Detail frame = new Ad_Customer_Detail();
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
	public Ad_Customer_Detail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Customer Booking Detail");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ad_Show_Booking_Detail bd = new Ad_Show_Booking_Detail ();
				bd.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(85, 80, 239, 46);
		contentPane.add(btnNewButton);
		
		JButton btnCustomerLoginDetail = new JButton("Customer Login Detail");
		btnCustomerLoginDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Ad_Show_Customer_Data cd = new Ad_Show_Customer_Data ();
				cd.setVisible(true);
		
			}
		});
		btnCustomerLoginDetail.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnCustomerLoginDetail.setBounds(85, 165, 239, 46);
		contentPane.add(btnCustomerLoginDetail);
		
		JLabel lblSelectType = new JLabel("Select Type :");
		lblSelectType.setFont(new Font("Matura MT Script Capitals", Font.BOLD, 25));
		lblSelectType.setBounds(108, 23, 193, 25);
		contentPane.add(lblSelectType);
	}
}
