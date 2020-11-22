package Database;
import java.util.*;


public class OrderList {
	private HashMap<Integer, String> orders;
	
	public OrderList()
	{
		orders = new HashMap<Integer, String>();
	}
	
	public void addOrder(Integer token, String order)
	{
		orders.put(token, order);
	}
	
	public boolean removeOrder(Integer token)
	{
		if(orders.containsKey(token))
		{
			orders.remove(token);
			return true;
		}
		else
		{
			return false;
		}
	}
}
