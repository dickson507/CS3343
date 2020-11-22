package src.MainSystem;


import java.io.*;
import java.util.*;
import src.MainSystem.*;


public class Main {

	public static void main(String args[]) throws IOException {
		// get the reception of the restaurant!
		Reception reception = Reception.getReception();
		
		try {
			Scanner scanner = new Scanner(new File("./src/MainSystem/myfile.txt"));
			while (scanner.hasNextLine()) {
				reception.input_order(scanner.nextLine());
				System.out.println("Order appended");
			}
			scanner.close();
			
			// reception.getListOfDishes();
			// kitchen
			Kitchen kitchenInstance = Kitchen.getInstance();
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
