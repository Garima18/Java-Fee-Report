import java.sql.*;
import java.util.*;

// 1. Connection to the Database

//2. Create the statement.

// 3. SQL Query

// 4. Process the statement

public class AccountantDao {

	public static Connection getCon()  {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		}
		catch(Exception e) {System.out.println(e);}
				return con;
	}
	
	public static boolean validate(String name, String password) {
	boolean status= false;
		try {
			Connection con = getCon();
			PreparedStatement PS = con.prepareStatement("Select * from accountant where Name = ? and Password = ?");
			PS.setString(1, name);
			PS.setString(2, password);
			ResultSet RS = PS.executeQuery();
			status = RS.next();
			con.close();
		}catch(Exception e) {System.out.println(e);}
		return status;
	}
	
	public static int save(Accountant a) {
		int status = 0;
		try {
			Connection con = getCon();
			PreparedStatement PS = con.prepareStatement("insert into accountant(name,password,email,contactno) values (?,?,?,?)");
			PS.setString(1, a.getName());
			PS.setString(2, a.getPassword());
			PS.setString(3, a.getEmail());
			PS.setString(4, a.getContactno());
			
			status = PS.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	
	public static List<Accountant> view(){
		List<Accountant> list = new ArrayList<>();
		try {
			Connection con = getCon();
			PreparedStatement PS = con.prepareStatement("Select * from accountant");
			ResultSet RS = PS.executeQuery();
			while(RS.next()) {
				Accountant a = new Accountant();
				a.setId(RS.getInt(1));
				a.setName(RS.getString(2));
				a.setPassword(RS.getString(3));
				a.setEmail(RS.getString(4));
				a.setContactno(RS.getString(5));
				list.add(a);	
			}
			con.close();
		}
		catch(Exception e) {System.out.println(e);}
		
		return list;
	}
	
	
	
	
	
}
