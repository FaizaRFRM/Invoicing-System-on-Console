import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ShopSettings {
public static void main()throws Exception {
		
		try {
			boolean exit = true;
			while (exit) {
		Scanner sc = new Scanner(System.in);
	System.out.println("\t \t 1:Load Data \t \t");
	System.out.println("\t \t 2:Set Shop Name and Invoice Header \t \t");
	System.out.println("\t \t 3:Go Back  \t \t");
	System.out.println(" *********************************************** ");
  	 Scanner scanner = new Scanner(System.in);

    int option = sc.nextInt();
	switch (option) {
	
	case 1:
		ShopSettings.LoadData();
	break;

	case 2:
		ShopSettings.createTableShop();
	break;
	case 3:
		MainMenu.main(null);
		break;

	}
			}exit = false;
			} catch (Exception e) {
				System.out.println(e);
			}
	
	}


public static void LoadData(){

	final String url = "jdbc:mysql://localhost:3306/InvoicingSystem";
	   final String user = "root";
	   final String pass = "root";
	   
	   
	   
//	  String QUERY = "SELECT * FROM Select *from  invoice,items where InvoiceId=itemId";
	  String QUERY = "SELECT Items.*,Invoice.* FROM Items"
	  		+ "inner JOIN Invoice"
	  		+ "On Items.itemId=Invoice.itmId";

	      Connection conn=null;
	      
	 try {
		 conn = DriverManager.getConnection(url, user, pass);
	 Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
     Statement stmt = conn.createStatement();
     DriverManager.registerDriver(driver);
     ResultSet rs=stmt.executeQuery(QUERY);

		 while(rs.next()) {
			int InvoiceId=rs.getInt("InvoiceId");
			String customerFullName=rs.getString("customerFullName");
			Date invoiceDate=rs.getDate("invoiceDate");
			int numberOfItems=rs.getInt("numberOfItems");
			int totalAmount=rs.getInt("totalAmount");
			int paidAmount=rs.getInt("paidAmount");
			int balance=rs.getInt("balance");
			String itmId=rs.getString("itmId");
			String itemId=rs.getString("itemId");
            String ItemName=rs.getString("ItemName");
			String unitPrice=rs.getString("unitPrice");
			String quantity=rs.getString("quantity");
			String qtyAmount_price=rs.getString("qtyAmount_price");
			
			
			
		     System.out.println("InvoiceId :" + InvoiceId);
		     System.out.println("customerFullName :" +customerFullName);
		     System.out.println("invoiceDate" +invoiceDate);
		     System.out.println("numberOfItems" +numberOfItems);
		     System.out.println("totalAmount" +totalAmount);
		     System.out.println("paidAmount" +paidAmount);
		     System.out.println("balance"+balance);
		     System.out.println("itmId"+itmId);
		     System.out.println("itemId"+itemId);
		     System.out.println("ItemName"+ItemName);
		     System.out.println("unitPrice"+unitPrice);
		     System.out.println("quantity"+quantity);
		     System.out.println("qtyAmount_price"+qtyAmount_price);

		     System.out.println("===========================================================");
		   
		 }
		 conn.close() ;
	 }  catch (Exception ex) {
           
            System.err.println(ex);
}
}

public static void createTableShop() throws Exception {

	final String url = "jdbc:mysql://localhost:3306/InvoicingSystem";

	final String user = "root";
	final String pass = "root";
	Connection conn = null;
//	String sql = ("CREATE TABLE Items(" + "itemId int Primary Key AUTO_INCREMENT,"
//			+ " ItemName varchar(225),"
//			+ " unitPrice Integer,"
//			+ "quantity Integer," 
//			+ "qtyAmount_price Integer)");
	try {
		String sql = ("CREATE TABLE Shop (" + "ShopId int Primary Key AUTO_INCREMENT,"
				+"ShopName varchar(225)," 
				+"Tel varchar(50),"
		        +"Fax varchar(50),"
		        +"Email varchar(250),"
		        +"Website  varchar(250))");
		
		Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

		DriverManager.registerDriver(driver);

		conn = DriverManager.getConnection(url, user, pass);
		Statement st = conn.createStatement();

		int m = st.executeUpdate(sql);
		if (m >= 0)
			{System.out.println("Created table in given database...");

			}else {
			System.out.println("failed to create");
			}
		conn.close();
	} catch (Exception ex) {

		System.err.println(ex);
	}
}


}
