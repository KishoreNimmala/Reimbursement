package com.chegg.solutions;

import java.util.ArrayList;

public class ReimbursementDatabase {
	public static String displayDatabases(ArrayList<ArrayList<ArrayList<String>>> database,ArrayList<String> names) {
		String databases="";
		int clientCount=0;
		for (ArrayList<ArrayList<String>> client : database) {
			databases=databases+"\nClient:"+names.get(clientCount);

			for (ArrayList<String> arrayList : client) {
				databases=databases+"\n";
				int column=0;
				for (String value : arrayList) {
					if(column==0)databases=databases+value;
					else databases=databases+","+value;
					column++;
				}

			}
			clientCount++;
		}
		return databases;
	}
	public static double totalExpensesClient(ArrayList<ArrayList<ArrayList<String>>> database,int clientNum) {
		double expense=0;
		for (ArrayList<String> arrayList : database.get(clientNum)) {
			expense=expense+Double.valueOf(arrayList.get(Config.COST));

		}
		return expense;
	}
	public static double totalExpenses(ArrayList<ArrayList<ArrayList<String>>> database) {
		double expense=0;
		for (ArrayList<ArrayList<String>> client : database) {

			for (ArrayList<String> arrayList : client) {
				expense=expense+Double.valueOf(arrayList.get(Config.COST));

			}
		}
		return expense;
	}
	public static double averageExpensesClient(ArrayList<ArrayList<ArrayList<String>>> database,int clientNum) {
		int avgCount=0;
		double expense=0;
		for (ArrayList<String> arrayList : database.get(clientNum)) {
			expense=expense+Double.valueOf(arrayList.get(Config.COST));
			avgCount++;
		}
		return expense/avgCount;
	}
	public static double averageExpenses(ArrayList<ArrayList<ArrayList<String>>> database) {
		int avgCount=0;
		double expense=0;
		for (ArrayList<ArrayList<String>> client : database) {

			for (ArrayList<String> arrayList : client) {
				expense=expense+Double.valueOf(arrayList.get(Config.COST));
				avgCount++;
			}
		}
		return expense/avgCount;
	}
	public static double mostRecentExpenses(ArrayList<ArrayList<ArrayList<String>>> database, int indexOf) {
		ArrayList<ArrayList<String>> client=database.get(indexOf);
		return Double.valueOf(client.get(client.size()-1).get(Config.COST));
	}
	public static void reimbursement(ArrayList<ArrayList<ArrayList<String>>> database, int indexOf) {
		// TODO Auto-generated method stub

	}
	public static void main(String args[]) {
		ArrayList database = Config.DATABASE; 
		ArrayList names = Config.NAMES; 
		Config.menu(database, names);
	}

}
