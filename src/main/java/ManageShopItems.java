import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
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
	System.out.println("\t \t Add Items \t \t");
	System.out.println("\t\t  Delete Items  \t \t");
	System.out.println("\t\t  Change Item Price  \t \t");
	System.out.println("\t\t   Report All Items  \t \t");
	System.out.println("\t\t  Go Back  \t \t");
	System.out.println(" *********************************************** ");
  	 Scanner scanner = new Scanner(System.in);

    int option = sc.nextInt();
	switch (option) {
	
	case 1:
//		ManageShopItems.
	break;

	case 2:
		ManageShopItems.deleteItem();
	break;
	case 3:
//		ManageShopItems.
		break;
	case 4:
//		ManageShopItems.
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
	
	public static void insert() throws Exception {
		Scanner sc= new Scanner(System.in);

			final String url = "jdbc:mysql://localhost:3306/InvoicingSystem";

			final String user = "root";
			final String pass = "root";
			Connection conn = null;
			try {
				
				 String ItemName="fff";
				 double unitPrice=2156.54;
				 int quantity=123456;
				 double qtyAmount_price=976687.79;
				
				    
				String sql = "insert into Items (ItemName,unitPrice,quantity,qtyAmount_price)"
						+ "values("+ItemName+"," +unitPrice+","+quantity+","+qtyAmount_price+")";		

				Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

				DriverManager.registerDriver(driver);

				conn = DriverManager.getConnection(url, user, pass);
				Statement st = conn.createStatement();
		
				int m = st.executeUpdate(sql);
				if (m >= 0) 
					{System.out.println("inserted in given database..." + sql);
					}
				else {
					System.out.println("failed");
				}
				
				conn.close();
			}catch (Exception ex) {

				System.err.println(ex);
			}

		}
public static void deleteItem() {
	final String url = "jdbc:mysql://localhost:3306/InvoicingSystem";

	 String user = "root";
	 String pass = "root";
	 try {
	 Scanner scanner = new Scanner(System.in);

	  	System.out.println ("inter Itemid uou want to delete");
	      Integer id=scanner.nextInt();
	      String sql = "delete from  Items where id="+id;
			 
			 Connection conn = null;
	      
	 
		 Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		   
	     DriverManager.registerDriver(driver);

	     conn = DriverManager.getConnection(url, user,
	             pass);

	     Statement st = conn.createStatement();

	     int m = st.executeUpdate(sql);
	     if (m >=0)
	         System.out.println("deleted is successful of " +id);
	     else
	         System.out.println("failed");

	     conn.close();
	 }

		  catch (Exception ex) {
           
            System.err.println(ex);
}
    }

}
