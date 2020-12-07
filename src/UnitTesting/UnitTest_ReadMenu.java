package UnitTesting;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Cusine.Dish;
import Cusine.ReadMenu;

public class UnitTest_ReadMenu {
	
	@Test
	public void testReadMenu1() {
		ReadMenu readmenu = new ReadMenu();
		ArrayList<Dish> dishes = ReadMenu.read(System.getProperty("user.dir") + "/src/TestMenu/SampleMenu1.txt");
		assertEquals("beef cake", ReadMenu.MenuToString(dishes));
	}
	
	@Test
	public void testReadMenu2() {
		ReadMenu readmenu = new ReadMenu();
		ArrayList<Dish> dishes = ReadMenu.read(System.getProperty("user.dir") + "/src/TestMenu/SampleMenu2.txt");
		assertEquals("", ReadMenu.MenuToString(dishes));
	}
	
	@Test
	public void testReadMenu3() {
		ReadMenu readmenu = new ReadMenu();
		ArrayList<Dish> dishes = ReadMenu.read(System.getProperty("user.dir") + "/src/TestMenu/SampleMenu3.txt");
		assertEquals("", ReadMenu.MenuToString(dishes));
	}
	
	@Test
	public void testReadMenu4() {
		ReadMenu readmenu = new ReadMenu();
		ArrayList<Dish> dishes = ReadMenu.read(System.getProperty("user.dir") + "/src/TestMenu/SampleMenu4.txt");
		assertEquals("", ReadMenu.MenuToString(dishes));
	}

}
