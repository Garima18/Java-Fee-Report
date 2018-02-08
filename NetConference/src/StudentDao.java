import java.util.*;
import java.sql.*;

public class StudentDao {
	public static int save(Student s) 
	{
	int status =0;
	
	try {
		Connection con = AccountantDao.getCon();
		PreparedStatement PS = con.prepareStatement("insert into student(name,email,course,fee,paid,due,address,city,state,country,contactno) values(?,?,?,?,?,?,?,?,?,?,?)");
		PS.setString(1,s.getName());
		PS.setString(2,s.getEmail());
		PS.setString(3,s.getCourse());
		PS.setInt(4,s.getFee());	
		PS.setInt(5, s.getPaid());
		PS.setInt(6,s.getDue());
		PS.setString(7, s.getAddress());
		PS.setString(8, s.getCity());
		PS.setString(9, s.getState());
		PS.setString(10, s.getCountry());
		PS.setString(11, s.getContactno());
		
		status = PS.executeUpdate();
		con.close();
		
	}catch(Exception e) {System.out.println(e);}
	return status;}
	
	public static int update(Student s) 
	{
	int status =0;
	
	try {
		Connection con = AccountantDao.getCon();
		PreparedStatement PS = con.prepareStatement("update student set name=?,email=?,course=?,fee=?,paid=?,due=?,address=?,city=?,state=?,country=?,contactno=? where rollno = ? ");
		PS.setString(1,s.getName());
		PS.setString(2,s.getEmail());
		PS.setString(3,s.getCourse());
		PS.setInt(4,s.getFee());	
		PS.setInt(5, s.getPaid());
		PS.setInt(6,s.getDue());
		PS.setString(7, s.getAddress());
		PS.setString(8, s.getCity());
		PS.setString(9, s.getState());
		PS.setString(10, s.getCountry());
		PS.setString(11, s.getContactno());
		PS.setInt(12, s.getRollno());
		
		status = PS.executeUpdate();
		con.close();
		
	}catch(Exception e) {System.out.println(e);}
	return status;}
	
	public static List<Student> view()
	{
		List<Student> list = new ArrayList<Student>();
		try {
			Connection con = AccountantDao.getCon();
			PreparedStatement ps = con.prepareStatement("Select * from student");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			Student s = new Student();
			s.setRollno(rs.getInt("rollno"));
			s.setName(rs.getString("name"));
			s.setEmail(rs.getString("email"));
			s.setCourse(rs.getString("course"));
			s.setFee(rs.getInt("fee"));
			s.setPaid(rs.getInt("paid"));
			s.setDue(rs.getInt("due"));
			s.setAddress(rs.getString("address"));
			s.setCity(rs.getString("City"));
			s.setState(rs.getString("state"));
			s.setCountry(rs.getString("country"));
			s.setContactno(rs.getString("contactno"));
			list.add(s);}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	public static Student getStudentbyRollno(int rollno) {
		Student s = new Student();
		{
			try {
				Connection con = AccountantDao.getCon();
				PreparedStatement ps = con.prepareStatement("Select * from Student where rollno =?");
				ps.setInt(1, rollno);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					s.setRollno(rs.getInt("rollno"));
					s.setName(rs.getString("name"));
					s.setEmail(rs.getString("email"));
					s.setCourse(rs.getString("course"));
					s.setFee(rs.getInt("fee"));
					s.setPaid(rs.getInt("paid"));
					s.setDue(rs.getInt("due"));
					s.setAddress(rs.getString("address"));
					s.setCity(rs.getString("City"));
					s.setState(rs.getString("state"));
					s.setCountry(rs.getString("country"));
					s.setContactno(rs.getString("contactno"));
				}con.close();
			}catch(Exception e) {System.out.println(e);}
		}
		return s;
	}
		public static List<Student> due(){
			List<Student> list = new ArrayList<Student>();
			{
				try {
					Connection con = AccountantDao.getCon();
					PreparedStatement ps = con.prepareStatement("Select * from student where due>0");
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						Student s = new Student();
						s.setRollno(rs.getInt("rollno"));
						s.setName(rs.getString("name"));
						s.setEmail(rs.getString("email"));
						s.setCourse(rs.getString("course"));
						s.setFee(rs.getInt("fee"));
						s.setPaid(rs.getInt("paid"));
						s.setDue(rs.getInt("due"));
						s.setAddress(rs.getString("address"));
						s.setCity(rs.getString("City"));
						s.setState(rs.getString("state"));
						s.setCountry(rs.getString("country"));
						s.setContactno(rs.getString("contactno"));
						list.add(s);
					}con.close();
				}catch(Exception e) {System.out.println(e);}
			}
			return list;
		}
	
}
