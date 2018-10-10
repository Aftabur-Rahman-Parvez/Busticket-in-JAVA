
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import beans.BusDetails;
import beans.TicketDetails;


@SuppressWarnings("serial")
public class BookTicket extends JFrame{
    int seatavailable;
    String so,des,bname,deptime,arrtime;
    int s=0;
	@SuppressWarnings("unchecked")
	public BookTicket(String name, String address, String mobileno, String route,
			String type, int seat,Date dt) {
		int flag1=0,flag2=0;
		List<BusDetails> buslist=new ArrayList<BusDetails>();
		
		BusDetails bus;
		File f=new File("BusDetails.dat");
		if(f.exists())
		{
		try {
			FileInputStream fis=new FileInputStream("BusDetails.dat");
			ObjectInputStream ois=new ObjectInputStream(fis);
			Object obj;
	        List<BusDetails> blist=new ArrayList<BusDetails>();
	        while((obj=ois.readObject())!=null){
		        blist=(List<BusDetails>)obj;
		        for(BusDetails b:blist)
		        { 
		        	if(route.equalsIgnoreCase(b.getBusroute())&&type.equals(b.getBustype()))
		        	{ flag1=1;
		        		if(b.getSeats()>=seat)
		        		{	if(flag2!=1)
		        			{
		        			so=b.getSource();
		        			des=b.getDestination();
		        			bname=b.getBusname();
		        			deptime=b.getDeperaturetime();
		        			arrtime=b.getArrivaltime();
		        			seatavailable=b.getSeats()-seat;
		        			bus=new BusDetails(so,des,bname,route,type,seatavailable,deptime,arrtime,seat+b.getSeatbook());
		        			buslist.add(bus);
		        			JOptionPane.showMessageDialog(this,"Ticket is booked");
		        			flag2=1;
		        			}
		        		    else
		        		    buslist.add(b);
		        	    }	
		        		else
		        		buslist.add(b);
		        	}
		        	else
		        		buslist.add(b);
		        }
		        }
	        	ois.close();
	        	fis.close();
				}
				catch(EOFException e){
		   
				}
				catch (FileNotFoundException e) {
					JOptionPane.showConfirmDialog(this, "There is no bus service");
		   
				} 
				catch (IOException e) {
					e.printStackTrace();
				} 
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				}
				if(flag2==0&&flag1==1)
					JOptionPane.showMessageDialog(this, "Seat is not available in the bus");
				else
				{if(flag1==0)
					JOptionPane.showMessageDialog(this, route+" route does not exist or "+type+" bus service doesnot exist for the "+route+" route\n Please check Available Bus services.");
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
				File f1=new File("TicketDetails.dat");
				List<TicketDetails> ticketlist=new ArrayList<TicketDetails>();
				TicketDetails ticket ;
				ArrayList<Integer>	list=new ArrayList<Integer>();
				int maxno;
				if(f1.exists())
				{
				try {
						Object obj;
						FileInputStream fis=new FileInputStream("TicketDetails.dat");
						ObjectInputStream ois=new ObjectInputStream(fis);
						List<TicketDetails> ticketlist1=new ArrayList<TicketDetails>();
						while((obj=ois.readObject())!=null){
							ticketlist1=(List<TicketDetails>)obj;
					        for(TicketDetails ticket1:ticketlist1)
					        {	
					        if((ticket1.getTicketnumber())!='\0')	
					        { list.add(ticket1.getTicketnumber());	
					        ticketlist.add(ticket1);
					        s=1;
					        }
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
				try
				 {  if(s==1)
					{maxno=Collections.max(list);
					maxno++;}
				 	else
				 		maxno=1000;
					JOptionPane.showMessageDialog(this, "Customer ticket number is "+maxno);
					FileOutputStream fos=new FileOutputStream("TicketDetails.dat");
			        ObjectOutputStream oos=new ObjectOutputStream(fos);
			        ticket=new TicketDetails(name,address,mobileno,so,des,bname,route,type,seat,maxno,arrtime,
			    			deptime,dt);
			        ticketlist.add(ticket);
			        oos.writeObject(ticketlist);
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
				else
				{
					
				try
					 { 
					    FileOutputStream fos=new FileOutputStream("TicketDetails.dat");
				        ObjectOutputStream oos=new ObjectOutputStream(fos);
				        ticket=new TicketDetails(name,address,mobileno,so,des,bname,route,type,seat,1000,arrtime,
				    			deptime,dt);
				        JOptionPane.showMessageDialog(this, "Customer ticket number is "+ticket.getTicketnumber());
				        ticketlist.add(ticket);
				        oos.writeObject(ticketlist);
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
    
}



