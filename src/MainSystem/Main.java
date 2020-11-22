package src.MainSystem;


import java.io.*;
import java.util.*;
import java.lang.*;
import src.MainSystem.*;


public class Main {

	public static void main(String args[]) throws IOException {
		// get the reception of the restaurant!
		Reception reception = Reception.getReception();
		ArrayList<CustomerOrder> co = new ArrayList<CustomerOrder>();
		
		try {
			Scanner scanner = new Scanner(new File("./src/MainSystem/myfile.txt"));
			while (scanner.hasNextLine()) {
				CustomerOrder order = reception.input_order(scanner.nextLine());
				co.add(order);
				System.out.println("Order appended");
			}
			scanner.close();
			// implement priority sort using co
			
			
			// reception.getListOfDishes();
			// kitchen
//			Kitchen kitchenInstance = Kitchen.getInstance();
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
