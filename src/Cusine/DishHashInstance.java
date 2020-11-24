package Cusine;

import java.util.HashMap;
import java.util.Map;

/*
 * This is a singleton instance to store the string to class mapping
 */
public class DishHashInstance {
	
	public static DishHashInstance dish_hash = null;
	
	private Map<String, Dish> registry;
	
	private DishHashInstance() {
		// TODO Auto-generated constructor stub
		registry = new HashMap<>();
	}
	
	public static DishHashInstance getDishHashInstance()
	{
		if (dish_hash == null)
		{
			dish_hash = new DishHashInstance();
		}
		return dish_hash;
	}
	
	// insert the dish into the hash table
	public void insertDish(Dish in_dish) {
		registry.put(in_dish.getDishName(), in_dish);
	}
	
	public Dish getDish(String name) {
		return registry.get(name);
	}
	

}
