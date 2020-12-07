package UnitTesting;

import java.io.*;
import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;
import MainSystem.*;
import Order.*;
import Persons.Customer;
import Kitchen.*;
import Cusine.*;

public class UnitTest_Customer {

	@Test
	public void UnitTest_Customer_01() throws Exception {
		Customer c = new Customer();
		assertEquals(1, c.getTokenNumber());
	}
	
	@Test
	public void UnitTest_Customer_02() throws Exception {
		Customer c2 = new Customer();
		Customer c3 = new Customer();
		assertEquals(3, c3.getTokenNumber());
	}
}
