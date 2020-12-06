package SystemTest;

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

public class SystemTest_MainSystem {
	private Reception reception = Reception.getReception();
	private DishHashInstance dishInstance = DishHashInstance.getDishHashInstance();
	
	@Test
	public void SystemTest_Main_01() throws Exception {
		setOutput();
		Main.main(null);
		assertEquals("Order appended\r\n"
				+ "Order appended\r\n"
				+ "Order appended\r\n"
				+ "Order appended\r\n"
				+ "Order appended\r\n"
				+ "CLOCK: 0\r\n"
				+ "chef Adam is cooking, duration: 42 customer token #2\r\n"
				+ "CLOCK: 1\r\n"
				+ "chef Bob is cooking, duration: 32 customer token #6\r\n"
				+ "CLOCK: 2\r\n"
				+ "chef Charlie is cooking, duration: 7 customer token #8\r\n"
				+ "Customer 8 has been served at 9.\r\n"
				+ "CLOCK: 10\r\n"
				+ "chef Charlie is cooking, duration: 22 customer token #4\r\n"
				+ "Customer 4 has been served at 32.\r\n"
				+ "CLOCK: 33\r\n"
				+ "chef Charlie is cooking, duration: 42 customer token #10\r\n"
				+ "Customer 6 has been served at 33.\r\n"
				+ "Customer 2 has been served at 42.\r\n"
				+ "Customer 10 has been served at 75.\r\n"
				+ "Process completed", getOutput().trim());
	}
	
	@Test
	public void SystemTest_Main_02() throws Exception{
		setOutput();
		reception.restartReception();
		dishInstance.restartDishHashInstance();
		Main.readMenuFromFile("./src/TestMenu/SampleMenu1.txt");
		Main.getInputFromFile(reception, "./src/SystemTest/test_file/Main_02.txt");	
		Kitchen kitchen = Kitchen.getInstance();
		Main.kitchenProcess(reception, kitchen);
		assertEquals("Order appended\r\n"
				+ "Order appended\r\n"
				+ "Order appended\r\n"
				+ "Order appended\r\n"
				+ "Order appended\r\n"
				+ "CLOCK: 0\r\n"
				+ "chef Adam is cooking, duration: 25 customer token #12\r\n"
				+ "CLOCK: 1\r\n"
				+ "chef Bob is cooking, duration: 15 customer token #16\r\n"
				+ "CLOCK: 2\r\n"
				+ "chef Charlie is cooking, duration: 5 customer token #18\r\n"
				+ "Customer 18 has been served at 7.\r\n"
				+ "CLOCK: 8\r\n"
				+ "chef Charlie is cooking, duration: 5 customer token #14\r\n"
				+ "Customer 14 has been served at 13.\r\n"
				+ "CLOCK: 14\r\n"
				+ "chef Charlie is cooking, duration: 25 customer token #20\r\n"
				+ "Customer 16 has been served at 16.\r\n"
				+ "Customer 12 has been served at 25.\r\n"
				+ "Customer 20 has been served at 39.\r\n"
				+ "Process completed", getOutput().trim());
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
