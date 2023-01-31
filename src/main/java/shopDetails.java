import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class shopDetails {

	public static void main() throws Exception {

		try {
			boolean exit = true;
			while (exit) {
				Scanner sc = new Scanner(System.in);
				System.out.println("\t \t 1:create table Shop details \t \t");
				System.out.println("\t \t 2:insert details \t \t");
				System.out.println("\t \t 3:Go Back  \t \t");
				System.out.println(" *********************************************** ");
				Scanner scanner = new Scanner(System.in);

				int option = sc.nextInt();
				switch (option) {

				case 1:
					shopDetails.createTableShopDetais();
					break;

				case 2:
					shopDetails.insert();
					break;
				case 3:
					MainMenu.main(null);
					break;

				}
			}
			exit = false;
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void createTableShopDetais() throws Exception {

		final String url = "jdbc:mysql://localhost:3306/InvoicingSystem";

		final String user = "root";
		final String pass = "root";
		Connection conn = null;

		try {
			String sql = ("CREATE TABLE ShopDetails (" + "Id int Primary Key AUTO_INCREMENT," + "Tel varchar(50),"
					+ "Fax varchar(50)," + "Email varchar(250)," + "Website  varchar(250),"
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

		for (int i = 0; i < s; i++) {
			System.out.println("Enter Tel");
			String Tel = scanner.next();

			System.out.println("Enter Fax");
			String Fax = scanner.next();

			System.out.println("Enter Email");
			String Email = scanner.next();

			System.out.println("Enter Website");
			String Website = scanner.next();

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

					String sql = "insert into ShopDetails (Tel,Fax,Email,Website,ShpId)" + "values('" + Tel + "','" + Fax + "','"
							+ Email + "','" + Website + "','" + ShId+ "')";
				int m = stmt.executeUpdate(sql);
				
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
