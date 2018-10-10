
import java.awt.*;
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
import beans.BusDetails;
@SuppressWarnings("serial")
public class BusDetailsDatabase extends JFrame{
	JTable busTable;
	String cols[]={"Bus Name","Bus Route","Bus Type","Departure time","Arrival time","Seats Available"};
	String[][] rows;
	@SuppressWarnings("unchecked")
	public BusDetailsDatabase(){
		File f=new File("BusDetails.dat");
		Container con=getContentPane();
		setLayout(new BorderLayout());
		int r=0,flag=0;
		if(f.exists())
		{
		try {
			FileInputStream fis=new FileInputStream("BusDetails.dat");
			ObjectInputStream ois=new ObjectInputStream(fis);
			Object obj;
	        List<BusDetails> blist=new ArrayList<BusDetails>();
	        while((obj=ois.readObject())!=null){
		        blist=(List<BusDetails>)obj;
		        rows=new String[blist.size()][cols.length];
		        for(BusDetails b:blist)
		        {rows[r][0]=b.getBusname();
				rows[r][1]=b.getBusroute();
				rows[r][2]=b.getBustype();
				rows[r][5]=String.valueOf(b.getSeats());
				rows[r][4]=b.getDeperaturetime();
				rows[r][3]=b.getArrivaltime();
				r++;
				flag=1;}
		        }
	        
	       ois.close();
	       fis.close();
	       }
	   catch(EOFException e){
		   
	   }
	   catch (FileNotFoundException e) {
		   JOptionPane.showConfirmDialog(this, "There is no bus service");
		   
		} 
	   catch (IOException e) {
			e.printStackTrace();
		} 
	   catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		}
		if(r!=0&&flag==1)
		{
		busTable=new JTable(rows,cols);
		JScrollPane pane=new JScrollPane(busTable);
		con.add(pane,"Center");
		setVisible(true);
		setSize(800,200);
		setLocation(250,200);
		setTitle("BUS DETAILS DATABASE");
		setResizable(false);
		}
		}
	/*public static void main(String args[]){
		new BusDetailsDatabase();
	}*/
}
