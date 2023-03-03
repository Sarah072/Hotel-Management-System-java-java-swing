import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Customers extends JFrame implements ActionListener{

	protected String customer_name;
	protected int customer_id;
	protected String customer_mobile;
	protected String customer_email;
	protected String customer_username;
	protected String customer_password;
	protected String customer_address;
	private OrderFood f=new OrderFood();
	
	private JTextField t1,t2;
	public Customers() {
		
	}
	public Customers(String name,int id,String mobile,String email,
	String username,String password,String address) {
		this.customer_name=name;
		this.customer_id=id;
		this.customer_mobile=mobile;
		this.customer_email=email;
		this.customer_username=username;
		this.customer_password=password;
		this.customer_address=address;
	
	}
	public void Registration() throws IOException, ClassNotFoundException  {
		Receptionist r=new Receptionist();
		r.RegisterCustomer();
	}
	public void CheckOut(String name) throws IOException {
		Receptionist r=new Receptionist();
		r.deleteCustomer(name);
	}
	
	public void bookRoom() throws IOException {
		BookRooms br=new BookRooms();
		br.book();
	}
	
	public void giveFeedBack() throws IOException {
		setLayout(new GridLayout(3, 1));
		setSize(800,600);
		 setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		 JLabel l1,l2,l3;
		 JButton b1,b2;
		 JPanel p,p1,p2;
		 
		 p = new JPanel();
		 p.setBackground(Color.white);
		l1= new JLabel("ENTER FEEDBACK");
		 l1.setHorizontalAlignment(SwingConstants.CENTER);
		 l1.setFont(new Font("Calibri", Font.BOLD, 36));
		p.add(l1);
		 add(p);
		 
		p1 = new JPanel();
		 p1.setBackground(Color.white);
		p1.setLayout(new FlowLayout());
		
		l1 = new JLabel("Enter Name: ");
		p1.add(l1);
		t1 = new JTextField(15);
		p1.add(t1);
		
		l2 = new JLabel("Enter Feedback: ");
		p1.add(l2);
		t2 = new JTextField(15);
		p1.add(t2);
		add(p1);
		
		
		 p2 = new JPanel();
		 p2.setBackground(Color.white);
		 p2.setLayout(new FlowLayout());
		 
		 b1 = new JButton("FEEDBACK ENTER");
		 b2 = new JButton("RETURN TO HOME");
		
		 p2.add(b1);
		 p2.add(b2);
		
		
		b1.addActionListener(this);
		 b2.addActionListener(this);
		
		 add(p2);
		 setVisible(true);
		
		}
	
	public void complain() throws IOException {
		setLayout(new GridLayout(3, 1));
		setSize(800,600);
		 setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		 JLabel l1,l2,l3;
		 JButton b1,b2;
		 JPanel p,p1,p2;
		 
		 p = new JPanel();
		 p.setBackground(Color.white);
		l1= new JLabel("RECORD COMPLAIN");
		 l1.setHorizontalAlignment(SwingConstants.CENTER);
		 l1.setFont(new Font("Calibri", Font.BOLD, 36));
		p.add(l1);
		 add(p);
		 
		p1 = new JPanel();
		 p1.setBackground(Color.white);
		p1.setLayout(new FlowLayout());
		
		l1 = new JLabel("Enter Name: ");
		p1.add(l1);
		t1 = new JTextField(15);
		p1.add(t1);
		
		l2 = new JLabel("Enter complain: ");
		p1.add(l2);
		t2 = new JTextField(15);
		p1.add(t2);
		add(p1);
		
		
		 p2 = new JPanel();
		 p2.setBackground(Color.white);
		 p2.setLayout(new FlowLayout());
		 
		 b1 = new JButton("COMPLAIN ENTER");
		 b2 = new JButton("RETURN TO HOME");
		
		 p2.add(b1);
		 p2.add(b2);
		
		
		b1.addActionListener(this);
		 b2.addActionListener(this);
		
		 add(p2);
		 setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand().equals("COMPLAIN ENTER")){
			 String yourfilename="CustomerComplaints.txt";
			 File file=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+yourfilename);
			  try {
				if(file.createNewFile()) {
						System.out.println("File created successfully");
					}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			  
		    DataOutputStream fw = null;
			try {
				fw = new DataOutputStream(new FileOutputStream(file,true));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				fw.writeBytes("Name: "+t1.getText()+"\n");
				fw.writeBytes("Complain: "+t2.getText()+"\n");
				fw.writeBytes("************************************"+"\n");
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			JFrame f2=new JFrame();
			f2.setSize(300,300);
			f2.setLocationRelativeTo(null);
			f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
			f2.setVisible(true);
			JLabel l=new JLabel("Complaint Added!");
			l.setHorizontalAlignment(SwingConstants.CENTER);
			 l.setFont(new Font("Calibri", Font.BOLD, 20));
			 JPanel p1=new JPanel();
				p1.add(l);
				f2.add(p1);
				
				 JButton jb=new JButton("RETURN");
				 
				 p1.add(jb);
				 
				 f2.add(p1);
				 jb.addActionListener(this);
		}
		else if(e.getActionCommand().equals("FEEDBACK ENTER")) {
			 String yourfilename="CustomerFeedBack.txt";
			 File file=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+yourfilename);
			  try {
				if(file.createNewFile()) {
						System.out.println("File created successfully");
					}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			  
		    DataOutputStream fw = null;
			try {
				fw = new DataOutputStream(new FileOutputStream(file,true));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				fw.writeBytes("Name: "+t1.getText()+"\n");
				fw.writeBytes("FeedBack: "+t2.getText()+"\n");
				fw.writeBytes("************************************"+"\n");
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			JFrame f2=new JFrame();
			f2.setSize(300,300);
			f2.setLocationRelativeTo(null);
			f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
			f2.setVisible(true);
			JLabel l=new JLabel("FEEDBACK ADDED!");
			l.setHorizontalAlignment(SwingConstants.CENTER);
			 l.setFont(new Font("Calibri", Font.BOLD, 20));
			 JPanel p1=new JPanel();
				p1.add(l);
				f2.add(p1);
				
				 JButton jb=new JButton("RETURN");
				 
				 p1.add(jb);
				 
				 f2.add(p1);
				 jb.addActionListener(this);
				
			
		}
		else if(e.getActionCommand().equals("RETURN TO HOME")) {
			dispose();
			new Menu().setVisible(true);
		}
		else if(e.getActionCommand().equals("RETURN")){
			new CustomerTasks();
		}
		
	}
		
	
	
	public void laundary() throws IOException {
		DoLaundary laundary=new DoLaundary();
		laundary.doLaundary();
		
	}
}
