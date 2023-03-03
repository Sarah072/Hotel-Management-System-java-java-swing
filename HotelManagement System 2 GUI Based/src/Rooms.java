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

public class Rooms extends JFrame implements ActionListener{
	
	protected int room_id;
	protected int room_number;
	protected String room_type;
	protected String room_status;
	protected String room_guest_name;
	JTextField t1,t2,t3,t4,t5;
	protected String All_data="";
	public Rooms() {
		
	}

	public Rooms(int id,int rn,String type,String status,String guest_name) {
		this.room_id=id;
		this.room_number=rn;
		this.room_guest_name=guest_name;
		this.room_status=status;
		this.room_type=type;
	}
	
	public void addRooms(Rooms r,File oldFile) throws IOException {
	
    	//String type="";
		
    	JFrame f=new JFrame("Add Room");
		f.setSize(500,300);
		 f.setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true); 
		JPanel p=new JPanel();
		JLabel j=null;
		boolean exist=false;
	    String str=Integer.toString(r.room_number);
	    DataInputStream scanFile=new DataInputStream(new FileInputStream(oldFile));
		String line="";
		if(oldFile.exists()) {
			  while((line = scanFile.readLine()) != null) {
				if(line.startsWith("Room No:") && line.endsWith(str)) {
					exist=true;
				}
			}
		}else {
			j=new JLabel("File doesn't exist!");
			 j.setHorizontalAlignment(SwingConstants.CENTER);
			 j.setFont(new Font("Calibri", Font.BOLD, 20));
			 p.setBackground(Color.PINK);
			 p.add(j);
			f.add(p);
			
			 JButton jb=new JButton("EXIT");
			 
			 p.add(jb);
			 f.add(p);
			 jb.addActionListener(this);
			scanFile.close();
		}
		if(exist==true) {
			j=new JLabel("Room alreday exist!");
			 j.setHorizontalAlignment(SwingConstants.CENTER);
			 j.setFont(new Font("Calibri", Font.BOLD, 20));
			 p.setBackground(Color.PINK);
			 p.add(j);
			f.add(p);
			
			 JButton jb=new JButton("EXIT");
			 
			 p.add(jb);
			 f.add(p);
			 jb.addActionListener(this);
			
		}
		
