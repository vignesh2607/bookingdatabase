package bookingapp.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Datainsert {
public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	System.out.println("user name");
	String User = sc.next();
	System.out.println("password");
	String Pass = sc.next();
	
	try 
	{
		Class.forName("com.mysql.cj.jdbc.Driver"); //step1 process loading 
		
	//STEP2---->create Connection
		String dburl = "jdbc:mysql://localhost:3306/3eje2?user=root&password=root";
		Connection con = DriverManager.getConnection(dburl);
		
	//issue the SQL query
		String query= "insert into bookingapplication.loginvalidation values(?,?)";
		
	//STEP3---->create Statement
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1,User);
		stmt.setString(2,Pass);
		
	//STEP4---->Execute query
		int count = stmt.executeUpdate();
		
	//processing the result
		if(count!=0) {
			System.out.println("data inserted successfully");
		}
		else {
			System.out.println("not inserted invalid data credentials...please check...");
		}
		
	} 
	
	catch (ClassNotFoundException | SQLException e)
	{
		e.printStackTrace();
	}
}
}

