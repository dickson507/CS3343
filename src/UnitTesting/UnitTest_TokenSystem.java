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
import TokenSystem.*;

public class UnitTest_TokenSystem {

	@Test
	public void UnitTest_Token_01() throws Exception {
		Token tokenInstance = Token.getInstance();
		Token ti = Token.getInstance();
		assertEquals(ti, tokenInstance);
	}
	
	@Test
	public void UnitTest_Token_02() throws Exception {
		Token tokenInstance = Token.getInstance();
		assertEquals(1, tokenInstance.getToken());
	}
	
	
	@Test
	public void UnitTest_Token_03() throws Exception {
		Token tokenInstance = Token.getInstance();
		tokenInstance.getToken();
		assertEquals(3, tokenInstance.getToken());
	}
}
