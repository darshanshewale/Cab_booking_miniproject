package cab_booking;

import java.awt.BorderLayout;
import java.sql.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JEditorPane;

public class Start extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
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
	public Start() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 302);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectUserType = new JLabel("!!!!!!!WELCOME !!!!!!");
		lblSelectUserType.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblSelectUserType.setBounds(106, 44, 243, 23);
		contentPane.add(lblSelectUserType);
		
		JButton admin = new JButton("ADMIN");
		admin.setBackground(new Color(255, 200, 0));
		admin.setFont(new Font("Tahoma", Font.BOLD, 17));
		admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			Admin_end a=new Admin_end();
		
			a.setVisible(true);
				
			}
				
		});
		admin.setBounds(68, 187, 108, 23);
		contentPane.add(admin);
		
		JButton student = new JButton("CUSTOMER");
		student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				CE_Traveller_Authen ce1=new CE_Traveller_Authen();
				ce1.setVisible(true);
				
			}
		});
		student.setBackground(Color.ORANGE);
		student.setFont(new Font("Tahoma", Font.BOLD, 17));
		student.setBounds(242, 187, 144, 23);
		contentPane.add(student);
		
		JLabel lblNewLabel = new JLabel("_/\\_  WELCOME TO ONLINE CAB BOOKING  _/\\_");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel.setBounds(33, 91, 391, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblSelctUserType = new JLabel("SELCT USER TYPE....");
		lblSelctUserType.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSelctUserType.setBounds(137, 144, 165, 14);
		contentPane.add(lblSelctUserType);
	}
}
