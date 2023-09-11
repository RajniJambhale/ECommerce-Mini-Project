package com.ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;




public class ProductOperation 
{
	
	List<BuyProduct> buyproductlist = new ArrayList<BuyProduct>();

	public void viewProducts() throws SQLException
	{
		Connection con=null;
		PreparedStatement  pstmt = null;
		ResultSet resultset = null;
		Registration registration = new Registration();
		
		String sqlProduct = ("SELECT * from products");
		try
		{
			con=registration.getUserConnection();
			pstmt = con.prepareStatement(sqlProduct);
			 resultset=pstmt.executeQuery(sqlProduct);
			
			List productlist = new ArrayList<>();
			
			 
			
			
			while(resultset.next())
			{
				int productid = resultset.getInt("productId");
				String name =resultset.getString("name");
				String description =  resultset.getString("description");
				double price = resultset.getDouble("price");
				int quantity = resultset.getInt("quantity");
				productlist.add(productid);
				productlist.add(name);
				productlist.add(description);
				productlist.add(price);
				productlist.add(quantity);
				
				
				Products product = new Products();
		        productlist.add(product);
				
		        IDComparator idcomparator = new IDComparator();
		        
		        System.out.println("---------------- Products -------------------------");
				
				 System.out.println("Product Id  : "+resultset.getInt(1));
	        	 System.out.println(" Product Name : "+resultset.getString(2));
	        	 System.out.println("Product Description : "+resultset.getString(3));
	        	 System.out.println("price : "+resultset.getInt(4));
	        	 System.out.println("Available Quantity : "+resultset.getBigDecimal(5));
	        	
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
	
	public void BuyProduct(int productid,int quantity, int userId) throws SQLException
	{
		
		Connection con=null;
		PreparedStatement  pstmt = null;
		ResultSet resultset = null;
		Registration registration = new Registration();
		
		String sqlProduct = "SELECT productId, name, description, price, quantity FROM products WHERE productId = ?";

		
		try 
		{
		 con = registration.getUserConnection();
		 pstmt = con.prepareStatement(sqlProduct);
		 pstmt.setInt(1, productid);
		 
		 
		 resultset = pstmt.executeQuery();
		 while(resultset.next()) 
		 {
 	    	
			 int productId = resultset.getInt("productId");
	            String name = resultset.getString("name");
	            String description = resultset.getString("description");
	            double price = resultset.getDouble("price");
	            int quantity1 = resultset.getInt("quantity");
 	    	
 	    	
	    	
 	    	buyproductlist.add(new BuyProduct(productId,name,description,price,quantity) );
 	    	System.out.println(buyproductlist);
 	    	String sqlBuyProduct = "INSERT INTO BuyProduct(productId,name,description,price,quantity,user_id) values(?,?,?,?,?,?)";
 	    	
 	    	try
 	    	{
 	    	con = registration.getUserConnection();
 	   		pstmt = con.prepareStatement(sqlBuyProduct);
 	    	
 	    	
 	    	
 	    	pstmt.setInt(1, productId);
 	    	pstmt.setString(2,name);
 	    	pstmt.setString(3, description);
 	    	pstmt.setDouble(4, price);
 	    	pstmt.setInt(5, quantity);
 	    	pstmt.setInt(6, userId);
 	    	
 	    	int a = pstmt.executeUpdate();
 	    	
 	    	if (a > 0) {
 	           System.out.println("Congratulations You have BUY the product successfully.");
 	    	}
 	    	
 	    
 	    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
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
	
	
	
	
	public double purchaseItem(int userId) throws SQLException {
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet resultSet = null;
	    Registration registration = new Registration();
	    double totalBill=0.0;

	    try {
	        con = registration.getUserConnection();

	        
	        String sqlUsername = "SELECT username FROM users WHERE userId = ?";
	        pstmt = con.prepareStatement(sqlUsername);
	        pstmt.setInt(1, userId);
	        resultSet = pstmt.executeQuery();

	        while (resultSet.next()) {
	            String username = resultSet.getString("username");
	            System.out.println("Username: " + username);
	        }

	        
	        String sqlBillAmount = "SELECT quantity, price  FROM buyproduct WHERE user_id = ?";
	        pstmt = con.prepareStatement(sqlBillAmount);
	        pstmt.setInt(1, userId);
	        resultSet = pstmt.executeQuery();

	        while (resultSet.next()) {
	           
	        	int quantity1=resultSet.getInt("quantity");
	        	double price1=resultSet.getDouble("price");
	        	
	        	 totalBill = quantity1 * price1;
	        	
	        	
	            
	        }
	    } 
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    } 
	    finally {
	        
	        if (resultSet != null) {
	            resultSet.close();
	        }
	        if (pstmt != null) {
	            pstmt.close();
	        }
	        if (con != null) {
	            con.close();
	        }
	    }
	    return totalBill;
	}

	

}
