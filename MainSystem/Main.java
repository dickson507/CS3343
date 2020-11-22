package MainSystem;
import java.io.*;
import java.util.*;


public class Main {

	public static void main(String args[]) throws IOException {
		// get the reception of the restaurant!
		//Reception reception = Reception.getReception();
		
		try {
			Scanner scanner = new Scanner(new File("CustomerOrders.txt"));
			while (scanner.hasNextLine())  {
				//reception.input_order(scanner.nextLine());
				String order = scanner.nextLine();
				System.out.println(order);
			}
			scanner.close();
			
			// reception.getListOfDishes();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}