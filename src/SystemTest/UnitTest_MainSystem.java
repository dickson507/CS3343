package SystemTest;

import java.io.*;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;
import MainSystem.*;
import Order.*;
import Kitchen.*;

public class UnitTest_MainSystem {

		
	@Test
    // Condition Coverage - Result False #1
    public void UnitTest_Main_01() throws Exception {
		setOutput();
		class Stub_Reception extends Reception {
			@Override
			public void input_order(String in_order){}
		}
		Stub_Reception reception = new Stub_Reception();
		String filepath = "./src/SystemTest/test_file/main_01.txt";
		Main.getInputFromFile(reception, filepath);
        assertEquals("Order appended\r\n", getOutput());
    }
	
	@Test
    // Condition Coverage - Result False #1
    public void UnitTest_Main_02() throws Exception {
		setOutput();
		class Stub_Reception extends Reception {
			@Override
			public void input_order(String in_order){}
		}
		Stub_Reception reception = new Stub_Reception();
		Kitchen kitchen = Kitchen.getInstance();
		Main.kitchenProcess(reception, kitchen);
        assertEquals("Process completed\r\n", getOutput());
    }
	
	
	@Test
    // Condition Coverage - Result False #1
    public void UnitTest_Output_01() throws Exception {
		setOutput();
		class Stub_CustomerOrder extends CustomerOrder {
			public Stub_CustomerOrder(int orderTime) {
				super(orderTime);
			}
		}
		Stub_CustomerOrder co = new Stub_CustomerOrder(10);
		Output.output(co, 10);
        assertEquals("Customer 1 has been served at 10.\r\n", getOutput());
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

