package Cusine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

/*
 * A class to read incoming Menu.txt, and converted them
 * to a set of dishes.
 */
public class ReadMenu {
	
	public static ArrayList<Dish> read(String path_menu)
	{
		ArrayList<Dish> dishes = new ArrayList<>();
		
		try {
			Scanner scanner = new Scanner(new File(path_menu));
			
			while (scanner.hasNextLine()) {
				List<String> dishInfo = Arrays.asList(scanner.nextLine().split(","));
				String dishName = dishInfo.get(0).trim();
				int dishType = Integer.parseInt(dishInfo.get(1).trim());
				int dishDuration = Integer.parseInt(dishInfo.get(2).trim());
				int dishPrice = Integer.parseInt(dishInfo.get(3).trim());
				
				Dish dish = new Dish(dishName, dishType, dishDuration, dishPrice);
				dishes.add(dish);
			}
			return dishes;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dishes;
		
	}

}
