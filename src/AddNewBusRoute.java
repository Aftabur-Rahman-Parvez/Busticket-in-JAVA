//copyright Nitish not for commercial purpose you can use this source code only for your school/college project.

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import beans.BusDetails;
@SuppressWarnings("serial")
public class AddNewBusRoute extends JFrame implements ActionListener{
	JTextField source,destination,busname,seats,arrivaltime,deperaturetime;
	@SuppressWarnings("rawtypes")
	JComboBox bustype;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JButton add,display,reset,back,exit;
	Container con;
	String type[]={"AC","Non-AC"};
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AddNewBusRoute(){
		Container con=getContentPane();
		con.setLayout(new GridLayout(7,2));
		Font f1= new Font("Times New Roman",Font.BOLD,15);
		setTitle("ADD NEW BUS ROUTE");
		l1=new JLabel("                                      SOURCE :-");
		l1.setFont(f1);
		l1.setForeground(Color.BLACK);
		source=new JTextField(27);
		con.add(l1);		con.add(source);
		l2=new JLabel("                                      DESTINATION :-");
		l2.setFont(f1);
		l2.setForeground(Color.BLACK);
		destination=new JTextField(27);
		con.add(l2); 	con.add(destination);
		JPanel p= new JPanel();
		JPanel p1= new JPanel();
		l3=new JLabel("BUS NAME :-");
		l3.setFont(f1);
		l3.setForeground(Color.BLACK);
		busname=new JTextField(5);
		p.add(l3); p.add(busname);
		l4=new JLabel("NUMBER OF SEATS:-");
		l4.setFont(f1);
		l4.setForeground(Color.BLACK);
		seats=new JTextField(5);
		p1.add(l4);
		p1.add(seats);
		con.add(p); con.add(p1);
		JPanel p2= new JPanel();
		JPanel p3= new JPanel();
		JPanel p4= new JPanel();
		l6=new JLabel("DEPARTURE TIME\n IN HR:MIN FORMAT");
		l6.setForeground(Color.BLACK);
		deperaturetime=new JTextField(6);
		p2.add(l6);
		p2.add(deperaturetime);
		l7=new JLabel("ARRIVAL TIME\n IN HR:MIN FORMAT");
		l7.setForeground(Color.BLACK);
		arrivaltime=new JTextField(6);
		p3.add(l7);
		p3.add(arrivaltime);
		con.add(p2); con.add(p3);
		l5=new JLabel("BUS TYPE:-");
		l5.setForeground(Color.BLACK);
		bustype=new JComboBox(type);
		p4.add(l5);
		p4.add(bustype);
		con.add(p4);
		add=new JButton("ADD");
		con.add(add);
		add.addActionListener(this);
		
		reset=new JButton("RESET");
		con.add(reset);
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				source.setText("");
				destination.setText("");
				busname.setText("");
				seats.setText("");
				arrivaltime.setText("");
				deperaturetime.setText("");
			}
		});	
		display=new JButton("DISPLAY");
		con.add(display);
		display.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new BusDetailsDatabase();
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
		
		setSize(700,450);
		setLocation(300,150);
		setResizable(false); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
	}

	public static void main(String[] args) {
		new AddNewBusRoute();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		File f=new File("BusDetails.dat");
		Object obj;
		String so=source.getText();
		String des=destination.getText();
		String bname=busname.getText();
		String btype=(String)(bustype.getSelectedItem());
		String deptime=deperaturetime.getText();
		String arrtime=arrivaltime.getText();
		String broute=so+"-"+des;
		List<BusDetails> buslist=new ArrayList<BusDetails>();
		BusDetails bus;
		if(so.equals("")||des.equals("")||bname.equals("")||seats.getText().equals("")||deptime.equals("")||arrtime.equals(""))
			JOptionPane.showMessageDialog(this, "Fields should not be empty");
		else
		{
			try{		
		if(f.exists())
		{
		try {
				
				FileInputStream fis=new FileInputStream("BusDetails.dat");
				ObjectInputStream ois=new ObjectInputStream(fis);
				List<BusDetails> buslist1=new ArrayList<BusDetails>();
				while((obj=ois.readObject())!=null){
					buslist1=(List<BusDetails>)obj;
			        for(BusDetails bus1:buslist1)
			        {	
			        buslist.add(bus1);
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
		 {  int se=Integer.parseInt(seats.getText());
		    FileOutputStream fos=new FileOutputStream("BusDetails.dat");
	        ObjectOutputStream oos=new ObjectOutputStream(fos);
	        bus=new BusDetails(so,des,bname,broute,btype,se,deptime,arrtime,0);
	        buslist.add(bus);
	        oos.writeObject(buslist);
	        JOptionPane.showMessageDialog(this,"New route is added succesfully");
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
			 {  int se=Integer.parseInt(seats.getText());
			    FileOutputStream fos=new FileOutputStream("BusDetails.dat");
		        ObjectOutputStream oos=new ObjectOutputStream(fos);
		        bus=new BusDetails(so,des,bname,broute,btype,se,deptime,arrtime,0);
		        buslist.add(bus);
		        oos.writeObject(buslist);
		        JOptionPane.showMessageDialog(this,"New route is added succesfully");
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
		catch(NumberFormatException e1)
		{
			JOptionPane.showMessageDialog(this,"Seats should be in integer form");
			seats.setText("");
			
		}
	  }
    }
}

	
