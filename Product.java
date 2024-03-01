package assignment.basics;

public class Product{
	private int productId;
	private String productName;
	private double sellingPrice;
	private int availableQuantity;
	
	
	public Product(int productId, String productName, double sellingPrice, int availableQuantity) {
		this.productId = productId;
		this.productName = productName;
		this.sellingPrice = sellingPrice;
		this.availableQuantity = availableQuantity;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

}
