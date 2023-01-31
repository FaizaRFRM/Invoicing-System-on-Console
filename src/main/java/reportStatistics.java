import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class reportStatistics {
	

	
public static void ReportStcs(){
		
		final String url = "jdbc:mysql://localhost:3306/InvoicingSystem";
		final String user = "root";
		final String pass = "root";

		String QUERY1 = ("SELECT COUNT(InvoiceId)From Invoice");
		String QUERY2 =("SELECT COUNT(numberOfItems)From Invoice");
		String QUERY3 =("SELECT SUM(totalAmount)From Invoice");

		
		Connection conn=null;
		
		try {
			conn = DriverManager.getConnection(url, user, pass);
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			Statement stmt1 = conn.createStatement();
			Statement stmt2 = conn.createStatement();
			Statement stmt3 = conn.createStatement();
			
			ResultSet rs1=stmt1.executeQuery(QUERY1);
			ResultSet rs2=stmt2.executeQuery(QUERY2);
			ResultSet rs3=stmt3.executeQuery(QUERY3);
			
			
			System.out.println("===========================================================");

			while(rs1.next()) {
				int InvoiceId = rs1.getInt(1);
				System.out.println("number of Invoice:  " + InvoiceId);

			}
			while(rs2.next()) {
				int numberOfItems = rs2.getInt(1);
				System.out.println("number Of Items:  " + numberOfItems);
				
			}
			while(rs3.next()) {
				int totalAmount = rs3.getInt(1);
				System.out.println("total sales:  " + totalAmount);
				
			}
				
				System.out.println("===========================================================");
				
			conn.close() ;
		}  catch (Exception ex) {
			
			System.err.println(ex);
		}
	}
	
	
	
	
	public static void ReportInvoices(){

		final String url = "jdbc:mysql://localhost:3306/InvoicingSystem";
		   final String user = "root";
		   final String pass = "root";
		   
		   
		   
		  String QUERY = "SELECT InvoiceId,customerFullName,invoiceDate,numberOfItems,totalAmount,balance FROM Invoice";
		  

		      Connection conn=null;
		      
		 try {
			 conn = DriverManager.getConnection(url, user, pass);
		 Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	     Statement stmt = conn.createStatement();
	     DriverManager.registerDriver(driver);
	     ResultSet rs=stmt.executeQuery(QUERY);

			 while(rs.next()) {
				 int InvoiceId = rs.getInt("InvoiceId");
					String customerFullName = rs.getString("customerFullName");
					Date invoiceDate = rs.getDate("invoiceDate");
					int numberOfItems = rs.getInt("numberOfItems");
					int totalAmount = rs.getInt("totalAmount");
					int balance = rs.getInt("balance");
				 
				 
					System.out.println("InvoiceId :" + InvoiceId);
					System.out.println("customerFullName :" + customerFullName);
					System.out.println("invoiceDate:" + invoiceDate);
					System.out.println("numberOfItems:" + numberOfItems);
					System.out.println("totalAmount:" + totalAmount);
					System.out.println("balance:" + balance);
			
					System.out.println("===========================================================");
			   
			 }
			 conn.close() ;
		 }  catch (Exception ex) {
	           
	            System.err.println(ex);
	}
	}
	
	
	
	
	public static void Search(){

		final String url = "jdbc:mysql://localhost:3306/InvoicingSystem";
		   final String user = "root";
		   final String pass = "root";
		   
		   Scanner scanner = new Scanner(System.in);
		  	System.out.println ("input id you want to show");
		      Integer inputID=scanner.nextInt();
		   
		  String QUERY = "SELECT * FROM items Inner join Invoice on  items.itemId=Invoice.InvoiceId where Invoice.InvoiceId='"+inputID+"'";
		  
		      Connection conn=null;
		      
		 try {
			 conn = DriverManager.getConnection(url, user, pass);
		 Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	     Statement stmt = conn.createStatement();
	     DriverManager.registerDriver(driver);
	     ResultSet rs=stmt.executeQuery(QUERY);
	     
//	     String sql = ("CREATE TABLE Items(" + "itemId int Primary Key AUTO_INCREMENT," 
//	             + " ItemName varchar(225),"
//				 + " unitPrice Integer,"
//	             + "quantity Integer," 
//			   	 + "qtyAmount_price Integer,"
//	             +"ShpId Integer REFERENCES Shop(ShopId))");

			 while(rs.next()) {
				 int InvoiceId = rs.getInt("InvoiceId");
					String customerFullName = rs.getString("customerFullName");
					Date invoiceDate = rs.getDate("invoiceDate");
					int numberOfItems = rs.getInt("numberOfItems");
					int totalAmount = rs.getInt("totalAmount");
					int balance = rs.getInt("balance");
					int itemId = rs.getInt("itemId");
					String ItemName = rs.getString("ItemName");
					int unitPrice = rs.getInt("unitPrice");
					int quantity = rs.getInt("quantity");
					int qtyAmount_price = rs.getInt("qtyAmount_price");
					int ShpId = rs.getInt("ShpId");
				 
				 
					System.out.println("InvoiceId :" + InvoiceId);
					System.out.println("customerFullName :" + customerFullName);
					System.out.println("invoiceDate:" + invoiceDate);
					System.out.println("numberOfItems:" + numberOfItems);
					System.out.println("totalAmount:" + totalAmount);
					System.out.println("balance:" + balance);
					System.out.println("itemId:" + itemId);
					System.out.println("ItemName:" + ItemName);
					System.out.println("unitPrice:" + unitPrice);
					System.out.println("quantity:" + quantity);
					System.out.println("qtyAmount_price:" + qtyAmount_price);
					System.out.println("ShpId:" + ShpId);
			
					System.out.println("===========================================================");
			   
			 }
			 conn.close() ;
		 }  catch (Exception ex) {
	           
	            System.err.println(ex);
	}
	}
	
	
	
}
