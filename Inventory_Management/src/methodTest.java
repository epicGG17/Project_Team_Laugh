import static org.junit.Assert.assertEquals;

import org.junit.Test;

@SuppressWarnings("unused")
public class methodTest {
	//testing get methods
	@Test
    public void getCategory(){
        String c = "laptop";
        double p = 10.9;
        int i = 1234;
        int q = 4;
        
        item obj = new item(c,p,i,q);


      assertEquals("getCategory()",c,obj.getCategory());
    }
	
	@Test
    public void getPrice(){
        String c = "laptop";
        double p = 10.9;
        int i = 1234;
        int q = 4;
        
        item obj = new item(c,p,i,q);


      assertEquals("getPrice()",p,obj.getPrice(),.01);
    }
	
	@Test
    public void getID(){
        String c = "laptop";
        double p = 10.9;
        int i = 1234;
        int q = 4;
        
        item obj = new item(c,p,i,q);


      assertEquals("getID()",i,obj.getID());
    }
	
	@Test
    public void getQuantity(){
        String c = "laptop";
        double p = 10.9;
        int i = 1234;
        int q = 4;
        
        item obj = new item(c,p,i,q);


      assertEquals("getQuantity()",q,obj.getQuantity());
    }
	
	//test set methods
	@Test
    public void setCategory(){
        String c = "laptop";
        double p = 10.9;
        int i = 1234;
        int q = 4;
        
        item obj = new item(c,p,i,q);
        
        String c2 = "TV";
        double p2 = 15.4;
        int i2 = 4413;
        int q2 = 7;
        
        obj.setCategory(c2);


      assertEquals("get altered Category",c2,obj.getCategory());
    }
	
	@Test
    public void setPrice(){
        String c = "laptop";
        double p = 10.9;
        int i = 1234;
        int q = 4;
        
        item obj = new item(c,p,i,q);
        
        String c2 = "TV";
        double p2 = 15.4;
        int i2 = 4413;
        int q2 = 7;
        
        obj.setPrice(p2);


      assertEquals("get altered price",p2,obj.getPrice(),.001);
    }
	
	@Test
    public void setID(){
        String c = "laptop";
        double p = 10.9;
        int i = 1234;
        int q = 4;
        
        item obj = new item(c,p,i,q);
        
        String c2 = "TV";
        double p2 = 15.4;
        int i2 = 4413;
        int q2 = 7;
        
        obj.setID(i2);


      assertEquals("get altered id",i2,obj.getID());
    }
	
	@Test
    public void setQuantity(){
        String c = "laptop";
        double p = 10.9;
        int i = 1234;
        int q = 4;
        
        item obj = new item(c,p,i,q);
        
        String c2 = "TV";
        double p2 = 15.4;
        int i2 = 4413;
        int q2 = 7;
        
        obj.setQuantity(q2);


      assertEquals("get altered quantity",q2,obj.getQuantity());
    }
}
