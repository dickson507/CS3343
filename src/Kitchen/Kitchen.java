package Kitchen;
import Persons.*;
import SchedulePrinter.printer;
import Order.*;
import java.util.*;

import MainSystem.Output;

import java.io.*;
/*
 * The kitchen will assign minimum number of chefs
 * to cook the food 
 * 
 */
public class Kitchen {
	private Chef chefA;
	private Chef chefB;
	private Chef chefC;
	private printer SchedulePrinter;
	
	public Kitchen(String name1,String ID1, String name2,String ID2, String name3, String ID3)
	{
		chefA = new Chef(name1, ID1);
		chefB = new Chef(name2, ID2);
		chefC = new Chef(name3, ID3);
		SchedulePrinter = new printer();
	}
	

	public void process(ArrayList<CustomerOrder> co)
	{
		int time = 0;//To track the time at which the dish is being served.
		while(!co.isEmpty() || 
				!(chefA.returnAvailability() &&
				  chefB.returnAvailability() &&
				  chefC.returnAvailability()))
		{
			if (co.size() > 0)
			{
				CustomerOrder temp = co.get(0);
				if(chefA.returnAvailability() == true)
				{
					temp = manageOrder(chefA, co, time, temp);
				}
				if(chefB.returnAvailability() ==  true)
				{
					temp = manageOrder(chefB, co, time, temp);
				}
				if(chefC.returnAvailability() == true)
				{
					temp = manageOrder(chefC, co, time, temp);
				}
				else {}
			}
			this.SchedulePrinter.addLog(chefA.cook(time));
			this.SchedulePrinter.addLog(chefB.cook(time));
			this.SchedulePrinter.addLog(chefC.cook(time));
			time++;
		}
		// output the current schedule to a text file
		System.out.println("Process ends");
		this.SchedulePrinter.addLog("Process ends");
		try {
			SchedulePrinter.printSchedule();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private CustomerOrder manageOrder(Chef chef, ArrayList<CustomerOrder> co, int time, CustomerOrder temp) {
		this.SchedulePrinter.addLog(chef.assignOrder(temp, time));
		if (co.size() > 0)
			co.remove(0);
		if (co.size() > 0)
			temp = co.get(0);
		return temp;
	}
	
}