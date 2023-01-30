import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Invoice {
	public static void main() throws Exception {

		try {
			boolean exit = true;
			while (exit) {
				Scanner sc = new Scanner(System.in);
				System.out.println("********************************************");
				System.out.println("*****************  Invoice  ****************");
				System.out.println("********************************************");
				System.out.println("\t \t 0-create table Invoice \t \t");
				System.out.println("\t \t 1-insert Invoice data \t \t");
				System.out.println("\t \t 2-Go Back  \t \t");
				System.out.println(" *********************************************** ");
				Scanner scanner = new Scanner(System.in);

				int option = sc.nextInt();
				switch (option) {

				case 0:
					Invoice.createTableInvoice();

					break;
				case 1:
					Invoice.insert();
					break;

				case 2:
					MainMenu.main(null);
					break;

				}
			}
			exit = false;
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
					+ " customerFullName varchar(225)," + " invoiceDate date," + "numberOfItems Integer,"
					+ "totalAmount Integer," + "paidAmount Integer," + "balance Integer,"
					+ "itmId int REFERENCES Items(itemId),"
			        + "ShpId int REFERENCES Shop(ShopId))");

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

		for (int i = 0; i < s; i++) {
//		
			System.out.println("Enter customerFullName :");
			String customerFullName = scanner.next();

			Date invoiceDate = new Date(System.currentTimeMillis());

			System.out.println("Enter numberOfItems");
			int numberOfItems = scanner.nextInt();

			System.out.println("Enter totalAmount");
			int totalAmount = scanner.nextInt();

			System.out.println("Enter paidAmount");
			int paidAmount =  scanner.nextInt();

			System.out.println("Enter balance");
			int balance = scanner.nextInt();

			System.out.println("Enter itmId");
			int itmId = scanner.nextInt();

			String sql = "insert into Invoice (customerFullName,invoiceDate,numberOfItems,totalAmount,paidAmount,balance,itmId)" + "values('"
					+ customerFullName + "','" + invoiceDate + "','" + numberOfItems + "','" + totalAmount + "','"
					+ paidAmount + "','" + balance + "','" + itmId + "')";

			try {

				Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

				DriverManager.registerDriver(driver);

				conn = DriverManager.getConnection(url, user, pass);
				Statement st = conn.createStatement();

				int m = st.executeUpdate(sql);
				if (m >= 0) {
					System.out.println("inserted in given database...");
				} else {
					System.out.println("failed");
				}

				conn.close();

			} catch (Exception ex) {

				System.err.println(ex);
			}
		}

	}
}
