package cab_booking;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class CE_Traveller_PBook extends JFrame {

	private JPanel contentPane;
	static String usrnm1="";

	/**
	 * Launch the application.
	 */
	public static void main(String username) {
		usrnm1=username;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CE_Traveller_PBook frame = new CE_Traveller_PBook();
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
	public CE_Traveller_PBook() {
		int i=0;
		String opq="'";
		String clq="'";
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAmountToBe = new JLabel("Amount To be Paid : ");
		lblAmountToBe.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAmountToBe.setBounds(31, 48, 213, 33);
		contentPane.add(lblAmountToBe);
		try
		{
			 java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/cab_booking?autoReconnect=true&useSSL=false", "root", "root");
			 String query = " select amount from traveller_booking_detail where usrnm ="+opq+usrnm1+clq+"";
             java.sql.Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             while(rs.next())
             {
              i = rs.getInt(1);
             
             System.out.println(i);
             }
             
             conn.close();
             
        }
        catch (Exception e1)
        {
          System.err.println("Got an exception!");
          System.err.println(e1.getMessage());
        }
		String am=""+i;
		
		JLabel lblNewLabel = new JLabel(am);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(241, 59, 82, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnPay = new JButton("PAY");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CE_Traveller_BookingC.main(usrnm1);
				CE_Traveller_BookingC c =  new CE_Traveller_BookingC();
				c.setVisible(true);
			}
		});
		btnPay.setBounds(155, 131, 89, 23);
		contentPane.add(btnPay);
		
		dispose();
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				CE_Traveller_CancelTrip ct = new CE_Traveller_CancelTrip();
				ct.setVisible(true);
			}
		});
		btnCancel.setBounds(155, 195, 89, 23);
		contentPane.add(btnCancel);
	}

	
}
