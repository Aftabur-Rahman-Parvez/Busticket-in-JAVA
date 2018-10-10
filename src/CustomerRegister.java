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


import beans.CustomerDetails;
@SuppressWarnings("serial")
public class CustomerRegister  extends JFrame implements ActionListener{
	JTextField t1, t2, t3, t4;
	JPasswordField p1;
	
	JLabel l1,l2,l3,l4,l5,label;
	JButton register,display,exit,back;
	Container con;
	
	public CustomerRegister(){
		Container con=getContentPane();
		con.setLayout(new GridLayout(8,2));
		Font f= new Font("ARIAL",Font.BOLD,15);
		Font f1= new Font("Times New Roman",Font.PLAIN,14);
		label=new JLabel("    REGISTER YOURSELF : ");
		label.setFont(f);
		label.setForeground(Color.BLACK);
		con.add(label);con.add(new JLabel(" "));
		l1=new JLabel("          NAME :-");
		l1.setFont(f1);
		l1.setForeground(Color.BLUE);
		t1=new JTextField(40);
		con.add(l1);	con.add(t1);
		l2=new JLabel("          ADDRESS :-");
		l2.setFont(f1);
		l2.setForeground(Color.BLUE);
		t2=new JTextField(40);
		con.add(l2);	con.add(t2);
		l3=new JLabel("          CONTACT NUMBER :-");
		l3.setFont(f1);
		l3.setForeground(Color.BLUE);
		t3=new JTextField(40);
		con.add(l3);	con.add(t3);
		l4=new JLabel("          E-MAIL :-");
		l4.setFont(f1);
		l4.setForeground(Color.BLUE);
		t4=new JTextField(40);
		con.add(l4);	con.add(t4);
		l5=new JLabel("          PASSWORD :-");
		l5.setFont(f1);
		l5.setForeground(Color.BLUE);
		p1= new JPasswordField(30);
		con.add(l5); con.add(p1);
		register=new JButton("REGISTER AND LOG IN");
		con.add(new JLabel(" ")); con.add(register);
		register.addActionListener(this);
		/*display=new JButton("DISPLAY");
		con.add(new JLabel(" ")); con.add(display);
		display.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new CustomerDetailsDatabase();
			}
		});	*/
		back=new JButton("BACK");
		con.add(back);
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new CustomerRegisterLogin();
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
		setSize(420,380);
		setLocation(450,150);
		setResizable(false); 
		setTitle("CUSTOMER REGISTRATION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
    	}
	public static void main(String[] args) {
		new CustomerRegister();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		File f=new File("CustomerDetails.dat");
		Object obj;
		String s1=t1.getText();
		String s2=t2.getText();
		String s3=t3.getText();
		String s4=t4.getText();
		char[] s5=p1.getPassword();
		List<CustomerDetails> cuslist=new ArrayList<CustomerDetails>();
		CustomerDetails cus;
		if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals(""))
			 JOptionPane.showMessageDialog(this,"Fields should not be empty.");
		else
		{
			
		if(f.exists())
		{
		try {
				
				FileInputStream fis=new FileInputStream("CustomerDetails.dat");
				ObjectInputStream ois=new ObjectInputStream(fis);
				List<CustomerDetails> cuslist1=new ArrayList<CustomerDetails>();
				while((obj=ois.readObject())!=null){
					cuslist1=(List<CustomerDetails>)obj;
			        for(CustomerDetails cus1:cuslist1)
			        {	
			        cuslist.add(cus1);
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
		 {  
		    FileOutputStream fos=new FileOutputStream("CustomerDetails.dat");
	        ObjectOutputStream oos=new ObjectOutputStream(fos);
	        cus=new CustomerDetails(s1,s2,s3,s4,s5);
	        cuslist.add(cus);
	        oos.writeObject(cuslist);
	        JOptionPane.showMessageDialog(this,"New customer registered \n Note- Your username is  your mail id.");
	        new CustomerHomepage(s1,s2,s3);
	        setVisible(false);
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
			    FileOutputStream fos=new FileOutputStream("CustomerDetails.dat");
		        ObjectOutputStream oos=new ObjectOutputStream(fos);
		        cus=new CustomerDetails(s1,s2,s3,s4,s5);
		        cuslist.add(cus);
		        oos.writeObject(cuslist);
		        JOptionPane.showMessageDialog(this,"New Customer registered \n Note- Your username is  your mail id");
		        new CustomerHomepage(s1,s2,s3); 
		        setVisible(false);
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

	

