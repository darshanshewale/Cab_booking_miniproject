package cab_booking;
    	        

import java.awt.*;

import java.awt.event.*;

import java.sql.*;

import java.util.Vector;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;

 

public class Ad_Show_Customer_Data extends JFrame implements ActionListener {

 

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

    String[] columnNames = {"Name ", "ID", "User Name ","Password ","Confirm Password"};

    String from;
    private JButton btnNewButton;

 

    Ad_Show_Customer_Data() {

 

        l0 = new JLabel("Fetching Customer Detail");

        l0.setForeground(Color.ORANGE);

        l0.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));

        l1 = new JLabel("Select Username:");
        l1.setFont(new Font("Times New Roman", Font.BOLD, 18));

        b1 = new JButton("submit");
        b1.setFont(new Font("Times New Roman", Font.BOLD, 17));

 

        l0.setBounds(75, 24, 350, 40);

        l1.setBounds(75, 110, 139, 20);

        b1.setBounds(259, 202, 150, 40);

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

            rs = st.executeQuery("select tnm from   traveller_signup");

            Vector v = new Vector();

            while (rs.next()) {

                unm = rs.getString(1);

                v.add(unm);

            }

            c1 = new JComboBox(v);

            c1.setBounds(259, 112, 150, 20);


            btnNewButton= new JButton("<-Back");
            btnNewButton.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		Ad_Customer_Detail a = new  Ad_Customer_Detail();
            		a.setVisible(true);
            	}
            });
            btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 11));
            btnNewButton.setBounds(10, 11, 67, 23);
            getContentPane().add(btnNewButton);



            getContentPane().add(c1);
          
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

        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        String Name = "";

        String ID = "";

        String Usernm= "";

        String Password = "";

        String CPassword = "";


        try {

            pst = con.prepareStatement("select * from traveller_signup where tnm='" + from + "'");

            ResultSet rs = pst.executeQuery();

            int i = 0;

            if (rs.next()) {

                Name = rs.getString("tnm");

                ID = rs.getString("tid");

                Usernm= rs.getString("unm");

                Password = rs.getString("tpass");
                
                CPassword = rs.getString("tcpass");

                model.addRow(new Object[]{Name, ID, Usernm ,Password, CPassword});

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

        new Ad_Show_Customer_Data();

    }

}