		if(exist==false) {
			DataOutputStream fileWriter=new DataOutputStream(new FileOutputStream(oldFile,true));

	
		fileWriter.writeBytes("Room No: "+r.room_number+"\n");
		fileWriter.writeBytes("Room ID: "+r.room_id+"\n");
		fileWriter.writeBytes("Room Type: "+r.room_type+"\n");
		fileWriter.writeBytes("Room Status: "+r.room_status+"\n");
		fileWriter.writeBytes("Room Guest: "+r.room_guest_name+"\n");
		fileWriter.writeBytes("*********************************************\n");
		fileWriter.close();
		j=new JLabel("Room No: "+r.room_number+" has been successfully added!");
		 j.setHorizontalAlignment(SwingConstants.CENTER);
		 j.setFont(new Font("Calibri", Font.BOLD, 25));
		 p.setBackground(Color.PINK);
		 p.add(j);
		f.add(p);
		
		 JButton jb=new JButton("EXIT");
		 
		 p.add(jb);
		 f.add(p);
		 jb.addActionListener(this);
		
			}
		
	}
   

	public File deleteRooms(int roomNo,File oldFile,String filename) throws IOException {
    	JPanel p=new JPanel();
		JLabel j=null;
    	JFrame f=new JFrame("Delete Room");
		f.setSize(500,300);
		 f.setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true); 
    	 String str=Integer.toString(roomNo);
    	 DataInputStream scan=new DataInputStream(new FileInputStream(oldFile));
	        String line="";
	        boolean found=false;
	        String All_data = "";
	        while((line = scan.readLine()) != null) {
	            String n = line;
	            if (n.toLowerCase().endsWith(str.toLowerCase())){
	                scan.readLine();
	                scan.readLine();
	                scan.readLine();
	                scan.readLine(); 
	                scan.readLine();
	                found=true;
	            }
	            else
	                All_data += (n+"\n");
	        }
	        scan.close();
	        boolean x = oldFile.delete();
	        if(x && found) {
	        	j=new JLabel("Room Deleted Successfully");
				 j.setHorizontalAlignment(SwingConstants.CENTER);
				 j.setFont(new Font("Calibri", Font.BOLD, 36));
				 p.setBackground(Color.PINK);
				 p.add(j);
				f.add(p);
				
				 JButton jb=new JButton("EXIT");
				 
				 p.add(jb);
				 f.add(p);
				 jb.addActionListener(this);
	           
	        }if(!found) {
	        	j=new JLabel("Room Not Found");
				 j.setHorizontalAlignment(SwingConstants.CENTER);
				 j.setFont(new Font("Calibri", Font.BOLD, 36));
				 p.setBackground(Color.PINK);
				 p.add(j);
				f.add(p);
				
				 JButton jb=new JButton("EXIT");
				 
				 p.add(jb);
				 f.add(p);
				 jb.addActionListener(this);
	        }
	        File newFile = new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+filename);
	        DataOutputStream fileWriter=new DataOutputStream(new FileOutputStream(newFile));
	       
	        fileWriter.writeBytes(All_data);
	        fileWriter.close();
	        return newFile;
	}
    public void editRooms(int roomNo,File oldFile,String filename) throws IOException {
    	
    	 JLabel nl=null;
		 JPanel np= new JPanel();
		 JFrame f=new JFrame("Edit Rooms");
			f.setSize(500,300);
			 f.setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			f.setVisible(true); 

		DataInputStream scan=new DataInputStream(new FileInputStream(oldFile));
	        Scanner input = new Scanner(System.in);
	        
	        String line="";
	        boolean found=false;
	        String str=Integer.toString(roomNo);
	        if(oldFile.exists()) {
        while((line = scan.readLine()) != null) {
          
            if (line.startsWith("Room No:") && line.endsWith(str)){
            	 found=true;
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
	        		l1= new JLabel("Room no "+str+" Found. Enter Updated Data");
	        		 l1.setHorizontalAlignment(SwingConstants.CENTER);
	        		 l1.setFont(new Font("Calibri", Font.BOLD, 36));
	        		p.add(l1);
	        		 add(p);
	        		p1 = new JPanel();
	        		 p1.setBackground(Color.white);
	        		p1.setLayout(new FlowLayout());
	        		l1 = new JLabel("Enter Room No: ");
	        		p1.add(l1);
	        		t1 = new JTextField(15);
	        		p1.add(t1);
	        		l2 = new JLabel("Enter Room ID: ");
	        		p1.add(l2);
	        		t2 = new JTextField(15);
	        		p1.add(t2);
	        		add(p1);
	        		p2 = new JPanel();
	        		 p2.setBackground(Color.white);
	        		p2.setLayout(new FlowLayout());
	        		l3 = new JLabel("Enter Room Type: ");
	        		p2.add(l3);
	        		t3 = new JTextField(15);
	        		p2.add(t3);
	        		l4 = new JLabel("Enter Status (Booked/Not Booked): ");
	        		p2.add(l4);
	        		t4 = new JTextField(15);
	        		p2.add(t4);
	        		add(p2);
	        		p3 = new JPanel();
	        		 p3.setBackground(Color.white);
	        		p3.setLayout(new FlowLayout());
	        		l5 = new JLabel("Enter Room Guest: ");
	        		p3.add(l5);
	        		t5 = new JTextField(15);
	        		p3.add(t5);
	        		add(p3);
	        		p5 = new JPanel();
	        		 p5.setBackground(Color.white);
	        		 p5.setLayout(new FlowLayout());
	        		 b1 = new JButton("EDIT ROOM");
	        		 b2 = new JButton("RETURN TO HOME");
	        		
	        		 p5.add(b1);
	        		 p5.add(b2);
	        		 add(p5);

	        			JPanel p61 = new JPanel();
	        			 p61.setBackground(Color.white);
	        			p61.setLayout(new FlowLayout());
	        			add(p61);
	        		b1.addActionListener(this);
	        		 b2.addActionListener(this);
	        		
	        		
	            } else
	                All_data += (line+"\n");
        
        } scan.close();
       
        
        if(!found){
	        nl = new JLabel("Room not found!");
			 nl.setHorizontalAlignment(SwingConstants.CENTER);
			 nl.setFont(new Font("Calibri", Font.BOLD, 36));
			 np.add(nl);
			 f.add(np);
			 
             JButton jb=new JButton("EXIT");
			 
			 np.add(jb);
			 f.add(np);
			 jb.addActionListener(this);
			
	    }
          
        }else {
        	 nl=new JLabel("FILE DOESN'T EXIST!");
			 nl.setHorizontalAlignment(SwingConstants.CENTER);
			 nl.setFont(new Font("Calibri", Font.BOLD, 32));
			 np.add(nl);
			 add(np);
			 
             JButton jb=new JButton("EXIT");
			 
			 np.add(jb);
			 add(np);
			 jb.addActionListener(this);
        } scan.close();
	        
    	
    }@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("EDIT ROOM")) {
	    	 dispose();
	 
	    	//String All_data="";
	    	 All_data +="Room No: "+t1.getText()+"\n";
    		 All_data +="Room ID: "+t2.getText()+"\n";
    		 All_data +="Room Type: "+t3.getText()+"\n";
    		 All_data +="Room Status: "+t4.getText()+"\n";
    		 All_data +="Room Guest Name: "+t5.getText()+"\n";
    		 
    		 File oldFile=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+t3.getText()+"Rooms.txt");
    	        boolean x = oldFile.delete();
    	        
    	 
    		 
    		 File file=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+t3.getText()+"Rooms.txt");
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
				f2.setSize(300,300);
				 f2.setLocationRelativeTo(null);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				f2.setVisible(true); 
				JPanel p=new JPanel();
				p.setBackground(Color.pink);
				JLabel l2=new JLabel("Room Updated Successfully!");
			  	 l2.setHorizontalAlignment(SwingConstants.CENTER);
					l2.setFont(new Font("Calibri", Font.BOLD, 24));
					p.add(l2);
					f2.add(p);

					JButton b=new JButton("EXIT AND PAY");
					JButton b2=new JButton("EXIT");
					p.add(b);
					p.add(b2);
					 f2.add(p);
					// f2.add(p2);
					 b.addActionListener(this);
					 b2.addActionListener(this);
					 
		
	}else if(e.getActionCommand().equals("EXIT")) {
		 dispose();
		 
		 new ReceptionistTasks();
    }else if(e.getActionCommand().equals("EXIT AND PAY")) {
		 dispose();
		 BookRooms br=new BookRooms();
		 br.roomPayment();
    }
	else if(e.getActionCommand().equals("RETURN TO HOME")) {
		dispose();
		new Menu().setVisible(true);
	}
}

    public void searchRooms(int roomNo,File oldFile,String filename) throws IOException {

    	JPanel p=new JPanel();
		JLabel j=null;
    	JFrame f=new JFrame("Search Room");
		f.setSize(500,300);
		 f.setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true); 
    	String str=Integer.toString(roomNo);
    	 DataInputStream scan=new DataInputStream(new FileInputStream(oldFile));
       boolean found=false;
       int i=1;
       String l="";
        while((l = scan.readLine()) != null) {
            String line = l;
            if (line.startsWith("Room No: ") && line.toLowerCase().endsWith(str.toLowerCase())){
                //System.out.println("Room found...\n"+line);
               
                	found=true;
                	while(i<=5) {
	                	 j = new JLabel(l);
	    				 j.setHorizontalAlignment(SwingConstants.CENTER);
	    				 j.setFont(new Font("Calibri", Font.BOLD, 36));
	    				
	    				 p.setBackground(Color.PINK);
	    				 p.add(j);
	    				 f.add(p);
	    				 l=scan.readLine();
	                	 i++;
	                	}
	                	  JButton jb=new JButton("EXIT");
	     				 
	     				 p.add(jb);
	     				 f.add(p);
	     				 jb.addActionListener(this);
                 
                scan.close();
                return;
            }
        }if(!found) {
        	j=new JLabel("Room Not Found");
			 j.setHorizontalAlignment(SwingConstants.CENTER);
			 j.setFont(new Font("Calibri", Font.BOLD, 36));
			 p.setBackground(Color.PINK);
			 p.add(j);
			f.add(p);
			
			 JButton jb=new JButton("EXIT");
			 
			 p.add(jb);
			 f.add(p);
			 jb.addActionListener(this);
        }
       
    }
   

	
}
class SingleRoom extends Rooms{
	JTextField t11,t22,t33,t44,t55;
	private Rooms r=new  Rooms();
	
