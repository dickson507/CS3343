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
import TokenSystem.Token;

public class SystemTest_MainSystem {
	private Reception reception = Reception.getReception();
	private DishHashInstance dishInstance = DishHashInstance.getDishHashInstance();
	
	@Test
	public void SystemTest_Main_01() throws Exception {
		setOutput();
		reception.restartReception();
		dishInstance.restartDishHashInstance();
		Token.getInstance().restartTokenSystem();
		Main.main(null);
		assertEquals("Order appended\r\n"
				+ "Order appended\r\n"
				+ "Order appended\r\n"
				+ "Order appended\r\n"
				+ "Order appended\r\n"
				+ "CLOCK: 0\r\n"
				+ "chef Adam is cooking, duration: 42 customer token #1\r\n"
				+ "CLOCK: 1\r\n"
				+ "chef Bob is cooking, duration: 32 customer token #3\r\n"
				+ "CLOCK: 2\r\n"
				+ "chef Charlie is cooking, duration: 7 customer token #4\r\n"
				+ "Customer 4 has been served at 9.\r\n"
				+ "CLOCK: 10\r\n"
				+ "chef Charlie is cooking, duration: 22 customer token #2\r\n"
				+ "Customer 2 has been served at 32.\r\n"
				+ "CLOCK: 33\r\n"
				+ "chef Charlie is cooking, duration: 42 customer token #5\r\n"
				+ "Customer 3 has been served at 33.\r\n"
				+ "Customer 1 has been served at 42.\r\n"
				+ "Customer 5 has been served at 75.\r\n"
				+ "Process completed", getOutput().trim());
	}
	
	@Test
	public void SystemTest_Main_02() throws Exception{
		setOutput();
		reception.restartReception();
		dishInstance.restartDishHashInstance();
		Token.getInstance().restartTokenSystem();
		
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
				+ "chef Adam is cooking, duration: 25 customer token #1\r\n"
				+ "CLOCK: 1\r\n"
				+ "chef Bob is cooking, duration: 15 customer token #3\r\n"
				+ "CLOCK: 2\r\n"
				+ "chef Charlie is cooking, duration: 5 customer token #4\r\n"
				+ "Customer 4 has been served at 7.\r\n"
				+ "CLOCK: 8\r\n"
				+ "chef Charlie is cooking, duration: 5 customer token #2\r\n"
				+ "Customer 2 has been served at 13.\r\n"
				+ "CLOCK: 14\r\n"
				+ "chef Charlie is cooking, duration: 25 customer token #5\r\n"
				+ "Customer 3 has been served at 16.\r\n"
				+ "Customer 1 has been served at 25.\r\n"
				+ "Customer 5 has been served at 39.\r\n"
				+ "Process completed", getOutput().trim());
	}
	
	@Test
	public void SystemTest_Main_03() throws Exception{
		setOutput();
		reception.restartReception();
		dishInstance.restartDishHashInstance();
		Token.getInstance().restartTokenSystem();
		
		Main.readMenuFromFile("./src/TestMenu/SampleMenu6.txt");
		Main.getInputFromFile(reception, "./src/SystemTest/test_file/Main_03.txt");	
		Kitchen kitchen = Kitchen.getInstance();
		Main.kitchenProcess(reception, kitchen);
		assertEquals("Order appended\r\n"
				+ "Order appended\r\n"
				+ "Order appended\r\n"
				+ "Order appended\r\n"
				+ "Order appended\r\n"
				+ "Order appended\r\n"
				+ "Order appended\r\n"
				+ "CLOCK: 0\r\n"
				+ "chef Adam is cooking, duration: 37 customer token #1\r\n"
				+ "CLOCK: 1\r\n"
				+ "chef Bob is cooking, duration: 38 customer token #7\r\n"
				+ "CLOCK: 2\r\n"
				+ "chef Charlie is cooking, duration: 27 customer token #3\r\n"
				+ "Customer 3 has been served at 29.\r\n"
				+ "CLOCK: 30\r\n"
				+ "chef Charlie is cooking, duration: 7 customer token #4\r\n"
				+ "Customer 1 has been served at 37.\r\n"
				+ "Customer 4 has been served at 37.\r\n"
				+ "CLOCK: 38\r\n"
				+ "chef Adam is cooking, duration: 49 customer token #6\r\n"
				+ "CLOCK: 39\r\n"
				+ "chef Charlie is cooking, duration: 37 customer token #5\r\n"
				+ "Customer 7 has been served at 39.\r\n"
				+ "CLOCK: 40\r\n"
				+ "chef Bob is cooking, duration: 17 customer token #2\r\n"
				+ "Customer 2 has been served at 57.\r\n"
				+ "Customer 5 has been served at 76.\r\n"
				+ "Customer 6 has been served at 87.\r\n"
				+ "Process completed", getOutput().trim());
	}
	
	@Test
	public void SystemTest_Main_04() throws Exception{
		setOutput();
		reception.restartReception();
		dishInstance.restartDishHashInstance();
		Token.getInstance().restartTokenSystem();
		
		Main.readMenuFromFile("./src/TestMenu/SampleMenu7.txt");
		Main.getInputFromFile(reception, "./src/SystemTest/test_file/Main_04.txt");	
		Kitchen kitchen = Kitchen.getInstance();
		Main.kitchenProcess(reception, kitchen);
		
		assertEquals("Order appended\r\n"
				+ "Order appended\r\n"
				+ "Order appended\r\n"
				+ "Order appended\r\n"
				+ "Order appended\r\n"
				+ "Order appended\r\n"
				+ "Order appended\r\n"
				+ "Order appended\r\n"
				+ "CLOCK: 0\r\n"
				+ "chef Adam is cooking, duration: 2055565 customer token #1\r\n"
				+ "CLOCK: 1\r\n"
				+ "chef Bob is cooking, duration: 1000007 customer token #7\r\n"
				+ "CLOCK: 2\r\n"
				+ "chef Charlie is cooking, duration: 1055566 customer token #3\r\n"
				+ "Customer 7 has been served at 1000008.\r\n"
				+ "CLOCK: 1000009\r\n"
				+ "chef Bob is cooking, duration: 55557 customer token #4\r\n"
				+ "Customer 4 has been served at 1055566.\r\n"
				+ "CLOCK: 1055567\r\n"
				+ "chef Bob is cooking, duration: 1000018 customer token #6\r\n"
				+ "Customer 3 has been served at 1055568.\r\n"
				+ "CLOCK: 1055569\r\n"
				+ "chef Charlie is cooking, duration: 2055565 customer token #5\r\n"
				+ "Customer 1 has been served at 2055565.\r\n"
				+ "CLOCK: 2055566\r\n"
				+ "chef Adam is cooking, duration: 55567 customer token #2\r\n"
				+ "Customer 6 has been served at 2055585.\r\n"
				+ "CLOCK: 2055586\r\n"
				+ "chef Bob is cooking, duration: 3000006 customer token #8\r\n"
				+ "Customer 2 has been served at 2111133.\r\n"
				+ "Customer 5 has been served at 3111134.\r\n"
				+ "Customer 8 has been served at 5055592.\r\n"
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
