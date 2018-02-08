import java.awt.*;
import javax.swing.*;
import java.util.List;

public class ViewAccountant extends JFrame{
	static ViewAccountant frame;
	
	public ViewAccountant(){
		List<Accountant> list = AccountantDao.view();
		int size = list.size();
		
		String data[][]=new String[size][5];
		int row =0;
		for(Accountant a:list)
		{
			data[row][0]=String.valueOf(a.getId());
			data[row][1]=a.getName();
			data[row][2]=a.getPassword();
			data[row][3] = a.getEmail();
			data[row][4]= a.getContactno();
			row++;
		}
		String columns[] = {"ID","Name","Password","Email id","Contact No"};
		
		JTable tbl = new JTable(data,columns);
		JScrollPane scroll = new JScrollPane(tbl);
		add(scroll);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100,100,450,450);
		
	}
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
				{
			public void run()
			{
				frame= new ViewAccountant();
				frame.setVisible(true);
			}
				}
				);
		
	}
	

}
