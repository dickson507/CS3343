package Menu;

import java.util.HashMap;
import java.util.Map;

public class Dish implements Comparable<Dish>{
	
	/*
	 * Dish type: 
	 * 		appetizer = 0
	 * 		main = 1
	 * 		desert = 2
	 */
	//starttime is the time the dish need to start cooking
	protected int starttime;
	//duration is the time need to finish cooking
	protected int duration;
	protected int type;
	protected String name;
	protected int allowance;
	

	
	public Dish(int starttime_in, int allowance_in, int duration_in, int type_in, String name_in) {
		this.starttime = starttime_in;
		this.duration = duration_in;
		this.type = type_in;
		this.name = name_in;
		this.allowance = allowance_in;
	}
	
	
	public int get_starttime() {
		return starttime;
	}
	
	public int get_duration() {
		return duration;
	}
	
	public int get_type() {
		return type;
	}
	
	public String get_name() {
		return name;
	}
	
	public int get_allowance() {
		return allowance;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Dish arg_dish = (Dish) o;
		return arg_dish.get_name().equals(this.get_name()) &&
				Integer.compare(arg_dish.get_type(), this.get_type()) == 0 &&
				Integer.compare(arg_dish.get_allowance(), this.get_allowance()) == 0 &&
				Integer.compare(arg_dish.get_duration(), this.get_duration()) == 0 &&
				Integer.compare(arg_dish.get_starttime(), this.get_starttime()) == 0;
	}
	

	@Override
	public int compareTo(Dish arg_dish) {
		if (type < arg_dish.get_type()) {
			return -1;
		}
		else if (type > arg_dish.get_type()) {
			return 1;
		}
		// sort the job according to the starting time
		else {
			if (starttime > arg_dish.get_starttime())
			{
				return 1;
			}
			else if (starttime < arg_dish.get_starttime())
			{
				return -1;
			}
		}
		return 0;
	}
}