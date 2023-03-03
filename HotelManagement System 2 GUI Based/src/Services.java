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
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public interface Services {

	public abstract void description() throws IOException;
}

class OrderFood extends JFrame implements Services,ActionListener{
	JTextField t5;
	private double cost;
	String line="";
	public void display_menu() throws FileNotFoundException {
		FileInputStream file=new FileInputStream("C:\\Users\\HP\\OneDrive\\Desktop\\"+"FoodMenu.txt");
		 DataInputStream r=new DataInputStream(file);
	       
         String line;
         JFrame f2=new JFrame("FOOD MENU");
			f2.setSize(600,600);
			f2.setLocationRelativeTo(null);
			f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
			f2.setVisible(true);
			
			JPanel p1 = new JPanel();
			 p1.setBackground(Color.white);
			p1.setLayout(new FlowLayout());
			JLabel l;
		 try {
			while((line = r.readLine()) != null) {
					
					l=new JLabel(line);
					l.setHorizontalAlignment(SwingConstants.CENTER);
					 l.setFont(new Font("Calibri", Font.BOLD, 20));
					 p1.add(l);
					 f2.add(p1);
			}
			 r.close();
	         setVisible(true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 JLabel l1 = new JLabel("Enter Food Items: ");
		 l1.setHorizontalAlignment(SwingConstants.CENTER);
		 l1.setFont(new Font("Calibri", Font.BOLD, 36));
		p1.add(l1);
		t5 = new JTextField(15);
		p1.add(t5);
		
		
		JButton b=new JButton("PROCEED");
		p1.add(b);
		f2.add(p1);
		b.addActionListener(this);
		f2.setVisible(true);
		
			try {
				r.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
}
	public String orderFood() throws IOException {
		
		String[] food_items=t5.getText().split(",");
		line=t5.getText();
		//System.out.println(line);
		for(int j=0;j<food_items.length;j++) {
			if(food_items[j]!=null) {
	    if(food_items[j].equalsIgnoreCase("Chicken Burger")) {
	    	cost+=350;
	    }else if(food_items[j].equalsIgnoreCase("Zinger Burger")) {
	    	cost+=420;
	    }else if(food_items[j].equalsIgnoreCase("Fish Burger")) {
	    	cost+=390;
	    }else if(food_items[j].equalsIgnoreCase("Beef Burger")) {
	    	cost+=550;
	    }else if(food_items[j].equalsIgnoreCase("Chicken Tikka Pizza")) {
	    	cost+=440;
	    }else if(food_items[j].equalsIgnoreCase("Chicken Fajita Pizza")) {
	    	cost+=410;
	    }else if(food_items[j].equalsIgnoreCase("Cheese Lover Pizza")) {
	    	cost+=350;
	    }else if(food_items[j].equalsIgnoreCase("Hot n Spicy Pizza")) {
	    	cost+=420;
	    }else if(food_items[j].equalsIgnoreCase("Plain Fries")) {
	    	cost+=110;
	    }else if(food_items[j].equalsIgnoreCase("Mayo Fries")) {
	    	cost+=190;
	    }else if(food_items[j].equalsIgnoreCase("Masala Friesr")) {
	    	cost+=140;
	    }else if(food_items[j].equalsIgnoreCase("Curly Fries")) {
	    	cost+=200;
	    }else if(food_items[j].equalsIgnoreCase("Fettucine Alferado Pasta")) {
	    	cost+=520;
	    }else if(food_items[j].equalsIgnoreCase("Crunchy Chicken Pasta")) {
	    	cost+=580;
	    }else if(food_items[j].equalsIgnoreCase("Water") || food_items[j].equalsIgnoreCase("Juice") || food_items[j].equalsIgnoreCase("Soft Drink") || food_items[j].equalsIgnoreCase("Fresh Lime") ) {
	    	cost+=90;
	    }else if(food_items[j].equalsIgnoreCase("Vanila ice-cream") || food_items[j].equalsIgnoreCase("Chocolate ice-cream") || food_items[j].equalsIgnoreCase("Strawberry ice-cream") || food_items[j].equalsIgnoreCase("Mango ice-cream")) {
	    	cost+=80;
	    	
	    }
	    }
		}
		
		//System.out.println(Arrays.toString(food_items));
	        return line;
		  
	}
	@Override
	public void description() throws IOException {
	
		String[] food_items=line.split(",");
		JFrame f2=new JFrame();
		f2.setSize(500,500);
		f2.setLocationRelativeTo(null);
		f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f2.setVisible(true);
		
		JLabel l=new JLabel("The ordered items are: ");
		l.setHorizontalAlignment(SwingConstants.CENTER);
		 l.setFont(new Font("Calibri", Font.BOLD, 20));
		 JPanel p1 = new JPanel();
		 p1.setBackground(Color.white);
		 p1.add(l);
		 f2.add(p1);
		//System.out.println("The ordered items are: "+(array.length>1? "are ":"is ")+": ");
		for(int i=0;i<food_items.length;i++) {
			
			 JLabel l1=new JLabel(food_items[i]+"  ");
				l1.setHorizontalAlignment(SwingConstants.CENTER);
				 l1.setFont(new Font("Calibri", Font.BOLD, 20));
				 p1.add(l1);
				 f2.add(p1);
			//System.out.println(array[i]);
		}
		JButton b=new JButton("RETURN");
		
		p1.add(b);
		
		f2.add(p1);
		
		b.addActionListener(this);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("OK")){
			JFrame f2=new JFrame();
				f2.setSize(300,300);
				f2.setLocationRelativeTo(null);
				f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
				f2.setVisible(true);
				JLabel l=new JLabel("Data Stored");
				l.setHorizontalAlignment(SwingConstants.CENTER);
				 l.setFont(new Font("Calibri", Font.BOLD, 20));
				 JPanel p1=new JPanel();
					p1.add(l);
					f2.add(p1);
					
					 JButton jb=new JButton("RETURN");
					 
					 p1.add(jb);
					 
					 f2.add(p1);
					 jb.addActionListener(this);
				
		}else if(e.getActionCommand().equals("RETURN")){
			new CustomerTasks();
		}else if (e.getActionCommand().equals("PROCEED")){
			try {
				orderFood();
			} catch (IOException e4) {
				
				e4.printStackTrace();
			}
			 JFrame f2=new JFrame();
				f2.setSize(300,300);
				f2.setLocationRelativeTo(null);
				f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
				
				
				JPanel p1 = new JPanel();
				 p1.setBackground(Color.white);
				p1.setLayout(new FlowLayout());
				JLabel l=new JLabel("Total cost is: "+cost);
				l.setHorizontalAlignment(SwingConstants.CENTER);
				 l.setFont(new Font("Calibri", Font.BOLD, 20));
				 p1.add(l);
				 f2.add(p1);
				
				JLabel l1 = new JLabel("Enter Enter customer id for payment: ");
				 l1.setHorizontalAlignment(SwingConstants.CENTER);
				 l1.setFont(new Font("Calibri", Font.BOLD, 16));
				p1.add(l1);
				t5 = new JTextField(15);
				p1.add(t5);
				
				
				JButton b=new JButton("PAY");
				
				p1.add(b);
				
				f2.add(p1);
				
				b.addActionListener(this);
				
				f2.setVisible(true);
			
		}else if(e.getActionCommand().equals("SHOW MY ORDER")) {
			try {
				description();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		}
			 
		else if(e.getActionCommand().equals("PAY")) {
			 Payments p = null;
				try {
					p = new Payments();
				} catch (IOException e3) {
					e3.printStackTrace();
				}
				  Random rand = new Random();
			        int rand_int1 = rand.nextInt(1000);
			        
			        p.payment_id=rand_int1;
	                p.payment_customer_id=Integer.parseInt(t5.getText());
			        p.payment_amount=cost;
			        p.payment_description="Food Payment";
			        
			        File file1=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+"Payments.txt");
			        DataOutputStream pay = null;
					try {
						pay = new DataOutputStream(new FileOutputStream(file1,true));
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
			       
			        try {
						pay.writeBytes("Payment id: "+p.payment_id+"\n");
						 pay.writeBytes("Customer id: "+p.payment_customer_id+"\n");
					        pay.writeBytes("Payment amount: "+p.payment_amount+"\n");
					        pay.writeBytes("Payment description: "+p.payment_description+"\n");
					        pay.writeBytes("***********************************************"+"\n");
					        pay.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			        JFrame f2=new JFrame();
					f2.setSize(300,300);
					f2.setLocationRelativeTo(null);
					f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
					f2.setVisible(true);
			        JPanel p1 = new JPanel();
					 p1.setBackground(Color.white);
					p1.setLayout(new FlowLayout());
					JButton b=new JButton("RETURN");
					JButton b2=new JButton("SHOW MY ORDER");
					p1.add(b);
					p1.add(b2);
					f2.add(p1);
					
					b.addActionListener(this);
					b2.addActionListener(this);
					
			
		}else if(e.getActionCommand().equals("RETURN")) {
			new CustomerTasks();
		}
		
		
	}
}
class BookRooms extends JFrame implements Services,ActionListener{
	JTextField t,t2,t5;
	private String type;
	private int rn,roomno;
	private double cost;
	
	public void book() throws IOException {
		
		JFrame f2=new JFrame();
		f2.setSize(500,500);
		f2.setLocationRelativeTo(null);
		f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		JPanel p1 = new JPanel();
		 p1.setBackground(Color.white);
		p1.setLayout(new FlowLayout());
		JLabel l=new JLabel("Enter name of person: ");
		l.setHorizontalAlignment(SwingConstants.CENTER);
		 l.setFont(new Font("Calibri", Font.BOLD, 20));
		 p1.add(l);
		 f2.add(p1);
		
	    t = new JTextField(15);
		p1.add(t);
		
		JLabel l2=new JLabel("Enter the room type (Single / Double / Triple): ");
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		 l2.setFont(new Font("Calibri", Font.BOLD, 20));
		 p1.add(l2);
		 f2.add(p1);
		
		 t2 = new JTextField(15);
			p1.add(t2);
		 JButton b=new JButton("OK FOR BOOKING");
			p1.add(b);
			f2.add(p1);
			b.addActionListener(this);
			f2.setVisible(true);
			
	  
		
	}
	@Override
	public void description() throws IOException {
		
		 JFrame f2=new JFrame();
			f2.setSize(300,300);
			f2.setLocationRelativeTo(null);
			f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
			f2.setVisible(true);
			
		 JPanel p1 = new JPanel();
		 p1.setBackground(Color.white);
		p1.setLayout(new FlowLayout());
		
		JLabel l=new JLabel("Room Booked Successfully :) ");
		l.setHorizontalAlignment(SwingConstants.CENTER);
		l.setFont(new Font("Calibri", Font.BOLD, 20));
									 
		 p1.add(l);
		JButton b=new JButton("RETURN");
		p1.add(b);
		f2.add(p1);
		
		b.addActionListener(this);
				
				
		
	}
	public void roomPayment() {
		cost=30000;
		
		 JFrame f2=new JFrame();
			f2.setSize(500,300);
			f2.setLocationRelativeTo(null);
			f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
			f2.setVisible(true);
			
			JPanel p1 = new JPanel();
			 p1.setBackground(Color.white);
			p1.setLayout(new FlowLayout());
			JLabel l=new JLabel("Total cost is: "+cost);
			l.setHorizontalAlignment(SwingConstants.CENTER);
			 l.setFont(new Font("Calibri", Font.BOLD, 20));
			 p1.add(l);
			 f2.add(p1);
			
			JLabel l1 = new JLabel("Enter Enter customer id for payment: ");
			 l1.setHorizontalAlignment(SwingConstants.CENTER);
			 l1.setFont(new Font("Calibri", Font.BOLD, 20));
			p1.add(l1);
			t5 = new JTextField(15);
			p1.add(t5);
			
			
			JButton b=new JButton("PROCEED");
			
			p1.add(b);
		
			f2.add(p1);
			b.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("EXIT")){
			new CustomerTasks();
		
	}else if(e.getActionCommand().equals("PROCEED")){
		 Payments p = null;
			try {
				p = new Payments();
			} catch (IOException e3) {
				e3.printStackTrace();
			}
			  Random rand = new Random();
		        int rand_int1 = rand.nextInt(1000);
		        
		        p.payment_id=rand_int1;
	            p.payment_customer_id=Integer.parseInt(t5.getText());
		        p.payment_amount=cost;
		        p.payment_description="Room Payment";
		        
		        File file1=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+"Payments.txt");
		        DataOutputStream pay = null;
				try {
					pay = new DataOutputStream(new FileOutputStream(file1,true));
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		       
		        try {
					pay.writeBytes("Payment id: "+p.payment_id+"\n");
					 pay.writeBytes("Customer id: "+p.payment_customer_id+"\n");
				        pay.writeBytes("Payment amount: "+p.payment_amount+"\n");
				        pay.writeBytes("Payment description: "+p.payment_description+"\n");
				        pay.writeBytes("***********************************************"+"\n");
				        pay.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        JFrame f2=new JFrame();
				f2.setSize(500,300);
				f2.setLocationRelativeTo(null);
				f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
				f2.setVisible(true);
				
				JPanel p1 = new JPanel();
				 p1.setBackground(Color.white);
				p1.setLayout(new FlowLayout());
				JButton b=new JButton("RETURN");
				JButton b2=new JButton("SHOW DESCRIPTION");
				p1.add(b);
				p1.add(b2);
				f2.add(p1);
				b.addActionListener(this);
				b2.addActionListener(this);
			    
	}
		else if(e.getActionCommand().equals("RETURN")){
			new CustomerTasks();
		}
		else if(e.getActionCommand().equals("OK")){
		 JFrame f2=new JFrame();
			f2.setSize(300,300);
			f2.setLocationRelativeTo(null);
			f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
			f2.setVisible(true);
			JLabel l=new JLabel("Data Stored");
			l.setHorizontalAlignment(SwingConstants.CENTER);
			 l.setFont(new Font("Calibri", Font.BOLD, 20));
			 JPanel p1=new JPanel();
				p1.add(l);
				f2.add(p1);
				
				 JButton jb=new JButton("RETURN");
				 
				 p1.add(jb);
				 
				 f2.add(p1);
				 jb.addActionListener(this);
				
			
	}else if(e.getActionCommand().equals("SHOW DESCRIPTION")){
		try {
			description();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
		else if(e.getActionCommand().equals("OK FOR BOOKING")) {
			Rooms r=new Rooms();
			
			File file=null;
			 String line="";
			 JFrame f=new JFrame();
				switch(t2.getText()) {
				case "Single":
				
					SingleRoom sr=new SingleRoom();
				   file=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+"SingleRoom.txt");
				    if(file.exists()) {
				    DataInputStream dis = null;
					try {
						dis = new DataInputStream(new FileInputStream(file));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				    try {
				    	
						while((line = dis.readLine()) != null) {
							
							String[] array=line.split(" ");
							if(line.startsWith("Room No: ")) {
								String roomNo=array[array.length-1];
								rn=Integer.parseInt(roomNo);
							}
							
							if(line.startsWith("Room Status: ") && line.endsWith("Not Booked")) {
								//foundSingle=true;
								f.setSize(300,300);
								f.setLocationRelativeTo(null);
								f.setDefaultCloseOperation(EXIT_ON_CLOSE);
								JLabel j=new JLabel("Single Room "+rn+" is available!");
								j.setHorizontalAlignment(SwingConstants.CENTER);
								 j.setFont(new Font("Calibri", Font.BOLD, 20));
								 f.add(j);
								 
								sr.editRooms(rn,file,"SingleRoom.txt");
								break;
								
							
							
						}
						}
					} catch (NumberFormatException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					// System.out.println("File not exists!");
					JLabel j=new JLabel("FILE DOESN'T EXIST!");
					 j.setHorizontalAlignment(SwingConstants.CENTER);
					j.setFont(new Font("Calibri", Font.BOLD, 32));
					
					 f.add(j);
					 
	                 JButton jb=new JButton("EXIT");
					 f.add(jb);
					 jb.addActionListener(this);
					 return;
				 }
					break;
				case "Double":
					
					DoubleRoom dr=new DoubleRoom();
				   
					 file=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+"DoubleRoom.txt");
					 if(file.exists()) {
						    DataInputStream dis = null;
							try {
								dis = new DataInputStream(new FileInputStream(file));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
						    try {
								while((line = dis.readLine()) != null) {
									
									String[] array=line.split(" ");
									if(line.startsWith("Room No: ")) {
										String roomNo=array[array.length-1];
										rn=Integer.parseInt(roomNo);
									}
									if(line.startsWith("Room Status: ") && line.endsWith("Not Booked")) {
										//JFrame f=new JFrame();
										f.setSize(300,300);
										f.setLocationRelativeTo(null);
										f.setDefaultCloseOperation(EXIT_ON_CLOSE);
										JLabel j=new JLabel("Double Room "+rn+" is available!");
										j.setHorizontalAlignment(SwingConstants.CENTER);
										 j.setFont(new Font("Calibri", Font.BOLD, 20));
										 f.add(j);
										 
									
											dr.editRooms(rn,file,"DoubleRoom.txt");
										break;
										
										//System.out.println("Room no: "+rn+" booked successfully");
								}
								
}
							} catch (NumberFormatException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					 }else {
						// System.out.println("File not exists!");
						 JLabel j=new JLabel("FILE DOESN'T EXIST!");
						 j.setHorizontalAlignment(SwingConstants.CENTER);
						j.setFont(new Font("Calibri", Font.BOLD, 32));
						
						 f.add(j);
						 
		                 JButton jb=new JButton("EXIT");
						 f.add(jb);
						 jb.addActionListener(this);
						 return;
						
					 }
						break;
				case "Triple":
				
					TripleRoom tr=new TripleRoom();
				  
					 file=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+"TripleRoom.txt");
					 if(file.exists()) {
						    DataInputStream dis = null;
							try {
								dis = new DataInputStream(new FileInputStream(file));
							} catch (FileNotFoundException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
						    try {
								while((line = dis.readLine()) != null) {
									
									String[] array=line.split(" ");
									if(line.startsWith("Room No: ")) {
										String roomNo=array[array.length-1];
										rn=Integer.parseInt(roomNo);
									}
									if(line.startsWith("Room Status: ") && line.endsWith("Not Booked")) {
										//JFrame f=new JFrame();
										f.setSize(300,300);
										f.setLocationRelativeTo(null);
										f.setDefaultCloseOperation(EXIT_ON_CLOSE);
										JLabel j=new JLabel("Triple Room "+rn+" is available!");
										j.setHorizontalAlignment(SwingConstants.CENTER);
										 j.setFont(new Font("Calibri", Font.BOLD, 20));
										 f.add(j);
										 
										tr.editRooms(rn,file,"TripleRoom.txt");
										break;
										//System.out.println("Room no: "+rn+" booked successfully");
								}
								
}
							} catch (NumberFormatException | IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					 }else {
							// System.out.println("File not exists!");
						 JLabel j=new JLabel("FILE DOESN'T EXIST!");
						 j.setHorizontalAlignment(SwingConstants.CENTER);
						j.setFont(new Font("Calibri", Font.BOLD, 32));
						
						 f.add(j);
						 
		                 JButton jb=new JButton("EXIT");
						 f.add(jb);
						 jb.addActionListener(this);
						 return;	 
					 }
						break;
					
				}
				
		}
	}
}
class DoLaundary extends JFrame implements Services,ActionListener{
	
	private double cost;
	
	 JTextField t1,t2,t3,t4,t5;
	public void doLaundary() throws IOException {
		setLayout(new GridLayout(6, 1));
		setSize(700,500);
		 setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		 JLabel l1,l2,l3,l4;
		 JButton b1,b2,b3;
		 JPanel p,p1,p2,p3;
		 
		 p = new JPanel();
		 p.setBackground(Color.white);
		l1= new JLabel("Laundary Information");
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
		
		l2 = new JLabel("Enter Phone: ");
		p1.add(l2);
		t2 = new JTextField(15);
		p1.add(t2);
		add(p1);
		p2 = new JPanel();
		 p2.setBackground(Color.white);
		p2.setLayout(new FlowLayout());
		l3 = new JLabel("Enter Room no: ");
		p2.add(l3);
		t3 = new JTextField(15);
		p2.add(t3);
		l4 = new JLabel("Enter clothes amount: ");
		p2.add(l4);
		t4 = new JTextField(15);
		p2.add(t4);
		add(p2);
		
		 p3 = new JPanel();
		 p3.setBackground(Color.white);
		 p3.setLayout(new FlowLayout());
		 b1 = new JButton("LAUNDARY ENTER");
		 b2 = new JButton("RETURN TO HOME");
		
		 p3.add(b1);
		 p3.add(b2);
		JPanel p4=new JPanel();
		 p4.setBackground(Color.white);
		 JPanel p5=new JPanel();
		 p5.setBackground(Color.white);
		b1.addActionListener(this);
		 b2.addActionListener(this);
		
		 add(p3);
		 add(p4);
		 add(p5);
		 setVisible(true);
		 
		 
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("LAUNDARY ENTER")){
			 String yourfilename="Laundary.txt";
			 File file=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+yourfilename);
			  try {
				if(file.createNewFile()) {
						System.out.println("File created successfully");
					}
			} catch (IOException e4) {
				// TODO Auto-generated catch block
				e4.printStackTrace();
			}
			  String n=t4.getText();
			  System.out.println(n);
			  if(Integer.parseInt(n)<10) {
				  cost=500;
			  }else if(Integer.parseInt(t4.getText())>10 && Integer.parseInt(t4.getText())<15) {
				  cost=1000;
			  }else {
				  cost=1500;
			  }
			  
			  JFrame f2=new JFrame();
				f2.setSize(300,300);
				f2.setLocationRelativeTo(null);
				f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
				
				
				JPanel p1 = new JPanel();
				 p1.setBackground(Color.white);
				p1.setLayout(new FlowLayout());
				JLabel l=new JLabel("Total cost is: "+cost);
				l.setHorizontalAlignment(SwingConstants.CENTER);
				 l.setFont(new Font("Calibri", Font.BOLD, 20));
				 p1.add(l);
				 f2.add(p1);
				
				JLabel l1 = new JLabel("Enter Enter customer id for payment: ");
				 l1.setHorizontalAlignment(SwingConstants.CENTER);
				 l1.setFont(new Font("Calibri", Font.BOLD, 16));
				p1.add(l1);
				t5 = new JTextField(15);
				p1.add(t5);
				JButton b=new JButton("PAY");
				
				p1.add(b);
				f2.add(p1);
				
				b.addActionListener(this);
				
				f2.setVisible(true);
			
		}else if(e.getActionCommand().equals("SHOW DESCRIPTION")) {
			try {
				description();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			 
		else if(e.getActionCommand().equals("PAY")) {
			 Payments p = null;
				try {
					p = new Payments();
				} catch (IOException e3) {
					e3.printStackTrace();
				}
				  Random rand = new Random();
			        int rand_int1 = rand.nextInt(1000);
			        
			        p.payment_id=rand_int1;
	                p.payment_customer_id=Integer.parseInt(t5.getText());
			        p.payment_amount=cost;
			        p.payment_description="Laundary Payment";
			        
			        File file1=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+"Payments.txt");
			        DataOutputStream pay = null;
					try {
						pay = new DataOutputStream(new FileOutputStream(file1,true));
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
			       
			        try {
						pay.writeBytes("Payment id: "+p.payment_id+"\n");
						 pay.writeBytes("Customer id: "+p.payment_customer_id+"\n");
					        pay.writeBytes("Payment amount: "+p.payment_amount+"\n");
					        pay.writeBytes("Payment description: "+p.payment_description+"\n");
					        pay.writeBytes("***********************************************"+"\n");
					        pay.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			        File file=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+"Laundary.txt");
			        DataOutputStream fw = null;
					try {
						fw = new DataOutputStream(new FileOutputStream(file,true));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				  try {
					fw.writeBytes("Customer Name: "+t1.getText()+"\n");
					  fw.writeBytes("Customer Phone Number: "+t2.getText()+"\n");
					  fw.writeBytes("Customer Room Number: "+t3.getText()+"\n");
					  fw.writeBytes("Number of clothes: "+t4.getText()+"\n");
					  fw.writeBytes("***************************************"+"\n");
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
			        JPanel p1 = new JPanel();
					 p1.setBackground(Color.white);
					p1.setLayout(new FlowLayout());
					JButton b=new JButton("RETURN");
					JButton b2=new JButton("SHOW DESCRIPTION");
					p1.add(b);
					p1.add(b2);
					f2.add(p1);
					
					b.addActionListener(this);
					b2.addActionListener(this);
								
		}else if(e.getActionCommand().equals("RETURN")) {
			new CustomerTasks();
		}
		else if(e.getActionCommand().equals("OK")){
			 JFrame f2=new JFrame();
				f2.setSize(300,300);
				f2.setLocationRelativeTo(null);
				f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
				f2.setVisible(true);
				JLabel l=new JLabel("Data Stored");
				l.setHorizontalAlignment(SwingConstants.CENTER);
				 l.setFont(new Font("Calibri", Font.BOLD, 20));
				JPanel p1=new JPanel();
				p1.add(l);
				f2.add(p1);
				
				 JButton jb=new JButton("RETURN");
				 
				 p1.add(jb);
				 
				 f2.add(p1);
				 jb.addActionListener(this);
				
				
		}else if(e.getActionCommand().equals("RETURN TO HOME")){
			new CustomerTasks();
		}
		
	}
	@Override
	public void description() throws IOException {
		
		JFrame f2=new JFrame();
		f2.setSize(600,600);
		f2.setLocationRelativeTo(null);
		f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f2.setVisible(true);
		
		
		 String yourfilename="Laundary.txt";
		 File file=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+yourfilename);
		 JPanel p1 = new JPanel();
 		 p1.setBackground(Color.white);
		 if(file.exists()) {
		 DataInputStream r=new DataInputStream(new FileInputStream(file));
		
		 String line;
		
         while ((line = r.readLine()) != null) {
        	 JLabel l=new JLabel(line+"  ");
     		l.setHorizontalAlignment(SwingConstants.CENTER);
     		 l.setFont(new Font("Calibri", Font.BOLD, 20));
     		 p1.add(l);
     		 f2.add(p1);
     		 
        	// System.out.println(line);
         }
         r.close();
		 }else {
			 JLabel l=new JLabel("File doesn't exists!");
	     		l.setHorizontalAlignment(SwingConstants.CENTER);
	     		 l.setFont(new Font("Calibri", Font.BOLD, 20));
	     		 p1.add(l);
	     		 f2.add(p1);
		 }
		 JButton b=new JButton("RETURN");
		 p1.add(b);
		 f2.add(p1);
		 b.addActionListener(this);
	}
	
}
