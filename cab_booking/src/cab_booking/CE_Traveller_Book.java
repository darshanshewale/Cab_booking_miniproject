package cab_booking;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.lang.Math;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class CE_Traveller_Book extends JFrame {

	private JPanel contentPane;
	int diff =0;
	String s1="";
	int value1 =0;

	String d1 ="";
	int value2=0;
	
	int Amount =0;
	String a ="";
	private JTextField textField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CE_Traveller_Book frame = new CE_Traveller_Book();
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
	public CE_Traveller_Book() {
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterSource = new JLabel("Enter Source :");
		lblEnterSource.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEnterSource.setBounds(10, 97, 136, 27);
		contentPane.add(lblEnterSource);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"-", "1.Wagholi", "2.Sainath_Nagar", "3.VadgaonSheri", "4.Kharadi", "5.Viman Nagar"}));
		comboBox.setBounds(203, 104, 102, 16);
		contentPane.add(comboBox);
		
		JLabel lblEnterDestination = new JLabel("Enter Destination :");
		lblEnterDestination.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEnterDestination.setBounds(10, 158, 154, 14);
		contentPane.add(lblEnterDestination);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"-", "1.Wagholi", "2.Sainath_Nagar", "3.VadgaonSheri", "4.Kharadi", "5.Viman Nagar"}));
		comboBox_1.setBounds(203, 156, 102, 16);
		contentPane.add(comboBox_1);
		
		JLabel lblEnterUsername = new JLabel("Enter Username:");
		lblEnterUsername.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEnterUsername.setBounds(10, 53, 154, 14);
		contentPane.add(lblEnterUsername);
		
		textField = new JTextField();
		textField.setBounds(209, 52, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				Object s = comboBox.getSelectedItem();
				if(s!= null)
				{
					s1 = s.toString();
					
				}
				if(s1.equals("1.Wagholi"))
					{
						value1=1;
					}
					else if(s1.equals("2.Sainath_Nagar"))
					{
						value1=2;
					}
					else if(s1.equals("3.VadgaonSheri"))
					{
						value1=3;
					}
					else if(s1.equals("4.Kharadi"))
					{
						value1=4;
					}
					else if(s1.equals("5.Viman Nagar"))
					{
						value1=5;
					}
					else if(s1.equals("-"))
					{
						value1=0;
					}

			
				Object d = comboBox_1.getSelectedItem();
				if(d!= null)
				{
					d1 = d.toString();
					
				}
				if(d1.equals("1.Wagholi"))
					{
						value2=1;
					}
					else if(d1.equals("2.Sainath_Nagar"))
					{
						value2=2;
					}
					else if(d1.equals("3.VadgaonSheri"))
					{
						value2=3;
					}
					else if(d1.equals("4.Kharadi"))
					{
						value2=4;
					}
					else if(d1.equals("5.Viman Nagar"))
					{
						value2=5;
					}
					else if(d1.equals("-"))
					{
						value2=0;
					}

				
				diff = Math.abs(value2-value1);
				Amount = diff * 20;
				a = String.valueOf(Amount);
				String username="";
				 username = textField.getText();
				System.out.println(username);
				
				
				
				try
				{
					 // create a mysql database connection
		             String myDriver = "org.gjt.mm.mysql.Driver";
		             // String myUrl = "jdbc:mysql://localhost/test";
		              Class.forName(myDriver);
	   			     
		              java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_booking?autoReconnect=true&useSSL=false", "root", "root");

			              // the mysql insert statement
			              String query = " insert into Traveller_Booking_Detail(usrnm, src,des,amount)"
			                + " values (?, ?, ?, ?)";

			              // create the mysql insert preparedstatement
			              PreparedStatement preparedStmt = conn.prepareStatement(query);
			              preparedStmt.setString (1, username);
			              preparedStmt.setString (2, s1);
			              preparedStmt.setString   (3, d1);
			              preparedStmt.setInt(4, Amount);

			              // execute the preparedstateme
			              preparedStmt.execute();
			              
			              conn.close();
			              
			              dispose();
			              
			              CE_Traveller_PBook.main(username);
							CE_Traveller_PBook p = new  CE_Traveller_PBook();
							p.setVisible(true);
						
			            
				}
				 catch (Exception e1)
	            {
	              System.err.println("Got an exception!");
	              System.err.println(e1.getMessage());
	            }
			}
		});
		btnSubmit.setBounds(143, 211, 89, 23);
		contentPane.add(btnSubmit);
		
			
	}
}
