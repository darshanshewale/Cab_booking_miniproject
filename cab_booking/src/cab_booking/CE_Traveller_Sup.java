package cab_booking;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.sql.*;
public class CE_Traveller_Sup extends JFrame {

	private JPanel contentPane;
	private JTextField tnm ;
	private JTextField tusernm ;
	private JTextField tid ;
	private JPasswordField passwordField;
	private JPasswordField tcpass ;
	private JTextField tpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CE_Traveller_Sup frame = new CE_Traveller_Sup();
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
	public CE_Traveller_Sup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Traveller Name :");
		lblNewLabel.setBounds(25, 72, 97, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Create Username :");
		lblNewLabel_1.setBounds(25, 122, 97, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Create Password :");
		lblNewLabel_2.setBounds(25, 147, 97, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Confirm Password :");
		lblNewLabel_3.setBounds(25, 172, 97, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Join Now");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
					String confirm_pass =  tcpass .getText();
					String password1 =  tpass.getText();
			                                                 
			        String Trvnm = tnm .getText();
			        String Trvid = tid .getText();
			        String Trvusernm = tusernm .getText();
			        
			            System.out.println(Trvnm);
			            System.out.println(Trvid);
			            System.out.println(Trvusernm);
			        if(Trvnm.equals(""))
			        {
			            JOptionPane.showMessageDialog(null, "Add Traveller Name");
			        }
			        
			        else if(Trvid.equals(""))
			        {
			            JOptionPane.showMessageDialog(null, "Add ID");
			        }
			        else if(Trvusernm.equals(""))
			        {
			            JOptionPane.showMessageDialog(null, "Add User Name");
			        }
			        else{
			            
			        
			        	try
			            {
			        		
			              // create a mysql database connection
			             String myDriver = "org.gjt.mm.mysql.Driver";
			             // String myUrl = "jdbc:mysql://localhost/test";
			              Class.forName(myDriver);
		   			              if(password1.equals(confirm_pass)) {
			
		   			            	java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_booking?autoReconnect=true&useSSL=false", "root", "root");

		  			              // the mysql insert statement
		  			              String query = " insert into Traveller_Signup (tnm, tID,unm, tpass,tcpass)"
		  			                + " values (?, ?, ?, ?, ?)";

		  			              // create the mysql insert preparedstatement
		  			              PreparedStatement preparedStmt = conn.prepareStatement(query);
		  			              preparedStmt.setString (1, Trvnm);
		  			              preparedStmt.setString (2, Trvid);
		  			              preparedStmt.setString   (3, Trvusernm);
		  			              preparedStmt.setString(4, password1);
		  			              preparedStmt.setString  (5, confirm_pass);

		  			              // execute the preparedstateme
		  			              preparedStmt.execute();
		  			              
		  			              conn.close();
		  			              dispose();
		  			            CE_Traveller_Lg CLn=new CE_Traveller_Lg();
								CLn.setVisible(true);
							
							}
							else
							{
								CE_Traveller_Sup Csup=new CE_Traveller_Sup();
								JOptionPane.showMessageDialog(Csup, "Password Dont matched....");
							}
							
			            }
			            catch (Exception e1)
			            {
			              System.err.println("Got an exception!");
			              System.err.println(e1.getMessage());
			            }
			        
			   
			        }
			   	
				
		}
		});
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(175, 213, 103, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblStudentEmailId = new JLabel("Enter Adhar NO. :");
		lblStudentEmailId.setBounds(24, 97, 97, 14);
		contentPane.add(lblStudentEmailId);
		
		JLabel lblNewLabel_4 = new JLabel("Sign Up");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_4.setBounds(167, 26, 97, 23);
		contentPane.add(lblNewLabel_4);
		
		tnm = new JTextField();
		tnm .setBounds(145, 69, 256, 20);
		contentPane.add(tnm );
		tnm .setColumns(10);
		
		tusernm =  new JTextField();
		tusernm .setBounds(145, 119, 256, 20);
		contentPane.add(tusernm );
		tusernm .setColumns(10);
		
		tid = new JTextField();
		tid .setBounds(145, 94, 256, 20);
		contentPane.add(tid );
		tid .setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(199, 172, -47, 17);
		contentPane.add(passwordField);
		
		tcpass = new JPasswordField();
		tcpass .setBounds(145, 169, 143, 20);
		contentPane.add(tcpass );
		
		
		
		
		tpass= new JTextField();
		tpass.setBounds(145, 144, 143, 20);
		contentPane.add(tpass);
		tpass.setColumns(10);
		
		
		
		
	}

}
