package Cusine;

public class NullDish extends Dish {

	public NullDish(String in_dishName, int in_dishTypeInt, int in_dishDuration, int in_price) {
		super(in_dishName, in_dishTypeInt, in_dishDuration, in_price);
	}
	
	public NullDish()
	{
		super("null", -1, 0, 0);
	}
}
