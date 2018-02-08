import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

public class AccountantSection extends JFrame{
	static AccountantSection frame;
	private JPanel contentPane;
	
	public AccountantSection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,450,450);
		contentPane = new JPanel();
		contentPane.setForeground(Color.gray);
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("Accountant Section");
		label.setFont(new Font("Arial", Font.BOLD, 40));
		
		JButton AddStudentbtn = new JButton("Add Student");
		AddStudentbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					AddStudent.main(new String[] {});
					frame.dispose();
				}}
				);
		
		
		JButton ViewStudentbtn = new JButton("View Student");
		ViewStudentbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ViewStudent.main(new String[] {});
			frame.dispose();
			}});
	
		JButton EditStudentbtn = new JButton("Edit Student");
		EditStudentbtn.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e) {
				EditStudent.main(new String[] {});
				frame.dispose();
			}});

		JButton DueFeebtn = new JButton("Due Fee");
		DueFeebtn.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e) {
			DueFeeList.main(new String[] {});
				frame.dispose();
			}});
	
		JButton Logoutbtn = new JButton("Logout");
		Logoutbtn.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e) {
				login.main(new String[] {});
				frame.dispose();
			}});
				
		GroupLayout layout = new GroupLayout(contentPane);
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
				.addGap(30)
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addGroup(layout.createSequentialGroup()
								.addGap(30)
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addComponent(AddStudentbtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(EditStudentbtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										)
								.addGap(30)
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addComponent(ViewStudentbtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(DueFeebtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										)
								)
						.addGroup(layout.createSequentialGroup()
								.addGap(150)
								.addComponent(Logoutbtn)
								)
					
						)
				.addContainerGap(40,Short.MAX_VALUE)
				);
		
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.LEADING)
				.addGap(30)
				.addComponent(label)
				.addGroup(layout.createSequentialGroup()
						.addGap(80)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(AddStudentbtn)
								.addGap(10)
								.addComponent(ViewStudentbtn)
								)
						.addGap(40)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(EditStudentbtn)
								.addGap(10)
								.addComponent(DueFeebtn)
								)
						.addGap(40)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(Logoutbtn)
								)
						)
				
				);contentPane.setLayout(layout);
	}
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
				{
			
			public void run()
			{
				frame = new AccountantSection();
				frame.setVisible(true);
			}
				}
				);
		
	}
	
	
}
