package com.chegg.solutions;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Config {
	final static int TYPE = 0;
	final static int DATE = 1;
	final static int COST = 2;
	final static int DETAILS = 3;
	final static String TYPE_TRAVEL = "Travel";
	final static String TYPE_LODGING = "Lodging";
	final static String TYPE_FOOD = "Food";
	final static String TYPE_OTHER = "Other";
	final static ArrayList<ArrayList<ArrayList<String>>> DATABASE = new ArrayList<ArrayList<ArrayList<String>>>(
			Arrays.asList(
					// Client 0 (Billson)
					new ArrayList<ArrayList<String>>(
							Arrays.asList(
									new ArrayList<String>(Arrays.asList(TYPE_TRAVEL, "11/03/19", "400.01", "JetBlue")),
									new ArrayList<String>(Arrays.asList(TYPE_LODGING, "11/03/19", "229.99", "Marriott")),
									new ArrayList<String>(Arrays.asList(TYPE_FOOD, "11/04/19", "19.78", "Room service")),
									new ArrayList<String>(Arrays.asList(TYPE_FOOD, "11/04/19", "15.46", "Old Fashioned")),
									new ArrayList<String>(Arrays.asList(TYPE_FOOD, "11/05/19", "26.84", "Sheetz")),
									new ArrayList<String>(Arrays.asList(TYPE_OTHER, "11/05/19", "5.00", "Metro pass"))
									)
							),
					// Client 1 (Brandersoft)
					new ArrayList<ArrayList<String>>(
							Arrays.asList(
									new ArrayList<String>(Arrays.asList(TYPE_TRAVEL, "10/27/19", "150.88", "Greyhound")),
									new ArrayList<String>(Arrays.asList(TYPE_LODGING, "10/27/19", "129.99", "Embassy Suites")),
									new ArrayList<String>(Arrays.asList(TYPE_FOOD, "10/27/19", "11.99", "Food truck")),
									new ArrayList<String>(Arrays.asList(TYPE_FOOD, "10/28/19", "35.19", "McDonald's"))

									)
							),
					//Client 2 (Jamesethy)
					new ArrayList<ArrayList<String>>(
							Arrays.asList(
									new ArrayList<String>(Arrays.asList(TYPE_TRAVEL, "08/31/19", "100.80", "Greyhound")),
									new ArrayList<String>(Arrays.asList(TYPE_LODGING, "08/31/19", "246.88", "Ritz Carlton"))
									)
							),
					// Client 3 (Carol)
					new ArrayList<ArrayList<String>>(
							Arrays.asList(
									new ArrayList<String>(Arrays.asList(TYPE_TRAVEL, "02/33/01", "67.23", "Snowdog"))) 
							)
					)
			);

	final static ArrayList<String> NAMES = new ArrayList<String>(Arrays.asList( "Billson", "Brandersoft", "Jamesethy", "Carol"));

	final static char readChar(Scanner input) {
		String line = input.nextLine();
		if(line==null || line.equals("")) {
			return '\0';
		} return line.toLowerCase().charAt(0);
	}
	final static void printMenu() {
		System.out.println("Navigate the database using these commands:");
		System.out.println(" d: (d)isplay the database");
		System.out.println(" t: get (t)otal expenses");
		System.out.println(" a: get (a)verage expenses");
		System.out.println(" m: get (m)ost recent expense");
		System.out.println(" r: (r)eimgurse a client");
		System.out.println(" q: (q)uit");
		System.out.println(" ?: show this menu");
	}

	final public static void menu(ArrayList<ArrayList<ArrayList<String>>> database, ArrayList<String> names) {
		Scanner input = new Scanner(System.in);
		char choice = 'L';
		String client = "";
		System.out.println("Welcome to the reimbursement database!");
		printMenu();
		do {
			System.out.print("Enter your choice: ");
			choice = readChar(input);
			switch(choice) {
			case 'd':
				System.out.print(ReimbursementDatabase.displayDatabases(database, names));
				break;
			case 't':
				System.out.print("Who would you like the total expenses for? (\"all\" for everyone in database) ");
				client = input.nextLine();
				if(client.equals("all")) {
					String rounded = String.format("%.2f", ReimbursementDatabase.totalExpenses(database));
					System.out.println("Total expenses for everyone: " + rounded);
				} 
				else if(names.indexOf(client) == -1) {
					System.out.println("Client " + client + " not found!");
				}
				else {
					String rounded = String.format("%.2f",
							ReimbursementDatabase.totalExpensesClient(database, names.indexOf(client)));
					System.out.println("Total expenses for " + client + ": " + rounded);
				}
				break;
			case 'a':
				System.out.print("Who would you like the average expenses for? (\"all\" for everyone in database) ");
				client = input.nextLine();
				if(client.equals("all")) {
					String rounded = String.format("%.2f", ReimbursementDatabase.averageExpenses(database));
					System.out.println("Average expenses for everyone: " + rounded);
				} 
				else if(names.indexOf(client) == -1) {
					System.out.println("Client " + client + " not found!");
				}else {
					String rounded = String.format("%.2f",ReimbursementDatabase.averageExpensesClient(database, names.indexOf(client)));
					System.out.println("Average expenses for " + client + ": " + rounded);
				}break;
			case 'm':
				System.out.print("Who would you like the most recent expense for? ");
				client = input.nextLine();
				if(names.indexOf(client) == -1) {
					System.out.println("Client " + client + " not found!");
				} else {
					System.out.println("ﬂost recent expense for " + client + ": \n" +
							ReimbursementDatabase.mostRecentExpenses(database, names.indexOf(client)));
				} break;
			case 'r':
				System.out.print("Who would you like to reimburse? ");
				client = input.nextLine();
				if(names.indexOf(client) == -1) {
					System.out.println("Client " + client + " not found!");
				} 
				else {
					ReimbursementDatabase.reimbursement(database, names.indexOf(client));
					System.out.println("Client " + client + " reimbursed!");
				} 
				break;
			case 'q':
				continue;
			case '?':
				printMenu();break;
			default:
				System.out.println("Unknown commandE");
			}
			System.out.println();
		} while(choice != 'q');
		System.out.println("Thank you!");
	} 
	
}




