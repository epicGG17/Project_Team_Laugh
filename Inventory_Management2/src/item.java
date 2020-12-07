//linked list, with methods to interact with the nodes
import java.util.Iterator;
public class item implements Iterable<node>{	
	
	//attributes
	private node first;
	private node last;
	private int size;
	
	//Constructors
	public item() {
		first = null;
		last = first;
	}
	
	//check if empty
	public boolean isEmpty() {
		if(first == null)
			return true;
		else
			return false;
	}
	
	//get first node
	public node getFirst() {
		return first;
	}
	
	//get last
	public node getLast() {
		return last;
	}
	
	//get number total number of different items in list
	public int getSize() {
		return size;
	}
	
	//add a new item in linked list
	public void addItem(String s, String n,double b,int i, int q) {
		if(isEmpty()) {
			first = new node(s,n,b,i,q);
			last = first;
			size++;
		}
		else {
			node add = new node(s,n,b,i,q);
			last.setLink(add);
			last = last.getLink();
			size++;
		}
	}
	
	public void addItem(node n) {
		if(isEmpty()) {
			first = n;
			last = first;
			size++;
		}
		else {
			node add = n;
			last.setLink(add);
			last = last.getLink();
			size++;
		}
	}
	
	
    public void delete(int idNum) 
    { 
        // Store head node 
        node temp = first, prev = null; 
  
        // If head node itself holds the key to be deleted 
        if (temp != null && temp.getID() == idNum) 
        { 
            first = temp.getLink(); // Changed head 
            size--;
            return; 
        } 
  
        // Search for the key to be deleted, keep track of the 
        // previous node as we need to change temp.next 
        while (temp != null && temp.getID() != idNum) 
        { 
            prev = temp; 
            temp = temp.getLink(); 
        }     
  
        // If key was not present in linked list 
        if (temp == null) return;
        
  
        // Unlink the node from linked list 
        prev.setLink(temp.getLink());
        if (temp == last)
        	last = prev;
        size--;
    } 
    
    public void change(node a, int idNum) 
    {  
        node temp = first, prev = null; 
        if (temp != null && temp.getID() == idNum) 
        { 
            first = a; // Changed head 
            return; 
        } 
        while (temp != null && temp.getID() != idNum) 
        { 
            prev = temp; 
            temp = temp.getLink(); 
        }     
        if (temp == null) return;
        a.setLink(temp.getLink());
        prev.setLink(a);
    } 
	
	public boolean searchIf(int x) 
    { 
        node current = first;    //Initialize current 
        while (current != null) 
        { 
            if (current.getID() == x) 
                return true;    //data found 
            current = current.getLink(); 
        } 
        return false;    //data not found 
    } 
	
	//Iterator implementation of search
	public node search(int x) 
    { 
        Iterator<node> test = this.iterator();
        while (test.hasNext()) 
        {
        	node current = test.next();
            if (current.getID() == x) 
                return current;    //data found 
        } 
        return null;    //data not found 
    } 
	
	//Iterator class
	@Override
	public Iterator<node> iterator() {
		return new itemIterator(this);
	}

}
