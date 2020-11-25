package SystemTest;

import java.io.*;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;
import MainSystem.*;
import Order.*;
import Kitchen.*;

public class UnitTest_Order {

			
	@Test
    // Condition Coverage - Result False #1
    public void UnitTest_Order_01() throws Exception {
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

