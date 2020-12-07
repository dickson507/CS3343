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

public class IntegrationTest_Main {
	private Reception reception = Reception.getReception();
	private DishHashInstance dishInstance = DishHashInstance.getDishHashInstance();
	
	// integrate the reception class and the dish hash instance
	@Test
	public void IntegrationTest_Main_01() throws Exception {
		setOutput();
		Main.readMenuFromFile("./src/TestMenu/SampleMenu1.txt");
		Main.getInputFromFile(reception, "./src/SystemTest/test_file/Main_02.txt");	
		reception.getListOfOrders();
		assertEquals("Order appended\r\n"
				+ "Order appended\r\n"
				+ "Order appended\r\n"
				+ "Order appended\r\n"
				+ "Order appended\r\n"
				+ "Token Number 2: null beef beef null cake\r\n"
				+ "Token Number 6: null beef null cake\r\n"
				+ "Token Number 8: null cake\r\n"
				+ "Token Number 4: null null cake\r\n"
				+ "Token Number 10: null null beef beef cake"
				+ "", getOutput().trim());
				
	}
	
	// integrate the reception class and the dish hash instance
	@Test
	public void IntegrationTest_Main_02() throws Exception {
		setOutput();
		reception.restartReception();
		dishInstance.restartDishHashInstance();
		Main.readMenuFromFile("./src/TestMenu/SampleMenu6.txt");
		Main.getInputFromFile(reception, "./src/SystemTest/test_file/Main_01.txt");	
		reception.getListOfOrders();
		assertEquals("Order appended\r\n"
				+ "Token Number 12: crackers beef beef fish cake", getOutput().trim());
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
