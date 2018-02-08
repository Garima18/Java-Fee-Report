import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

public class AdminSection extends JFrame {
	static AdminSection frame;
	public JPanel contentPane;
	 
	public AdminSection()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,450,450);
		contentPane = new JPanel();
		contentPane.setForeground(Color.gray);
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("Admin Section");
		label.setFont(new Font("Arial", Font.BOLD, 40));
		
		JButton AddAccountantbtn = new JButton("Add Accountant");
		AddAccountantbtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				AddAccountant.main(new String[] {});
				frame.dispose();	
			}
		});
		
		JButton ViewAccountantbtn = new JButton("View Accountant");
		ViewAccountantbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAccountant.main(new String[] {});
				frame.dispose();
			}
		}	
		);

		
		JButton Logoutbtn = new JButton("Logout");
		Logoutbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.main(new String[] {});
				frame.dispose();
			}	
		}
		);
	
		GroupLayout layout = new GroupLayout(contentPane);
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGap(100)
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addComponent(label)
								))
						.addGroup(layout.createSequentialGroup()
								.addGap(150)
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addComponent(AddAccountantbtn)
										))
						.addGroup(layout.createSequentialGroup()
								.addGap(145)
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addComponent(ViewAccountantbtn)
										))
						.addGroup(layout.createSequentialGroup()
								.addGap(180)
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addComponent(Logoutbtn)
										))
						)
				.addContainerGap(200, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(20)
						.addComponent(label)
						.addGap(10)
						.addComponent(AddAccountantbtn)
						.addGap(10)
						.addComponent(ViewAccountantbtn)
						.addGap(10)
						.addComponent(Logoutbtn)
						.addContainerGap(50,Short.MAX_VALUE)
						)
				);
		contentPane.setLayout(layout);
	}
	
	public static void main(String args[])
	{
		EventQueue.invokeLater(new Runnable()
				{
				public void run() {
				frame = new AdminSection();
				frame.setVisible(true);
				}
				
				}
				);
	}

}
