package com.ecommerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Registration {

	
	Scanner scanner = new Scanner(System.in);
	Connection con=null;
	PreparedStatement stmt = null;
	
	 List<User>userlist = new ArrayList<User>();
	public Connection getUserConnection() throws SQLException, ClassNotFoundException
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
		   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerceproject2","root","root");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		   return con;
	
	}
	
	public List<User> registerUser() throws SQLException
	{
		System.out.println("Enter the First Name : ");
		String firstname=scanner.next();
		System.out.println("Enter the Last Name : ");
		String lastname=scanner.next();
		System.out.println("Enter the Username : ");
		String username = scanner.next();
		System.out.println("Enter the password : ");
		String password = scanner.next();
		System.out.println("Enter the city : ");
		String city = scanner.next();
		System.out.println("Enter the mail id : ");
		String mail = scanner.next();
		System.out.println("Enter the mobile number : ");
	    String mobileNumber = scanner.next();
	    

	    
	    
	    
	    
	    
	    User user = new User();
	    user.setFirstName(firstname);
	    user.setLastName(lastname);
	    user.setUserName(username);
	    user.setPassword(password);
	    user.setCity(city);
	    user.setEmail(mail);
	    user.setMobleNumber(mobileNumber);
	    
	    
//	    List<User>userlist = new ArrayList<User>();
	    userlist.add(user);
	    System.out.println(userlist);
	    
	    
	    try
	    {
	    	Connection con=getUserConnection();
	    	String insertQuery = "insert into users(username,password,firstname,lastname,city,email,mobilenumber)values(?,?,?,?,?,?,?)";
	    	stmt = con.prepareStatement(insertQuery);
	    	
	    	stmt.setString(1, username);
	    	stmt.setString(2, password);
	    	stmt.setString(3, firstname);
	    	stmt.setString(4, lastname);
	    	stmt.setString(5, city);
	    	stmt.setString(6, mail);
	    	stmt.setString(7, mobileNumber);
	    	
	    	int i=stmt.executeUpdate();
	    	System.out.println(i+"  Record inserted");
	    	
	    	
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    finally
	    {
	    	con.close();
	    	stmt.close();
	    }
	    
	    return userlist;
	}
	
	
	    
	
	
}