	public void addRooms() throws IOException {
		
		setLayout(new GridLayout(6, 1));
		setSize(800,600);
		 setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	
		
		 JLabel l1,l2,l3,l4,l5;
		 JButton b1,b2;
		 JPanel p,p1,p2,p3,p4;
		 
		 p = new JPanel();
		 p.setBackground(Color.white);
		l1= new JLabel("ADD ROOM");
		 l1.setHorizontalAlignment(SwingConstants.CENTER);
		 l1.setFont(new Font("Calibri", Font.BOLD, 36));
		p.add(l1);
		 add(p);
		 p1 = new JPanel();
		 p1.setBackground(Color.white);
		p1.setLayout(new FlowLayout());
		l1 = new JLabel("Enter Room No: ");
		p1.add(l1);
		t11 = new JTextField(15);
		p1.add(t11);
		//System.out.println(t11.getText());
		l2 = new JLabel("Enter Room ID: ");
		p1.add(l2);
		t22 = new JTextField(15);
		p1.add(t22);
		add(p1);
		//System.out.println(t2.getText());
		p2 = new JPanel();
		 p2.setBackground(Color.white);
		p2.setLayout(new FlowLayout());
		l3 = new JLabel("Enter Room Type (Single) : ");
		p2.add(l3);
		t33 = new JTextField(15);
		p2.add(t33);
		//System.out.println(t3.getText());
		l4 = new JLabel("Enter Room Status (Booked/Not Booked): ");
		p2.add(l4);
		t44 = new JTextField(15);
		p2.add(t44);
		add(p2);
		p3 = new JPanel();
		 p3.setBackground(Color.white);
		p3.setLayout(new FlowLayout());
		l5 = new JLabel("Enter Room Guest: ");
		p3.add(l5);
		t55 = new JTextField(15);
		p3.add(t55);
		add(p3);
		p4 = new JPanel();
		 p4.setBackground(Color.white);
		p4.setLayout(new FlowLayout());
		
		 b1 = new JButton("ADD ROOM");
		 b2 = new JButton("RETURN TO HOME");
		
		 
		 p4.add(b1);
		 p4.add(b2);
		
		 add(p4);
		
		JPanel p5 = new JPanel();
		 p5.setBackground(Color.white);
		p5.setLayout(new FlowLayout());
		add(p5);
		b1.addActionListener(this);
		 b2.addActionListener(this);
		
		
		
		 setVisible(true);
		

   }
	
		  
	@Override
	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand().equals("ADD ROOM")){
			File oldFile=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+"SingleRoom.txt"); 
    	    if(oldFile.exists()) {
    		try {
    			//System.out.println(t11.getText());
    			 r.room_number=Integer.parseInt(t11.getText());
    			r.room_id=Integer.parseInt(t22.getText());
    			r.room_type=t33.getText();
    			r.room_status=t44.getText();
    			r.room_guest_name=t55.getText();
    			 System.out.println(r.room_number);
				super.addRooms(r,oldFile);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	    }else {
        	    try {
    				oldFile.createNewFile();
    			} catch (IOException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
    				System.out.println("File created successfully");
    				try {
    					super.addRooms(r,oldFile);
    				} catch (IOException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
    			}
		}else if(e.getActionCommand().equals("EDIT ROOM")) {
    	    	 dispose();
    	    	 
    		    	
    		    	 All_data +="Room No: "+t1.getText()+"\n";
    	    		 All_data +="Room ID: "+t2.getText()+"\n";
    	    		 All_data +="Room Type: "+t3.getText()+"\n";
    	    		 All_data +="Room Status: "+t4.getText()+"\n";
    	    		 All_data +="Room Guest Name: "+t5.getText()+"\n";
    	    		 
    	    		 System.out.println(All_data);
    	    		 File oldFile1=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+t3.getText()+"Room.txt");
    	    	        boolean x = oldFile1.delete();
    	    	     
    	    		 File file=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+t3.getText()+"Room.txt");
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
    					JLabel l2=new JLabel("Room Updated Successfully!");
    				  	 l2.setHorizontalAlignment(SwingConstants.CENTER);
    						l2.setFont(new Font("Calibri", Font.BOLD, 24));
    						p.add(l2);
    						f2.add(p);


    						JButton b=new JButton("EXIT AND PAY");
    						JButton b2=new JButton("EXIT");
    						p.add(b);
    						p.add(b2);
    						 f2.add(p);
    						// f2.add(p2);
    						 b.addActionListener(this);
    						 b2.addActionListener(this);
    						
   		
   	}
    	   
		else if(e.getActionCommand().equals("RETURN TO HOME")) {
			dispose();
			new Menu().setVisible(true);
		}else if(e.getActionCommand().equals("EXIT AND PAY")) {
			
			 BookRooms br=new BookRooms();
			 br.roomPayment();
	    }
		else if(e.getActionCommand().equals("EXIT")) {
			dispose();
			new ReceptionistTasks();
		}

			
	}
	
    public void deleteRooms(int roomNo) throws IOException {
    
    	
    		File oldFile=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+"SingleRoom.txt"); 
    		String filename="SingleRoom.txt";
    		 if(oldFile.exists()) {
    			 super.deleteRooms(roomNo,oldFile,filename);
    	    	    }else {
    	    	    oldFile.createNewFile();
    					System.out.println("File created successfully");
    					 super.deleteRooms(roomNo,oldFile,filename);
    				}
    		 
    		
    }
    public void editRooms(int roomNo) throws IOException {
    	String filename="";
    	
        		File oldFile=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+"SingleRoom.txt"); 
        		 filename="SingleRoom.txt";
        		 if(oldFile.exists()) {
        				super.editRooms(roomNo,oldFile,filename);
        	    	    }else {
        	    	    oldFile.createNewFile();
        					System.out.println("File created successfully");
        					super.editRooms(roomNo,oldFile,filename);
        				}
        		
        
    	
    	
    }
   
    public void searchRooms(int roomNo) throws IOException {

    	
    		File oldFile=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+"SingleRoom.txt"); 
    		String filename="SingleRoom.txt";
    		 if(oldFile.exists()) {
    	    		super.searchRooms(roomNo,oldFile,filename);
 	    	    }else {
 	    	    oldFile.createNewFile();
 					System.out.println("File created successfully");
 					super.searchRooms(roomNo,oldFile,filename);
 				}
    		
    }
    public void display() throws IOException {
    	JPanel p=null;
    	JFrame f =null;
    	File file=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+"SingleRoom.txt"); 
    	if(file.exists()) {
    		f=new JFrame("ROOMS DATABASE");
				f.setSize(800,800);
				 f.setLocationRelativeTo(null);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				f.setVisible(true); 
				 
				JLabel l1 = new JLabel("                  SINGLE ROOMS DATABASE                ");
				 l1.setHorizontalAlignment(SwingConstants.CENTER);
				 l1.setFont(new Font("Calibri", Font.BOLD, 36));
				 p = new JPanel();
				 p.setBackground(Color.PINK);
				p.add(l1);
				
				 f.add(p);
    	 DataInputStream sc=new DataInputStream(new FileInputStream(file));
   	  String l="";
         while((l = sc.readLine()) != null) {
        	JLabel l2=new JLabel(l+"      ");
        	 l2.setHorizontalAlignment(SwingConstants.CENTER);
			 l2.setFont(new Font("Calibri", Font.BOLD, 24));
			
			 p.add(l2);
	         f.add(p);
        	
         }
        
         sc.close();
         f.setVisible(true);
		 }else {
			JLabel l2=new JLabel("FILE DOESN'T EXIST!");
			 l2.setHorizontalAlignment(SwingConstants.CENTER);
			 l2.setFont(new Font("Calibri", Font.BOLD, 32));
			 p.add(l2);
			 f.add(p);
			// System.out.println("File doesn't exists!");
		 } p.add(new JLabel("                                             "));
		 
		JButton b=new JButton("EXIT");
		 p.add(b);
		 f.add(p);
		 b.addActionListener(this);
		 f.setVisible(true);
		

	}
}
class DoubleRoom extends Rooms{
	private Rooms r=new Rooms();
	JTextField t11,t22,t33,t44,t55;
	public void addRooms() throws IOException {
		
			setLayout(new GridLayout(6, 1));
			setSize(800,600);
			 setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true);
			
			
			 JLabel l1,l2,l3,l4,l5;
			 JButton b1,b2;
			 JPanel p,p1,p2,p3,p4;
			 
