import java.awt.Container;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



@SuppressWarnings("serial")
public class PrintTicket extends JFrame implements ActionListener{
	Container con;
	JLabel l1;
	JButton yes,no,back;
	public PrintTicket()
	{
		con=getContentPane();
		setLayout(new FlowLayout());
		l1=new JLabel("Want to print ticket ");
		con.add(l1);
		yes=new JButton("YES");
		con.add(yes);
		yes.addActionListener(this);
		no=new JButton("NO");
		con.add(no);
		no.addActionListener(new ActionListener(){
			@SuppressWarnings("rawtypes")
			public void actionPerformed(ActionEvent e) {
				new ConfirmSeat();
				setVisible(false);
			}
		});	
		back=new JButton("BACK");
		con.add(back);
		back.addActionListener(new ActionListener(){
			@SuppressWarnings("rawtypes")
			public void actionPerformed(ActionEvent e) {
				new ConfirmSeat();
				setVisible(false);
			}
		});	
		setVisible(true);
		setTitle("PRINT TICKET");
    	setSize(300,130);
    	setLocation(500,230);
    	setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
			new Print();
		
		}
  }
