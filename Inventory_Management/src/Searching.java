
public class Searching {
//search by item by name or id
	
		
	public static boolean searchItem(node n, String i)
	{
		//check it the string is empty
		if(i == null || i == null)
				return false;
		//check if the string is searching by id or name of the item
		//check if the string is number
		node temp = n; 
		if( containNumbers(i))
		{
			int id = Integer.parseInt(i); 
			 // looking for the item by id
			while(temp != null)
			{
				if(temp.getID() == id)
				{
					System.out.println("ID has been found");
					System.out.print("Category: " + temp.getCategory() + ", ");
					System.out.print("Name: " + temp.getName() + ", ");
					System.out.print("Price: " + temp.getPrice() + ", ");
					System.out.print("ID: " + temp.getID() + ", ");
					System.out.print("Quantity: " + temp.getQuantity() + "\n");
					return true;
				}
				temp = temp.getLink();
			}
		}
		else
		{
			//looking for the item by name
			while(temp != null)
			{
				if( temp.getName() == i)
				{
					System.out.println("Name has been has been found");
					System.out.print("Category: " + temp.getCategory() + ", ");
					System.out.print("Name: " + temp.getName() + ", ");
					System.out.print("Price: " + temp.getPrice() + ", ");
					System.out.print("ID: " + temp.getID() + ", ");
					System.out.print("Quantity: " + temp.getQuantity() + "\n");
					return true;
				}
				temp = temp.getLink();	
			}
		}
			System.out.println("Item has not been found");
			System.out.println("Please Try again");
			return false;
	}
		//returns true if the string has numbers
	public static boolean containNumbers(String s)
	{
		for(int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			if(  !(Character.isDigit(c)) )
			{
				return false;
			}
		}
		return true;
	}
//search by category
	public static boolean searchThruCat(node n, String cat)
	{
		//checks if the node is empty
		if(cat == null || cat == null)
			return false;
		node temp = n; 
		System.out.println("Catogory ");
		//em check if items can be found under that cat.
		boolean em = false;
		while(temp != null)
		{
			if( temp.getCategory() == cat)
			{
				//will only print once the cat if found.
				if(em == false)
				{
					System.out.println("List of item in that Catorgry: " + cat);
					em = true;
				}
				System.out.print("Name: " + temp.getName() + ", ");
				System.out.print("Price: " + temp.getPrice() + ", ");
				System.out.print("ID: " + temp.getID() + ", ");
				System.out.print("Quantity: " + temp.getQuantity() + "\n");
					
			}
				temp = temp.getLink();
		}
		//if item cannot be found under that catergry
		if(em == false)
		{
			System.out.println("Sorry no item is found unber that catorgry");
			return false;
		}
		return true;
			
	}
}
