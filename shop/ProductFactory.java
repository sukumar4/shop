package shop;

import java.util.List;
import java.util.ArrayList;

public class ProductFactory {

	private static List<String> prodNames = new ArrayList<String>();
	
	public static Product createProduct(String name, int price)
	{
		Product p = new Product(name);
		p.setPrice(price);
		
		return p;
	}
	
	public static List<String> getProdNames()
	{
		return prodNames;
	}
}
