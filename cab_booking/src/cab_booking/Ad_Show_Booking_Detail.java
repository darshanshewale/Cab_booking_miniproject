package cab_booking;
    	        

import java.awt.*;

import java.awt.event.*;

import java.sql.*;

import java.util.Vector;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;

 

public class Ad_Show_Booking_Detail extends JFrame implements ActionListener {

 

    JFrame frame1;

    JLabel l0, l1, l2;

    JComboBox c1;

    JButton b1;

    Connection con;

    ResultSet rs, rs1;

    Statement st, st1;

    PreparedStatement pst;

    String unm;

    static JTable table;

    String[] columnNames = {"User Name ", "Source","Destination","Amount_Paid"};

    String from;
    private JButton button;

 

    Ad_Show_Booking_Detail() {

 

        l0 = new JLabel("Fetching Customer Detail");

        l0.setForeground(Color.red);

        l0.setFont(new Font("Times New Roman", Font.BOLD, 26));

        l1 = new JLabel("Select Username :");
        l1.setFont(new Font("Times New Roman", Font.BOLD, 18));

        b1 = new JButton("submit");
        b1.setFont(new Font("Times New Roman", Font.BOLD, 16));

 

        l0.setBounds(75, 26, 350, 40);

        l1.setBounds(75, 110, 144, 20);

        b1.setBounds(273, 187, 150, 40);

        b1.addActionListener(this);

 

        setTitle("Customer Detail");

        getContentPane().setLayout(null);

        setVisible(true);

        setSize(500, 500);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

 

        getContentPane().add(l0);

        getContentPane().add(l1);;

        getContentPane().add(b1);

        try {

            

            con = DriverManager.getConnection("jdbc:mysql://localhost/cab_booking?autoReconnect=true&useSSL=false", "root", "root");

            st = con.createStatement();

            rs = st.executeQuery("select usrnm from traveller_booking_detail");

            Vector v = new Vector();

            while (rs.next()) {

                unm = rs.getString(1);

                v.add(unm);

            }

            c1 = new JComboBox(v);

            c1.setBounds(273, 112, 150, 20);

 

            getContentPane().add(c1);
            
            button = new JButton("<-Back");
            button.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		Ad_Customer_Detail a = new  Ad_Customer_Detail();
            		a.setVisible(true);
            	}
            });
            button.setFont(new Font("Times New Roman", Font.BOLD, 11));
            button.setBounds(10, 11, 67, 23);
            getContentPane().add(button);

            st.close();

            rs.close();

        } catch (Exception e) {

        }

    }

 

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            showTableData();

        }

 

    }

 

    public void showTableData() {

 

        frame1 = new JFrame("Database Search Result");

        frame1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        frame1.getContentPane().setLayout(new BorderLayout());

//TableModel tm = new TableModel();

        DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(columnNames);

//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());

//table = new JTable(model);

        table = new JTable();

        table.setModel(model);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        table.setFillsViewportHeight(true);

        JScrollPane scroll = new JScrollPane(table);

        scroll.setHorizontalScrollBarPolicy(

                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        scroll.setVerticalScrollBarPolicy(

                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        from = (String) c1.getSelectedItem();

//String textvalue = textbox.getText();

        String uname = "";

        String Source = "";

        String Destination = "";

        String Amount_Paid = "";

 

        try {

            pst = con.prepareStatement("select * from traveller_booking_detail where usrnm='" + from + "'");

            ResultSet rs = pst.executeQuery();

            int i = 0;

            if (rs.next()) {

                uname = rs.getString("usrnm");

                Source = rs.getString("src");

                Destination = rs.getString("des");

                Amount_Paid = rs.getString("amount");

                model.addRow(new Object[]{uname, Source, Destination , Amount_Paid });

                i++;

            }

            if (i < 1) {

                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);

            }

            if (i == 1) {

                System.out.println(i + " Record Found");

            } else {

                System.out.println(i + " Records Found");

            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }

        frame1.getContentPane().add(scroll);

        frame1.setVisible(true);

        frame1.setSize(400, 300);

    }

 

    public static void main(String args[]) {

        new Ad_Show_Booking_Detail();

    }

}