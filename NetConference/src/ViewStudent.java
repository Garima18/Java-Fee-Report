import java.awt.*;
import java.util.List;
import java.util.*;
import javax.swing.*;

public class ViewStudent extends JFrame{
	static ViewStudent frame;
	
	public ViewStudent(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100,100,800,450);
		
		List<Student> list = StudentDao.view();
		int size = list.size();
		
		String data[][]= new String[size][12];
		int row=0;
		for(Student s:list)
		{
			data[row][0]= String.valueOf(s.getRollno());
			data[row][1]=s.getName();
			data[row][2]=s.getEmail();
			data[row][3]=s.getCourse();
			data[row][4]=String.valueOf(s.getFee());
			data[row][5]=String.valueOf(s.getPaid());
			data[row][6] = String.valueOf(s.getDue());
			data[row][7]= s.getAddress();
			data[row][8] = s.getCity();
			data[row][9] = s.getState();
			data[row][10]=s.getCountry();
			data[row][11]=s.getContactno();
			
			row++;
		}
		String ColumnNames[] = {"Roll No","Name","Email","Course","Fee","Paid","Due","Address","City","State","Country","Contact No"};
		
		JTable JT = new JTable(data,ColumnNames);
		JScrollPane sp = new JScrollPane(JT);
		add(sp);
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
				{
			public void run() {
				frame = new ViewStudent();
				frame.setVisible(true);
			}
				}
				);
		
	}
	
	
	
}
