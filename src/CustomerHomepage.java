import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
@SuppressWarnings("serial")
public class CustomerHomepage  extends JFrame implements ActionListener{

	private JButton button2,button3,button4,button5;
	JLabel label,l1;
	String cname,cadd,cnum;
	public CustomerHomepage(String name,String add,String num)
	{	
		cname=name;
		cadd=add;
		cnum=num;
		Container con=getContentPane();
		con.setLayout(new GridLayout(4,2));
		Font f= new Font("ARIAL",Font.BOLD,15);
		Font f1= new Font("Times New Roman",Font.BOLD,15);
		Font f2= new Font("Times New Roman",Font.BOLD,12);
		label= new JLabel("  CUSTOMER HOMEPAGE");
		label.setFont(f);
		label.setForeground(Color.BLACK);
		l1= new JLabel("             SELECT :-");
		l1.setFont(f1);
		l1.setForeground(Color.BLUE);
		button2=new JButton("BOOK TICKET ");
		button2.setFont(f2);
		button2.setForeground(Color.BLACK);
		button3=new JButton("CANCEL TICKET");
		button3.setFont(f2);
		button3.setForeground(Color.BLACK);
		button4=new JButton("SIGN OUT");
		button4.setFont(f2);
		button4.setForeground(Color.BLACK);
		button5= new JButton("EXIT");
		button5.setFont(f2);
		button5.setForeground(Color.BLACK);
		con.add(label); con.add(new JLabel(""));
		con.add(l1);con.add(button2);
		con.add(new JLabel("")); con.add(button3);
		con.add(button4);con.add(button5);
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new CustomerBookTicket(cname, cadd, cnum);
				setVisible(false);
			}
		});	
		button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new CustomerCancelTicket(cname,cadd,cnum);
				setVisible(false);
			}
		});
		button4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new CustomerRegisterLogin();
				setVisible(false);
			}
		});	
		button5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});	
		
		setSize(400,280);
		setLocation(450,200);
		setResizable(false); 
		setTitle("HOME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
