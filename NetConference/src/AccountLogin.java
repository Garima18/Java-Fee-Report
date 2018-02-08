import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

public class AccountLogin extends JFrame {
	static AccountLogin frame;
	public JPanel contentPane;
	public JTextField nameText;
	public JPasswordField passwordfield;
	
	public AccountLogin()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,450,450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("Accountant Login");
		label.setFont(new Font("Arial", Font.BOLD, 40));
		
		JLabel Accountantlbl = new JLabel("Name:");
		nameText = new JTextField();
		nameText.setColumns(15);
		JLabel Passwordlbl = new JLabel("Password: ");
		passwordfield = new JPasswordField();
		
		JButton Loginbtn = new JButton("Login");
		Loginbtn.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				String name = nameText.getText();
				String password = String.valueOf(passwordfield.getPassword());
				boolean status = AccountantDao.validate(name,password);
				
				if(status)
				{
					AccountantSection.main(new String[] {});
					frame.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(AccountLogin.this, "Sorry, Invalid Accountant");
				}
			}
				}
				);
		JButton Backbtn = new JButton("Back");
		Backbtn.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e) {
				login.main(new String[] {});
				frame.dispose();}
				}
				);
		GroupLayout layout = new GroupLayout(contentPane);
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
				.addGap(40)
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGap(40)
								.addComponent(label)
						.addGroup(layout.createSequentialGroup()
								.addGap(40)
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(Accountantlbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(Passwordlbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								)
						.addGap(30)
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(nameText)
								.addGap(30)
								.addComponent(passwordfield)
								))
						.addGroup(layout.createSequentialGroup()
								.addGap(30)
								.addComponent(Loginbtn, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
								.addGap(30)
								.addComponent(Backbtn, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
								)
						)
				.addContainerGap(100,Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.LEADING)
				.addGap(50)
				.addComponent(label)
				
				.addGroup(layout.createSequentialGroup()
						.addGap(70)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addGap(30)
								.addComponent(Accountantlbl)
								.addGap(20)
								.addComponent(nameText)
						)
				.addGap(30)
				
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addGap(30)
								.addComponent(Passwordlbl)
								.addGap(20)
								.addComponent(passwordfield)
								)
						.addGap(30)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
				.addComponent(Loginbtn)
				.addComponent(Backbtn)
						))
				);contentPane.setLayout(layout);
	}
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
				{
				public void run()
				{
					frame = new AccountLogin();
					frame.setVisible(true);
				}}
				);
		
	}
}