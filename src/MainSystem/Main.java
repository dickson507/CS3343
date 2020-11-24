package MainSystem;


import java.io.*;
import java.util.*;

import Cusine.Dish;
import Cusine.DishHashInstance;
import Cusine.ReadMenu;

import java.lang.*;
import MainSystem.*;
import Order.Reception;


public class Main {

	public static void main(String args[]) throws IOException {
		// get the reception of the restaurant!
		Reception reception = Reception.getReception();
		
		try {
			
			/*
			 * this is the first step
			 * read the menu first, load all the corresponding dish classes into the hash table
			 * The DishHashInstance is a singleton, can be called in everywhere.
			 */
			for (Dish dish : ReadMenu.read("./src/Cusine/Menu.txt"))
			{
				DishHashInstance.
				getDishHashInstance().
				insertDish(dish);
			}
			
			
			Scanner scanner = new Scanner(new File("./src/MainSystem/myfile.txt"));
			while (scanner.hasNextLine()) {
				reception.input_order(scanner.nextLine());
				System.out.println("Order appended");
			}
			scanner.close();
			
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
