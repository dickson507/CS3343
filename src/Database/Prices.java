package Database;
import java.util.*;

public class Prices {
	private HashMap<String, Integer> price_list;
	public Prices()
	{
		price_list = new HashMap<String, Integer>();
	}
	public void addDish(String dishName, int price)
	{
		price_list.put(dishName, price);
	}
	public Integer getPrice(String dishName)
	{
		if(price_list.containsKey(dishName))
		{
			return price_list.get(dishName);
		}
		else
		{
			return null;
		}
	}
	public Integer removeDish(String dishName)
	{
		return price_list.remove(dishName);
	}
}
