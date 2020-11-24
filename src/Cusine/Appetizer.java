package Cusine;

public class Appetizer implements DishType{
	int type;
	public Appetizer() {
		type = 0;
	}
	public Appetizer(int in_type) {
		type = in_type;
	}
	public String GetTypeString()
	{
		return "Appetizer";
	}
	public int GetType()
	{
		return type;
	}
}
