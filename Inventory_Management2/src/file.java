import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class file {
	
	private static file instance = new file();
	private static File fileview = new File("fullinv.txt");
	private static File wfile = new File("fullinvW.txt");
	
	private file() {
	}
	
	public static file getInstance() {
		return instance;
	}

	//scans the file and inserts items into linked list
	public void scanFile(item arritem) throws FileNotFoundException {
		
		// sets file to the input file,  then scans the file with scanfile
		//File file = new File("fullinv.txt");
		Scanner scanFile = new Scanner(fileview);
		
		// while there is still content on the line
		while (scanFile.hasNext()) {
			
			// creates a node and adds it to the linked list
			node node = new node( scanFile.next(), scanFile.next(), 
					scanFile.nextDouble(), scanFile.nextInt(), scanFile.nextInt() );
			arritem.addItem(node);
		}
		
		scanFile.close();
		
	}
	
	
	// overwrites the original file with the new content
	public static void saveFile(item arritem) throws IOException {
		//File file = new File("fullinv.txt");
		FileWriter fw = new FileWriter(fileview);
		PrintWriter pw = new PrintWriter(fw);
		
		node temp = arritem.getFirst();
		
		// writes to the new file
		while(temp!= null) {
			syntax(pw, temp);
			temp = temp.getLink();
		}
		
		//closes the file so the work is saved
		pw.close();
	}
	
	
	public static void syntax(PrintWriter pw, node temp) {
		pw.print(temp.getCategory() + " ");
		pw.print(temp.getName() + " ");
		pw.print(temp.getPrice() + " ");
		pw.print(temp.getID() + " ");
		pw.print(temp.getQuantity() + "\n");
		
	}
		
	//

}
