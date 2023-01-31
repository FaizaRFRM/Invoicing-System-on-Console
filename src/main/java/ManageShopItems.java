import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import com.google.gson.Gson;

public class ManageShopItems {
public static void main()throws Exception {
		
		try {
			boolean exit = true;
			while (exit) {
		Scanner sc = new Scanner(System.in);
	System.out.println("********************************************");
	System.out.println("*****************   Items   ****************");
	System.out.println("********************************************");
	System.out.println("\t \t 0-create table Items \t \t");
	System.out.println("\t \t 1-Add Items \t \t");
	System.out.println("\t \t 2-Delete Items  \t \t");
	System.out.println("\t \t 3-Change Item Price  \t \t");
	System.out.println("\t \t 4-Report All Items  \t \t");
	System.out.println("\t \t 5-Go Back  \t \t");
	System.out.println(" *********************************************** ");
  	 Scanner scanner = new Scanner(System.in);

    int option = sc.nextInt();
	switch (option) {
	
	case 0:
		ManageShopItems.createTableItems();

	break;
	case 1:
		ManageShopItems.insert();
		break;

	case 2:
		ManageShopItems.deleteItem();
	break;
	case 3:
		
		ManageShopItems.updateById();
		break;
	case 4:
		ManageShopItems.ReportItems();
		break;
	case 5:
		MainMenu.main(null);
		break;

	}
			}exit = false;
			} catch (Exception e) {
				System.out.println(e);
			}
	
	}

public static void createTableItems() throws Exception {

	final String url = "jdbc:mysql://localhost:3306/InvoicingSystem";

	final String user = "root";
	final String pass = "root";
	Connection conn = null;
	try {
		String sql = ("CREATE TABLE Items(" + "itemId int Primary Key AUTO_INCREMENT," 
	             + " ItemName varchar(225),"
				 + " unitPrice Integer,"
	             + "quantity Integer," 
			   	 + "qtyAmount_price Integer,"
	             +"ShpId Integer REFERENCES Shop(ShopId))");

		Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

		DriverManager.registerDriver(driver);

		conn = DriverManager.getConnection(url, user, pass);
		Statement st = conn.createStatement();

		int m = st.executeUpdate(sql);
		if (m >= 0) {
			System.out.println("Created table in given database...");

		} else {
			System.out.println("failed to create");
		}
		conn.close();
	} catch (Exception ex) {

		System.err.println(ex);
	}
}




	
	public static void insert() throws Exception {

			final String url = "jdbc:mysql://localhost:3306/InvoicingSystem";
		  	 Scanner scanner = new Scanner(System.in);

			final String user = "root";
			final String pass = "root";
			Connection conn = null;
			
			System.out.println("how many records you want to insert :");
			 int s = scanner.nextInt();
				 
			 for(int i=0;i<s;i++) {  
					 
					 System.out.println("Enter ItemName :");
					 String ItemName = scanner.next();

	   			     System.out.println("Enter unitPrice :");
	   			     double unitPrice = scanner.nextDouble();

	   			     System.out.println("Enter quantity");
	   			     int quantity = scanner.nextInt();

	   			     System.out.println("Enter qtyAmount_price");
	   			     double qtyAmount_price = scanner.nextDouble();

	   				System.out.println("Enter ShopName");
	   				String ShopName = scanner.next();

					 
	   				String QUERY = "SELECT ShopId FROM Shop where ShopName='" + ShopName+"'";

				
				try {
				 
				Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

				DriverManager.registerDriver(driver);

				conn = DriverManager.getConnection(url, user, pass);
				Statement stmt = conn.createStatement();
				

				int ShId=0;
				ResultSet rs = stmt.executeQuery(QUERY);
				while(rs.next()) {
					ShId = rs.getInt("ShopId");
				}
				System.out.println(ShId);

				String sql = "insert into Items (ItemName,unitPrice,quantity,qtyAmount_price,ShpId)"
						+ "values('"+ItemName+"','" +unitPrice+"','"+quantity+"','"+qtyAmount_price+ "','"
						+ ShId + "')";
				
				int m = stmt.executeUpdate(sql);
				if (m >= 0) 
					{System.out.println("inserted in given database...");
					}
				else {
					System.out.println("failed");
				}
				
				conn.close();
				
			}catch (Exception ex) {

				System.err.println(ex);
			}
			}

		}
	
	
public static void deleteItem() {
	final String url = "jdbc:mysql://localhost:3306/InvoicingSystem";

	 String user = "root";
	 String pass = "root";
	 try {
	 Scanner scanner = new Scanner(System.in);

	  	System.out.println ("inter Itemid uou want to delete");
	      Integer itemId=scanner.nextInt();
	      String sql = "delete from  Items where itemId="+itemId;
			 
			 Connection conn = null;
	      
	 
		 Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		   
	     DriverManager.registerDriver(driver);

	     conn = DriverManager.getConnection(url, user,
	             pass);

	     Statement st = conn.createStatement();

	     int m = st.executeUpdate(sql);
	     if (m >=0)
	         System.out.println("deleted is successful of " +itemId);
	     else
	         System.out.println("failed");

	     conn.close();
	 }

		  catch (Exception ex) {
           
            System.err.println(ex);
}
    }
public static void updateById(){
	
	final String url = "jdbc:mysql://localhost:3306/InvoicingSystem";

	 String user = "root";
	 String pass = "root";
	 try {
	 Scanner scanner = new Scanner(System.in);

	  	System.out.println ("input Itemid you want to update");
	      Integer Itemid=scanner.nextInt();
	      String sql = "update Items set unitPrice='55.22' where Itemid="+Itemid;
			 
			 Connection conn = null;
	      
	 
		 Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		   
	     DriverManager.registerDriver(driver);

	     conn = DriverManager.getConnection(url, user,
	             pass);

	     Statement st = conn.createStatement();

	     int m = st.executeUpdate(sql);
	     if (m >=0)
	         System.out.println("update is successful of " +Itemid);
	     else
	         System.out.println("failed");

	     conn.close();
	 }

		  catch (Exception ex) {
           
            System.err.println(ex);
}
    }

public static void ReportItems(){

	final String url = "jdbc:mysql://localhost:3306/InvoicingSystem";
	   final String user = "root";
	   final String pass = "root";
	   
	   
	   
	  String QUERY = "SELECT * FROM items";
	  

	      Connection conn=null;
	      
	 try {
		 conn = DriverManager.getConnection(url, user, pass);
	 Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
     Statement stmt = conn.createStatement();
     DriverManager.registerDriver(driver);
     ResultSet rs=stmt.executeQuery(QUERY);

		 while(rs.next()) {
			int itemId=rs.getInt("itemId");
			String ItemName=rs.getString("ItemName");
			double  unitPrice=rs.getDouble("unitPrice");
			int quantity=rs.getInt("quantity");
			double qtyAmount_price=rs.getDouble("qtyAmount_price");
			
			
			
		     System.out.println("itemId :" + itemId);
		     System.out.println("ItemName :" +ItemName);
		     System.out.println("unitPrice" +unitPrice);
		     System.out.println("quantity" +quantity);
		     System.out.println("qtyAmount_price" +qtyAmount_price);
		     System.out.println("===========================================================");
		   
		 }
		 conn.close() ;
	 }  catch (Exception ex) {
           
            System.err.println(ex);
}
}



}
