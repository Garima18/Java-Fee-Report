import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.event.*;
import javax.swing.border.*;

import javax.swing.JFrame;


public class login extends JFrame{
	static login frame;
	private JPanel contentPane;
	public login()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100,400, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.gray);
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("Fee Report");
		label.setFont(new Font("Arial", Font.BOLD, 40));
		
		JButton adminbtn = new JButton ("Admin Login");
		adminbtn.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						AdminLogin.main(new String[] {});
						frame.dispose();
					}
				}	
				);
		JButton accountantbtn = new JButton ("Accountant Login");
		accountantbtn.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						AccountLogin.main(new String[] {});
						frame.dispose();
					}
				}	
				);
		JButton exitbtn = new JButton("Exit");
		exitbtn.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
				});
		
		GroupLayout layout = new GroupLayout(contentPane);
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
				.addGap(100)
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(label, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(adminbtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(accountantbtn,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(exitbtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						)
				.addContainerGap(300,Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(label)
						.addComponent(adminbtn, GroupLayout.PREFERRED_SIZE, 32,GroupLayout.PREFERRED_SIZE)
						.addGap(10)
						.addComponent(accountantbtn, GroupLayout.PREFERRED_SIZE, 32,GroupLayout.PREFERRED_SIZE)
						.addGap(10)
						.addComponent(exitbtn)
						)
				);
		contentPane.setLayout(layout);		
		
		/*GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(143)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(accountantbtn, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(adminbtn, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
							.addComponent(label)))
					.addContainerGap(210, Short.MAX_VALUE))
		);*/
		/*layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(label)
					.addGap(42)
					.addComponent(adminbtn, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(accountantbtn, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(91, Short.MAX_VALUE))
		);
		contentPane.setLayout(layout);
		*/
		//setVisible(true);
	}
		public static void main(String args[])
		{
			EventQueue.invokeLater(new Runnable()
					{
				public void run() {
					try {
						frame = new login();
						frame.setVisible(true);
					} 
					catch (Exception e) {
						e.printStackTrace();
					}
				}
					}
			
					);
		}
}
