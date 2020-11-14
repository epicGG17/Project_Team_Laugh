
public class item {
	String name;
	int id;
	int quantity;
	Double price;
	String category;
	
	item(String n, int d, int q, double p, String s){
		
		name = n;
		id = d;
		quantity = q;
		price = p;
		category = s;
	
	}
	public void showData() {
		System.out.println("Name: " +name+ "  "+"ID:  "+ id+ "  "+ "Quantity: "+ quantity+ "  "
	+ "Price: "+ price+ " Cat: "+ category);
	}
	

}