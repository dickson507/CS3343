package Cusine;

public class NullDishType implements DishType{
	int type;
	public NullDishType() {
		type = 3;
	}
	public NullDishType(int in_type) {
		type = in_type;
	}
	public String GetTypeString()
	{
		return "null";
	}
	public int GetType()
	{
		return type;
	}
}

