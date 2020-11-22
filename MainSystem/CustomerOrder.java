package MainSystem;
import java.util.*;
import java.io.*;
import Menu.*;
import Persons.*;

public class CustomerOrder {
	private Customer c;
	private int flag;
	private int orderTime;
	private ArrayList<Dish> Appetizers;
	private ArrayList<Dish> Mains;
	private ArrayList<Dish> Dessert;
	private int time_taken_appetizers;
	public CustomerOrder(int orderTime)
	{
		c = new Customer();
		Appetizers = new ArrayList<Dish>();
		Mains = new ArrayList<Dish>();
		Dessert = new ArrayList<Dish>();
		this.orderTime = orderTime;
		flag = 0;
	}
	public Customer getCustomer()
	{
		return c;
	}
	public ArrayList getAppetizers()
	{
		return Appetizers;
	}
	public ArrayList getMains()
	{
		return Mains;
	}
	public ArrayList getDessert()
	{
		return Dessert;
	}
	public void addAppetizers(Dish d)
	{
		Appetizers.add(d);
	}
	public boolean removeAppetizers(Dish d)
	{
		boolean result = Appetizers.remove(d);
		return result;
	}
	public void addMains(Dish d)
	{
		Mains.add(d);
	}
	public boolean removeMains(Dish d)
	{
		boolean result = Mains.remove(d);
		return result;
	}
	public void addDessert(Dish d)
	{
		Dessert.add(d);
	}
	public boolean removeDessert(Dish d)
	{
		boolean result = Dessert.remove(d);
		return result;
	}
	public int getTimeTaken()
	{
		int total = 0;
		for(int i = 0;i < Appetizers.size();i++)
		{
			total += Appetizers.get(i).get_duration();
		}
		for(int i = 0;i < Mains.size();i++)
		{
			total += Mains.get(i).get_duration();
		}
		for(int i = 0;i < Dessert.size();i++)
		{
			total += Dessert.get(i).get_duration();
		}
		return total;
	}
	public void incrementFlag()
	{
		flag += 1;
	}
	public int getFlag()
	{
		return flag;
	}
}
