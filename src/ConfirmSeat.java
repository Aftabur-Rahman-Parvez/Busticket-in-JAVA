import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import beans.TicketDetails;


@SuppressWarnings("serial")
public  class ConfirmSeat<Static> extends JFrame implements ActionListener{
	static String sou,des,broute,btype,bname,deptime,arrtime,name,address,mobileno;
	static int seat,date,month,year;
	static int number;
	Date dt;
	JTextField ticketno;
	JLabel l1;
	JButton seatconform,exit,reset,display,back,bookdet;
	public ConfirmSeat(){
		Container con=getContentPane();
		con.setLayout(new GridLayout(4,2));
		Font f1= new Font("Times New Roman",Font.BOLD,15);
		l1=new JLabel("ENTER TICKET NUMBER");
		l1.setFont(f1);
		l1.setForeground(Color.BLUE);
		ticketno=new JTextField(6);
		con.add(l1);  		con.add(ticketno);
		seatconform=new JButton("CONFIRM BOOKING");
		con.add(new JLabel(" "));  con.add(seatconform);
		seatconform.addActionListener(this);
		bookdet=new JButton("BOOKING DETAILS");
		 con.add(bookdet);
		bookdet.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new TicketDatabase();
				
			}
		});	
		reset=new JButton("RESET");
		 con.add(reset);
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				seatconform.setText(" ");
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
		exit=new JButton("EXIT");
		 con.add(exit);
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});	
		setSize(400,230);
		setLocation(450,200);
		setResizable(false); 
		setTitle("CONFIRMATION OF TICKET :");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
    }
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
			new ConfirmSeat();
	}
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int i=0,flag=0;
		@SuppressWarnings("unused")
		List<TicketDetails> ticketlist=new ArrayList<TicketDetails>();
		if(ticketno.getText().equals(""))
			JOptionPane.showMessageDialog(this, "Fields should not be empty");
		else
		{
		try{	
			number=Integer.parseInt(ticketno.getText());
		try{
			Object obj;
			FileInputStream fis=new FileInputStream("TicketDetails.dat");
			ObjectInputStream ois=new ObjectInputStream(fis);
			List<TicketDetails> ticketlist1=new ArrayList<TicketDetails>();
			while((obj=ois.readObject())!=null){
				ticketlist1=(List<TicketDetails>)obj;
		        for(TicketDetails ticket:ticketlist1)
		        {
		        	if(number==ticket.getTicketnumber())
		        	 {
		        		seat=ticket.getSeat();
		        	  	sou=ticket.getSource();
	        			des=ticket.getDestination();
	        			bname=ticket.getBusname();
	        			btype=ticket.getBustype();
	        			deptime=ticket.getDeperaturetime();
	        			arrtime=ticket.getArrivaltime();
	        			name=ticket.getName();
	        			address=ticket.getAddress();
	        			mobileno=ticket.getMobileno();
	        			year=ticket.getDate().getYear();
	        			month=ticket.getDate().getMonth();
	        			date=ticket.getDate().getDate();
	        			JOptionPane.showMessageDialog(this,"Seat is confirmed");
	        			ticketno.setText("");	
	        			new PrintTicket();
	        			setVisible(false);
	        			i++;
		        	 }
		        }
			}
		        ois.close();
			    fis.close();
			}
			 catch(EOFException e1){
					
				   }
				  catch (FileNotFoundException e1) {
					  JOptionPane.showMessageDialog(this, "No ticket is booked");
					  flag=1;
					}
				  catch (IOException e1) {
						e1.printStackTrace();
					}
				  catch (ClassNotFoundException e1) {
						e1.printStackTrace();
				  }
				  if(i==0&&flag==0)
			        	JOptionPane.showMessageDialog(this, "Not a valid ticket number");
		}catch(NumberFormatException e1)
		{
			JOptionPane.showMessageDialog(this,"Ticket number should be in integer form");
			ticketno.setText("");	
		}
		}	
		}
	}
