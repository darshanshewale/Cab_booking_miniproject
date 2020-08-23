package cab_booking;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import java.awt.Color;

import java.sql.*;
public class Admin_end extends JFrame {

	private JPanel contentPane;
	private JTextField usernm;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_end frame = new Admin_end();
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
	public Admin_end() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(81, 94, 81, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(81, 142, 81, 14);
		contentPane.add(lblPassword);
		
		usernm = new JTextField();
		usernm.setText("");
		usernm.setBounds(205, 93, 113, 20);
		contentPane.add(usernm);
		usernm.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(Color.GREEN);
		btnLogin.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			String uname=usernm.getText();
			String pass=password.getText();
			//#####################SQL#######################
			int i=0;
			 try
			    {
			      
			      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/cab_booking?autoReconnect=true&useSSL=false", "root", "root");
			      
			      String query = "select * from admin";

			      // create the java statement
			      Statement st = conn.createStatement();
			      
			      // execute the query, and get a java resultset"
			      ResultSet rs = st.executeQuery(query);
			      
			      // iterate through the java resultset
			      while (rs.next())
			      {
			        //int id = rs.getInt("id");
			        String sqlname = rs.getString("usrnm");
			        String sqlpass = rs.getString("pass");
			        
			        // print the results
			       
			        
			        
			        // System.out.format("%s, %s", usrName, pass);
			      
			      
			      
			        if(uname.equals(sqlname) & pass.equals(sqlpass) )
					{
						
			        	 i =1;
					}
					
			       
			      
			      
			      }
			      st.close();
			    }
			    catch (Exception e1)
			    {
			      System.err.println("Got an exception! ");
			      System.err.println(e1.getMessage());
			    }

			
		
			 if(i==1 )
				{
				 	dispose();
					Ad_Customer_Detail sframe=new  Ad_Customer_Detail();
					
					sframe.setVisible(true);
				
				}
				
		        else {
		        	dispose();
		        	Admin_end lframe=new Admin_end();
					JOptionPane.showMessageDialog(lframe, "Incorrect password or Username !!!");
				}
		      
			
			
			
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.setBounds(168, 193, 89, 30);
		contentPane.add(btnLogin);
		
		JLabel lblAdmin = new JLabel("LOGIN");
		lblAdmin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAdmin.setBounds(168, 28, 89, 20);
		contentPane.add(lblAdmin);
		
		password = new JPasswordField();
		password.setBounds(205, 141, 113, 19);
		contentPane.add(password);
	}
}
