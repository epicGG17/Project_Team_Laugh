//linked list, with methods to interact with the nodes
public class item {	
	
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
	
	//search an id number and delete an object with matching id num
	/*public void delete(int idNum) {
		boolean found = false;
		if(first.getID() == idNum) {
			first = null;
			found = true;
		}
		else {
			node trail = first;
			node temp = first.getLink();
			while(temp!=null) {
				if(temp.getID() == idNum) {
					trail.setLink(temp.getLink());
					temp = null;
					found = true;
					break;
				}
				else {
					temp = temp.getLink();
					trail = trail.getLink();
				}
			}
		}
		if(found) {
			System.out.println("Item with id number " + idNum + " has been deleted");
			size--;
		}
		else {
			System.out.println("Item with id number " + idNum + " not found");
		}
	}*/
	
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
	
	
	public node search(int x) 
    { 
        node current = first;    //Initialize current 
        while (current != null) 
        { 
            if (current.getID() == x) 
                return current;    //data found 
            current = current.getLink(); 
        } 
        return null;    //data not found 
    } 
	
	
	//print all info in each node of the list
	public void print() {
		node temp = first;
		System.out.println("Number of items in inventory: " + size);
		if(size == 0) {
			System.out.print("List is empty");
		}
		else {
			while(temp!= null) {
				System.out.print("Category: " + temp.getCategory() + ", ");
				System.out.print("Name: " + temp.getName() + ", ");
				System.out.print("Price: " + temp.getPrice() + ", ");
				System.out.print("ID: " + temp.getID() + ", ");
				System.out.print("Quantity: " + temp.getQuantity() + "\n");
				
				temp = temp.getLink();
			}		
		}		
	}
}
