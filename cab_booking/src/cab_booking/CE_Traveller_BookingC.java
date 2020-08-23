package cab_booking;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.Color;

public class CE_Traveller_BookingC extends JFrame {

	private JPanel contentPane;
	static String usrnm ="";
	/**
	 * Launch the application.
	 */
	public static void main(String usrnm1) {
		usrnm=usrnm1;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CE_Traveller_BookingC frame = new CE_Traveller_BookingC();
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
	public CE_Traveller_BookingC() {
		
		int amt=0;
		String opq="'";
		String clq="'";
		String src= "";
        String des= "";
        String usrnm2= "";
        String a="";
        
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("!!!!  THANK YOU !!!!");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(87, 22, 266, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Username :");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblName.setBounds(36, 107, 111, 14);
		contentPane.add(lblName);
		
		JLabel lblSource = new JLabel("Source :");
		lblSource.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSource.setBounds(36, 147, 82, 14);
		contentPane.add(lblSource);
		
		JLabel lblDestination = new JLabel("Destination :");
		lblDestination.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDestination.setBounds(36, 184, 111, 14);
		contentPane.add(lblDestination);
		
		JLabel lblAmountPaid = new JLabel("Amount Paid :");
		lblAmountPaid.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAmountPaid.setBounds(36, 223, 150, 14);
		contentPane.add(lblAmountPaid);
		
		try
		{
			 java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab_booking?autoReconnect=true&useSSL=false", "root", "root");
			 String query = " select * from traveller_booking_detail where usrnm ="+opq+usrnm+clq+"";
             java.sql.Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             while(rs.next())
             {
            
            	 usrnm2 = rs.getString(1);
               src= rs.getString(2);
               des= rs.getString(3);
              amt = rs.getInt(4);
              a=""+amt;
              
              if(src.equals("1.Wagholi"))
              {
            	  src="Wagholi";
            	  
              }
              else if(src.equals("2.Sainath_Nagar"))
              {
            	  src="Sainath_Nagar";
            	  
              }
              else if(src.equals("3.VadgaonSheri"))
              {
            	  src="VadgaonSheri";
              }
              else if(src.equals("4.Kharadi"))
              {
            	  src="Kharadi";
              }
              else if(src.equals("5.Viman Nagar"))
              {
            	  src="Viman Nagar";
              }
              

              if(des.equals("1.Wagholi"))
              {
            	  des="Wagholi";
            	  
              }
              else if(des.equals("2.Sainath_Nagar"))
              {
            	  des="Sainath_Nagar";
            	  
              }
              else if(des.equals("3.VadgaonSheri"))
              {
            	  des="VadgaonSheri";
              }
              else if(des.equals("4.Kharadi"))
              {
            	  des="Kharadi";
              }
              else if(des.equals("5.Viman Nagar"))
              {
            	  des="Viman Nagar";
              }
            
             }
             
             conn.close();
             
        }
        catch (Exception e1)
        {
          System.err.println("Got an exception!");
          System.err.println(e1.getMessage());
        }
		
		JLabel lblusrnm = new JLabel(usrnm2);
		lblusrnm.setBounds(196, 109, 143, 14);
		contentPane.add(lblusrnm);
		
		JLabel lblsrc = new JLabel(src);
		lblsrc.setBounds(196, 147, 143, 14);
		contentPane.add(lblsrc);
		
		JLabel lbldes = new JLabel(des);
		lbldes.setBounds(196, 186, 143, 14);
		contentPane.add(lbldes);
		
		JLabel lblamt = new JLabel(a);
		lblamt.setBounds(196, 225, 143, 14);
		contentPane.add(lblamt);
		
		JLabel lblRideCompleted = new JLabel("::::: Ride Completed ::::");
		lblRideCompleted.setForeground(Color.BLACK);
		lblRideCompleted.setFont(new Font("Snap ITC", Font.BOLD, 18));
		lblRideCompleted.setBounds(80, 47, 236, 24);
		contentPane.add(lblRideCompleted);
		dispose();
	}

}
