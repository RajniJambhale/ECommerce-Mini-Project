package com.ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminOperation 
{

	Registration registration = new Registration();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet resultset = null;
	Admin1 admin = new Admin1();
	
	Scanner scanner = new Scanner(System.in);
	
	
	public void AddProductToTable() throws SQLException
	{
		System.out.println("Product Id : ");
		int pid = scanner.nextInt();
		
		System.out.println("Product Name : ");
		String pname = scanner.next();
		
		System.out.println("Product Description : ");
		String pdescription = scanner.next();
		
		System.out.println("Quantity : ");
		int quantity = scanner.nextInt();
		
		System.out.println("Price : ");
		double price = scanner.nextDouble();
		
		
		admin.setProductId(pid);
		admin.setProductName(pname);
		admin.setDescription(pdescription);
		admin.setQuantity(quantity);
		admin.setPrice(price);
		
		List productlist = new ArrayList<>();
		productlist.add(pid);
		productlist.add(pname);
		productlist.add(pdescription);
		productlist.add(quantity);
		productlist.add(price);
		
		System.out.println(productlist);
		
		
		
		try
		{
			Registration registration = new Registration();
			con=registration.getUserConnection();
			String sqlProductInsert = "Insert into products(productId,name,description,price,quantity)values(?,?,?,?,?) ";
			
			registration.getUserConnection();
			pstmt=con.prepareStatement(sqlProductInsert);
			
			
			pstmt.setInt(1, pid);
			pstmt.setString(2,pname);
			pstmt.setString(3,pdescription);
			pstmt.setDouble(4, price);
			pstmt.setInt(5, quantity);
			
			
			pstmt.execute();
			System.out.println("Insertion Successfully Done ");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally {
		    
		    try {
		        if (resultset != null) {
		            resultset.close();
		        }
		        if (pstmt != null) {
		            pstmt.close();
		        }
		        if (con != null) {
		            con.close();
		        }
		    } 
		    catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		
		
		
	}

	public double DisplayAmountToEndUser()
	{
		
		double Amount =admin.getPrice()* admin.getQuantity();
		return Amount;
		
	}
	
	
	public int CheckQuantity(int productId) throws SQLException, ClassNotFoundException {
	    int quantity = -1;
	    
	    try {
	        con = registration.getUserConnection();
	        String sqlQuantity = "SELECT quantity FROM products WHERE productId = ?";
	        pstmt = con.prepareStatement(sqlQuantity);
	        pstmt.setInt(1, productId);
	        resultset = pstmt.executeQuery();
	        
	        if (resultset.next()) {
	            
	            quantity = resultset.getInt("quantity");
	            
	        } else {
	            System.out.println("Product with productId " + productId + " not found.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        
	        try {
	            if (resultset != null) {
	                resultset.close();
	            }
	            if (pstmt != null) {
	                pstmt.close();
	            }
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return quantity;
	}

	
	
	public void DisplayRegisteredUser () throws SQLException
	{
		try
		{
			String sqlRegisterUser = "SELECT * FROM users";
			con= registration.getUserConnection();
			pstmt=con.prepareStatement(sqlRegisterUser);
			resultset=pstmt.executeQuery(sqlRegisterUser);
			
			System.out.println("******************* REGISTERD USER ********************");
			while(resultset.next())
			{
				System.out.println("User ID  : " + resultset.getInt("userId"));  
				System.out.println("User Name  : "+ resultset.getString("username"));
				System.out.println("First Name : "+ resultset.getString("firstname"));
				System.out.println("Last Name : "+ resultset.getString("lastname"));
				System.out.println("City : "+resultset.getString("city"));
				System.out.println("Email : " +resultset.getString("email"));
				System.out.println("Mobile Number : "+resultset.getString("mobilenumber"));
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			con.close();
			pstmt.close();
			resultset.close();
		}
	}
	
	public void DisplayUserHistory(int userId) throws SQLException {
	    try {
	        String sqlRegisterUser = "SELECT ProductId, description, quantity FROM buyproduct WHERE user_id = ?";
	        con = registration.getUserConnection();
	        pstmt = con.prepareStatement(sqlRegisterUser);
	        pstmt.setInt(1, userId);
	        resultset = pstmt.executeQuery();
	        
	        System.out.println("******************* USER's HISTORY ********************");
	        if (resultset.next()) {
	            
	            do {
	                System.out.println("Product ID  : " + resultset.getInt("ProductId"));
	                System.out.println("DESCRIPTION  : " + resultset.getString("description"));
	                System.out.println("Quantity : " + resultset.getString("quantity"));
	            } while (resultset.next());
	        } else {
	            
	            System.out.println("User with ID " + userId + " not found in the history.");
	        }
	    } catch (Exception e) 
	    {
	        e.printStackTrace();
	    } 
	    finally {
	        
	        try {
	            if (resultset != null) {
	                resultset.close();
	            }
	            if (pstmt != null) {
	                pstmt.close();
	            }
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

}
