import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import beans.BusDetails;
@SuppressWarnings("serial")
public class RemoveBus extends JFrame implements ActionListener{
	JTextField busname;
	JLabel l1;
	JButton remove,display,exit,back,reset;
	Container con;
		public RemoveBus(){
		Container con=getContentPane();
		con.setLayout(new GridLayout(4,2));
		Font f1= new Font("Times New Roman",Font.BOLD,14);
		l1=new JLabel("ENTER NAME OF THE BUS \nTO BE REMOVED:-");
		l1.setFont(f1);
		busname=new JTextField(20);
		con.add(l1);
		con.add(busname);
		display=new JButton("DISPLAY EXISTING BUS ROUTES");
		con.add(display);
		display.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new BusDetailsDatabase();
			}
		});	
		remove=new JButton("REMOVE BUS");
		con.add(remove);
		remove.addActionListener(this);
		reset=new JButton("RESET");
		con.add(reset);
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				busname.setText("");				
			}
		});	
		back=new JButton("BACK");
		con.add(back);
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new AdministratorHomePage();
				setVisible(false);
			}
		});	
		con.add(new JLabel(" "));
		exit=new JButton("EXIT");
		con.add(exit);
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});	
		setSize(600,200);
		setLocation(400,220);
		setResizable(false); 
		setTitle("REMOVE BUS ROUTE ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
    }

	public static void main(String[] args) {
		new RemoveBus();
	}

	@SuppressWarnings({  "unchecked" })
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int flag=0;
		if(busname.getText().equals(""))
			JOptionPane.showMessageDialog(this, "Fields should not be empty");
		else
		{
		String b=busname.getText();
		int i=0;
		List<BusDetails> buslist=new ArrayList<BusDetails>();
		try{
			
			Object obj;
			FileInputStream fis=new FileInputStream("BusDetails.dat");
			ObjectInputStream ois=new ObjectInputStream(fis);
			List<BusDetails> buslist1=new ArrayList<BusDetails>();
			while((obj=ois.readObject())!=null){
				buslist1=(List<BusDetails>)obj;
		        for(BusDetails bus:buslist1)
		        {
		        	if(bus.getBusname().equalsIgnoreCase(b))
		        	 {
		        		 if(bus.getSeatbook()<=0)
			        	  {
			        		  JOptionPane.showMessageDialog(this,bus.getBusroute()+" route is succesfully removed with "+bus.getBusname()+" bus service");
			        	      i++;
			        	  }
			        	  else
			        	  { JOptionPane.showMessageDialog(this,bus.getBusname()+" bus service cannot be removed seats are already booked");
			        	  	buslist.add(bus);
			        	  	flag=1;
			        	  }
			        	 } 
		        	else
		        		buslist.add(bus);
		        }
			}
		        ois.close();
			    fis.close();
			}
			 catch(EOFException e1){
					
				   }
				  catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				  catch (IOException e1) {
						e1.printStackTrace();
					}
				  catch (ClassNotFoundException e1) {
						e1.printStackTrace();
				  }
		       if(i==0&&flag==0)
		        	JOptionPane.showMessageDialog(this, "Choosen bus does not exist");
		        else
				{
				try
				 { 
				    FileOutputStream fos=new FileOutputStream("BusDetails.dat");
			        ObjectOutputStream oos=new ObjectOutputStream(fos);
			        oos.writeObject(buslist);
			        oos.close();
			        fos.close();
			       } 
				catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} 
				catch (IOException e1) {
					e1.printStackTrace();
				}
				}
			} 
		}
	}

