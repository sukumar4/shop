package shop;

/**
 * 
 * @author Sukumar
 *
 */
public class SuperMarketImpl implements SuperMarket {

	//Fields to store pricing rule input
	private int baseQuantity = 0;
	private int offeredQuantity = 0;
	private char offerItemType;
	
	//Specific Product object based on input item 
	private Product prodA=null, prodB=null, prodC=null;
	
	//Specific ProductOrder objects
	private ProductOrder orderA=null, orderB=null, orderC=null;
	
	//Array to hold input price list
	private String prices[];
	
	//Total amount
	private int totalAmount = 0;
	
	/**
	 * 
	 * @param price
	 * @param rules
	 */
	public SuperMarketImpl(String price[], String rules[])
	{
		prices = price;
		offerItemType = rules[0].charAt(0);
		baseQuantity = Integer.valueOf(rules[1]);
		offeredQuantity = Integer.valueOf(rules[2]);
	}
	
	/**
	 * 
	 * @param prodSeq
	 */
	private void createOrders(String prodSeq) throws Exception
	{
		//Create three products based on specific Item input - only once
		//increment it's count based on input item sequence
		prodA = ProductFactory.createProduct("A", Integer.parseInt(prices[0]));
		prodB = ProductFactory.createProduct("B", Integer.parseInt(prices[1]));
		prodC = ProductFactory.createProduct("C", Integer.parseInt(prices[2]));
		
		//create respective ProductOrder that keeps track of number of Product of specific type		
		for(int i = 0; i<prodSeq.length(); i++)
		{
			//number of input item can be counted with a counter here;
			//nevertheless, creating respective product into the list and 
			//later getting the total size from the individual objects
			if(prodSeq.charAt(i) == 'A')
			{
				if(orderA == null)
				{
					orderA = new ProductOrder();
					
					//Set the pricing rule for type 'A'
					if(offerItemType == 'A')
					{
						orderA.setHasOffer(true);
						
						System.out.println("A base quantity: " + baseQuantity);
						orderA.setBaseQuantity(baseQuantity);
						
						System.out.println("A offered quantity: " + offeredQuantity);
						orderA.setOfferedQuantity(offeredQuantity);
					}
				}
				orderA.addProduct(prodA);
			}
			else if(prodSeq.charAt(i) == 'B')
			{
				if(orderB == null)
				{
					orderB = new ProductOrder();
					//Set the pricing rule for type 'B'
					if(offerItemType == 'B')
					{
						orderB.setHasOffer(true);
						System.out.println("B base quantity: " + baseQuantity);
						orderB.setBaseQuantity(baseQuantity);
						
						System.out.println("B offered quantity: " + offeredQuantity);
						orderB.setOfferedQuantity(offeredQuantity);
					}
				}
				orderB.addProduct(prodB);
			}
			else if(prodSeq.charAt(i) == 'C')
			{
				if(orderC == null)
				{
					orderC = new ProductOrder();
					//Set the pricing rule for type 'C'
					if(offerItemType == 'C')
					{
						orderC.setHasOffer(true);
						
						System.out.println("C base quantity: " + baseQuantity);
						orderC.setBaseQuantity(baseQuantity);
						
						System.out.println("C offered quantity: " + offeredQuantity);
						orderC.setOfferedQuantity(offeredQuantity);
					}
				}
				orderC.addProduct(prodC);
			}
		}
	}
	
	/**
	 * 
	 * @param order
	 * @return
	 */
	private int calculateOfferCount(ProductOrder order)
	{
		int totalQuantity = order.getProducts().size();
		int baseCount = order.getBaseQuantity();
		int offerCount = order.getOfferedQuantity();
		int finalQuantity = 0;
		
		if((order.isHasOffer()) && (offerCount < baseCount)) // 3 < 5 or 4 < 5 or 2 < 3
		{
			int reminder = totalQuantity % baseCount;
			//recalculate count for specific type - Total number of Products B for final billing with the offer
			finalQuantity = offerCount + reminder;
		}
		return finalQuantity;
	}
	
	/**
	 * 
	 */
	private void calculateOrderPrice() throws Exception
	{
		//Total number of Product of type "A"
		int quantityA = orderA.getProducts().size();
		//Item should have offer and total quantities should be bigger than base quantity
		if(orderA.isHasOffer() && (orderA.getBaseQuantity() <= quantityA))
		{
			quantityA = calculateOfferCount(orderA);
		}
		
		//Total number of Product of type "B"
		int quantityB = orderB.getProducts().size();
		if(orderB.isHasOffer() && (orderB.getBaseQuantity() <= quantityB))
		{
			quantityB = calculateOfferCount(orderB);
		}
		
		//Total number of Product of type "C"
		int quantityC = orderC.getProducts().size();
		if(orderC.isHasOffer() && (orderC.getBaseQuantity() <= quantityC))
		{
			quantityC = calculateOfferCount(orderC);
		}
 				
		int priceA = orderA.getProducts().get(0).getPrice();
		int priceB = orderB.getProducts().get(0).getPrice();
		int priceC = orderC.getProducts().get(0).getPrice();
		
		System.out.println("All the three count: " + quantityA + "," + quantityB + "," + quantityC);
		System.out.println("All the three prices: " + "$" + priceA + "," + 
													"$" + priceB + "," + 
													"$" + priceC);
		
		//Set the total price for each order (for as many Products)
		orderA.setOrderPrice(quantityA * priceA);
		orderB.setOrderPrice(quantityB * priceB);
		orderC.setOrderPrice(quantityC * priceC);
		
	}
	
	/**
	 * 
	 */
	@Override
	public int checkout(String items) {
		// TODO Auto-generated method stub
		try
		{
			createOrders(items);
			calculateOrderPrice();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.exit(0);
		}
		
		totalAmount = orderA.getOrderPrice() + orderB.getOrderPrice() + orderC.getOrderPrice();
			
		return totalAmount;
	}

}
