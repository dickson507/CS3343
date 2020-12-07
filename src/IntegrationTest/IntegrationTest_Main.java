package IntegrationTest;


import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import Cusine.DishHashInstance;
import Kitchen.Kitchen;
import MainSystem.Main;
import Order.Reception;
import TokenSystem.Token;

public class IntegrationTest_Main {
	private Reception reception = Reception.getReception();
	private DishHashInstance dishInstance = DishHashInstance.getDishHashInstance();
	
	// integrate the main class and the dish hash instace only
	@Test
	public void IntegrationTest_Main_01() throws Exception {
		setOutput();
		dishInstance.restartDishHashInstance();
		Main.readMenuFromFile("./src/TestMenu/SampleMenu1.txt");
		System.out.print(dishInstance.getDish("beef"));
		assertEquals("Dish name = beef ,Dish type = Main Course ,Dish duration = 10 ,Dish price = 50", getOutput().trim());
	}
	
	@Test
	public void IntegrationTest_Main_02() throws Exception {
		setOutput();
		dishInstance.restartDishHashInstance();
		Main.readMenuFromFile("./src/TestMenu/SampleMenu4");
		System.out.print(dishInstance.getDish("beef"));
		assertEquals("Dish name = null ,Dish type = null ,Dish duration = 0 ,Dish price = 0", getOutput().trim());
	}
	
	// integrate the reception class and the dish hash instance
	@Test
	public void IntegrationTest_Main_03() throws Exception {
		setOutput();
		reception.restartReception();
		Main.readMenuFromFile("./src/TestMenu/SampleMenu1.txt");
		Main.getInputFromFile(reception, "./src/SystemTest/test_file/Main_02.txt");	
		reception.getListOfOrders();
		assertEquals("Order appended\r\n"
				+ "Order appended\r\n"
				+ "Order appended\r\n"
				+ "Order appended\r\n"
				+ "Order appended\r\n"
				+ "Token Number 1: null beef beef null cake\r\n"
				+ "Token Number 3: null beef null cake\r\n"
				+ "Token Number 4: null cake\r\n"
				+ "Token Number 2: null null cake\r\n"
				+ "Token Number 5: null null beef beef cake"
				+ "", getOutput().trim());
				
	}
	
	// integrate the reception class and the dish hash instance
	@Test
	public void IntegrationTest_Main_04() throws Exception {
		setOutput();
		reception.restartReception();
		dishInstance.restartDishHashInstance();
		Token.getInstance().restartTokenSystem();
		Main.readMenuFromFile("./src/TestMenu/SampleMenu6.txt");
		Main.getInputFromFile(reception, "./src/SystemTest/test_file/Main_01.txt");	
		reception.getListOfOrders();
		assertEquals("Order appended\r\n"
				+ "Token Number 1: crackers beef beef fish cake", getOutput().trim());
	}

	
	PrintStream oldPrintStream;
	ByteArrayOutputStream bos;

	private void setOutput() throws Exception {
		oldPrintStream = System.out;
		bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));
	}

	private String getOutput() { // throws Exception
		System.setOut(oldPrintStream);
		return bos.toString();
	}
}
