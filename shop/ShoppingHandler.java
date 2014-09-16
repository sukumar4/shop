package shop;

/**
 * 
 * @author Sukumar
 *
 */
public class ShoppingHandler {

	//SuperMarket interface for handling input request
	private SuperMarket superMarket = null;
	
	//To store input item sequence
	private String items;

	/**
	 * 
	 * @param items
	 * @param price
	 * @param rules
	 */
	public ShoppingHandler(String items, String price[], String rules[])
	{
		superMarket = new SuperMarketImpl(price, rules);
		this.items = items;
	}
	
	/**
	 * 
	 * @return
	 */
	public int checkout()
	{
		return superMarket.checkout(items);
	}
}
