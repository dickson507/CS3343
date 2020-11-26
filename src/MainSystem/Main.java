package MainSystem;


import java.io.*;
import java.util.*;

import Cusine.Dish;
import Cusine.DishHashInstance;
import Cusine.ReadMenu;

import java.lang.*;
import MainSystem.*;
import Order.CustomerOrder;
import Order.Reception;
import Kitchen.*;


public class Main {
	
	public static void getInputFromFile(Reception reception, String filepath) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(filepath));
		while (scanner.hasNextLine()) {
			reception.input_order(scanner.nextLine());
			System.out.println("Order appended");
		}
		scanner.close();
	}

	public static void kitchenProcess(Reception reception, Kitchen kitchen) {
		ArrayList<CustomerOrder> co = reception.getCustomerOrderQueue();
		kitchen.process(co);
		System.out.println("Process completed");
	}
	
	
	public static void main(String args[]) throws IOException {
		// get the reception of the restaurant!
		Reception reception = Reception.getReception();
		
		try {
			for (Dish dish : ReadMenu.read("./src/Cusine/Menu.txt"))
			{
				DishHashInstance.
				getDishHashInstance().
				insertDish(dish);
			}
			
			getInputFromFile(reception, "./src/MainSystem/myfile.txt");	
			
//			reception.getListOfOrders();
			Kitchen kitchen = new Kitchen("Abby", "001", "Bobby", "002", "Chabby", "003");
			kitchenProcess(reception, kitchen);
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
