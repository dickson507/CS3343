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
	public Chef(String name, String ID)
	{
		this.name = name;
		this.ID = name;
		isAvailable = true;
	}
	public void assignOrder(CustomerOrder order)
	{
		this.order = order;
		remainingTime = order.getTimeTaken();
		isAvailable = false;
	}
	public void cook(int time)
	{
		System.out.println("chef "+this.name+" is cooking");
		System.out.println(remainingTime);
		if(remainingTime == 0)
		{
			Output.output(this.order, time);
			isAvailable = true;
			return;
		}
		else
		{
			remainingTime -= 1;
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