import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class file {

	//scans the file and inserts items into linked list
	public static void scanFile(item arritem) throws FileNotFoundException {
		
		// sets file to the input file,  then scans the file with scanfile
		File file = new File("fullinv.txt");
		Scanner scanFile = new Scanner(file);
		
		// while there is still content on the line
		while (scanFile.hasNext()) {
			
			// creates a node and adds it to the linked list
			node node = new node( scanFile.next(), scanFile.next(), 
					scanFile.nextDouble(), scanFile.nextInt(), scanFile.nextInt() );
			arritem.addItem(node);
		}
		
	}
	
	//writes to a different file so the original isn't overwritten
	public static void writeFile(item arritem) throws IOException {
		

		File file = new File("fullinvW.txt");
		FileWriter fw = new FileWriter(file);
		PrintWriter pw = new PrintWriter(fw);
		
		node temp = arritem.getFirst();
		
		while(temp!= null) {
				pw.print(temp.getCategory() + " ");
				pw.print(temp.getName() + " ");
				pw.print(temp.getPrice() + " ");
				pw.print(temp.getID() + " ");
				pw.print(temp.getQuantity() + "\n");
				
				temp = temp.getLink();
				
		}
		
		pw.close();
	}
	
	
	// overwrites the original file with the new content
	public static void saveFile(item arritem) throws IOException {
		File file = new File("fullinv.txt");
		FileWriter fw = new FileWriter(file);
		PrintWriter pw = new PrintWriter(fw);
		
		node temp = arritem.getFirst();
		
		// writes to the new file
		while(temp!= null) {
				pw.print(temp.getCategory() + " ");
				pw.print(temp.getName() + " ");
				pw.print(temp.getPrice() + " ");
				pw.print(temp.getID() + " ");
				pw.print(temp.getQuantity() + "\n");
				
				temp = temp.getLink();
				
		}
		
//closes the file so the work is saved
		pw.close();
	}
	
		


}
