import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;


public class EditStudent extends JFrame{
	static EditStudent frame;
	private JPanel contentPane;
	private JTextField rollnoTextfield;
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

	public EditStudent()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,450,500);
		contentPane = new JPanel();
		contentPane.setForeground(Color.gray);
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		
		JLabel Rollnolbl = new JLabel("Roll No:");
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
		
		JSeparator separator = new JSeparator();
		
		rollnoTextfield = new JTextField();
		rollnoTextfield.setColumns(8);
		nameTextfield = new JTextField();
		nameTextfield.setColumns(10);
		emailTextfield = new JTextField();
		emailTextfield.setColumns(10);
		courseTextfield = new JTextField();
		courseTextfield.setColumns(10);
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
		
		JButton Loadbtn = new JButton("Load Record");
		Loadbtn.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						String srollno = rollnoTextfield.getText();
						if(srollno == null||srollno.trim().equals(" ")) {
							JOptionPane.showMessageDialog(EditStudent.this, "Please enter valid Roll no.");
						}
						else {
							
							int rollno = Integer.parseInt(srollno);
							Student s = StudentDao.getStudentbyRollno(rollno);
							nameTextfield.setText(s.getName());
							emailTextfield.setText(s.getEmail());
							courseTextfield.setText(s.getCourse());
							feeTextfield.setText(String.valueOf(s.getFee()));
							paidTextfield.setText(String.valueOf(s.getPaid()));
							dueTextfield.setText(String.valueOf(s.getDue()));
							addressField.setText(s.getAddress());
							cityTextfield.setText(s.getCity());
							stateTextfield.setText(s.getState());
							countryTextfield.setText(s.getCountry());
							contactTextfield.setText(s.getContactno());
						}}
				}
				);
		
		JButton UpdateStudentbtn = new JButton("Update Student");
		UpdateStudentbtn.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e) {
				int rollno = Integer.parseInt(rollnoTextfield.getText());
				String name= nameTextfield.getText();
				String email= emailTextfield.getText();
				String course= courseTextfield.getText();
				int fee= Integer.parseInt(feeTextfield.getText());
				int paid= Integer.parseInt(paidTextfield.getText());
				int due= Integer.parseInt(dueTextfield.getText());
				String address= addressField.getText();
				String city= cityTextfield.getText();
				String state= stateTextfield.getText();
				String country= countryTextfield.getText();
				String contactno= contactTextfield.getText();
				
				Student s = new Student(rollno,name,email,course,fee,paid,due,address,city,state,country,contactno);
				int status = StudentDao.update(s);
				
				if(status>0) {
					JOptionPane.showMessageDialog(EditStudent.this, "Student Updated Successfully");
					AccountantSection.main(new String[] {});
					frame.dispose();
				}else {
					JOptionPane.showMessageDialog(EditStudent.this, "Error!! Student not updated");
				}
				}});
				
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
				.addGap(10)
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
				.addGap(20)
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(Rollnolbl)
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
				.addGap(30)
				.addGroup(layout.createParallelGroup(Alignment.LEADING,false)
						.addComponent(rollnoTextfield)
						.addComponent(nameTextfield)
						.addComponent(emailTextfield)
						.addComponent(courseTextfield)
						.addComponent(feeTextfield)
						.addComponent(paidTextfield)
						.addComponent(dueTextfield)
						.addComponent(addressField)
						.addComponent(cityTextfield)
						.addComponent(stateTextfield)
						.addComponent(countryTextfield)
						.addComponent(contactTextfield)
						)
				.addGap(10)
				.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(Loadbtn))
				)
						.addGap(40)
						.addGroup(layout.createSequentialGroup()
								.addComponent(separator)
								)
						.addGroup(layout.createSequentialGroup()
								.addGap(50)
								.addComponent(UpdateStudentbtn)
								.addGap(30)
								.addComponent(Backbtn)
								)
				).addContainerGap(10,Short.MAX_VALUE));
				layout.setVerticalGroup(
						layout.createParallelGroup(Alignment.LEADING)
						.addGap(30)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(Rollnolbl)
										.addComponent(rollnoTextfield)
										.addComponent(Loadbtn)
										)
								.addGap(10)
								.addComponent(separator)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(Namelbl)
										.addComponent(nameTextfield)
										)
								.addGap(10)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(Emaillbl)
										.addComponent(emailTextfield)
										)
								.addGap(10)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(Courselbl)
										.addComponent(courseTextfield)
										)
								.addGap(10)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(Feelbl)
										.addComponent(feeTextfield)
										)
								.addGap(10)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(Paidlbl)
										.addComponent(paidTextfield)
										)
								.addGap(10)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(Duelbl)
										.addComponent(dueTextfield)
										)
								.addGap(10)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(Addresslbl)
										.addComponent(addressField)
										)
								.addGap(10)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(Citylbl)
										.addComponent(cityTextfield)
										)
								.addGap(10)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(Statelbl)
										.addComponent(stateTextfield)
										)
								.addGap(10)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(Countrylbl)
										.addComponent(countryTextfield)
										)
								.addGap(10)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(Contactlbl)
										.addComponent(contactTextfield)
										)
								.addGap(10)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(UpdateStudentbtn)
										.addComponent(Backbtn)
										)
								));contentPane.setLayout(layout);
}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
				{
			public void run() {
				frame = new EditStudent();
				frame.setVisible(true);
			}
				}
				);
	}

}
