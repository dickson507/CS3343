package Persons;
import java.io.*;
import java.util.*;
import Order.*;
import MainSystem.*;
/*import Cusine.Dish;*/


public class Chef {

	private String name;
	private String ID;
	private CustomerOrder order;
	private boolean isAvailable;
	private int remainingTime;
	private ArrayList<Integer> processedCustomerOrder;
	
	public Chef(String name, String ID)
	{
		this.name = name;
		this.ID = name;
		isAvailable = true;
		this.processedCustomerOrder = new ArrayList<Integer>();
	}
	public String assignOrder(CustomerOrder order, int time)
	{
		this.order = order;
		remainingTime = order.getTimeTaken();
		System.out.println("CLOCK: " + time);
		System.out.print("chef "+this.name+" is cooking, duration: " + this.order.getTimeTaken());
		System.out.println(" customer token #" + this.order.getCustomer().getTokenNumber());
		
		isAvailable = false;
		
		String message = "CLOCK: " + time + " chef "+this.name+" is cooking, duration: " + this.order.getTimeTaken() + 
				" customer token #" + this.order.getCustomer().getTokenNumber();
		return message;
	}
	public String cook(int time)
	{
		if(remainingTime <= 0 &&
				!this.processedCustomerOrder.contains(this.order.getCustomer().getTokenNumber()))
		{
			String endMessage = Output.output(this.order, time);
			isAvailable = true;
			this.processedCustomerOrder.add(this.order.getCustomer().getTokenNumber());
			return endMessage;
		}
		else
		{
			remainingTime -= 1;
			return null;
		}
	}
	public int getRemainingTime()
	{
		return remainingTime;
	}
	public boolean returnAvailability()
	{
		return isAvailable;
	}
}