			 p = new JPanel();
			 p.setBackground(Color.white);
			l1= new JLabel("ADD ROOM");
			 l1.setHorizontalAlignment(SwingConstants.CENTER);
			 l1.setFont(new Font("Calibri", Font.BOLD, 36));
			p.add(l1);
			 add(p);
			 p1 = new JPanel();
			 p1.setBackground(Color.white);
			p1.setLayout(new FlowLayout());
			l1 = new JLabel("Enter Room No: ");
			p1.add(l1);
			t11 = new JTextField(15);
			p1.add(t11);
			l2 = new JLabel("Enter Room ID: ");
			p1.add(l2);
			t22 = new JTextField(15);
			p1.add(t22);
			add(p1);
			p2 = new JPanel();
			 p2.setBackground(Color.white);
			p2.setLayout(new FlowLayout());
			l3 = new JLabel("Enter Room Type (Double) : ");
			p2.add(l3);
			t33 = new JTextField(15);
			p2.add(t33);
			l4 = new JLabel("Enter Room Status (Booked/Not Booked): ");
			p2.add(l4);
			t44 = new JTextField(15);
			p2.add(t44);
			add(p2);
			p3 = new JPanel();
			 p3.setBackground(Color.white);
			p3.setLayout(new FlowLayout());
			l5 = new JLabel("Enter Room Guest: ");
			p3.add(l5);
			t55 = new JTextField(15);
			p3.add(t55);
			add(p3);
			p4 = new JPanel();
			 p4.setBackground(Color.white);
			p4.setLayout(new FlowLayout());
			
