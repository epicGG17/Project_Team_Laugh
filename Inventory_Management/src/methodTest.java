import static org.junit.Assert.assertEquals;

import org.junit.Test;

@SuppressWarnings("unused")
public class methodTest {
	//testing get methods

	@Test
    public void testAdd(){
        String c = "laptop";
        String n = "Sasmsung";
        double p = 10.9;
        int i = 1234;
        int q = 4;
        
        node testNode = new node(c, n, p, i, q);
        
        item arr = new item();
        arr.addItem(c, n, p, i, q);
        arr.addItem(c, n, p+1, i+1, q);

        assertEquals("test add method", testNode.getID()+1,arr.getLast().getID());
    }
	
	@Test
    public void testAdd2(){
        String c = "laptop";
        String n = "Sasmsung";
        double p = 10.9;
        int i = 1234;
        int q = 4;
        
        node testNode = new node(c, n, p, i, q);
        
        item arr = new item();
        arr.addItem(c, n, p, i, q);
        arr.addItem(c, n, p+1, i+1, q);

        assertEquals("test add method", testNode.getID(),arr.getFirst().getID());
    }
	
	@Test
    public void testDelete(){
        String c = "laptop";
        String n = "Sasmsung";
        double p = 10.9;
        int i = 1234;
        int q = 4;
        int count = 3;
        int idNum = 1234;
        
        node testNode = new node(c, n, p, i, q);
        node testNode2 = new node(c, n, p+1, i+1, q+1);
        node testNode3 = new node(c, n, p+2, i+2, q+2);
        
        item arr = new item();
        
        arr.addItem(testNode);
        arr.addItem(testNode2);
        arr.addItem(testNode3);
        
        arr.delete(1235);

        assertEquals("test delete method", count-1 ,arr.getSize());
    }
	
	@Test
    public void testDelete2(){
        String c = "laptop";
        String n = "Sasmsung";
        double p = 10.9;
        int i = 1234;
        int q = 4;
        int count = 3;
        int idNum = 1234;
        
        node testNode = new node(c, n, p, i, q);
        node testNode2 = new node(c, n, p+1, i+1, q+1);
        node testNode3 = new node(c, n, p+2, i+2, q+2);
        
        item arr = new item();
        
        arr.addItem(testNode);
        arr.addItem(testNode2);
        arr.addItem(testNode3);
        
        arr.delete(1245);

        assertEquals("test delete method", count ,arr.getSize());
    }

	@Test
    public void testprint(){
        String c = "laptop";
        String n = "Sasmsung";
        double p = 10.9;
        int i = 1234;
        int q = 4;
        
        node testNode = new node(c, n, p, i, q);
        
        item arr = new item();
        arr.addItem(c, n, p, i, q);
        arr.addItem(c, n, p+1, i+1, q);

        arr.print();
    }
	
}
