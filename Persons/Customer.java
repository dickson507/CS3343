package Persons;
import java.util.*;
import java.io.*;
import TokenSystem.*;

public class Customer {
	private int tokenNumber;
	public Customer()
	{
		Token tokenInstance = Token.getInstance();
		tokenNumber = tokenInstance.getToken();
	}
	public int getTokenNumber()
	{
		return tokenNumber;
	}
}
