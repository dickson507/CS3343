package UnitTesting;

import org.junit.Test;
import org.junit.jupiter.api.*;

import Cusine.Dish;
import Cusine.DishHashInstance;
import Cusine.ReadMenu;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;

import Order.*;


public class UnitTest_Reception {
	private Reception reception;
	private DishHashInstance dishInstance;
	private ReadMenu readmenu;
	
	@Before
	public void setup() throws Exception{
		reception = Reception.getReception();
		dishInstance = DishHashInstance.getDishHashInstance();
		readmenu = new ReadMenu();
	}
	@Test
	public void testReception1() throws Exception {
		setOutput();
		for(Dish dish : readmenu.read("./src/TestMenu/SampleMenu5.txt")){
			dishInstance.insertDish(dish);
		}
		reception.input_order("0/crackers;beef,beef,fish;cake");
		reception.getListOfOrders();
		assertEquals("Token Number 2: crackers beef beef fish cake\r\n", getOutput());
	}
	
	@After public void restart() throws Exception{
		reception.restartReception();
		dishInstance.restartDishHashInstance();
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
