import java.awt.BorderLayout;
import java.awt.Container;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import beans.TicketDetails;


@SuppressWarnings("serial")
public class TicketDatabase extends JFrame{
		JTable ticketTable;
		String cols[]={"Ticket Number","Passenger Name"};
		String[][] rows;
		@SuppressWarnings("unchecked")
		public TicketDatabase(){
			File f=new File("TicketDetails.dat");
			Container con=getContentPane();
			setLayout(new BorderLayout());
			int r=0;
			if(f.exists())
			{
			try {
				FileInputStream fis=new FileInputStream("TicketDetails.dat");
				ObjectInputStream ois=new ObjectInputStream(fis);
				Object obj;
		        List<TicketDetails> tlist=new ArrayList<TicketDetails>();
		        while((obj=ois.readObject())!=null){
			        tlist=(List<TicketDetails>)obj;
			        rows=new String[tlist.size()][cols.length];
			        for(TicketDetails t:tlist)
			        {
			        rows[r][0]=String.valueOf(t.getTicketnumber());
			        rows[r][1]=t.getName();
					r++;
			        }
			        }
		        
		       ois.close();
		       fis.close();
		       }
		   catch(EOFException e){
			   
		   }
		   catch (FileNotFoundException e) {
			   JOptionPane.showMessageDialog(this, "No database is created");
			   
			} 
		   catch (IOException e) {
				e.printStackTrace();
			} 
		   catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			}
			if(r!=0)
			{
			ticketTable=new JTable(rows,cols);
			JScrollPane pane=new JScrollPane(ticketTable);
			con.add(pane,"Center");
			setVisible(true);
			setSize(250,200);
			setLocation(500,200);
			setTitle("TICKET BOOK DATABASE");
			setResizable(false);
			}
			else
				 JOptionPane.showMessageDialog(this, "There is no ticket booked");
			}

	

}