			 b1 = new JButton("ADD ROOM");
			 b2 = new JButton("RETURN TO HOME");
			
			 p4.add(b1);
			 p4.add(b2);

				JPanel p5 = new JPanel();
				 p5.setBackground(Color.white);
				p5.setLayout(new FlowLayout());
				add(p5);
			
			b1.addActionListener(this);
			 b2.addActionListener(this);
			
			 add(p4);
			 setVisible(true);
			
    	
    	
	}
    public void deleteRooms(int roomNo) throws IOException {
    
    	
    		File oldFile=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+"DoubleRoom.txt"); 
    		String filename="DoubleRoom.txt";
    		 if(oldFile.exists()) {
    			 super.deleteRooms(roomNo,oldFile,filename);
    	    	    }else {
    	    	    oldFile.createNewFile();
    					System.out.println("File created successfully");
    					 super.deleteRooms(roomNo,oldFile,filename);
    				}
    		
    }
    public void editRooms(int roomNo) throws IOException {
    	String filename="";
    	
        		File oldFile=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+"DoubleRoom.txt"); 
        		 filename="DoubleRoom.txt";
        		 if(oldFile.exists()) {
     				super.editRooms(roomNo,oldFile,filename);
     	    	    }else {
     	    	    oldFile.createNewFile();
     					System.out.println("File created successfully");
     					super.editRooms(roomNo,oldFile,filename);
     				}
     		
    	
    	
    }
   
    public void searchRooms(int roomNo) throws IOException {

    	
    		File oldFile=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+"DoubleRoom.txt"); 
    		String filename="DoubleRoom.txt";
    		 if(oldFile.exists()) {
 	    		super.searchRooms(roomNo,oldFile,filename);
	    	    }else {
	    	    oldFile.createNewFile();
					System.out.println("File created successfully");
					super.searchRooms(roomNo,oldFile,filename);
				}
    		
    }
    public void display() throws IOException {
    
    	JPanel p=null;
    	JFrame f =null;
    	File file=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+"DoubleRoom.txt"); 
    	if(file.exists()) {
    		f=new JFrame("ROOMS DATABASE");
				f.setSize(800,800);
				 f.setLocationRelativeTo(null);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				f.setVisible(true); 
				 
				JLabel l1 = new JLabel("                  DOUBLE ROOMS DATABASE                ");
				 l1.setHorizontalAlignment(SwingConstants.CENTER);
				 l1.setFont(new Font("Calibri", Font.BOLD, 36));
				 p = new JPanel();
				 p.setBackground(Color.PINK);
				p.add(l1);
				
				 f.add(p);
    	 DataInputStream sc=new DataInputStream(new FileInputStream(file));
   	  String l="";
         while((l = sc.readLine()) != null) {
        	JLabel l2=new JLabel(l+"      ");
        	 l2.setHorizontalAlignment(SwingConstants.CENTER);
			 l2.setFont(new Font("Calibri", Font.BOLD, 24));
			
			 p.add(l2);
	         f.add(p);
        	
         }
        
         sc.close();
         f.setVisible(true);
		 }else {
			JLabel l2=new JLabel("FILE DOESN'T EXIST!");
			 l2.setHorizontalAlignment(SwingConstants.CENTER);
			 l2.setFont(new Font("Calibri", Font.BOLD, 32));
			 p.add(l2);
			 f.add(p);
			// System.out.println("File doesn't exists!");
		 } p.add(new JLabel("                                             "));
		 
		JButton b=new JButton("EXIT");
		 p.add(b);
		 f.add(p);
		 b.addActionListener(this);
		 f.setVisible(true);
		

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("ADD ROOM")){
			File oldFile=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+"DoubleRoom.txt"); 
    	    if(oldFile.exists()) {
    		try {
    			r.room_number=Integer.parseInt(t11.getText());
    			r.room_id=Integer.parseInt(t22.getText());
    			r.room_type=t33.getText();
    			r.room_status=t44.getText();
    			r.room_guest_name=t55.getText();
				super.addRooms(r,oldFile);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	    }else {
    	    try {
				oldFile.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				System.out.println("File created successfully");
				try {
					super.addRooms(r,oldFile);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}else if(e.getActionCommand().equals("RETURN TO HOME")) {
			dispose();
			new Menu().setVisible(true);
		}else if(e.getActionCommand().equals("EXIT AND PAY")) {
			 dispose();
			 BookRooms br=new BookRooms();
			 br.roomPayment();
	    }
		else if(e.getActionCommand().equals("EXIT")) {
			dispose();
			new ReceptionistTasks();
		}else if(e.getActionCommand().equals("EDIT ROOM")) {
	    	 dispose();
	    	 
		    	
	    	 All_data +="Room No: "+t1.getText()+"\n";
    		 All_data +="Room ID: "+t2.getText()+"\n";
    		 All_data +="Room Type: "+t3.getText()+"\n";
    		 All_data +="Room Status: "+t4.getText()+"\n";
    		 All_data +="Room Guest Name: "+t5.getText()+"\n";
    		 
    		 System.out.println(All_data);
    		 File oldFile1=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+t3.getText()+"Room.txt");
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
    		 
    		 
    		 File file=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+t3.getText()+"Room.txt");
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
				JLabel l2=new JLabel("Room Updated Successfully!");
			  	 l2.setHorizontalAlignment(SwingConstants.CENTER);
					l2.setFont(new Font("Calibri", Font.BOLD, 24));
					p.add(l2);
					f2.add(p);


					JButton b=new JButton("EXIT AND PAY");
					JButton b2=new JButton("EXIT");
					p.add(b);
					p.add(b2);
					 f2.add(p);
					// f2.add(p2);
					 b.addActionListener(this);
					 b2.addActionListener(this);
					
					 
				 
	
}

			
		
	}
}
class TripleRoom extends Rooms{
	JTextField t11,t22,t33,t44,t55;
	private Rooms r=new  Rooms();
	public void addRooms() throws IOException {
		setLayout(new GridLayout(6, 1));
		setSize(800,600);
		 setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		
		 JLabel l1,l2,l3,l4,l5;
		 JButton b1,b2;
		 JPanel p,p1,p2,p3,p4;
		 
		 p = new JPanel();
		 p.setBackground(Color.white);
		l1= new JLabel("ADD ROOM");
		 l1.setHorizontalAlignment(SwingConstants.CENTER);
		 l1.setFont(new Font("Calibri", Font.BOLD, 36));
		p.add(l1);
		 add(p);
		 p1 = new JPanel();
		 p1.setBackground(Color.white);
		p1.setLayout(new FlowLayout());
		l1 = new JLabel("Enter Room No: ");
		p1.add(l1);
		t11 = new JTextField(15);
		p1.add(t11);
		l2 = new JLabel("Enter Room ID: ");
		p1.add(l2);
		t22 = new JTextField(15);
		p1.add(t22);
		add(p1);
		p2 = new JPanel();
		 p2.setBackground(Color.white);
		p2.setLayout(new FlowLayout());
		l3 = new JLabel("Enter Room Type (Triple) : ");
		p2.add(l3);
		t33 = new JTextField(15);
		p2.add(t33);
		l4 = new JLabel("Enter Room Status (Booked/Not Booked): ");
		p2.add(l4);
		t44 = new JTextField(15);
		p2.add(t44);
		add(p2);
		p3 = new JPanel();
		 p3.setBackground(Color.white);
		p3.setLayout(new FlowLayout());
		l5 = new JLabel("Enter Room Guest: ");
		p3.add(l5);
		t55 = new JTextField(15);
		p3.add(t55);
		add(p3);
		p4 = new JPanel();
		 p4.setBackground(Color.white);
		p4.setLayout(new FlowLayout());
		
		 b1 = new JButton("ADD ROOM");
		 b2 = new JButton("RETURN TO HOME");
		
		 p4.add(b1);
		 p4.add(b2);

			JPanel p5 = new JPanel();
			 p5.setBackground(Color.white);
			p5.setLayout(new FlowLayout());
			add(p5);
		
		b1.addActionListener(this);
		 b2.addActionListener(this);
		
		 add(p4);
		 setVisible(true);
		
	}
    public void deleteRooms(int roomNo) throws IOException {
    
    	
    		File oldFile=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+"TripleRoom.txt"); 
    		String filename="TripleRoom.txt";
    		 if(oldFile.exists()) {
    			 super.deleteRooms(roomNo,oldFile,filename);
    	    	    }else {
    	    	    oldFile.createNewFile();
    	    	    
    					System.out.println("File created successfully");
    					super.deleteRooms(roomNo,oldFile,filename);
    				}
    		
    }
    public void editRooms(int roomNo) throws IOException {
    	String filename="";
    	
        		File oldFile=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+"TripleRoom.txt"); 
        		 filename="TripleRoom.txt";
        		 if(oldFile.exists()) {
     				super.editRooms(roomNo,oldFile,filename);
     	    	    }else {
     	    	    oldFile.createNewFile();
     					System.out.println("File created successfully");
     					super.editRooms(roomNo,oldFile,filename);
     				}
     		
    	
    	
    }
   
    public void searchRooms(int roomNo) throws IOException {

    	
    		File oldFile=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+"TripleRoom.txt"); 
    		String filename="TripleRoom.txt";
    		 if(oldFile.exists()) {
 	    		super.searchRooms(roomNo,oldFile,filename);
	    	    }else {
	    	    oldFile.createNewFile();
					System.out.println("File created successfully");
					super.searchRooms(roomNo,oldFile,filename);
				}
    		
    }
    public void display() throws IOException {
    
    	File file=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+"TripleRoom.txt"); 
    	JPanel p=null;
    	JFrame f =null;
    	if(file.exists()) {
    		f=new JFrame("ROOMS DATABASE");
				f.setSize(800,800);
				 f.setLocationRelativeTo(null);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				f.setVisible(true); 
				 
				JLabel l1 = new JLabel("                  TRIPLE ROOMS DATABASE                ");
				 l1.setHorizontalAlignment(SwingConstants.CENTER);
				 l1.setFont(new Font("Calibri", Font.BOLD, 36));
				 p = new JPanel();
				 p.setBackground(Color.PINK);
				p.add(l1);
				
				 f.add(p);
    	 DataInputStream sc=new DataInputStream(new FileInputStream(file));
   	  String l="";
         while((l = sc.readLine()) != null) {
        	JLabel l2=new JLabel(l+"      ");
        	 l2.setHorizontalAlignment(SwingConstants.CENTER);
			 l2.setFont(new Font("Calibri", Font.BOLD, 24));
			
			 p.add(l2);
	         f.add(p);
        	
         }
        
         sc.close();
         f.setVisible(true);
		 }else {
			JLabel l2=new JLabel("FILE DOESN'T EXIST!");
			 l2.setHorizontalAlignment(SwingConstants.CENTER);
			 l2.setFont(new Font("Calibri", Font.BOLD, 32));
			 p.add(l2);
			 f.add(p);
			// System.out.println("File doesn't exists!");
		 } p.add(new JLabel("                                             "));
		 
		JButton b=new JButton("EXIT");
		 p.add(b);
		 f.add(p);
		 b.addActionListener(this);
		 f.setVisible(true);
		

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("ADD ROOM")){
			File oldFile=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+"TripleRoom.txt"); 
    	    if(oldFile.exists()) {
    		try {
    			r.room_number=Integer.parseInt(t11.getText());
    			r.room_id=Integer.parseInt(t22.getText());
    			r.room_type=t33.getText();
    			r.room_status=t44.getText();
    			r.room_guest_name=t55.getText();
				super.addRooms(r,oldFile);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	    }else {
    	    try {
				oldFile.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				System.out.println("File created successfully");
				try {
					super.addRooms(r,oldFile);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}else if(e.getActionCommand().equals("RETURN TO HOME")) {
			dispose();
			new Menu().setVisible(true);
		}else if(e.getActionCommand().equals("EXIT AND PAY")) {
			
			 BookRooms br=new BookRooms();
			 br.roomPayment();
	    }
		else if(e.getActionCommand().equals("EXIT")) {
			dispose();
			
				new ReceptionistTasks();
			
		}else if(e.getActionCommand().equals("EXIT AND PAY")) {
			
			 BookRooms br=new BookRooms();
			 br.roomPayment();
	    }
		else if(e.getActionCommand().equals("EDIT ROOM")) {
	    	
		    	
	    	 All_data +="Room No: "+t1.getText()+"\n";
    		 All_data +="Room ID: "+t2.getText()+"\n";
    		 All_data +="Room Type: "+t3.getText()+"\n";
    		 All_data +="Room Status: "+t4.getText()+"\n";
    		 All_data +="Room Guest Name: "+t5.getText()+"\n";
    		 
    		 System.out.println(All_data);
    		 File oldFile1=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+t3.getText()+"Room.txt");
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
    		 
    		 
    		 File file=new File("C:\\Users\\HP\\OneDrive\\Desktop\\"+t3.getText()+"Room.txt");
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
				JLabel l2=new JLabel("Room Updated Successfully!");
			  	 l2.setHorizontalAlignment(SwingConstants.CENTER);
					l2.setFont(new Font("Calibri", Font.BOLD, 24));
					p.add(l2);
					f2.add(p);

					JButton b=new JButton("EXIT AND PAY");
					JButton b2=new JButton("EXIT");
					p.add(b);
					p.add(b2);
					 f2.add(p);
					// f2.add(p2);
					 b.addActionListener(this);
					 b2.addActionListener(this);
					 
				 
	
}

			
		
    }

}
