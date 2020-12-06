package Kitchen;
import Persons.*;
import Order.*;
import java.util.*;
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
	private static Kitchen kitchen =  new Kitchen("Adam", "C1","Bob","C2","Charlie","C3");
	private Kitchen(String name1,String ID1, String name2,String ID2, String name3, String ID3)
	{
		chefA = new Chef(name1, ID1);
		chefB = new Chef(name2, ID2);
		chefC = new Chef(name3, ID3);
	}
	public static Kitchen getInstance()
	{
		return kitchen;
	}
	public void process(ArrayList<CustomerOrder> co)
	{
		int time = 0;//To track the time at which the dish is being served.
		while(!co.isEmpty() || !(chefA.returnAvailability() && chefB.returnAvailability()&& chefC.returnAvailability()))
		{
			
				if(chefA.returnAvailability() == true && !co.isEmpty())
				{
					CustomerOrder temp = co.get(0);
					chefA.assignOrder(temp, time);
					if (!co.isEmpty())
						co.remove(0);
				}
				else if(chefB.returnAvailability() ==  true && !co.isEmpty())
				{
					CustomerOrder temp = co.get(0);
					chefB.assignOrder(temp, time);
					if (!co.isEmpty())
						co.remove(0);      
				}
				else if(chefC.returnAvailability() == true && !co.isEmpty())
				{
					CustomerOrder temp = co.get(0);
					chefC.assignOrder(temp, time);
					if (!co.isEmpty())
						co.remove(0);
				}
				else {}
			chefA.cook(time);
			chefB.cook(time);
			chefC.cook(time);
			time += 1;
		}
	}
	/*
	 * Main class for the interval scheduling
	 */
	
}