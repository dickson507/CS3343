package MainSystem;
import Persons.*;
import Menu.*;
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
	private Kitchen kitchen = new Kitchen("Abby", "001", "Bobby", "002", "Chabby", "003");
	public Kitchen getInstance()
	{
		return kitchen;
	}
	public void process(ArrayList<CustomerOrder> co)
	{
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
			chefA.cook();
			chefB.cook();
			chefC.cook();
		}
	}
	/*
	 * Main class for the interval scheduling
	 */
	
}