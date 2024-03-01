package assignment.basics;

public class Item extends Product{
	private String itemName;
	private String category;
	private double buyingPrice;
	
	public Item(int productId, String productName, double sellingPrice, int availableQuantity, String itemName,
			String category, double buyingPrice) 
	{
		super(productId, productName, sellingPrice, availableQuantity);
		this.itemName = itemName;
		this.category = category;
		this.buyingPrice = buyingPrice;
	}

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getBuyingPrice() {
		return buyingPrice;
	}
	public void setBuyingPrice(double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}	
}
