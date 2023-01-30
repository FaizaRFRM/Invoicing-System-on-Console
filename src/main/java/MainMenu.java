import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class MainMenu {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		try {
			boolean exit = true;

			while (exit) {
				System.out.println("********************************************");
				System.out.println("***************** Main Menue ***************");
				System.out.println("********************************************");
				System.out.println("\t \t  1:Shop Settings \t \t");
				System.out.println("\t \t  2:Manage Shop Items \t \t");
				System.out.println("\t \t  3:Invoice details \t \t");
				System.out.println("\t \t  4:set invoice header \t \t");
				System.out.println("\t \t  5:Create New Invoice \t \t");
				System.out.println("\t \t  6:Report: Statistics \t \t");
				System.out.println("\t \t  7:Report: All Invoices  \t \t");
				System.out.println("\t \t  8:Search (1) Invoic \t \t");
				System.out.println("\t \t  9:Program Statistic \t \t");
				System.out.println("\t \t  10:Exit  \t \t");
				System.out.println(" *********************************************** ");
				Scanner scanner = new Scanner(System.in);

				int option = sc.nextInt();
				switch (option) {

				case 1:
					ShopSettings.main();
					break;

				case 2:
					ManageShopItems.main();
					break;
				case 3:
					Invoice.main();
					break;
				case 4:
					shopDetails.main();
					break;
				case 5:
					System.out.println(
							"Are you sure you want to exit? If yes press 0, if you want back to menue press 1");
					int num = sc.nextInt();
					if (num == 0) {
						System.out.println("The Exit exist...");
						System.exit(0);
					} else {
						MainMenu.main(args);
					}
					break;

				}
			}
			exit = false;

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
