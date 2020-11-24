import static org.junit.Assert.*;

import org.junit.Test;

public class SeachingTest {
	@Test
	public void numbers()
	{
		String n = "1234";
		int x = 1234;
		assertEquals("Tesing string to numbers", true, Searching.containNumbers(n));
		assertEquals("Tesing string to numbers", false, Searching.containNumbers("pizza"));
	}
	
	@Test
	public void testSearchItem() {
		String c = "laptop";
        String n = "Sasmsung";
        double p = 10.9;
        int i = 1234;
        int q = 4;
        
        node testing = new node(c, n, p, i, q);
        
        //testing on empty list
		boolean  t = Searching.searchItem(null, null );
		assertEquals("Empty node", false, t);
		  
		item arr = new item();
		arr.addItem(testing);
		arr.addItem(c, n, p, i, q);
		arr.addItem("TV", "vizio", 99.99, 4499, 5);
		arr.addItem("TV", "LG", 59.99, 4563, 6);
		arr.addItem("laptop", "acer", 699.99, 7896, 10);
		arr.addItem("phone", "apple x", 999.99, 0001, 9);
		arr.addItem("tablet", "air", 899.99, 4456, 8);
		// search id
		t = Searching.searchItem(arr.getFirst(), "0001");
		assertEquals("Looking for id if there", true, t);
		t = Searching.searchItem(arr.getFirst(), "0011");
		assertEquals("Looking for id if not there", false, t);
		//searching by item name
		t = Searching.searchItem(arr.getFirst(), "acer");
		assertEquals("Looking for item by name", true, t);
		t = Searching.searchItem(arr.getFirst(), "pie");
		assertEquals("Looking for item not there", false, t);	
		//fail("Not yet implemented");
	}
	
	@Test
	public void searchCat() {
		String c = "laptop";
        String n = "Sasmsung";
        double p = 10.9;
        int i = 1234;
        int q = 4;
        
        node testing = new node(c, n, p, i, q);
        
        //testing on empty list
		boolean  t = Searching.searchThruCat(null, null);
		assertEquals("Empty node", false, t);
		  
		item arr = new item();
		arr.addItem(testing);
		arr.addItem(c, n, p, i, q);
		arr.addItem("TV", "vizio", 99.99, 4499, 5);
		arr.addItem("TV", "LG", 59.99, 4563, 6);
		arr.addItem("laptop", "acer", 699.99, 7896, 10);
		arr.addItem("phone", "apple IX", 999.99, 0001, 9);
		arr.addItem("tablet", "air", 899.99, 4456, 8);
		//checking if Cat can be found
		t = Searching.searchThruCat(arr.getFirst(), "TV");
		assertEquals("If the Cat is there", true, t);
		//checking if the Cat is not there
		t = Searching.searchThruCat(arr.getFirst(), "XD");
		assertEquals("If the Cat is there", false, t);
	}

}
