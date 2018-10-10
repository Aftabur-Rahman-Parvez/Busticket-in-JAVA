import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
@SuppressWarnings("serial")
public class MainLogin extends JFrame implements ActionListener{

	private JButton button1,button2,button3;
	JLabel label,l1,l,l2,l3;
	private String sysdate,systime;
	public MainLogin()
	{
		
		Container con=getContentPane();
		con.setLayout(new GridLayout(6,2));
		Font f=new Font("Times New Roman",Font.CENTER_BASELINE,15);
		Font f1=new Font("ARIAL",Font.BOLD,14);
		l=new JLabel("ROYAL CRUISER BUS SERVICES");
		l.setFont(f1);
		l.setForeground(Color.BLACK);
		l1=new JLabel("               SELECT USER :-");
		l1.setFont(f);
		l1.setForeground(Color.BLUE);
		button1=new JButton("CUSTOMER");
		button2=new JButton("ADMINISTRATOR");
		button3=new JButton("EXIT");
		Calendar cal = Calendar.getInstance();
		String cday = ""+cal.get(Calendar.DATE);
		int x =cal.get(Calendar.MONTH);
		String cmonth = ""+(x+1);
		String cyear =""+cal.get(Calendar.YEAR); 
		sysdate = cday+"/"+cmonth+"/"+cyear;
		l2=new JLabel("                                        DATE:    "+sysdate); 		
		String chr = ""+cal.get(Calendar.HOUR_OF_DAY);
		String cmin = ""+cal.get(Calendar.MINUTE);
		String csec =""+cal.get(Calendar.SECOND);
		systime = chr+":"+cmin+":"+csec;
		l3=new JLabel("                                        TIME:       "+systime);	
		con.add(l);con.add(new JLabel(""));
		con.add(new JLabel(""));con.add(l2);
		con.add(new JLabel(""));con.add(l3);
		con.add(l1);	con.add(button1);
		con.add(new JLabel(""));	con.add(button2);
		con.add(new JLabel(""));	con.add(button3);
		button1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
				new CustomerRegisterLogin();
				setVisible(false);
			}
		});	
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new AdministratorLogin();
				setVisible(false);
			}
		});	
		button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});	
		
			setSize(475, 270);
			setLocation(400,200);
			setResizable(false); 
			setTitle("BUS TICKET RESERVATION SYSTEM");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			setVisible(true);
		
		
	}
	public static void main(String args[])
	{
		new MainLogin();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
}
