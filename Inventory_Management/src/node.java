//node class 
	public class node{
		private String category;
		private String name;
		private double price;
		private int id;
		private int quantity;
		private node link;
		
		public node() {
			category = null;
			name = null;
			price = 0.0;
			id = 0;
			quantity = 0;	
			link = null;
		}
		
		public node(String s,String n ,double b, int i, int q) {
			category = s;
			name = n;
			price = b;
			id = i;
			quantity = q;
			link = null;
		}
		
		//get methods for each attribute
		
		public String getCategory() {
			return category;
		}
		
		public String getName() {
			return name;
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
		
		public node getLink() {
			return link;
		}
		
		//set methods for each attribute
		
		public void setCategory(String s) {
			category = s;
		}
		
		public void setName(String s) {
			name = s;
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
		
		public void setLink(node n) {
			link = n;
		}
	}