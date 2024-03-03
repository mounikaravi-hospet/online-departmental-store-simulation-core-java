package assignment.basics;

import java.util.*;

public class StoreInformation {
	private List<User> users;
	private Map<Integer, Item> items;
	private boolean userLogged;
	private boolean adminLogged;
	private String username;
	Scanner sc;
	
	public StoreInformation() {
		sc = new Scanner(System.in);
		setUserLogged(false);
		setAdminLogged(false);
		users = new ArrayList<User>();
		items = new HashMap<Integer, Item>();
	}	
	
	public boolean isAdminLogged() {
		return adminLogged;
	}

	public void setAdminLogged(boolean adminLogged) {
		this.adminLogged = adminLogged;
	}

	public boolean isUserLogged() {
		return userLogged;
	}

	public void setUserLogged(boolean userLogged) {
		this.userLogged = userLogged;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public void registerUser(String username, String emailId, String password) {
		users.add(new User(username, emailId, password));
	}	
	
	public void login(String username, String password) {
		if(username.equals("admin") && password.equals("admin")) {
			System.out.println("Welcome Admin");
			setAdminLogged(true);
		}
		else {
			for(User user : users) {
				if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
					System.out.println("Welcome "+user.getUsername());
					setUserLogged(true);
				}else {
					System.out.println("Invalid Username or password!");
				}
			}
		}
	}
	
	public void startUpMenu() {
		System.out.println("Choose an option:");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        int option = sc.nextInt();
        sc.nextLine(); 

        switch (option) {
            case 1:
                System.out.println("Enter Username: ");
                String username = sc.nextLine();
                System.out.println("Enter Password: ");
                String password = sc.nextLine();
                login(username, password);
                setUsername(username);
                break;
            case 2:
                System.out.println("Enter Username: ");
                String newUsername = sc.nextLine();
                System.out.println("Enter Email Id: ");
                String emailId = sc.nextLine();
                System.out.println("Enter Password: ");
                String newPassword = sc.nextLine();
                registerUser(newUsername, emailId, newPassword);
                startUpMenu();
                break;
            case 3: System.exit(0);
            default:
                System.out.println("Invalid option");
        }
	}

	
	public void addItems(int productId, String productName, double buyingPrice, int availableQuantity, String category, String itemName){
		double sellingPrice = (buyingPrice*50)+buyingPrice;
		items.put(productId, new Item(productId, productName, sellingPrice, availableQuantity, itemName, category, buyingPrice));
	}
	
	public void viewProducts() {
		if(getUsername().equals("admin")) {
			for(Map.Entry<Integer, Item> entry : items.entrySet()) {
				Item item = entry.getValue();
				System.out.println(item.getProductId() + " : " + item.getProductName()+ " : " + item.getCategory()
				+ " : " + item.getSellingPrice()+ " : " + item.getBuyingPrice() + " : " + item.getAvailableQuantity());
			}
		}
		else {
			for(Map.Entry<Integer, Item> entry : items.entrySet()) {
				Item item = entry.getValue();
				System.out.println(item.getProductId() + " : " + item.getProductName()+ " : " + item.getCategory()
				+ " : " + item.getSellingPrice()+ " : " + item.getAvailableQuantity());
			}
		}
	}
	
	public void viewProductsByCategory(String category) {
		if(getUsername().equals("admin")) {
			for(Map.Entry<Integer, Item> entry : items.entrySet()) {
				Item item = entry.getValue();
				if(item.getCategory().equalsIgnoreCase(category)) {
					System.out.println(item.getProductId() + " : " + item.getProductName()+ " : " + item.getCategory()
					+ " : " + item.getSellingPrice()+ " : " + item.getBuyingPrice()+ " : " + item.getAvailableQuantity());
				}
			}	
		} else {
			for(Map.Entry<Integer, Item> entry : items.entrySet()) {
				Item item = entry.getValue();
				if(item.getCategory().equalsIgnoreCase(category)) {
					System.out.println(item.getProductId() + " : " + item.getProductName()+ " : " + item.getCategory()
					+ " : " + item.getSellingPrice()+ " : " + item.getAvailableQuantity());
				}
			}	
		}
	}
	
	public void searchProduct(int id) {
		if(getUsername().equals("admin")) {
			for(Map.Entry<Integer, Item> entry : items.entrySet()) {
				Item item = entry.getValue();
				if(item.getProductId() == id) {
					System.out.println(item.getProductId() + " : " + item.getProductName()+ " : " + item.getCategory()
					+ " : " + item.getSellingPrice()+ " : " + item.getBuyingPrice()+ " : " + item.getAvailableQuantity());
				}
			}	
		}
	}
	
	public double totalAmountSpent() {
	    double sum = 0.0;
	    for (Item item : items.values()) {
	        sum += item.getBuyingPrice();
	    }
	    return sum;
	}
	
	public double calculateProfits() {
	    double totalProfits = 0.0;
	    for (Item item : items.values()) {
	        double profitPerItem = item.getSellingPrice() - item.getBuyingPrice();
	        totalProfits += profitPerItem * item.getAvailableQuantity();
	    }
	    return totalProfits;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String cat = "n";
		String category;
		StoreInformation store = new StoreInformation();
		
//		int productId, String productName, double buyingPrice, int availableQuantity, String category, String itemName
		store.addItems(10, "Pencil", 1.0, 200, "Stationery", "HB Pencil");
		store.addItems(11, "Tomato", 1.5, 150, "Vegetables", "Red Tomato");
		store.addItems(12, "Cucumber", 1.2, 120, "Vegetables", "Green Cucumber");
		store.addItems(13, "Bread", 2.0, 100, "Grocery", "White Bread");
		store.addItems(14, "Apple", 2.0, 180, "Fruits", "Red Apple");
		store.addItems(15, "Orange", 1.8, 160, "Fruits", "Juicy Orange");
		store.addItems(16, "Notebook", 3.0, 150, "Stationery", "A5 Spiral Notebook");
		store.addItems(17, "Eggs", 3.5, 200, "Grocery", "Fresh Eggs");
		store.addItems(18, "Shampoo", 8.0, 120, "Toiletry", "Anti-Dandruff Shampoo");
		store.addItems(19, "Potato", 1.0, 220, "Vegetables", "Yellow Potato");

		
		store.registerUser("Anu", "anu@example.com", "123");
		store.startUpMenu();
		
		if(store.isUserLogged()) {
			System.out.println("User actions");
			store.viewProducts();
			System.out.println("Enter 'y' to filter by category: ");
			cat = sc.next();
			
			if(cat.equals("y")) {
				System.out.println("Enter the category you want to filter: ");
				category = sc.next();
				store.viewProductsByCategory(category);
			}
		}
		
		if(store.isAdminLogged()) {
			System.out.println("Admin actions");
			System.out.println("Total expenditure: " +store.totalAmountSpent());
			System.out.println("Profits: " +store.calculateProfits());
			
			store.viewProducts();
			if(cat.equals("y")) {
				System.out.println("Enter the category you want to filter: ");
				category = sc.next();
				store.viewProductsByCategory(category);
			}
		}
		
		sc.close();
		
	}
}
