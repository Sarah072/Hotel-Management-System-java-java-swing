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
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Receptionist extends JFrame implements ActionListener
{

	private String receptionist_name;
	private int receptionist_id;
	private String receptionist_mobile;
	private String receptionist_email;
	private String receptionist_address;
	protected String All_data="";
	private JTextField t1,t2,t3,t4,t5,t6,t7,t11,t22,t33,t44,t55,t66,t77;
	public Receptionist() throws IOException {
		
	}
	public String getName() {
		return receptionist_name;
	}public int getId() {
		return receptionist_id;
	}public String getMobile() {
		return receptionist_mobile;
	}public String getEmail() {
		return receptionist_email;
	}public String getAddress() {
		return receptionist_address;
	}
	public void RegisterCustomer() throws IOException, ClassNotFoundException {
		setLayout(new GridLayout(6, 1));
		setSize(800,600);
		 setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		 JLabel l1,l2,l3,l4,l5,l6,l7,l8;
		 JButton b1,b2,b3;
		 JPanel p,p1,p2,p3,p4,p5,p6;
		 
		 p = new JPanel();
		 p.setBackground(Color.white);
		l1= new JLabel("REGISTER CUSTOMER");
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
		l2 = new JLabel("Enter Id: ");
		p1.add(l2);
		t2 = new JTextField(15);
		p1.add(t2);
		add(p1);
		p2 = new JPanel();
		 p2.setBackground(Color.white);
		p2.setLayout(new FlowLayout());
		l3 = new JLabel("Enter Phone: ");
		p2.add(l3);
		t3 = new JTextField(15);
		p2.add(t3);
		l4 = new JLabel("Enter email: ");
		p2.add(l4);
		t4 = new JTextField(15);
		p2.add(t4);
		add(p2);
		p3 = new JPanel();
		 p3.setBackground(Color.white);
		p3.setLayout(new FlowLayout());
		l5 = new JLabel("Enter username: ");
		p3.add(l5);
		t5 = new JTextField(15);
		p3.add(t5);
		l6 = new JLabel("Enter password: ");
		p3.add(l6);
		t6 = new JTextField(15);
		p3.add(t6);
		add(p3);
		p4 = new JPanel();
		 p4.setBackground(Color.white);
		p4.setLayout(new FlowLayout());
		l7 = new JLabel("Enter address: ");
		p4.add(l7);
		t7 = new JTextField(15);
		p4.add(t7);
		add(p4);
		p5 = new JPanel();
		 p5.setBackground(Color.white);
		 p5.setLayout(new FlowLayout());
		 b1 = new JButton("REGISTER");
		 b2 = new JButton("RETURN TO HOME");
		
		 p5.add(b1);
		 p5.add(b2);
		
		
		b1.addActionListener(this);
		 b2.addActionListener(this);
		
		 add(p5);
		 setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand().equals("REGISTER")){
			boolean exists=false;
			String filename="Registered customers.txt";
			File file=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+filename);
			 try {
				if(file.createNewFile()) {
						System.out.println("File created successfully");
					}
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			 
			 DataInputStream scan = null;
			try {
				scan = new DataInputStream(new FileInputStream(file));
			} catch (FileNotFoundException e2) {
				
				e2.printStackTrace();
			}
			 if(file.exists()) {
			
			 String line="";
			if(file.exists()) {
				 try {
					while((line = scan.readLine()) != null) {
						if(line.endsWith(t1.getText())) {
							JFrame f2=new JFrame();
							f2.setSize(300,300);
							f2.setLocationRelativeTo(null);
							f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
							f2.setVisible(true);
							JLabel l=new JLabel("Customer already exists!");
							l.setHorizontalAlignment(SwingConstants.CENTER);
							 l.setFont(new Font("Calibri", Font.BOLD, 20));
							 

							 JPanel jp=new JPanel();
							 jp.add(l);
							 f2.add(jp);
							 JButton jb=new JButton("RETURN AS RECEPTIONIST");
							 JButton jb2=new JButton("RETURN AS CUSTOMER");
							 
							 jp.add(jb);
							 jp.add(jb2);
							 f2.add(jp);
							 jb.addActionListener(this);
							 jb2.addActionListener(this);
							
							 
							exists=true;
						}
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else {
				System.out.println("File doesn't exist");
				try {
					scan.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			if(exists==false) {
				 DataOutputStream fileWriter = null;
				try {
					fileWriter = new DataOutputStream(new FileOutputStream(file,true));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			try {
				fileWriter.writeBytes("Customer name: "+t1.getText()+"\n");
				fileWriter.writeBytes("Customer id: "+t2.getText()+"\n");
				fileWriter.writeBytes("Customer phone number: "+t3.getText()+"\n");
				fileWriter.writeBytes("Customer email: "+t4.getText()+"\n");
				fileWriter.writeBytes("Customer username: "+t5.getText()+"\n");
				fileWriter.writeBytes("Customer password: "+t6.getText()+"\n");
				fileWriter.writeBytes("Customer address: "+t7.getText()+"\n");
				fileWriter.close();
				
				JFrame f2=new JFrame();
				f2.setSize(300,200);
				f2.setLocationRelativeTo(null);
				f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
				f2.setVisible(true);
				JLabel l=new JLabel("Registration Successfull");
				l.setHorizontalAlignment(SwingConstants.CENTER);
				 l.setFont(new Font("Calibri", Font.BOLD, 20));
				 JPanel jp=new JPanel();
				 jp.add(l);
				 f2.add(jp);
				 JButton jb=new JButton("RETURN AS RECEPTIONIST");
				 JButton jb2=new JButton("RETURN AS CUSTOMER");
				 
				 jp.add(jb);
				 jp.add(jb2);
				 f2.add(jp);
				 jb.addActionListener(this);
				 jb2.addActionListener(this);
				
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			
				}
			
			}
		}else if(e.getActionCommand().equals("EDIT CUSTOMER")) {
			 dispose();
	    	 All_data +="Customer name: "+t11.getText()+"\n";
    		 All_data +="Customer id: "+t22.getText()+"\n";
    		 All_data +="Customer phone number: "+t33.getText()+"\n";
    		 All_data +="Customer email: "+t44.getText()+"\n";
    		 All_data +="Customer username: "+t55.getText()+"\n";
    		 All_data +="Customer password: "+t55.getText()+"\n";
    		 All_data +="Customer address: "+t55.getText()+"\n";
    		 
    		// System.out.println(All_data);
    		 File oldFile1=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+"Registered customers.txt");
    	        boolean x = oldFile1.delete();
    	        
    	        
    	       /* if(!found){
    		        nl = new JLabel("Customer name not found!");
    				 nl.setHorizontalAlignment(SwingConstants.CENTER);
    				 nl.setFont(new Font("Calibri", Font.BOLD, 36));
    				 np.add(nl);
    				 f.add(np);
    				 
    	             JButton jb=new JButton("EXIT");
    				 
    				 np.add(jb);
    				 f.add(np);
    				 jb.addActionListener(this);
    				
    		    }*/
    		 
    		 
    		 File file=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+"Registered customers.txt");
    		DataOutputStream fileWriter = null;
			try {
				fileWriter = new DataOutputStream(new FileOutputStream(file));
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
    		try {
				fileWriter.writeBytes(All_data);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				fileWriter.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	 JFrame f2=new JFrame();
				f2.setSize(500,500);
				 f2.setLocationRelativeTo(null);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				f2.setVisible(true); 
				JPanel p=new JPanel();
				p.setBackground(Color.pink);
				JLabel l2=new JLabel("Customer information Updated Successfully!");
			  	 l2.setHorizontalAlignment(SwingConstants.CENTER);
					l2.setFont(new Font("Calibri", Font.BOLD, 24));
					p.add(l2);
					f2.add(p);

					JButton b=new JButton("EXIT");
					p.add(b);
					 f2.add(p);
					// f2.add(p2);
					 b.addActionListener(this);
					 
				 
	
}

		
		else  if(e.getActionCommand().equals("EXIT")) {
			 dispose();
			 
			 new ReceptionistTasks();
	     }else if(e.getActionCommand().equals("RETURN AS RECEPTIONIST")) {
	    	 dispose();
	    	 new ReceptionistTasks();
	     }else if(e.getActionCommand().equals("RETURN AS CUSTOMER")) {
	    	 dispose();
	    	 new CustomerTasks();
	     }
		
		else if(e.getActionCommand().equals("RETURN TO HOME")) {
			dispose();
			new Menu().setVisible(true);
		}
		
	}
	public void deleteCustomer(String name) throws IOException {
		String filename="Registered customers.txt";
		 File oldFile=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+filename);
		 boolean found=false;
		 JLabel l1=null;
		 JPanel p1= new JPanel();;
			JFrame f=new JFrame("Delete Customer");
			f.setSize(300,300);
			 f.setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			f.setVisible(true); 
			if(oldFile.exists()) {
		 DataInputStream scan=new DataInputStream(new FileInputStream(oldFile));
	       String line="";
	        String All_data = "";
	        while((line = scan.readLine()) != null) {
	            if (line.toLowerCase().endsWith(name.toLowerCase())){
	               scan.readLine();
	                scan.readLine();
	                scan.readLine();
	               scan.readLine();
	               scan.readLine();
	                scan.readLine();
	             
	                found=true;
	            }
	            else
	                All_data += (line+"\n");
	        }
	        scan.close();
	        boolean x = oldFile.delete();
	        
	        if(found) {
	        	l1 = new JLabel("Data Deleted Successfully!");
			 l1.setHorizontalAlignment(SwingConstants.CENTER);
			 l1.setFont(new Font("Calibri", Font.BOLD, 20));
			 
			 p1.setBackground(Color.PINK);
			 p1.add(l1);
			 f.add(p1);
			 
			
			 JButton jb=new JButton("RETURN AS RECEPTIONIST");
			 JButton jb2=new JButton("RETURN AS CUSTOMER");
			 
			 p1.add(jb);
			 p1.add(jb2);
			 f.add(p1);
			 jb.addActionListener(this);
			 jb2.addActionListener(this);
			
	        } if(!found){
		        l1 = new JLabel("Customer name not found!");
				 l1.setHorizontalAlignment(SwingConstants.CENTER);
				 l1.setFont(new Font("Calibri", Font.BOLD, 20));
				 p1.add(l1);
				 f.add(p1);
				 JButton jb=new JButton("RETURN AS RECEPTIONIST");
				 JButton jb2=new JButton("RETURN AS CUSTOMER");
				 
				 p1.add(jb);
				 p1.add(jb2);
				 f.add(p1);
				 jb.addActionListener(this);
				 jb2.addActionListener(this);
				
				
		    }
			
	        File newFile = new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+filename);
	      newFile.createNewFile();
	        DataOutputStream fileWriter=new DataOutputStream(new FileOutputStream(newFile));
	        fileWriter.writeBytes(All_data);
	        fileWriter.close();
	      
			}else {
				 l1=new JLabel("FILE DOESN'T EXIST!");
				 l1.setHorizontalAlignment(SwingConstants.CENTER);
				 l1.setFont(new Font("Calibri", Font.BOLD, 20));
				 p1.add(l1);
				 f.add(p1);
				 JButton jb=new JButton("RETURN AS RECEPTIONIST");
				 JButton jb2=new JButton("RETURN AS CUSTOMER");
				 
				 p1.add(jb);
				 p1.add(jb2);
				 f.add(p1);
				 jb.addActionListener(this);
				 jb2.addActionListener(this);
				
			}
	}
	public void editCustomer(String name) throws IOException {
		String filename="Registered customers.txt";
		File oldFile=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+filename);
		 JLabel nl=null;
		 JPanel np= new JPanel();
		JFrame f=new JFrame("Edit Customer");
			f.setSize(500,300);
			 f.setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			f.setVisible(true); 
		DataInputStream scan=new DataInputStream(new FileInputStream(oldFile));
	        Scanner input = new Scanner(System.in);
	       
	        String line;
	        boolean found=false;
	        if(oldFile.exists()) {
	        while((line = scan.readLine()) != null) {
	           
	            if (line.toLowerCase(Locale.ROOT).endsWith(name.toLowerCase(Locale.ROOT))){
	                scan.readLine();
	                scan.readLine();
	                scan.readLine();
	                scan.readLine();
	                scan.readLine();
	                scan.readLine();
	                scan.readLine();
	                
	                setLayout(new GridLayout(6, 1));
	        		setSize(800,600);
	        		 setLocationRelativeTo(null);
	        		setDefaultCloseOperation(EXIT_ON_CLOSE);
	        		setVisible(true);
	        		
	        		 JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	        		 JButton b1,b2,b3;
	        		 JPanel p,p1,p2,p3,p4,p5,p6;
	        		 
	        		 p = new JPanel();
	        		 p.setBackground(Color.white);
	        		l1= new JLabel("Name Found. Enter Updated Data");
	        		 l1.setHorizontalAlignment(SwingConstants.CENTER);
	        		 l1.setFont(new Font("Calibri", Font.BOLD, 36));
	        		p.add(l1);
	        		 add(p);
	        		p1 = new JPanel();
	        		 p1.setBackground(Color.white);
	        		p1.setLayout(new FlowLayout());
	        		l1 = new JLabel("Enter Name: ");
	        		p1.add(l1);
	        		t11 = new JTextField(15);
	        		p1.add(t11);
	        		l2 = new JLabel("Enter Id: ");
	        		p1.add(l2);
	        		t22 = new JTextField(15);
	        		p1.add(t22);
	        		add(p1);
	        		p2 = new JPanel();
	        		 p2.setBackground(Color.white);
	        		p2.setLayout(new FlowLayout());
	        		l3 = new JLabel("Enter Phone: ");
	        		p2.add(l3);
	        		t33 = new JTextField(15);
	        		p2.add(t33);
	        		l4 = new JLabel("Enter email: ");
	        		p2.add(l4);
	        		t44 = new JTextField(15);
	        		p2.add(t44);
	        		add(p2);
	        		p3 = new JPanel();
	        		 p3.setBackground(Color.white);
	        		p3.setLayout(new FlowLayout());
	        		l5 = new JLabel("Enter username: ");
	        		p3.add(l5);
	        		t55 = new JTextField(15);
	        		p3.add(t55);
	        		l6 = new JLabel("Enter password: ");
	        		p3.add(l6);
	        		t66 = new JTextField(15);
	        		p3.add(t66);
	        		add(p3);
	        		p4 = new JPanel();
	        		 p4.setBackground(Color.white);
	        		p4.setLayout(new FlowLayout());
	        		l7 = new JLabel("Enter address: ");
	        		p4.add(l7);
	        		t77 = new JTextField(15);
	        		p4.add(t77);
	        		add(p4);
	        		p5 = new JPanel();
	        		 p5.setBackground(Color.white);
	        		 p5.setLayout(new FlowLayout());
	        		 b1 = new JButton("EDIT CUSTOMER");
	        		 b2 = new JButton("RETURN TO HOME");
	        		
	        		 p5.add(b1);
	        		 p5.add(b2);
	        		
	        		
	        		b1.addActionListener(this);
	        		 b2.addActionListener(this);
	        		
	        		 add(p5);
	        		 setVisible(true);
	        		 found=true;
	              
	  
	    		    
	        		
	            } else
	                All_data += (line+"\n");
	        }
	        if(!found){
		        nl = new JLabel("Customer name not found!");
				 nl.setHorizontalAlignment(SwingConstants.CENTER);
				 nl.setFont(new Font("Calibri", Font.BOLD, 36));
				 np.add(nl);
				 f.add(np);
				 
	             JButton jb=new JButton("EXIT");
				 
				 np.add(jb);
				 f.add(np);
				 jb.addActionListener(this);
				 f.setVisible(true);
	        }
	        scan.close();
	       
	        }else {
	        	 nl=new JLabel("FILE DOESN'T EXIST!");
				 nl.setHorizontalAlignment(SwingConstants.CENTER);
				 nl.setFont(new Font("Calibri", Font.BOLD, 32));
				 np.add(nl);
				 f.add(np);
				 
                 JButton jb=new JButton("EXIT");
				 
				 np.add(jb);
				 f.add(np);
				 jb.addActionListener(this);
	        }
	}
	public void findCustomer(String name) throws IOException {
		JLabel l1=null;
		JPanel p1=null;
		String filename="Registered customers.txt";
		File oldFile=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+filename);
		DataInputStream scan=new DataInputStream(new FileInputStream(oldFile));
		boolean found=false;
		JFrame f=new JFrame("Search Customer");
			f.setSize(500,300);
			 f.setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			f.setVisible(true); 
			 p1 = new JPanel();
	       
	       
	        String l="";
	        int i=1;
	        while((l = scan.readLine()) != null) {
	         
	            if (l.toLowerCase().endsWith(name.toLowerCase())){
	               // System.out.println("Entity found...\n"+line);
	            	found=true;
	               
	                	while(i<=7) {
	                	 l1 = new JLabel(l);
	    				 l1.setHorizontalAlignment(SwingConstants.CENTER);
	    				 l1.setFont(new Font("Calibri", Font.BOLD, 20));
	    				
	    				 p1.setBackground(Color.PINK);
	    				 p1.add(l1);
	    				 f.add(p1);
	    				 l=scan.readLine();
	                	 i++;
	                	}
	                	  JButton jb=new JButton("EXIT");
	     				 
	     				 p1.add(jb);
	     				 f.add(p1);
	     				 jb.addActionListener(this);
	              
	                scan.close();
	                //new Menu2().setVisible(true);
	                return;
	                
	            }
	        }
	        if(!found) {
	        l1 = new JLabel("Customer name not found!");
			 l1.setHorizontalAlignment(SwingConstants.CENTER);
			 l1.setFont(new Font("Calibri", Font.BOLD, 20));
			 p1.add(l1);
			 f.add(p1);
			 
			 
			 JButton jb=new JButton("EXIT");
			 
			 p1.add(jb);
			 f.add(p1);
			 jb.addActionListener(this);
	        }
	       

	}
	
	public void viewRoomsInfo() throws IOException {
		 JButton b=null;
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
	   
		// System.out.println("Triple Rooms");
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
			JButton b=null;
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
					 l1 = new JLabel("                     REGISTERED CUSTOMERS                  ");
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
		public void setName(String name) {
			receptionist_name=name;
		}
		public void setId(int id) {
			receptionist_id=id;;
		}
		public void setMobile(String mobile) {
			receptionist_mobile=mobile;
		}
		public void setEmail(String email) {
			receptionist_email=email;
		}
		public void setAddress(String address) {
			receptionist_address=address;
		}
		
	}

	
	

