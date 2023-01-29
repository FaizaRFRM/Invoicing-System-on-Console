import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class MainMenu {

	public static void main(String[] args)throws Exception {
//		boolean backToMenue = true;
		Scanner sc = new Scanner(System.in);

		try {
			boolean exit = true;

			while (exit) {
	System.out.println("\t \t  0:Create tables \t \t");
	System.out.println("\t \t  1:Shop Settings \t \t");
	System.out.println("\t \t  2:Manage Shop Items \t \t");
	System.out.println("\t \t  3:Create New Invoice \t \t");
	System.out.println("\t \t  4:Report: Statistics \t \t");
	System.out.println("\t \t  5:Report: All Invoices  \t \t");
	System.out.println("\t \t  6:Search (1) Invoic \t \t");
	System.out.println("\t \t  7:Program Statistic \t \t");
	System.out.println("\t \t  8:Exit  \t \t");
	System.out.println(" *********************************************** ");
  	 Scanner scanner = new Scanner(System.in);

    int option = sc.nextInt();
	switch (option) {
	
	case 0:
		MainMenu.createTableInvoice();
		MainMenu.createTableItems();
	break;
	case 1:
		ShopSettings.main();
		break;

	case 2:
		ManageShopItems.main();
	break;
	case 3:
//		MainMenu.;
		break;
	case 4:
//		MainMenu.();
		break;
	case 5:
//		MainMenu.();
		break;
	case 6:
//		MainMenu.();
		break;
	case 7:
//		MainMenu.();
		break;
	case 8:
		System.out.println("Are you sure you want to exit? If yes press 1, if No press 0 And you will back to menue"); 
		 int num = sc.nextInt();
		if (num == 0) {
			System.exit(0);
		}else {
			MainMenu.main(args);
		}
		break;

	}
			}exit = false;
			
			} catch (Exception e) {
				System.out.println(e);
			}
	
	}
	
	public static void createTableInvoice() throws Exception {

		final String url = "jdbc:mysql://localhost:3306/InvoicingSystem";

		final String user = "root";
		final String pass = "root";
		Connection conn = null;
		try {
			String sql = ("CREATE TABLE Invoice (" + "InvoiceId int Primary Key AUTO_INCREMENT,"
					+ " customerFullName varchar(225)," 
					+ " invoiceDate date,"
					+ "numberOfItems Integer,"
					+ "totalAmount Integer," 
					+ "paidAmount Integer,"
					+ "balance Integer,"
			        +"itmId int REFERENCES Items(itemId))");

			
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
					+ "qtyAmount_price Integer)");

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
