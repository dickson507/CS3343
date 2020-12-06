package UnitTesting;

import org.junit.Test;
import org.junit.jupiter.api.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import Kitchen.*;
import Cusine.*;
import Order.*;


public class TestKitchen
{
	private ArrayList<CustomerOrder> orders;
	private Kitchen kitchen;
	/*@BeforeEach
	public void setup() throws Exception
	{
		orders = new ArrayList<CustomerOrder>();
		kitchen = Kitchen.getInstance();
	}*/
	
	@Test
	public void Test1()
	{
		orders = new ArrayList<CustomerOrder>();
		kitchen = Kitchen.getInstance();
		kitchen.process(orders);
	}
	@Test
	public void Test2()
	{
		orders = new ArrayList<CustomerOrder>();
		kitchen = Kitchen.getInstance();
		CustomerOrder order1 = new CustomerOrder(1);
		order1.addAppetizers(new Dish("Pan-Fried Fish", 0, 2, 20));
		order1.addMains(new Dish("Lamb Shank", 1, 2, 40));
		order1.addDessert(new Dish("Ice Cream", 2, 2, 40));
		orders.add(order1);
		kitchen.process(orders);
	}
	
	@Test
	public void Test3()
	{
		orders = new ArrayList<CustomerOrder>();
		kitchen = Kitchen.getInstance();
		CustomerOrder order1 = new CustomerOrder(1);
		CustomerOrder order2 = new CustomerOrder(2);
		order1.addAppetizers(new Dish("Pan-Fried Fish", 0, 2, 20));
		order1.addMains(new Dish("Lamb Shank", 1, 2, 40));
		order1.addDessert(new Dish("Ice Cream", 2, 2, 40));
		orders.add(order1);
		order2.addAppetizers(new Dish("Fried Corn", 0, 4, 40));
		order2.addMains(new Dish("Fish-n-Chips", 1, 6, 40));
		order2.addDessert(new Dish("Gulab Jamun", 2, 3, 40));
		orders.add(order2);
		kitchen.process(orders);
	}
	
	@Test
	public void Test4()
	{
		orders = new ArrayList<CustomerOrder>();
		kitchen = Kitchen.getInstance();
		CustomerOrder order1 = new CustomerOrder(1);
		CustomerOrder order2 = new CustomerOrder(2);
		CustomerOrder order3 = new CustomerOrder(2);
		order1.addAppetizers(new Dish("Pan-Fried Fish", 0, 2, 20));
		order1.addMains(new Dish("Lamb Shank", 1, 2, 40));
		order1.addDessert(new Dish("Ice Cream", 2, 2, 40));
		orders.add(order1);
		order2.addAppetizers(new Dish("Fried Corn", 0, 4, 40));
		order2.addMains(new Dish("Fish-n-Chips", 1, 6, 40));
		order2.addDessert(new Dish("Gulab Jamun", 2, 3, 40));
		orders.add(order2);
		order3.addAppetizers(new Dish("Chilli Potato", 0, 3, 20));
		order3.addMains(new Dish("Sichuan Chicken", 1, 4, 35));
		order3.addDessert(new Dish("Brownie", 0, 3, 30));
		orders.add(order3);
		kitchen.process(orders);
	}

}
	
