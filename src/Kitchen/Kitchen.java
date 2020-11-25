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
	private Kitchen(String name1,String ID1, String name2,String ID2, String name3, String ID3)
	{
		chefA = new Chef(name1, ID1);
		chefB = new Chef(name2, ID2);
		chefC = new Chef(name3, ID3);
	}
	private static Kitchen kitchen = new Kitchen("Abby", "001", "Bobby", "002", "Chabby", "003");
	public static Kitchen getInstance()
	{
		return kitchen;
	}
	public void process(ArrayList<CustomerOrder> co)
	{
		int time = 0;//To track the time at which the dish is being served.
		while(!co.isEmpty())
		{
			CustomerOrder temp = co.get(0);
			if(chefA.returnAvailability() == true)
			{
				
				chefA.assignOrder(temp);
				co.remove(0);
			}
			else if(chefB.returnAvailability() ==  true)
			{
				chefB.assignOrder(temp);
				co.remove(0);
			}
			else if(chefC.returnAvailability() == true)
			{
				chefC.assignOrder(temp);
				co.remove(0);
			}
			else {}
			chefA.cook(time);
			chefB.cook(time);
			chefC.cook(time);
		}
	}
	/*
	 * Main class for the interval scheduling
	 */
	
}