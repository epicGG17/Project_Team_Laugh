
public class item {
	//attributes
	private String category;
	private double price;
	private int id;
	private int quantity;
	
	//constructors
	public item() {
		category = null;
		price = 0.0;
		id = 0;
		quantity = 0;
	}
	
	public item(String s, double b, int i, int q) {
		category = s;
		price = b;
		id = i;
		quantity = q;
	}
	
	//Get attribute methods
	public String getCategory() {
		return category;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getID() {
		return id;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	//set attribute methods
	public void setCategory(String s) {
		category = s;
	}
	
	public void setPrice(double p) {
		price = p;
	}
	
	public void setID(int i) {
		id = i;
	}
	
	public void setQuantity(int q) {
		quantity = q;
	}
}
