package Cusine;

public class Dessert implements DishType{

	int type;
	public Dessert() {
		type = 2;
	}
	public Dessert(int in_type) {
		type = in_type;
	}
	public String GetTypeString()
	{
		return "Dessert";
	}
	public int GetType()
	{
		return type;
	}
}
