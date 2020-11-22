package src.MainSystem;

import java.util.ArrayList;
import java.util.PriorityQueue;

import src.Cusine.*;
import src.MainSystem.*;

/*
 * The driver program for the restaurant to receive orders
 */
public class Reception {
	
	private static Reception reception_restaurant = null;
	
	// variables here
	private PriorityQueue<Dish> input_dish = null;
	
	
	private Reception() {
		input_dish = new PriorityQueue<>();
		input_dish.clear();
	}
	
	private CustomerOrder OrderToDish(String in_order)
	{
		int delimiter = in_order.indexOf('/');
		String starttime_str = in_order.substring(0, delimiter);
		int starttime = Integer.parseInt(starttime_str);
		
		CustomerOrder co = new CustomerOrder(starttime);
		
		String dishes_str = in_order.substring(delimiter + 1);
		
		String appetizer_str = dishes_str.split(";")[0];
		String[] appetizer_name = appetizer_str.split(",");
		for (int i = 0; i < appetizer_name.length; i++) {
			System.out.print(appetizer_name[i]);
			Dish dish = new Dish(appetizer_name[i]);
			co.addAppetizers(dish);
		}
		
		String main_str = dishes_str.split(";")[1];
		String[] main_name = main_str.split(",");
		for (int i = 0; i < main_name.length; i++) {
			System.out.print(main_name[i]);
			Dish dish = new Dish(main_name[i]);
			co.addMains(dish);
		}
		String dessert_str = dishes_str.split(";")[2];
		String[] dessert_name = dessert_str.split(",");
		for (int i = 0; i < dessert_name.length; i++) {
			System.out.print(dessert_name[i]);
			Dish dish = new Dish(dessert_name[i]);
			co.addDessert(dish);
		}
		
		return co;
		
//		for (int j = 0; j < dishes_array.length; j++) {
//			this.input_dish.add(
//					DishRegistry.getDishRegistry().
//					StringToDish(dishes_array[j], starttime));
//		}
	}
	
	public static Reception getReception()
	{
		if (reception_restaurant == null)
		{
			reception_restaurant = new Reception();
		}
		return reception_restaurant;
	}
	
	public void getListOfDishes(){
		// priority queue is implemented as a heap.
		while (input_dish.size() > 0) {
			Dish polled = input_dish.poll();
			System.out.println(polled.get_name() + 
					", start time= " + polled.get_starttime() +
					", type = " + polled.get_type());
		}
	}
	
	/*
	 * Receives orders, convert into list of dishes
	 * */
	public CustomerOrder input_order(String in_order)
	{
		return OrderToDish(in_order);
	}
	
	public void restartReception()
	{
		reception_restaurant = new Reception();
	}
	
	
}
