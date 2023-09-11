package com.ecommerce;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class TestCasesMainClass
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		//System.out.println(userlist);
		Scanner scanner = new Scanner(System.in);
        while (true) 
        {
        	 System.out.println("***** Welcome to E-Commerce application *****\n");
            System.out.println("1. User Registration");
            System.out.println("2. User Login");
            System.out.println("3. View Products");
            System.out.println("4. Buy Products");
            System.out.println("5. View cart");
            System.out.println("6. Purchase the item");
            System.out.println("7. Add product item to table");
            System.out.println("8. Calculate Bill and Display amount to End User");
            System.out.println("9. Check Quantity ");
            System.out.println("10. Check Registered User");
            System.out.println("11. Check User history");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
          

            
            
            Registration registration = new Registration();
            AdminOperation adminoperation = new AdminOperation();
            
            
            switch (choice)
            {
            
            case 1:
            	System.out.println("------- Registration Process -------");
            	
            	try {
					registration.registerUser();
					System.out.println("Registration Successfully done....");
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Error: Registration failed.");
                }
            	break;
            	
            case 2:
            	
            	System.out.println("------- Login Process -------");
            	System.out.println("Enter User Name : ");
            	String username = scanner.next();
            	System.out.println("Enter Password : ");
            	String password = scanner.next();
            	LoginUser loginuser = new LoginUser(username,password);
            	try
            	{
            		loginuser.loginUser(username, password);
            	}
            	catch(Exception e)
            	{
            		e.printStackTrace();
            	}
            	break;
            	
            case 3:
            	
            	//System.out.println("---------- View Products -----------");
            	ProductOperation products = new ProductOperation();
            	products.viewProducts();
            	break;
            	
            case 4:
            	System.out.println("------------- Buy Products --------------");
            	System.out.println("Enter product Id to buy product :");
            	int productid = scanner.nextInt();
            	System.out.println("Enter Quantity  :");
            	int quantity = scanner.nextInt();
            	System.out.println("Enter your User Id :");
            	int userId = scanner.nextInt();
            	ProductOperation productsbuy = new ProductOperation();
            	productsbuy.BuyProduct(productid, quantity, userId);
            	
            	System.out.println("Do you want to view Cart ? (Yes/No");
            	break;
            	
            case 5:
            	
            	System.out.println(" Product item has been added to cart");
            	break;
            	
            case 6:
            	
            	System.out.println("Enter your User Id :");
            	int userId1 = scanner.nextInt();
            	ProductOperation purchaseproducts = new ProductOperation();
            	double totalBill = purchaseproducts.purchaseItem(userId1);
            	System.out.println("Total Bill Amount is : "+totalBill);
            	
            	break;
            	
            case 7:
            	
            	
            	adminoperation.AddProductToTable();
            	break;
            	
            case 8:
            	System.out.println("Admin Will Calculate the Bill");
            	double DisplayAmount=adminoperation.DisplayAmountToEndUser();
            	System.out.println("Display Amount to End User  : "+DisplayAmount);
            	break;
            	
            case 9:
            //  	System.out.println("----------- Check Quantity ------------------");
            	System.out.println("Enter Product Id : ");
            	int productId = scanner.nextInt();
            	
            	int quantity1=adminoperation.CheckQuantity(productId);
            	System.out.println("Quantity is : "+quantity1);
            	break;
            	
            case 10:
            //	System.out.println("------------- Registered User --------------");
            	adminoperation.DisplayRegisteredUser();
            	break;
            	
            case 11:
            	
            //	System.out.println("------------ User History --------------");
            	System.out.println("Enter User Id : ");
            	int userid = scanner.nextInt();
            	adminoperation.DisplayUserHistory(userid);
            	break;
            	
            	
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
                break;
            	
            }
	   }
	}
}
