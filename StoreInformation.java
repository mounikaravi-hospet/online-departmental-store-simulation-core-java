package assignment.basics;

import java.util.*;

public class StoreInformation {
	private List<User> users;
	private Map<Integer, Item> items;
	
	public StoreInformation() {
		users = new ArrayList<User>();
		items = new HashMap<Integer, Item>();
	}
	
	public void registerUser(String username, String emailId, String password) {
		users.add(new User(username, emailId, password));
	}
	
	public boolean adminLogin(String username, String password) {
		return (username.equals("admin") && password.equals("admin")) ? true : false;
	}
	
	public void addItems(int productId, String productName, double buyingPrice, double sellingPrice, int availableQuantity, String category, String itemName){
		items.put(productId, new Item(productId, productName, sellingPrice, availableQuantity, itemName, category, buyingPrice));
	}
}
