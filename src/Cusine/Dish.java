package Cusine;

/*
 * Parameters needed:
 * 		name     (string)
 * 		type     (DishType)
 * 		duration (int)
 * 		price    (int)
 * 
 * make all the getters
 *  
 */

public class Dish {
	
	private String   dishName;
	private DishType dishType;
	private int 	 dishDuration;
	private int 	 price;
	
	
	public Dish(String   in_dishName,
				int      in_dishTypeInt,
				int      in_dishDuration,
				int      in_price) {
		
		dishName = in_dishName;
		switch (in_dishTypeInt) {
		case 0:
			dishType = new Appetizer();
			break;
		case 1:
			dishType = new MainCourse();
			break;
		case 2:
			dishType = new Dessert();
			break;
		}	
		dishDuration = in_dishDuration;
		price = in_price;
	}
	
	
	public String getDishName() {
		return dishName;
	}

	public int getDishType() {
		return dishType.GetType();
	}
	

	public int getDishDuration() {
		return dishDuration;
	}

	public int getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return "Dish name = " + this.dishName
				+ " ,Dish type = " + this.dishType.GetTypeString()
				+ " ,Dish duration = " + this.dishDuration
				+ " ,Dish price = " + this.price;
	}

}
