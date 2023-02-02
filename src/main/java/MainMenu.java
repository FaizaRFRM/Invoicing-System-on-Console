import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class MainMenu {

	public static void main(String[] args) throws Exception {
		Map<String,Integer>countTimes=reportStatistics.menuWithCount();
		Scanner scanner = new Scanner(System.in);


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

				
				int option = scanner.nextInt();
				switch (option) {

				case 1:
					countTimes.put("1-Shop Settings",countTimes.get("1-Shop Settings")+1);

					ShopSettings.main();

					break;

				case 2:
					countTimes.put("2-Manage Shop Items",countTimes.get("2-Manage Shop Items")+1);

					ManageShopItems.main();

					break;
				case 3:
					countTimes.put("3-Invoice details",countTimes.get("3-Invoice details")+1);

					Invoice.main();

					break;
				case 4:
					countTimes.put("4-set invoice header",countTimes.get("4-set invoice header")+1);

					shopDetails.main();

					break;
				case 5:
					countTimes.put("5-Create New Invoice",countTimes.get("5-Create New Invoice")+1);

					Invoice.insert();

					break;
				case 6:
					countTimes.put("6-Report: Statistics",countTimes.get("6-Report: Statistics")+1);

					reportStatistics.ReportStcs();


					break;
				case 7:
					countTimes.put("7-Report: All Invoices",countTimes.get("7-Report: All Invoices")+1);

					reportStatistics.ReportInvoices();


					break;
				case 8:
					countTimes.put("8-Search (1) Invoic",countTimes.get("8-Search (1) Invoic")+1);

					reportStatistics.Search();


					break;
				case 9:
					countTimes.put("9-Program Statistic",countTimes.get("9-Program Statistic")+1);

					for(Map.Entry<String,Integer> value:countTimes.entrySet()) {
						System.out.println(value.getKey()+" happend "+value.getValue()+" times");
					}

					break;
				case 10:
					countTimes.put("10-Exit",countTimes.get("10-Exit")+1);

					System.out.println(
							"Are you sure you want to exit? If yes press 0, if you want back to menue press 1");
					int num = scanner.nextInt();
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
