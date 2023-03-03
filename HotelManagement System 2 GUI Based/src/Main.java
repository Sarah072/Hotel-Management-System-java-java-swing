import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		 Menu m=new Menu();
	
	}
}class Menu extends JFrame implements ActionListener{
	JButton b1,b2,b3;
	 JPanel p,p1;
	 JLabel l,l1,l3;
	JTextField t;
	
		public Menu(){
		Font f = new Font("Times New Roman",Font.BOLD,35);
		 //header
		 p1 = new JPanel(); 
		 p1.setBounds(0,0,900,100);
		 p1.setBackground(new Color(0,0,0,4));
		 JLabel l = new JLabel("UNIVERSITY MANAGEMENT SYSTEM");
		 l.setForeground(Color.black);
		 l.setBounds(200,50,400,50);
		 l.setFont(f);
		 p1.add(l);
		 setSize(900,600);
		 setLocationRelativeTo(null);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 //main menu 
		 p = new JPanel();
		 p.setLayout(null);
		 p.setSize(400,400);
		 p.setBounds(250,175,400,270);
		 p.setBackground(new Color(0,0,0,180));
		 JLabel l1 = new JLabel("MAIN MENU");
		 l1.setForeground(Color.WHITE);
		 l1.setBounds(110,30,300,50); 
		 l1.setFont(f);
		 p.add(l1);
		 
		 b1 = new JButton("LOGIN AS ADMIN");
		 b2 = new JButton("LOGIN AS FACULTY MEMBER");
		 b3 = new JButton("LOGIN AS STUDENT");
		 
		 b1.setBounds(60,90,300,30);
		 b2.setBounds(60,140,300,30);
		 b3.setBounds(60,190,300,30);
		 p.add(b2);
		 p.add(b1);
		 p.add(b3);
		
		 b1.addActionListener(this);
		 b2.addActionListener(this);
		 b3.addActionListener(this);
		 //Background 
		 ImageIcon pic = new ImageIcon("C:\\Users\\HP\\OneDrive\\Desktop\\uni.jpg");
		 Image img = pic.getImage();
		 Image temp_img = img.getScaledInstance(900,600,Image.SCALE_SMOOTH);
		 pic = new ImageIcon(temp_img);
		 l3 = new JLabel("",pic,JLabel.CENTER);
		 l3.setBounds(0,0,900,600);
		 l3.add(p);
		 l3.add(p1);
		 add(l3);
		setVisible(true);
		
		
	}@Override
		public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==b1) {
			 dispose();
			 JFrame f2=new JFrame();
				f2.setSize(300,300);
				f2.setLocationRelativeTo(null);
				f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
				
				
				JPanel p1 = new JPanel();
				 p1.setBackground(Color.white);
				p1.setLayout(new FlowLayout());
				
				
				JLabel l1 = new JLabel("Enter your ID: ");
				 l1.setHorizontalAlignment(SwingConstants.CENTER);
				 l1.setFont(new Font("Calibri", Font.BOLD,30));
				p1.add(l1);
				t = new JTextField(15);
				p1.add(t);
				
				
				JButton b=new JButton("ENTER");
				p1.add(b);
				f2.add(p1);
				
				b.addActionListener(this);
				f2.setVisible(true);
			
		 }else if(e.getActionCommand().equals("ENTER")) {
			 if(t.getText().equals("777")) {
			 new ReceptionistTasks().setVisible(true);
			 }else {
				 JFrame f2=new JFrame();
					f2.setSize(300,300);
					f2.setLocationRelativeTo(null);
					f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
					
					
					JPanel p1 = new JPanel();
					 p1.setBackground(Color.white);
					p1.setLayout(new FlowLayout());
					
					
					JLabel l1 = new JLabel("INVALID ID");
					 l1.setHorizontalAlignment(SwingConstants.CENTER);
					 l1.setFont(new Font("Calibri", Font.BOLD, 30));
					p1.add(l1);
					
					
					JButton b=new JButton("OK");
					p1.add(b);
					f2.add(p1);
					
					b.addActionListener(this);
					f2.setVisible(true);
			 }
		 }else if(e.getActionCommand().equals("OK")) {
			 new Menu().setVisible(true);;
		 }
		 else if(e.getSource()==b2) {
			 dispose();
			 JFrame f2=new JFrame();
				f2.setSize(300,300);
				f2.setLocationRelativeTo(null);
				f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
				
				
				JPanel p1 = new JPanel();
				 p1.setBackground(Color.white);
				p1.setLayout(new FlowLayout());
				
				
				JLabel l1 = new JLabel("Enter your ID: ");
				 l1.setHorizontalAlignment(SwingConstants.CENTER);
				 l1.setFont(new Font("Calibri", Font.BOLD, 30));
				p1.add(l1);
				t = new JTextField(15);
				p1.add(t);
				
				
				JButton b=new JButton("ENTER ");
				p1.add(b);
				f2.add(p1);
				
				b.addActionListener(this);
				f2.setVisible(true);
			// new ManagerTasks().setVisible(true);
		 
		 }else if(e.getActionCommand().equals("ENTER ")) {
			 if(t.getText().equals("888")) {
				 new ManagerTasks().setVisible(true);
			 }else {
				 JFrame f2=new JFrame();
					f2.setSize(300,300);
					f2.setLocationRelativeTo(null);
					f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
					
					
					JPanel p1 = new JPanel();
					 p1.setBackground(Color.white);
					p1.setLayout(new FlowLayout());
					
					
					JLabel l1 = new JLabel("INVALID ID");
					 l1.setHorizontalAlignment(SwingConstants.CENTER);
					 l1.setFont(new Font("Calibri", Font.BOLD, 30));
					p1.add(l1);
					
					
					JButton b=new JButton("OK");
					p1.add(b);
					f2.add(p1);
					
					b.addActionListener(this);
					f2.setVisible(true);
			 }
		 }
		 else {
			 dispose();
			 new CustomerTasks().setVisible(true);
		 }
		 }

} 
class ReceptionistTasks extends JFrame implements ActionListener{
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b_single_room,b_double_room,b_triple_room,b_single_add,
	b_single_delete,b_single_edit,b_single_search,b_single_display,b_double_add,b_double_delete,
	b_double_search,b_double_edit,b_double_display,b_triple_add,b_triple_delete,b_triple_search,b_triple_edit,
	b_triple_display;
	 JPanel p,p1,p2,p3,p4,p5,p6,p7,p8; 
	 JLabel l1,l3;
	 JTextField t;
	 JTextField t2;
	 JTextField t3;
	 JTextField t1_delete_single,t1_edit_single,t1_search_single,t2_delete_double,t2_edit_double,
	 t2_search_double,t3_delete_triple,t3_edit_triple,t3_search_triple;
	 SingleRoom sr=new SingleRoom();
	 DoubleRoom dr=new DoubleRoom();
	 TripleRoom tr=new TripleRoom();
	public ReceptionistTasks(){
		
	setLayout(new GridLayout(5, 1));
	setSize(800,500);
	 setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	 l1 = new JLabel("RECEPTIONIST TASK");
	 l1.setHorizontalAlignment(SwingConstants.CENTER);
	 l1.setFont(new Font("Calibri", Font.BOLD, 36));
	 p = new JPanel();
	 p.setBackground(Color.white);
	p.add(l1);
	 add(p);
	 
	 b1 = new JButton("Do Registration of Customer");  
	 b2 = new JButton("View Rooms Information"); 
	 b3 = new JButton("View Registered Guest");  
	 b4 = new JButton("Delete Customer");    
	 b5 = new JButton("Edit Customer");    //not done  
	 b6 = new JButton("Search Customer");
	 b7 = new JButton("Go to Rooms class");//not done
	 b8 = new JButton("Exit"); 
	 
	 p1 = new JPanel();
	 p1.setBackground(Color.white);
	 p2 = new JPanel();
	 p2.setBackground(Color.white);
	 p3 = new JPanel();
	 p3.setBackground(Color.white);
	// ta1 = new JTextArea();
	 p4 = new JPanel();
	 p4.setBackground(Color.white);
	 p5 = new JPanel();
	 p5.setBackground(Color.white);
	 p6 = new JPanel();
	 p5.setBackground(Color.white);
	 p7 = new JPanel();
	 p5.setBackground(Color.white);
	 p8 = new JPanel();
	 p5.setBackground(Color.white);
	 p1.add(b1);
	 p1.add(b2);
	 p1.add(b3);
	 p2.add(b4);
	 p2.add(b5);
	 p2.add(b6);
	 p3.add(b7);
	 p3.add(b8);
	JPanel p4 = new JPanel();
	 p4.setBackground(Color.white);

	 add(p1);
	 add(p2);
	 add(p3);
	 add(p4);
	 /*add(p4);
	 add(p5);
	 add(p6);
	 add(p7);
	 add(p8);*/
	
	b1.addActionListener(this);
	 b2.addActionListener(this);
	 b3.addActionListener(this);
	 b4.addActionListener(this);
	 b5.addActionListener(this);
	 b6.addActionListener(this);
	 b7.addActionListener(this);
	 b8.addActionListener(this);
		
	 setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Receptionist r = null;
		try {
			r = new Receptionist();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		 
		 if(e.getSource()==b1) {
			 dispose();
			 
			 try {
				 r.RegisterCustomer();
				
			} catch (IOException e1) {
				
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 }else if(e.getSource()==b2) {
			
			 dispose();
			try {
				r.viewRoomsInfo();
				
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		 }else if(e.getSource()==b3){
			
			 dispose();
			 try {
				 r.viewRegisteredGuest();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		 }else if(e.getSource()==b4) {
			 dispose();
			JFrame f2=new JFrame();
				f2.setSize(300,300);
				f2.setLocationRelativeTo(null);
				f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
				
				
				JPanel p1 = new JPanel();
				 p1.setBackground(Color.white);
				p1.setLayout(new FlowLayout());
				JLabel l=new JLabel("Enter your name: ");
				l.setHorizontalAlignment(SwingConstants.CENTER);
				 l.setFont(new Font("Calibri", Font.BOLD, 20));
				 p1.add(l);
				 f2.add(p1);
				
			    t = new JTextField(15);
				p1.add(t);
				
				
				JButton b=new JButton("OK FOR DELETE");
				p1.add(b);
				f2.add(p1);
				b.addActionListener(this);
				f2.setVisible(true);
				 dispose();
		 } else if(e.getSource()==b5) {
			 dispose();
				JFrame f2=new JFrame();
					f2.setSize(300,300);
					f2.setLocationRelativeTo(null);
					f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
					
					
					JPanel p1 = new JPanel();
					 p1.setBackground(Color.white);
					p1.setLayout(new FlowLayout());
					JLabel l=new JLabel("Enter your name: ");
					l.setHorizontalAlignment(SwingConstants.CENTER);
					 l.setFont(new Font("Calibri", Font.BOLD, 20));
					 p1.add(l);
					 f2.add(p1);
					
				    t2 = new JTextField(15);
					p1.add(t2);
					
					
					JButton b=new JButton("OK FOR UPDATE");
					p1.add(b);
					f2.add(p1);
					b.addActionListener(this);
					f2.setVisible(true);
					 dispose();
		 }else if(e.getSource()==b6) {
			 dispose();
				JFrame f2=new JFrame();
					f2.setSize(300,300);
					f2.setLocationRelativeTo(null);
					f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
					
					
					JPanel p1 = new JPanel();
					 p1.setBackground(Color.white);
					p1.setLayout(new FlowLayout());
					JLabel l=new JLabel("Enter the name: ");
					l.setHorizontalAlignment(SwingConstants.CENTER);
					 l.setFont(new Font("Calibri", Font.BOLD, 20));
					 p1.add(l);
					 f2.add(p1);
					
				    t3 = new JTextField(15);
					p1.add(t3);
					
					
					JButton b=new JButton("OK FOR SEARCH");
					p1.add(b);
					f2.add(p1);
					b.addActionListener(this);
					f2.setVisible(true);
					 dispose();
		 }else if(e.getSource()==b7) {
			 JFrame f2=new JFrame();
				f2.setSize(300,300);
				f2.setLocationRelativeTo(null);
				f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
				JLabel l1 = new JLabel("Room Types");
				 l1.setHorizontalAlignment(SwingConstants.CENTER);
				 l1.setFont(new Font("Calibri", Font.BOLD, 36));
				JPanel p = new JPanel();
				 p.setBackground(Color.pink);
				p.add(l1);
				 f2.add(p);
				
				 
				 b_single_room = new JButton("Single Rooms");  
				 b_double_room = new JButton("Double Rooms"); 
				 b_triple_room = new JButton("Triple Rooms");  
				
				 
				JPanel p1 = new JPanel();
				 p1.setBackground(Color.pink);
				
				 p1.add(b_single_room);
				 p1.add(b_double_room);
				 p1.add(b_triple_room);
				
				 f2.add(p1);
				 f2.add(p1);
				 f2.add(p1);
				
				b_single_room.addActionListener(this);
				 b_double_room.addActionListener(this);
				 b_triple_room.addActionListener(this);
				

				 f2.setVisible(true);
			 
		 }
		 else if(e.getActionCommand().equals("OK FOR DELETE")){
			 try {
				r.deleteCustomer(t.getText());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if(e.getActionCommand().equals("OK FOR UPDATE")){
			 try {
				r.editCustomer(t2.getText());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if(e.getActionCommand().equals("OK FOR SEARCH")){
			 try {
				r.findCustomer(t3.getText());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getActionCommand().equals("Single Rooms")) {
			
			JPanel p,p1,p2,p3,p4,p5=null;
			JLabel l1=null;
			JFrame f2=new JFrame();
			f2.setSize(300,300);
			f2.setLocationRelativeTo(null);
			f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
			f2.setVisible(true);
			 l1 = new JLabel("SINGLE ROOM TASK");
			 l1.setHorizontalAlignment(SwingConstants.CENTER);
			 l1.setFont(new Font("Calibri", Font.BOLD, 36));
			 p = new JPanel();
			 p.setBackground(Color.white);
			p.add(l1);
			 f2.add(p);
			
			 b_single_add = new JButton("Add room (Single)");  
			 b_single_delete = new JButton("Delete room (Single)"); 
			 b_single_search = new JButton("Search room (Single)");  
			 b_single_edit = new JButton("Edit room (Single)");    
			 b_single_display = new JButton("Display Single Rooms");      
			 
			 p1 = new JPanel();
			 p1.setBackground(Color.white);
			
			
			 p1.add(b_single_add);
			 p1.add(b_single_delete);
			 p1.add(b_single_search);
			 p1.add(b_single_edit);
			 p1.add(b_single_display);
			
			f2.add(p1);
			f2.add(p1);
			f2.add(p1);
			f2.add(p1);
			f2.add(p1);
			
			 b_single_add.addActionListener(this);
			 b_single_delete.addActionListener(this);
			 b_single_search.addActionListener(this);
			 b_single_edit.addActionListener(this);
			 b_single_display.addActionListener(this);
			

			 f2.setVisible(true);
			 
		}else if(e.getActionCommand().equals("Double Rooms")) {
			JPanel p,p1,p2,p3,p4,p5=null;
			JLabel l1=null;
			JFrame f2=new JFrame();
			f2.setSize(300,300);
			f2.setLocationRelativeTo(null);
			f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
			f2.setVisible(true);
			 l1 = new JLabel("DOUBLE ROOM TASK");
			 l1.setHorizontalAlignment(SwingConstants.CENTER);
			 l1.setFont(new Font("Calibri", Font.BOLD, 36));
			 p = new JPanel();
			 p.setBackground(Color.white);
			p.add(l1);
			f2.add(p);
			
			 b_double_add = new JButton("Add room (Double)");  
			 b_double_delete = new JButton("Delete room (Double)"); 
			 b_double_search = new JButton("Search room (Double)");  
			 b_double_edit = new JButton("Edit room (Double)");    
			 b_double_display = new JButton("Display Double Rooms");      
			 
			 p1 = new JPanel();
			 p1.setBackground(Color.white);
		
			
			 p1.add(b_double_add);
			 p1.add(b_double_delete);
			 p1.add(b_double_search);
			 p1.add(b_double_edit);
			 p1.add(b_double_display);
			
			 f2.add(p1);
			 f2.add(p1);
			 f2.add(p1);
			 f2.add(p1);
			 f2.add(p1);
			
			 b_double_add.addActionListener(this);
			 b_double_delete.addActionListener(this);
			 b_double_search.addActionListener(this);
			 b_double_edit.addActionListener(this);
			 b_double_display.addActionListener(this);
			

			 f2.setVisible(true);
		}else if(e.getActionCommand().equals("Triple Rooms")) {
			JPanel p,p1,p2,p3,p4,p5=null;
			JLabel l1=null;
			JFrame f2=new JFrame();
			f2.setSize(300,300);
			f2.setLocationRelativeTo(null);
			f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
			f2.setVisible(true);
			 l1 = new JLabel("TRIPLE ROOM TASK");
			 l1.setHorizontalAlignment(SwingConstants.CENTER);
			 l1.setFont(new Font("Calibri", Font.BOLD, 36));
			 p = new JPanel();
			 p.setBackground(Color.white);
			p.add(l1);
			f2.add(p);
			
			 b_triple_add = new JButton("Add room (Triple)");  
			 b_triple_delete = new JButton("Delete room (Triple)"); 
			 b_triple_search = new JButton("Search room (Triple)");  
			 b_triple_edit = new JButton("Edit room (Triple)");    
			 b_triple_display = new JButton("Display Triple Rooms");      
			 
			 p1 = new JPanel();
			 p1.setBackground(Color.white);
			
			 p1.add(b_triple_add);
			 p1.add(b_triple_delete);
			 p1.add(b_triple_search);
			 p1.add(b_triple_edit);
			 p1.add(b_triple_display);
			
			 f2.add(p1);
			 f2.add(p1);
			 f2.add(p1);
			 f2.add(p1);
			 f2.add(p1);
			
			 b_triple_add.addActionListener(this);
			 b_triple_delete.addActionListener(this);
			 b_triple_search.addActionListener(this);
			 b_triple_edit.addActionListener(this);
			 b_triple_display.addActionListener(this);
			

			 f2.setVisible(true);
		}else if(e.getActionCommand().equals("Add room (Single)")) {
			try {
				sr.addRooms();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getActionCommand().equals("Delete room (Single)")) {
			JFrame f=new JFrame();
			f.setSize(500,300);
			 f.setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			f.setVisible(true); 
			
			JLabel l=new JLabel("Enter the room to delete: ");
			 l.setHorizontalAlignment(SwingConstants.CENTER);
			 l.setFont(new Font("Calibri", Font.BOLD, 36));
			 t1_delete_single=new JTextField(15);
			 JPanel p1 = new JPanel();
			 p1.setBackground(Color.white);
			p1.setLayout(new FlowLayout());
			p1.add(l);
			f.add(p);
			p1.add(t1_delete_single);
			f.add(p);
			
			JButton b=new JButton("OK FOR DELETE (SINGLE ROOM)");
			p1.add(b);
			f.add(p1);
			b.addActionListener(this);
			
			 
		}else if(e.getActionCommand().equals("Edit room (Single)")) {
			JFrame f=new JFrame();
			f.setSize(500,300);
			 f.setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			f.setVisible(true); 
			
			JLabel l=new JLabel("Enter the room to edit: ");
			 l.setHorizontalAlignment(SwingConstants.CENTER);
			 l.setFont(new Font("Calibri", Font.BOLD, 36));
			 t1_edit_single=new JTextField(15);
			 JPanel p1 = new JPanel();
			 p1.setBackground(Color.white);
			p1.setLayout(new FlowLayout());
			p1.add(l);
			f.add(p);
			p1.add(t1_edit_single);
			f.add(p);
			
			JButton b=new JButton("OK FOR EDIT (SINGLE ROOM)");
			p1.add(b);
			f.add(p1);
			b.addActionListener(this);
		}else if(e.getActionCommand().equals("Search room (Single)")) {
			JFrame f=new JFrame();
			f.setSize(500,300);
			 f.setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			f.setVisible(true); 
			
			JLabel l=new JLabel("Enter the room to search: ");
			 l.setHorizontalAlignment(SwingConstants.CENTER);
			 l.setFont(new Font("Calibri", Font.BOLD, 36));
			 t1_search_single=new JTextField(15);
			 JPanel p1 = new JPanel();
			 p1.setBackground(Color.white);
			p1.setLayout(new FlowLayout());
			p1.add(l);
			f.add(p);
			p1.add(t1_search_single);
			f.add(p);
			
			JButton b=new JButton("OK FOR SEARCH (SINGLE ROOM)");
			p1.add(b);
			f.add(p1);
			b.addActionListener(this);
		}else if(e.getActionCommand().equals("Display Single Rooms")) {
			try {
				
				sr.display();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getActionCommand().equals("Add room (Double)")) {
			try {
				dr.addRooms();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getActionCommand().equals("Delete room (Double)")) {
			JFrame f=new JFrame();
			f.setSize(500,300);
			 f.setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			f.setVisible(true); 
			
			JLabel l=new JLabel("Enter the room to delete: ");
			 l.setHorizontalAlignment(SwingConstants.CENTER);
			 l.setFont(new Font("Calibri", Font.BOLD, 36));
			 t2_delete_double=new JTextField(15);
			 JPanel p1 = new JPanel();
			 p1.setBackground(Color.white);
			p1.setLayout(new FlowLayout());
			p1.add(l);
			f.add(p);
			p1.add(t2_delete_double);
			f.add(p);
			
			JButton b=new JButton("OK FOR DELETE (DOUBLE ROOM)");
			p1.add(b);
			f.add(p1);
			b.addActionListener(this);
		}else if(e.getActionCommand().equals("Edit room (Double)")) {
			JFrame f=new JFrame();
			f.setSize(500,300);
			 f.setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			f.setVisible(true); 
			
			JLabel l=new JLabel("Enter the room to edit: ");
			 l.setHorizontalAlignment(SwingConstants.CENTER);
			 l.setFont(new Font("Calibri", Font.BOLD, 36));
			 t2_edit_double=new JTextField(15);
			 JPanel p1 = new JPanel();
			 p1.setBackground(Color.white);
			p1.setLayout(new FlowLayout());
			p1.add(l);
			f.add(p);
			p1.add(t2_edit_double);
			f.add(p);
			
			JButton b=new JButton("OK FOR EDIT (DOUBLE ROOM)");
			p1.add(b);
			f.add(p1);
			b.addActionListener(this);
		}else if(e.getActionCommand().equals("Search room (Double)")) {
			JFrame f=new JFrame();
			f.setSize(500,300);
			 f.setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			f.setVisible(true); 
			
			JLabel l=new JLabel("Enter the room to search: ");
			 l.setHorizontalAlignment(SwingConstants.CENTER);
			 l.setFont(new Font("Calibri", Font.BOLD, 36));
			  t2_search_double=new JTextField(15);
			 JPanel p1 = new JPanel();
			 p1.setBackground(Color.white);
			p1.setLayout(new FlowLayout());
			p1.add(l);
			f.add(p);
			p1.add(t2_search_double);
			f.add(p);
			
			JButton b=new JButton("OK FOR SEARCH (DOUBLE ROOM)");
			p1.add(b);
			f.add(p1);
			b.addActionListener(this);
		}else if(e.getActionCommand().equals("Display Double Rooms")) {
			try {
				dr.display();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getActionCommand().equals("Add room (Triple)")) {
			try {
				tr.addRooms();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getActionCommand().equals("Delete room (Triple)")) {
			JFrame f=new JFrame();
			f.setSize(500,300);
			 f.setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			f.setVisible(true); 
			
			JLabel l=new JLabel("Enter the room to delete: ");
			 l.setHorizontalAlignment(SwingConstants.CENTER);
			 l.setFont(new Font("Calibri", Font.BOLD, 36));
			 t3_delete_triple=new JTextField(15);
			 JPanel p1 = new JPanel();
			 p1.setBackground(Color.white);
			p1.setLayout(new FlowLayout());
			p1.add(l);
			f.add(p);
			p1.add(t3_delete_triple);
			f.add(p);
			
			JButton b=new JButton("OK FOR DELETE (TRIPLE ROOM)");
			p1.add(b);
			f.add(p1);
			b.addActionListener(this);
		}else if(e.getActionCommand().equals("Edit room (Triple)")) {
			JFrame f=new JFrame();
			f.setSize(500,300);
			 f.setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			f.setVisible(true); 
			
			JLabel l=new JLabel("Enter the room to edit: ");
			 l.setHorizontalAlignment(SwingConstants.CENTER);
			 l.setFont(new Font("Calibri", Font.BOLD, 36));
			 t3_edit_triple=new JTextField(15);
			 JPanel p1 = new JPanel();
			 p1.setBackground(Color.white);
			p1.setLayout(new FlowLayout());
			p1.add(l);
			f.add(p);
			p1.add(t3_edit_triple);
			f.add(p);
			
			JButton b=new JButton("OK FOR EDIT (TRIPLE ROOM)");
			p1.add(b);
			f.add(p1);
			b.addActionListener(this);
		}else if(e.getActionCommand().equals("Search room (Triple)")) {
			JFrame f=new JFrame();
			f.setSize(500,300);
			 f.setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			f.setVisible(true); 
			
			JLabel l=new JLabel("Enter the room to search: ");
			 l.setHorizontalAlignment(SwingConstants.CENTER);
			 l.setFont(new Font("Calibri", Font.BOLD, 36));
			 t3_search_triple=new JTextField(15);
			 JPanel p1 = new JPanel();
			 p1.setBackground(Color.white);
			p1.setLayout(new FlowLayout());
			p1.add(l);
			f.add(p);
			p1.add(t3_search_triple);
			f.add(p);
			
			JButton b=new JButton("OK FOR SEARCH (TRIPLE ROOM)");
			p1.add(b);
			f.add(p1);
			b.addActionListener(this);
		}else if(e.getActionCommand().equals("Display Triple Rooms")) {
			try {
				tr.display();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getActionCommand().equals("OK FOR DELETE (SINGLE ROOM)")) {
			int roomNo=Integer.parseInt(t1_delete_single.getText());
			try {
				sr.deleteRooms(roomNo);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getActionCommand().equals("OK FOR EDIT (SINGLE ROOM)")) {
			int roomNo=Integer.parseInt(t1_edit_single.getText());
			try {
				sr.editRooms(roomNo);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getActionCommand().equals("OK FOR SEARCH (SINGLE ROOM)")) {
			int roomNo=Integer.parseInt(t1_search_single.getText());
			try {
				sr.searchRooms(roomNo);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getActionCommand().equals("OK FOR DELETE (DOUBLE ROOM)")) {
			int roomNo=Integer.parseInt(t2_delete_double.getText());
			try {
				dr.deleteRooms(roomNo);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getActionCommand().equals("OK FOR EDIT (DOUBLE ROOM)")) {
			int roomNo=Integer.parseInt(t2_edit_double.getText());
			try {
				dr.editRooms(roomNo);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getActionCommand().equals("OK FOR SEARCH (DOUBLE ROOM)")) {
			int roomNo=Integer.parseInt(t2_search_double.getText());
			try {
				dr.searchRooms(roomNo);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getActionCommand().equals("OK FOR DELETE (TRIPLE ROOM)")) {
			int roomNo=Integer.parseInt(t3_delete_triple.getText());
			try {
				tr.deleteRooms(roomNo);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getActionCommand().equals("OK FOR EDIT (TRIPLE ROOM)")) {
			int roomNo=Integer.parseInt(t3_edit_triple.getText());
			try {
				tr.editRooms(roomNo);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getActionCommand().equals("OK FOR SEARCH (TRIPLE ROOM)")) {
			int roomNo=Integer.parseInt(t3_search_triple.getText());
			try {
				tr.searchRooms(roomNo);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		 else {
			 dispose();
			 new Menu().setVisible(true);
		 }
		 }
}
class ManagerTasks extends JFrame implements ActionListener{
	JButton b1,b2,b3,b4,b5;
	 JPanel p,p1,p2,p3,p4,p5; 
	 JLabel l1,l3;
	 JTextArea ta1;
	 
	public ManagerTasks(){
		
	setLayout(new GridLayout(6, 1));
	setSize(800,600);
	 setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
	 l1 = new JLabel("MANAGER TASK");
	 l1.setHorizontalAlignment(SwingConstants.CENTER);
	 l1.setFont(new Font("Calibri", Font.BOLD, 36));
	 p = new JPanel();
	 p.setBackground(Color.white);
	p.add(l1);
	 add(p);

	 b1 = new JButton("View Customer FeedBack");
	 b2 = new JButton("View Customer Complaints");
	 b3 = new JButton("View Rooms Information");
	 b4 = new JButton("View Registered Guest");
	 b5 = new JButton("Exit");
	 p1 = new JPanel();
	 p1.setBackground(Color.white);
	 p2 = new JPanel();
	 p2.setBackground(Color.white);
	 p3 = new JPanel();
	 p3.setBackground(Color.white);
	 ta1 = new JTextArea();
	 p4 = new JPanel();
	 p4.setBackground(Color.white);
	 p5 = new JPanel();
	 p5.setBackground(Color.white);
	 p1.add(b1);
	 p2.add(b2);
	 p3.add(b3);
	 p3.add(ta1);
	 p5.add(b5);
	 p4.add(b4);
	 
	 add(p1);
	 add(p2);
	 add(p3);
	 add(p4);
	 add(p5);
	
	b1.addActionListener(this);
	 b2.addActionListener(this);
	 b3.addActionListener(this);
	 b4.addActionListener(this);
	 b5.addActionListener(this);

	 setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Manager m1=new Manager();
		 if(e.getSource()==b1) {
			 dispose();
			 
			 try {
				m1.viewFeedBack();
				
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		 }else if(e.getSource()==b2) {
			
			 dispose();
			try {
				m1.viewComplaints();
				
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		 }else if(e.getSource()==b3){
			
			 dispose();
			 try {
					m1.viewRoomsInfo();
				
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		 }else if(e.getSource()==b4) {
			 dispose();
			try {
				m1.viewRegisteredGuest();
				
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		 }else {
			 dispose();
			 new Menu().setVisible(true);
		 }
		 }
}
class CustomerTasks extends JFrame implements ActionListener{
	JButton b1,b2,b3,b4,b5,b6,b7,b8;
	 JPanel p,p1,p2,p3,p4,p5,p6,p7,p8; 
	 JLabel l1,l3;
	 JTextField t;
	 JFrame f;
	public CustomerTasks(){
		setLayout(new GridLayout(5, 1));
		setSize(800,500);
		 setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		 l1 = new JLabel("CUSTOMER TASK");
		 l1.setHorizontalAlignment(SwingConstants.CENTER);
		 l1.setFont(new Font("Calibri", Font.BOLD, 36));
		 p = new JPanel();
		 p.setBackground(Color.white);
		p.add(l1);
		 add(p);
		 b1 = new JButton("Registration");
		 b2 = new JButton("CheckOut");  //not done
		 b3 = new JButton("Order Food");
		 b4 = new JButton("Book Room"); //not done
		 b5 = new JButton("Do Laundary");
		 b6 = new JButton("Give FeedBack");
		 b7 = new JButton("Complain to Manager");
		 b8 = new JButton("Exit");
		 
		 p1 = new JPanel();
		 p1.setBackground(Color.white);
		 p2 = new JPanel();
		 p2.setBackground(Color.white);
		 p3 = new JPanel();
		 p3.setBackground(Color.white);
		// ta1 = new JTextArea();
		 p4 = new JPanel();
		 p4.setBackground(Color.white);
		 p5 = new JPanel();
		 p5.setBackground(Color.white);
		 p6 = new JPanel();
		 p5.setBackground(Color.white);
		 p7 = new JPanel();
		 p5.setBackground(Color.white);
		 p8 = new JPanel();
		 p5.setBackground(Color.white);
		 p1.add(b1);
		 p1.add(b2);
		 p1.add(b3);
		 p2.add(b4);
		 p2.add(b5);
		 p2.add(b6);
		 p3.add(b7);
		 p3.add(b8);
		JPanel p4 = new JPanel();
		 p4.setBackground(Color.white);

		 add(p1);
		 add(p2);
		 add(p3);
		 add(p4);
		
		
		b1.addActionListener(this);
		 b2.addActionListener(this);
		 b3.addActionListener(this);
		 b4.addActionListener(this);
		 b5.addActionListener(this);
		 b6.addActionListener(this);
		 b7.addActionListener(this);
		 b8.addActionListener(this);
		
		 setVisible(true);
		
		
		
		
	
}
	@Override
	public void actionPerformed(ActionEvent e) {
		Customers c=new Customers();
		 
		 if(e.getSource()==b1) {
			 try {
				c.Registration();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 dispose();
		 }else if(e.getSource()==b2) {
			
			 JFrame f2=new JFrame();
				f2.setSize(300,300);
				f2.setLocationRelativeTo(null);
				f2.setDefaultCloseOperation(EXIT_ON_CLOSE);
				
				
				JPanel p1 = new JPanel();
				 p1.setBackground(Color.white);
				p1.setLayout(new FlowLayout());
				JLabel l=new JLabel("Enter your name: ");
				l.setHorizontalAlignment(SwingConstants.CENTER);
				 l.setFont(new Font("Calibri", Font.BOLD, 20));
				 p1.add(l);
				 f2.add(p1);
				
			    t = new JTextField(15);
				p1.add(t);
				System.out.println(t.getText());
				
				
				JButton b=new JButton("OK");
				p1.add(b);
				f2.add(p1);
				b.addActionListener(this);
				f2.setVisible(true);
				 dispose();
		 }else if(e.getSource()==b3) {
			 try {
				 OrderFood o=new OrderFood();
				 o.display_menu();
					//c.orderFood();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				 dispose();
		 }else if(e.getSource()==b4) {
			 try {
					c.bookRoom();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				 dispose();
		 }else if(e.getSource()==b5) {
			 try {
					c.laundary();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				 dispose();
		 }else if(e.getSource()==b6) {
			 try {
					c.giveFeedBack();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				 dispose();
		 }else if(e.getSource()==b7) {
			 try {
					c.complain();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				 dispose();
		 }
		 else if(e.getActionCommand().equals("OK")){
			 try {
				c.CheckOut(t.getText());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		 else {
			 dispose();
			 new Menu().setVisible(true);
		 }
		
	}
}
