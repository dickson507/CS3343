package MainSystem;
import java.util.*;
import java.io.*;
import java.lang.*;
import MainSystem.*;
import Order.CustomerOrder;
import Order.Reception;
import Kitchen.*;
import Cusine.*;


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
	
	public static void readMenuFromFile(String menu_path) {
		for (Dish dish : ReadMenu.read(menu_path))
		{
			DishHashInstance.
			getDishHashInstance().
			insertDish(dish);
		}
	}
	
	public static void main(String args[]) throws IOException {
		Reception reception = Reception.getReception();
		
		try {
			readMenuFromFile("./src/Cusine/Menu.txt");
			getInputFromFile(reception, "./src/MainSystem/myfile.txt");	
			Kitchen kitchen = Kitchen.getInstance();
			kitchenProcess(reception, kitchen);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}