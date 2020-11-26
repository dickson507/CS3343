package SystemTest;

import java.io.*;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;
import MainSystem.*;
import Order.*;
import Kitchen.*;
import Persons.*;

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
		
		class Stub_Kitchen extends Kitchen {

			public Stub_Kitchen(String name1, String ID1, String name2, String ID2, String name3, String ID3) {
				super(name1, ID1, name2, ID2, name3, ID3);
			}
			
			@Override
			public void process(ArrayList<CustomerOrder> cd) {}
			
		}
		Stub_Reception reception = new Stub_Reception();
		Stub_Kitchen kitchen = new Stub_Kitchen("Abby", "001", "Bobby", "002", "Chabby", "003");
		Main.kitchenProcess(reception, kitchen);
        assertEquals("Process completed\r\n", getOutput());
    }
	
	
	@Test
    // Condition Coverage - Result False #1
    public void UnitTest_Output_01() throws Exception {
		setOutput();
		class Stub_CustomerOrder extends CustomerOrder {
			public Stub_CustomerOrder(int orderTime, Customer c) {
				super(orderTime, c);
			}
		}
		class Stub_Customer extends Customer {}
		Stub_Customer c = new Stub_Customer();
		Stub_CustomerOrder co = new Stub_CustomerOrder(10, c);
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

