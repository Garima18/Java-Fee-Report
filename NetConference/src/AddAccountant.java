import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

public class AddAccountant extends JFrame {
	public JPanel contentPane;
	static AddAccountant frame;
	private JTextField nameText;
	private JTextField emailText;
	private JTextField contactText;
	private JPasswordField passwordfield;
	
	
	
	public AddAccountant()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,450,450);
		contentPane = new JPanel();
		contentPane.setForeground(Color.gray);
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("Add Accountant");
		label.setFont(new Font("Arial", Font.BOLD, 40));
		JLabel Namelbl = new JLabel("Name:");
		JLabel Passlbl = new JLabel("Password:");
		JLabel Emaillbl = new JLabel("Email Id:");
		JLabel Contactlbl = new JLabel("Contact No: ");
		
		nameText = new JTextField();
		nameText.setColumns(15);
		emailText = new JTextField();
		emailText.setColumns(15);
		contactText = new JTextField();
		contactText.setColumns(15);
		passwordfield = new JPasswordField();
		passwordfield.setColumns(15);
		
		JButton AddAccountantbtn = new JButton("Add Accountant");
		AddAccountantbtn.addActionListener(new ActionListener()
				{
				public void actionPerformed(ActionEvent e)
				{
					String name = nameText.getText();
					char ch[] = passwordfield.getPassword();
					String password = String.valueOf(ch);
					String email = emailText.getText();
					String contactno = contactText.getText();
					String Email_Regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
					Boolean b= email.matches(Email_Regex);
					if(b==false) {
						JOptionPane.showMessageDialog(AddAccountant.this, "invlid Email id");
						nameText.setText("");
						passwordfield.setText("");
						emailText.setText("");
						contactText.setText("");
					}
					else {
					
					
					Accountant a =  new Accountant(name,password,email,contactno);
					int status=AccountantDao.save(a);
					
					if(status>0)
					{
						JOptionPane.showMessageDialog(AddAccountant.this, "Accountant Added Successfully");
						nameText.setText("");
						passwordfield.setText("");
						emailText.setText("");
						contactText.setText("");
					}else {
						JOptionPane.showMessageDialog(AddAccountant.this, "Sorry, Not able to add Accountant");
					}	
				}}
				});
		JButton Backbtn = new JButton("Back");
		Backbtn.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				AdminSection.main(new String[] {});
				frame.dispose();
			}
				}
				);

		GroupLayout layout= new GroupLayout(contentPane);
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
				.addGap(100)
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addGroup(layout.createSequentialGroup()
								.addGap(40)
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addComponent(Namelbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

										.addComponent(Passlbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(Emaillbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(Contactlbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								)
								.addGap(20)
								.addGroup(layout.createParallelGroup(Alignment.TRAILING)
								.addComponent(nameText)
								.addComponent(passwordfield)
								.addComponent(emailText)
								.addComponent(contactText)
								))
							.addGroup(layout.createSequentialGroup()
									.addGap(30)
									.addComponent(AddAccountantbtn)
									.addGap(30)
									.addComponent(Backbtn)
									))
				.addContainerGap(100,Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.LEADING)
				.addComponent(label)
				.addGroup(layout.createSequentialGroup()
						
						.addGap(50)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(Namelbl,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(10)
								.addComponent(nameText))
						.addGap(20)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(Passlbl)
								.addGap(10)
								.addComponent(passwordfield))
						.addGap(20)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(Emaillbl)
								.addGap(10)
								.addComponent(emailText))
						.addGap(20)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(Contactlbl)
								.addGap(10)
								.addComponent(contactText))
						.addGap(20)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(AddAccountantbtn)
								.addComponent(Backbtn)
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
						frame = new AddAccountant();
						frame.setVisible(true);
					}
				}
				);
	}
	

}
