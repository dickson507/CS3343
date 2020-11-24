package MainSystem;

import Order.*;

public class Output {
	public static void output(CustomerOrder c, int time)
	{
		System.out.println("Customer " + c.getCustomer().getTokenNumber() + " has been served at " + time + ".");
	}
}
