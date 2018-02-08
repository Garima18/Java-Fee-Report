import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;



public class AdminLogin extends JFrame {
	static AdminLogin frame;
	private JPanel contentPane;
	private JTextField textfield;
	private JPasswordField passwordfield;
	
	public AdminLogin()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,450,450);
		contentPane = new JPanel();
		contentPane.setForeground(Color.gray);
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("Admin Login");
		label.setFont(new Font("Arial", Font.BOLD, 40));
		
		JLabel Adminlbl = new JLabel("Name:");
		JLabel Passlbl = new JLabel("Password:");
		
		textfield = new JTextField();
		textfield.setColumns(15);
		
		passwordfield = new JPasswordField();
		
		JButton admloginbtn = new JButton("Login");
		admloginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textfield.getText();
				char ch[] = passwordfield.getPassword();
				String password = String.valueOf(ch);
				if(name.equals("admin")&&password.equals("admin123"))
				{
					String s[] = {};
					AdminSection.main(s);
					frame.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(AdminLogin.this,"Sorry, Worng name or Password");
					textfield.setText("");
					passwordfield.setText("");
				}				
			}
		}
		);
		GroupLayout layout = new GroupLayout(contentPane);
		layout.setHorizontalGroup(
			layout.createSequentialGroup()
			.addGap(100)
			.addGroup(layout.createParallelGroup(Alignment.LEADING)
					.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
							.addGap(32)
							.addComponent(Adminlbl)
							.addComponent(Passlbl)
							))
					.addGroup(layout.createSequentialGroup()
							.addGap(90)
							.addGroup(layout.createParallelGroup(Alignment.TRAILING,false)
							.addComponent(textfield)
							.addComponent(passwordfield)
							))
					.addComponent(admloginbtn, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
					)
			.addContainerGap(111,Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(label)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(Adminlbl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								)
						.addGap(23)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(Passlbl,GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								)
						.addGap(23)
						.addComponent(admloginbtn,GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						)
				
				);
		contentPane.setLayout(layout);
	}
	public static void main(String args[])
	{
		EventQueue.invokeLater(new Runnable()
				{
			public void run()
			{try {
				frame = new AdminLogin();
				frame.setVisible(true);
			}catch(Exception e) { e.printStackTrace();}	
			}
				}
				);
	}

}
