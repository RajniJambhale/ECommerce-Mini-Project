package com.ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class LoginUser extends Registration
{

	String username;
	String password;
	
	public LoginUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
	public String getUsername() {
		return username;
	}

    public void setUsername(String username) {
		this.username = username;
	}

    public String getPassword() {
		return password;
	}

    public void setPassword(String password) {
		this.password = password;
	}

    public  User loginUser(String username1, String password1) throws SQLException 
	{
        // User Login logic
		User user = new User();
		Registration  register = new Registration();
	
		String firstname1=null;
		int userId = 0;
		
		String 	sqlQuery2 = "SELECT firstname,userId FROM users where username= ? and password= ?";
		try 
		{
		Connection con = register.getUserConnection();
		PreparedStatement pstmt = con.prepareStatement(sqlQuery2);
		 pstmt.setString(1, username);
		 pstmt.setString(2, password);
		 
		 ResultSet resultset = pstmt.executeQuery();
		 while(resultset.next()) 
		 {
 	    	
 	    	firstname1 = resultset.getString("firstname");
 	    	userId = resultset.getInt("userId");
 	    	
 	    }
 	    con.close();
 	    pstmt.close();
 	    resultset.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
        Map<String,String>authenticatedUser = authenticateUser(username, password);

        if (authenticatedUser != null) {
            System.out.println("Login successful. Welcome, " + firstname1 + "!");
            System.out.println("Your User Id is  : " + userId  );
            return user; 
        } else {
            System.out.println("Login failed. Please check your username and password.");
            return null; 
        }
    }

    private  Map<String,String> authenticateUser(String username, String password) throws SQLException
    {
    	LoginUser loginuser = new LoginUser(username,password);
    	
    	try
    	{
    		Connection con= loginuser.getUserConnection();
    	    Statement stmt = con.createStatement();
    	    String sqlQuery1 = "SELECT username,password FROM users";
    	   
    	     ResultSet resultset = stmt.executeQuery(sqlQuery1);
    	    Map<String,String>usepass = new HashMap<>();
    	
    	    while(resultset.next()) {
    	    	String username1=resultset.getString("username");
    	    	String password1 = resultset.getString("password");
    	    	usepass.put(username1, password1);
    	    }
    	    con.close();
    	    stmt.close();
    	    resultset.close();
    	    
        for (Map.Entry<String, String> entry : usepass.entrySet()) {
            if (entry.getKey().equals(username) && entry.getValue().equals(password)) {
                return usepass;
            }
        }
    	}
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        return null; // No matching user found
        
      
    }

}
