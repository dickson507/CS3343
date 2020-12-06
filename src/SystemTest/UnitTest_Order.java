package SystemTest;

import java.io.*;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;
import MainSystem.*;
import Order.*;
import Persons.Customer;
import Kitchen.*;
import Cusine.*;

public class UnitTest_Order {

			
	@Test
    // Condition Coverage - Result False #1
    public void UnitTest_CustomerOrder_01() throws Exception {
		CustomerOrder co = new CustomerOrder(0);
        //assertEquals(c, co.getCustomer());
    }
	
	@Test
    // Condition Coverage - Result False #1
    public void UnitTest_CustomerOrder_02() throws Exception {
		class Stub_Dish extends Dish {
			public Stub_Dish(String in_dishName, int in_dishTypeInt, int in_dishDuration, int in_price) {
				super(in_dishName, in_dishTypeInt, in_dishDuration, in_price);
			}
		}
		CustomerOrder co = new CustomerOrder(0);
		Stub_Dish dish = new Stub_Dish("crackers",0,2,10);
		co.addAppetizers(dish);
		co.addAppetizers(dish);
		co.removeAppetizers(dish);
		ArrayList<Dish> appetizers = new ArrayList<Dish>();
		appetizers.add(dish);
        assertEquals(appetizers, co.getAppetizers());
    }
	
	@Test
    // Condition Coverage - Result False #1
    public void UnitTest_CustomerOrder_03() throws Exception {
		class Stub_Dish extends Dish {
			public Stub_Dish(String in_dishName, int in_dishTypeInt, int in_dishDuration, int in_price) {
				super(in_dishName, in_dishTypeInt, in_dishDuration, in_price);
			}
		}
		CustomerOrder co = new CustomerOrder(0);
		Stub_Dish dish = new Stub_Dish("fish",1,15,50);
		co.addMains(dish);
		co.addMains(dish);
		co.removeMains(dish);
		ArrayList<Dish> mains = new ArrayList<Dish>();
		mains.add(dish);
        assertEquals(mains, co.getMains());
    }
	
	@Test
    // Condition Coverage - Result False #1
    public void UnitTest_CustomerOrder_04() throws Exception {
		class Stub_Dish extends Dish {
			public Stub_Dish(String in_dishName, int in_dishTypeInt, int in_dishDuration, int in_price) {
				super(in_dishName, in_dishTypeInt, in_dishDuration, in_price);
			}
		}
		CustomerOrder co = new CustomerOrder(0);
		Stub_Dish dish = new Stub_Dish("cake",2,5,10);
		co.addDessert(dish);
		co.addDessert(dish);
		co.removeDessert(dish);
		ArrayList<Dish> desserts = new ArrayList<Dish>();
		desserts.add(dish);
        assertEquals(desserts, co.getDessert());
    }
	
	@Test
    // Condition Coverage - Result False #1
    public void UnitTest_CustomerOrder_05() throws Exception {
		class Stub_Dish extends Dish {
			public Stub_Dish(String in_dishName, int in_dishTypeInt, int in_dishDuration, int in_price) {
				super(in_dishName, in_dishTypeInt, in_dishDuration, in_price);
			}
		}
		CustomerOrder co = new CustomerOrder(0);
		Stub_Dish dish1 = new Stub_Dish("crackers",0,2,10);
		Stub_Dish dish2 = new Stub_Dish("fish",1,15,50);
		Stub_Dish dish3 = new Stub_Dish("cake",2,5,10);
		co.addAppetizers(dish1);
		co.addMains(dish2);
		co.addDessert(dish3);
        assertEquals(22, co.getTimeTaken());
    }
	
	@Test
    // Condition Coverage - Result False #1
    public void UnitTest_CustomerOrder_06() throws Exception {
		CustomerOrder co = new CustomerOrder(0);
		co.incrementFlag();
        assertEquals(1, co.getFlag());
    }
	
	@Test
    // Condition Coverage - Result False #1
    public void UnitTest_CustomerOrder_07() throws Exception {
		CustomerOrder co = new CustomerOrder(0);
        assertEquals(0, co.getOrderTime());
    }
	
	@Test
	public void UnitTest_CustomerOrder_08() throws Exception {
		class Stub_Dish extends Dish {
			public Stub_Dish(String in_dishName, int in_dishTypeInt, int in_dishDuration, int in_price) {
				super(in_dishName, in_dishTypeInt, in_dishDuration, in_price);
			}
		}
		CustomerOrder co = new CustomerOrder(0);
		Stub_Dish dish1 = new Stub_Dish("crackers",0,2,10);
		Stub_Dish dish2 = new Stub_Dish("fish",1,15,50);
		Stub_Dish dish3 = new Stub_Dish("cake",2,5,10);
		co.addAppetizers(dish1);
		co.addMains(dish2);
		co.addDessert(dish3);
        assertEquals(" crackers fish cake", co.getOrderName());
    }
	
	@Test
	public void UnitTest_CustomerOrder_09() throws Exception {
		CustomerOrder co = new CustomerOrder(0);
        assertEquals(true, co.equals(co));
    }
	
	@Test
	public void UnitTest_CustomerOrder_10() throws Exception {
		CustomerOrder co = new CustomerOrder(0);
        assertEquals(false, co.equals(null));
    }
	
	@Test
	public void UnitTest_CustomerOrder_11() throws Exception {
		CustomerOrder co = new CustomerOrder(0);
        assertEquals(true, co.equals(co));
    }
	
	@Test
	public void UnitTest_CustomerOrder_12() throws Exception {
		CustomerOrder co1 = new CustomerOrder(0);
		CustomerOrder co2 = new CustomerOrder(0);
        assertEquals(true, co1.equals(co2));
    }
	
	@Test
	public void UnitTest_CustomerOrder_13() throws Exception {
		CustomerOrder co1 = new CustomerOrder(0);
		CustomerOrder co2 = new CustomerOrder(1);
        assertEquals(false, co1.equals(co2));
    }
	
	@Test
	public void UnitTest_CustomerOrder_14() throws Exception {
		class Stub_Dish extends Dish {
			public Stub_Dish(String in_dishName, int in_dishTypeInt, int in_dishDuration, int in_price) {
				super(in_dishName, in_dishTypeInt, in_dishDuration, in_price);
			}
		}
		CustomerOrder co1 = new CustomerOrder(0);
		CustomerOrder co2 = new CustomerOrder(0);
		Stub_Dish dish = new Stub_Dish("crackers",0,2,10);
		co2.addAppetizers(dish);
        assertEquals(false, co1.equals(co2));
    }
	
	@Test
	public void UnitTest_CustomerOrder_15() throws Exception {
		CustomerOrder co1 = new CustomerOrder(0);
		CustomerOrder co2 = new CustomerOrder(1);
        assertEquals(-1, co1.compareTo(co2));
    }
	
	@Test
	public void UnitTest_CustomerOrder_16() throws Exception {
		CustomerOrder co1 = new CustomerOrder(0);
		CustomerOrder co2 = new CustomerOrder(0);
        assertEquals(0, co1.compareTo(co2));
    }
	
/*	PrintStream oldPrintStream;
	ByteArrayOutputStream bos;

	private void setOutput() throws Exception {
		oldPrintStream = System.out;
		bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));
	}

	private String getOutput() { // throws Exception
		System.setOut(oldPrintStream);
		return bos.toString();
	}*/
}

