package shop;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 * @author Sukumar
 *
 */
public class ProductOrder {
	
	private List<Product> products;
	private int orderPrice;
	private boolean hasOffer;
	private int baseQuantity;
	private int offeredQuantity;
	
	public ProductOrder()
	{
		products = new ArrayList<Product>();
	}
	
	public void addProduct(Product p)
	{
		products.add(p);
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public boolean isHasOffer() {
		return hasOffer;
	}

	public void setHasOffer(boolean hasOffer) {
		this.hasOffer = hasOffer;
	}

	public int getOfferedQuantity() {
		return offeredQuantity;
	}

	public void setOfferedQuantity(int offeredQuantity) {
		this.offeredQuantity = offeredQuantity;
	}

	public int getBaseQuantity() {
		return baseQuantity;
	}

	public void setBaseQuantity(int baseQuantity) {
		this.baseQuantity = baseQuantity;
	}
	
	
	
}
