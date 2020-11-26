package Order;
import java.util.*;
import java.io.*;
import Cusine.*;
import Persons.*;

public class CustomerOrder implements Comparable<CustomerOrder> {
	private Customer c;
	private int flag;
	private int orderTime;
	private ArrayList<Dish> Appetizers;
	private ArrayList<Dish> Mains;
	private ArrayList<Dish> Dessert;
	
	public CustomerOrder(int orderTime, Customer c)
	{
		this.c = c;
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
			total += Appetizers.get(i).getDishDuration();
		}
		for(int i = 0;i < Mains.size();i++)
		{
			total += Mains.get(i).getDishDuration();
		}
		for(int i = 0;i < Dessert.size();i++)
		{
			total += Dessert.get(i).getDishDuration();
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
	
	public int getOrderTime() {
		return orderTime;
	}
	
	public String getOrderName() {
		String result = "";
		for (int i = 0; i < Appetizers.size(); i++) {
			result += " "+Appetizers.get(i).getDishName();
		}
		for (int i = 0; i < Mains.size(); i++) {
			result += " "+Mains.get(i).getDishName();
		}
		for (int i = 0; i < Dessert.size(); i++) {
			result += " "+Dessert.get(i).getDishName();
		}
		return result;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CustomerOrder co = (CustomerOrder) o;
		return Integer.compare(co.getOrderTime(), this.getOrderTime()) == 0 &&
				Integer.compare(co.getTimeTaken(), this.getTimeTaken()) == 0;
	}
	

	@Override
	public int compareTo(CustomerOrder co) {
		int compareOrderTime = Integer.compare(this.getOrderTime(), co.getOrderTime());
		if (compareOrderTime != 0) {
			return compareOrderTime;
		}
		else {
			return Integer.compare(this.getTimeTaken(), co.getTimeTaken());
		}
	}
}
