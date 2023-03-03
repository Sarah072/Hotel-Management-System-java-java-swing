import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Manager extends JFrame implements ActionListener{
	private JButton b;
	public String manager_name;
	public int manager_id;
	public String maager_address;
	public String manager_phone;
	public void viewFeedBack() throws IOException {
		
		 JPanel p=null; 
		 JFrame f = null;
		 JLabel l1,l2;
		 String yourfilename="CustomerFeedBack.txt";
		 File file=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+yourfilename);
	
		 if(file.exists()) {
			// setLayout(new GridLayout(6, 1));
			  f=new JFrame("Customer FeedBack");
				f.setSize(800,800);
				 f.setLocationRelativeTo(null);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				f.setVisible(true); 
				 l1 = new JLabel("                         CUSTOMER FEEDBACKS                     ");
				 l1.setHorizontalAlignment(SwingConstants.CENTER);
				 l1.setFont(new Font("Calibri", Font.BOLD, 36));
				 p = new JPanel();
				 p.setBackground(Color.PINK);
				p.add(l1);
				
				 f.add(p);
				
				 
		 DataInputStream r=new DataInputStream(new FileInputStream(file));
		
		 String line;
		// p1 = new JPanel();
    	 //p1.setBackground(Color.white);
         while ((line = r.readLine()) != null) {
        	
        	 l2=new JLabel(line+"            ");
        	 l2.setHorizontalAlignment(SwingConstants.CENTER);
			 l2.setFont(new Font("Calibri", Font.BOLD, 24));
			
			 p.add(l2);
	         f.add(p);
        	// System.out.println(line);
         }
        
         r.close();
         setVisible(true);
		 }else {
			 l2=new JLabel("FILE DOESN'T EXIST!");
			 l2.setHorizontalAlignment(SwingConstants.CENTER);
			 l2.setFont(new Font("Calibri", Font.BOLD, 32));
			 p.add(l2);
			 f.add(p);
			// System.out.println("File doesn't exists!");
		 } p.add(new JLabel("                                             "));
		 
		 b=new JButton("EXIT");
		 p.add(b);
		 f.add(p);
		 b.addActionListener(this);
		 setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		
		 if(e.getSource()==b) {
			 dispose();
			 
			 new ManagerTasks();
	     }
}
		 
	public void viewComplaints() throws IOException {
		 JPanel p=null; 
		 JFrame f = null;
		 JLabel l1,l2;
		 String yourfilename="CustomerComplaints.txt";
		 File file=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+yourfilename);
	
		 if(file.exists()) {
			// setLayout(new GridLayout(6, 1));
			  f=new JFrame("Customer Complaints");
				f.setSize(800,800);
				 f.setLocationRelativeTo(null);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				f.setVisible(true); 
				 l1 = new JLabel("                   CUSTOMER COMPLAINTS               ");
				 l1.setHorizontalAlignment(SwingConstants.CENTER);
				 l1.setFont(new Font("Calibri", Font.BOLD, 36));
				 p = new JPanel();
				 p.setBackground(Color.PINK);
				p.add(l1);
				
				 f.add(p);
				
				 
		 DataInputStream r=new DataInputStream(new FileInputStream(file));
		
		 String line;
		// p1 = new JPanel();
    	 //p1.setBackground(Color.white);
         while ((line = r.readLine()) != null) {
        	
        	 l2=new JLabel(line+"            ");
        	 l2.setHorizontalAlignment(SwingConstants.CENTER);
			 l2.setFont(new Font("Calibri", Font.BOLD, 24));
			
			 p.add(l2);
	         f.add(p);
        	// System.out.println(line);
         }
        
         r.close();
         setVisible(true);
		 }else {
			 l2=new JLabel("FILE DOESN'T EXIST!");
			 l2.setHorizontalAlignment(SwingConstants.CENTER);
			 l2.setFont(new Font("Calibri", Font.BOLD, 32));
			 p.add(l2);
			 f.add(p);
			// System.out.println("File doesn't exists!");
		 }
		 p.add(new JLabel("                                             "));
		 b=new JButton("EXIT");
		 p.add(b);
		 f.add(p);
		 b.addActionListener(this);
		 setVisible(true);
	}
	public void viewRoomsInfo() throws IOException {
		 JPanel p=null; 
		 JFrame f = null;
		 JLabel l1,l2;
		 File file=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+"SingleRoom.txt");
	
		 if(file.exists()) {
			// setLayout(new GridLayout(6, 1));
			  f=new JFrame("Registered Rooms");
				f.setSize(800,800);
				 f.setLocationRelativeTo(null);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				f.setVisible(true); 
				 l1 = new JLabel("                   REGISTERED ROOMS                     ");
				 l1.setHorizontalAlignment(SwingConstants.CENTER);
				 l1.setFont(new Font("Calibri", Font.BOLD, 36));
				 p = new JPanel();
				 p.setBackground(Color.PINK);
				p.add(l1);
				
				 f.add(p);
				
				 
		 DataInputStream r=new DataInputStream(new FileInputStream(file));
		
		 String line;
		// p1 = new JPanel();
    	 //p1.setBackground(Color.white);
         while ((line = r.readLine()) != null) {
        	
        	 l2=new JLabel(line+"                     ");
        	 l2.setHorizontalAlignment(SwingConstants.CENTER);
			 l2.setFont(new Font("Calibri", Font.BOLD, 24));
			
			 p.add(l2);
	         f.add(p);
        	// System.out.println(line);
         }
         r.close();
         File file2=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+"DoubleRoom.txt");
			
		 DataInputStream dis2=new DataInputStream(new FileInputStream(file2));
         String line2;
		 
         while ((line2 = dis2.readLine()) != null) {
        	 l2=new JLabel(line2+"                     ");
        	 l2.setHorizontalAlignment(SwingConstants.CENTER);
			 l2.setFont(new Font("Calibri", Font.BOLD, 24));
			
			 p.add(l2);
	         f.add(p);
         }
         dis2.close();
         File file3=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+"TripleRoom.txt");
			
		 DataInputStream dis3=new DataInputStream(new FileInputStream(file3));
	   
		 System.out.println("Triple Rooms");
		 String line3;
		 
         while ((line3 = dis3.readLine()) != null) {
        	 l2=new JLabel(line3+"                    ");
        	 l2.setHorizontalAlignment(SwingConstants.CENTER);
			 l2.setFont(new Font("Calibri", Font.BOLD, 24));
			
			 p.add(l2);
	         f.add(p);
         }
         dis3.close();
         setVisible(true);
		 }else {
			 l2=new JLabel("FILE DOESN'T EXIST!");
			 l2.setHorizontalAlignment(SwingConstants.CENTER);
			 l2.setFont(new Font("Calibri", Font.BOLD, 32));
			 p.add(l2);
			 f.add(p);
			// System.out.println("File doesn't exists!");
		 }
		 p.add(new JLabel("                                             "));
		 b=new JButton("EXIT");
		 p.add(b);
		 f.add(p);
		 b.addActionListener(this);
		 setVisible(true);
 }
   
	public void viewRegisteredGuest() throws IOException {
		 JPanel p=null; 
		 JFrame f = null;
		 JLabel l1,l2;
		 File file=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+"Registered customers.txt");
	
		 if(file.exists()) {
			  f=new JFrame("Customer FeedBack");
				f.setSize(800,800);
				 f.setLocationRelativeTo(null);
				f.setDefaultCloseOperation(EXIT_ON_CLOSE);
				f.setVisible(true); 
				 l1 = new JLabel("                      REGISTERED CUSTOMERS                   ");
				 l1.setHorizontalAlignment(SwingConstants.CENTER);
				 l1.setFont(new Font("Calibri", Font.BOLD, 36));
				 p = new JPanel();
				 p.setBackground(Color.PINK);
				p.add(l1);
				
				 f.add(p);
				
				 
		 DataInputStream r=new DataInputStream(new FileInputStream(file));
		
		 String line;
		int count=0;
         while ((line = r.readLine()) != null) {
        	
        	 if(count==5) {
        		 JPanel p1=new JPanel();
        		 p1.setBackground(Color.PINK);
        		 l2=new JLabel(line+"            ");
            	 l2.setHorizontalAlignment(SwingConstants.CENTER);
    			 l2.setFont(new Font("Calibri", Font.BOLD, 24));
    			
    			 p1.add(l2);
    	         f.add(p1);
    	         count=1;
        	 }else {
        	 l2=new JLabel(line+"            ");
        	 l2.setHorizontalAlignment(SwingConstants.CENTER);
			 l2.setFont(new Font("Calibri", Font.BOLD, 24));
			
			 p.add(l2);
	         f.add(p);
	         count++; //1 //2//3//4//5
        	// System.out.println(line);
         }
         }
        
         r.close();
         setVisible(true);
		 }else {
			 l2=new JLabel("FILE DOESN'T EXIST!");
			 l2.setHorizontalAlignment(SwingConstants.CENTER);
			 l2.setFont(new Font("Calibri", Font.BOLD, 32));
			 p.add(l2);
			 f.add(p);
			// System.out.println("File doesn't exists!");
		 }
         p.add(new JLabel("                                             "));
		 b=new JButton("EXIT");
		 p.add(b);
		 f.add(p);
		 b.addActionListener(this);
		 setVisible(true);
		 
	}
}