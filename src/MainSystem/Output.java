package MainSystem;

import Order.*;

public class Output {
	public static String output(CustomerOrder co, int time)
	{
		String sentence = "Customer " + co.getCustomer().getTokenNumber() + " has been served at " + time + ".";
		System.out.println(sentence);
		return sentence;
	}
}
