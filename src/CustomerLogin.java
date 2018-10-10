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
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import beans.CustomerDetails;
@SuppressWarnings("serial")
public class CustomerLogin extends JFrame implements ActionListener{
	JTextField username;
	JPasswordField pass;
	JLabel l1,l2,label;
	JButton login,exit,reset,back;
	Container con;
	public CustomerLogin(){
		Container con=getContentPane();
		con.setLayout(new GridLayout(6,2));
		Font f= new Font("ARIAL",Font.BOLD,15);
		Font f1= new Font("Times New Roman",Font.PLAIN,14);
		label=new JLabel("LOG IN : ");
		label.setFont(f);
		label.setForeground(Color.BLACK);
		l1=new JLabel("ENTER E-MAIL ID/USERNAME :-");
		username=new JTextField(30);
		l1.setFont(f1);
		l1.setForeground(Color.BLUE);
		l2=new JLabel("ENTER PASSWORD :-");
		l2.setFont(f1);
		l2.setForeground(Color.BLUE);
		pass=new JPasswordField(30);
		login=new JButton("LOG IN");
		reset=new JButton("RESET");
		back=new JButton("BACK");
		exit=new JButton("EXIT");
		con.add(label); con.add(new JLabel(""));
		con.add(l1);con.add(username);
		con.add(l2);con.add(pass);
		con.add(new JLabel(""));con.add(login);
		con.add(new JLabel(""));con.add(reset);
		con.add(back);con.add(exit);
		login.addActionListener(this);
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				username.setText("");
				pass.setText("");
			}
		});	
			back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new CustomerRegisterLogin();
				setVisible(false);
			}
		});
			exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});	
		
			setSize(420,300);
			setLocation(400,200);
			setResizable(false); 
			setTitle("SIGN IN");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			setVisible(true);
    }

	public static void main(String[] args) {
		new CustomerLogin();
	}

	@SuppressWarnings({  "unchecked" })
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int flag=0;
		if(username.getText().equals("")||pass.getPassword().equals(""))
			JOptionPane.showMessageDialog(this, "Fields should not be empty");
		else
		{
		int i=1;
		List<CustomerDetails> cuslist=new ArrayList<CustomerDetails>();
		try{
			
			Object obj;
			FileInputStream fis=new FileInputStream("CustomerDetails.dat");
			ObjectInputStream ois=new ObjectInputStream(fis);
			List<CustomerDetails> cuslist1=new ArrayList<CustomerDetails>();
			while((obj=ois.readObject())!=null){
				cuslist1=(List<CustomerDetails>)obj;
		        for(CustomerDetails cus:cuslist1)
		        {
		        	if(cus.getEmail().equals(username.getText())&&String.valueOf(cus.getPass()).equals(String.valueOf( pass.getPassword())))
		        	 {
		        	 
		        	  new CustomerHomepage(cus.getName(),cus.getAdd(),cus.getPhno());
		        	  i=0;
		        	  setVisible(false);
		        	 }
		        	else
		        	 cuslist.add(cus);
	
		        }
			}
		        ois.close(); 
			    fis.close();
			}
			 catch(EOFException e1){
					
				   }
				  catch (FileNotFoundException e1) {
					  JOptionPane.showConfirmDialog(this, "Customer have to register first ");
					  flag=1;
					}
				  catch (IOException e1) {
					  JOptionPane.showConfirmDialog(this, "Customer have to register first ");
					  flag=1;
					}
				  catch (ClassNotFoundException e1) {
						e1.printStackTrace();
				  }
		       if(i==1&&flag==0)
		        	JOptionPane.showMessageDialog(this, "Username or/and password incorrect");
		    
			} 
		}
	}