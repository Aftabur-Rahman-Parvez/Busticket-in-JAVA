
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
@SuppressWarnings("serial")
public class AdministratorLogin extends JFrame implements ActionListener{
	JTextField username;
	JPasswordField pass;
	JLabel l1,l2,label;
	JButton login,exit,reset,back;
	Container con;
	public AdministratorLogin(){
		Container con=getContentPane();
		con.setLayout(new GridLayout(6,2));
		Font f=new Font("ARIAL",Font.BOLD,14);
		Font f1=new Font("Times New Roman",Font.CENTER_BASELINE,15);
		label=new JLabel("WELCOME ADMINISTRATOR");
		label.setFont(f);
		label.setForeground(Color.BLACK);
		l1=new JLabel("            ENTER USERNAME :-");
		username=new JTextField(30);
		l1.setFont(f1);
		l1.setForeground(Color.BLUE);
		l2=new JLabel("            ENTER PASSWORD :-");
		l2.setFont(f1);
		l2.setForeground(Color.BLUE);
		pass=new JPasswordField(30);
		//con.add(label); con.add(new JLabel(" "));
		//con.add(l1); con.add(username);
		//con.add(l2); con.add(pass);
		login=new JButton("LOG IN");
		con.add(new JLabel(" "));  con.add(login);
		login.addActionListener(this);
		reset=new JButton("RESET");
		//con.add(new JLabel(" ")); con.add(reset);
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				username.setText("");
				pass.setText("");
			}
		});	
		back=new JButton("BACK");
		con.add(back);
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new MainLogin();
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
		
		setSize(575, 270);
		setLocation(400,200);
		setResizable(false); 
		setTitle(" ADMINISTRATOR  LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
    }

	public static void main(String[] args) {
		new AdministratorLogin();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	/*	String p = new String(pass.getPassword());
		if(username.getText().equals("")||p.equals(""))
			JOptionPane.showConfirmDialog(this, "Fields should not be empty");
		else{
				if(username.getText().equals("souvik")&& p.equals("1000")|| username.getText().equals("palash")&& p.equals("2000")|| username.getText().equals("anadi")&& p.equals("3000")|| username.getText().equals("gautam")&& p.equals("4000")||username.getText().equals("nitish")&& p.equals("5000")   ){*/
					new AdministratorHomePage();
					setVisible(false);
				/*}
				else
					JOptionPane.showMessageDialog(this,"Username and/or password incorrect ");
		}*/
	}
}