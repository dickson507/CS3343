package MainSystem;

import Order.*;

public class Output {
	public static void output(CustomerOrder co, int time)
	{
		System.out.println("Customer " + co.getCustomer().getTokenNumber() + " has been served at " + time + ".");
	}
}
