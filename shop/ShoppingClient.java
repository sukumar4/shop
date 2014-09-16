package shop;

import java.io.IOException;
import java.util.Scanner;
import java.io.InputStreamReader;

/**
 * 
 * @author Sukumar
 *
 */
public class ShoppingClient {
	
	public static void main(String args[]) throws IOException
	{
		String items = "ABBACBBAB";
		String price[] = {"20", "50", "30"};
		String rules[] = {"B", "5", "3"};

		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		System.out.println("Please input your Item sequence:");
		String strItems = scanner.nextLine();
		if(strItems != null && !strItems.isEmpty())
		{
			items = strItems.toUpperCase();
		}
		
		System.out.println("Please enter your price for Product A");
		String priceA = scanner.nextLine();
		if(priceA != null && !priceA.isEmpty())
		{
			price[0] = priceA;
		}
		
		System.out.println("Please enter your price for Product B");
		String priceB = scanner.nextLine();
		if(priceB != null && !priceB.isEmpty())
		{
			price[1] = priceB;
		}
		
		System.out.println("Please enter your price for Product C");
		String priceC = scanner.nextLine();
		if(priceC != null && !priceC.isEmpty())
		{
			price[2] = priceC;
		}
		
		System.out.println("Please enter Item Type for offer");
		String type = scanner.nextLine();
		if(type != null && !type.isEmpty())
		{
			rules[0] = type.toUpperCase();
		}
		
		System.out.println("Please enter Base Quantity for the offer Item Type:");
		String baseQuantity = scanner.nextLine();
		if(baseQuantity != null && !baseQuantity.isEmpty())
		{
			rules[1] = baseQuantity;
		}
				
		System.out.println("Please enter Offer Quantity for the offer Item Type");
		String offerQuantity = scanner.nextLine();
		if(offerQuantity != null && !offerQuantity.isEmpty())
		{
			rules[2] = offerQuantity;
		}
		
		
		System.out.println("Input Item Sequence: " + items);
		ShoppingHandler shoppingHandler = new ShoppingHandler(items, price, rules);
		
		//shoppingHandler.loadProducts();
		int totalAmount = shoppingHandler.checkout();
				
		System.out.println("Total Amount: $" + totalAmount);
	}

}
