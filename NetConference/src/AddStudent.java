import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import java.util.*;


public class AddStudent extends JFrame {
	static AddStudent frame;
	private JPanel contentPane;
	
	private JTextField nameTextfield;
	private JTextField emailTextfield;
	private JTextField courseTextfield;
	private JTextField feeTextfield;
	private JTextField paidTextfield;
	private JTextField dueTextfield;
	private JTextField cityTextfield;
	private JTextField stateTextfield;
	private JTextField countryTextfield;
	private JTextField contactTextfield;
	JTextArea addressField;
	private JComboBox course1field;
	
	
	
	public AddStudent()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,450,600);
		contentPane = new JPanel();
		contentPane.setForeground(Color.gray);
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("Add Student");
		label.setFont(new Font("Arial", Font.BOLD, 40));
		JLabel Namelbl = new JLabel("Name:");
		JLabel Emaillbl = new JLabel("Email id:");
		JLabel Courselbl = new JLabel("Course:");
		JLabel Feelbl = new JLabel("Fee:");
		JLabel Paidlbl = new JLabel("Paid:");
		JLabel Duelbl = new JLabel("Due:");
		JLabel Addresslbl = new JLabel("Address:");
		JLabel Citylbl = new JLabel("City:");
		JLabel Statelbl = new JLabel("State:");
		JLabel Countrylbl = new JLabel("Country:");
		JLabel Contactlbl = new JLabel("Contact No:");
	
		String courselist[] = {"Physics","Chemistry","Maths","Biology"};
		JComboBox course1field = new JComboBox(courselist);
		
		
		nameTextfield = new JTextField();
		nameTextfield.setColumns(10);
		emailTextfield = new JTextField();
		emailTextfield.setColumns(10);
		
		
		feeTextfield = new JTextField();
		feeTextfield.setColumns(10);
		paidTextfield = new JTextField();
		paidTextfield.setColumns(10);
		dueTextfield = new JTextField();
		dueTextfield.setColumns(10);
		cityTextfield = new JTextField();
		cityTextfield.setColumns(10);
		stateTextfield = new JTextField();
		stateTextfield.setColumns(10);
		countryTextfield = new JTextField();
		countryTextfield.setColumns(10);
		contactTextfield = new JTextField();
		contactTextfield.setColumns(10);
		addressField = new JTextArea();
		addressField.setRows(3);
		addressField.setColumns(10);
		
		
		JButton AddStudentbtn = new JButton("Add Student");
		AddStudentbtn.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e) 
			{
				String name= nameTextfield.getText();
				String email= emailTextfield.getText();
				String course = (String)course1field.getSelectedItem();
				//String course= courseTextfield.getText();
				int fee= Integer.parseInt(feeTextfield.getText());
				int paid= Integer.parseInt(paidTextfield.getText());
				int due= Integer.parseInt(dueTextfield.getText());
				String address= addressField.getText();
				String city= cityTextfield.getText();
				String state= stateTextfield.getText();
				String country= countryTextfield.getText();
				String contactno= contactTextfield.getText();
				
				String Email_Regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
				Boolean b= email.matches(Email_Regex);
				if(b==false) {
					JOptionPane.showMessageDialog(AddStudent.this, "invlid Email id");
					nameTextfield.setText("");
					emailTextfield.setText("");
					course1field.setSelectedItem("");
					//courseTextfield.setText("");
					feeTextfield.setText("");
					paidTextfield.setText("");
					dueTextfield.setText("");
					addressField.setText("");
					cityTextfield.setText("");
					stateTextfield.setText("");
					countryTextfield.setText("");
					contactTextfield.setText("");
				
				}else {
				
				
				Student s = new Student(name, email,course,fee, paid, due, address,city,state,country,contactno);
				int status = StudentDao.save(s);
				
				if(status>0)
				{
					JOptionPane.showMessageDialog(AddStudent.this, "Student Added");
					nameTextfield.setText("");
					emailTextfield.setText("");
					course1field.setSelectedItem("");
					//courseTextfield.setText("");
					feeTextfield.setText("");
					paidTextfield.setText("");
					dueTextfield.setText("");
					addressField.setText("");
					cityTextfield.setText("");
					stateTextfield.setText("");
					countryTextfield.setText("");
					contactTextfield.setText("");
				}
				else {JOptionPane.showMessageDialog(AddStudent.this, "Sorry, Unable to add student!!");}
			}
			}
			});
		JButton Backbtn = new JButton("Back");
		Backbtn.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e) {
				AccountantSection.main(new String[] {});
				frame.dispose();
			}});
		
		GroupLayout layout = new GroupLayout(contentPane);
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
				.addGap(30)
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addGap(20)
						.addGroup(layout.createSequentialGroup()
								.addGap(30)
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addComponent(Namelbl)
										.addComponent(Emaillbl)
										.addComponent(Courselbl)
										.addComponent(Feelbl)
										.addComponent(Paidlbl)
										.addComponent(Duelbl)
										.addComponent(Addresslbl)
										.addComponent(Citylbl)
										.addComponent(Statelbl)
										.addComponent(Countrylbl)
										.addComponent(Contactlbl)
										)
								.addGap(40)
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addComponent(nameTextfield)
										.addComponent(emailTextfield)
										.addComponent(course1field)
										.addComponent(feeTextfield)
										.addComponent(paidTextfield)
										.addComponent(dueTextfield)
										.addComponent(addressField)
										.addComponent(cityTextfield)
										.addComponent(stateTextfield)
										.addComponent(countryTextfield)
										.addComponent(contactTextfield)
										)
								)
						.addGroup(layout.createSequentialGroup()
								.addGap(40)
								.addComponent(AddStudentbtn)
								.addGap(50)
								.addComponent(Backbtn)
								)
							).addContainerGap(100,Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(Alignment.LEADING)
				.addGap(30)
				.addComponent(label)
				.addGroup(layout.createSequentialGroup()
						.addGap(60)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(Namelbl)
								.addComponent(nameTextfield)
								)
						.addGap(15)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(Emaillbl)
								.addComponent(emailTextfield)
								)
						.addGap(15)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(Courselbl)
								.addComponent(course1field)
								)
						.addGap(15)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(Feelbl)
								.addComponent(feeTextfield)
								)

						.addGap(15)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(Paidlbl)
								.addComponent(paidTextfield)
								)

						.addGap(15)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(Duelbl)
								.addComponent(dueTextfield)
								)
						.addGap(15)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(Addresslbl)
								.addComponent(addressField)
								)

						.addGap(15)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(Citylbl)
								.addComponent(cityTextfield)
								)

						.addGap(15)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(Statelbl)
								.addComponent(stateTextfield)
								)

						.addGap(15)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(Countrylbl)
								.addComponent(countryTextfield)
								)
						.addGap(15)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(Contactlbl)
								.addComponent(contactTextfield)
								)

						.addGap(15)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(AddStudentbtn)
								.addComponent(Backbtn)
								)
						)
				); contentPane.setLayout(layout);
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
				{
				public void run() {
					frame = new AddStudent();
					frame.setVisible(true);
				}
				
				}
				);
		
	}	
	
	

}
