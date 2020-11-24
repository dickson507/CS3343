package Cusine;

public class MainCourse implements DishType{
	
	int type;
	public MainCourse()
	{
		type = 1;
	}
	public MainCourse(int in_type) {
		type = in_type;
	}
	public String GetTypeString()
	{
		return "Main Course";
	}
	public int GetType()
	{
		return type;
	}
}

