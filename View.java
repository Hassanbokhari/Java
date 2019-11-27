package pkg;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane; 
import javax.swing.JTable;
import java.sql.*;

import javax.swing.JOptionPane;


class View{
	private JTable table; 
	private String[][] columnData = new String[10][6];
	private String [] columnName = {"Roll Number", "Name", "Father Name", "Gender", "Email", "Address"};
	JFrame frame = new JFrame("Database Search");
	private Database db = new Database();

	public View(){

		JTextField t1 = new JTextField("Enter Name Here: ");
		t1.setBounds(350, 50, 300, 30);  
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	    JButton btn = new JButton("Search");
	    btn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	db.Search(t1.getText());
		    }
		});
	    btn.setBounds(450, 85,200,40);  
	    frame.add(btn, BorderLayout.NORTH);  
	    frame.add(t1, BorderLayout.NORTH);
	    frame.setSize(1000,600); 
	    frame.setVisible(true); 

	}
    public static void main(String args[]) {
    	new View();
	}

	class Database {

	private Connection cn;
	private Statement st;
	public ResultSet rs;
	
	
	public void connect()
	{
		try {
			cn = DriverManager.getConnection("jdbc:mysql://localhost/Student", "root", "");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection Not Possible");
			JOptionPane.showMessageDialog(null, "Connection Not Possible");
		}
		
	}
	
	public void print(ResultSet r)
	{
		int count = 0;
		int row = 0;
		ResultSetMetaData rsmd;
		try {
			rsmd = r.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
		   while (r.next()) {
		       for (int i = 1; i <= columnsNumber; i++) {
		           if (i > 1) System.out.print(",  ");
		           String columnValue = r.getString(i);
		           columnData[row][count] = columnValue;
		           count += 1;
		           System.out.print(columnValue);
		       }
		       row += 1;
		       System.out.println("");
		   }
		   JFrame f = new JFrame(); 
		   f.setTitle("Data"); 
		   table = new JTable(columnData, columnName);
		   table.setBounds(500, 100, 300, 90);
		   table.setVisible(true);
		   JScrollPane sp = new JScrollPane(table); 
	       frame.add(sp, BorderLayout.CENTER); 
	       frame.setVisible(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet Search(String Name) {
		connect();
		String query1 = "SELECT * FROM student where Name like '%" + Name + "%'";
		try {
			st = cn.createStatement();
			ResultSet rs = st.executeQuery(query1);
			print(rs);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Not foud");
			return rs;
		}
	}
}
}