import java.awt.Container;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Print extends JFrame{
		public Print(){
		Container con=getContentPane();
		JPanel panel=new JPanel();
		LayoutManager layout=new BoxLayout(panel,BoxLayout.Y_AXIS);
		panel.setLayout(layout);
		panel.add(new JLabel("Ticket number----- "+ConfirmSeat.number));
		panel.add(new JLabel("Date of journey-----  "+ConfirmSeat.date+"/"+ConfirmSeat.month+"/"+ConfirmSeat.year));
		panel.add(new JLabel("Customer name----- "+ConfirmSeat.name));
		panel.add(new JLabel("Customer address----- "+ConfirmSeat.address));
		panel.add(new JLabel("Customer mobile number----- "+ConfirmSeat.mobileno));
		panel.add(new JLabel("Source place----- "+ConfirmSeat.sou));
		panel.add(new JLabel("Destination place-----  "+ConfirmSeat.des));
		panel.add(new JLabel("Bus name----- "+ConfirmSeat.bname));
		panel.add(new JLabel("Bus rote----- "+ConfirmSeat.sou+"-"+ConfirmSeat.des));
		panel.add(new JLabel("Bus type----- "+ConfirmSeat.btype));
		panel.add(new JLabel("Number of seats booked----- "+ConfirmSeat.seat));
		panel.add(new JLabel("Bus deperature time----- "+ConfirmSeat.deptime));
		panel.add(new JLabel("Bus arrival time----- "+ConfirmSeat.arrtime));
		con.add(panel);
		setTitle("TICKET DETAILS");
		setVisible(true);
		setSize(350,250);
		setResizable(false);
		}

}
