package Order;

import java.util.ArrayList;
import java.util.PriorityQueue;

import Cusine.*;
import MainSystem.*;
import Persons.*;

/*
 * The driver program for the restaurant to receive orders
 */
public class Reception {
	
	private static Reception reception_restaurant = null;
	
	// variables here
	private PriorityQueue<CustomerOrder> input_order = null;
	
	
	public Reception() {
		input_order = new PriorityQueue<>();
		input_order.clear();
	}
	
	private void OrderToDish(String in_order)
	{
		int delimiter = in_order.indexOf('/');
		String starttime_str = in_order.substring(0, delimiter);
		int starttime = Integer.parseInt(starttime_str);
		
		Customer c = new Customer();
		CustomerOrder co = new CustomerOrder(starttime, c);
		
		String dishes_str = in_order.substring(delimiter + 1);
		
		String appetizer_str = dishes_str.split(";")[0];
		if (appetizer_str.length() > 0) {
			String[] appetizer_name = appetizer_str.split(",");
			for (String appetizer_name_in : appetizer_name) {
				System.out.print(appetizer_name_in);
				Dish dish = DishHashInstance.getDishHashInstance().getDish(appetizer_name_in);
				co.addAppetizers(dish);
			}
		}
		
		String main_str = dishes_str.split(";")[1];
		if (main_str.length() > 0) {
			String[] main_name = main_str.split(",");
			for (String main_name_in : main_name) {
				System.out.print(main_name_in);
				Dish dish = DishHashInstance.getDishHashInstance().getDish(main_name_in);
				co.addMains(dish);
			}
		}
		
		String dessert_str = dishes_str.split(";")[2];
		if (dessert_str.length() > 0) {
			String[] dessert_name = dessert_str.split(",");
			for (String dessert_name_in : dessert_name) {
				System.out.print(dessert_name_in);
				Dish dish = DishHashInstance.getDishHashInstance().getDish(dessert_name_in);
				co.addDessert(dish);
			}
		}
		
		this.input_order.add(co);
	}
	
	public static Reception getReception()
	{
		if (reception_restaurant == null)
		{
			reception_restaurant = new Reception();
		}
		return reception_restaurant;
	}
	
	public void getListOfOrders(){
		// priority queue is implemented as a heap.
		ArrayList<CustomerOrder> co = this.getCustomerOrderQueue();
		for (int i = 0; i < co.size(); i++) {
			CustomerOrder polled = co.get(i);
			System.out.println("Token Number " + 
								polled.getCustomer().getTokenNumber() +
								":" + polled.getOrderName());
		}
	}
	
	
	// Convert PriorityQueue to ArrayList
	public ArrayList<CustomerOrder> getCustomerOrderQueue() {
		PriorityQueue<CustomerOrder> pq = new PriorityQueue<>(input_order);
		ArrayList<CustomerOrder> co = new ArrayList<CustomerOrder>();
		while (pq.size() > 0) {
			co.add(pq.poll());
		}
		return co;
	}
	
	/*
	 * Receives orders, convert into list of dishes
	 * */
	public void input_order(String in_order)
	{
		OrderToDish(in_order);
	}
	
	public void restartReception()
	{
		reception_restaurant = new Reception();
	}
	
	
}
