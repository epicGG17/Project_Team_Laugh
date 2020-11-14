import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) throws IOException {
		// name id quantity price category
		
		int total;
		int arraySize;
		Scanner scanFile = rFile();

		
		// get the size from the file and create array with 50 more spaces
		total = scanFile.nextInt();
		arraySize = total + 50;
		item[] obj = new item[arraySize];
		
		// fill the array with the list provided
		scanInventory(obj, total);
		
		//test adding a new item;
		total = addItem(obj, total);
		
		
		//test the save file class;
		wFile.saveFile(obj, total);
		
		}
		
	


	public static void scanInventory(item[] obj, int total) throws FileNotFoundException {
			Scanner scanFile = rFile();
			//fills in the array with the items in fullin.txt
			scanFile.next();
			
			for (int i = 0; i < total; i++ ) {
				int num = i+ 1;
				obj[i]= new item(scanFile.next(), scanFile.nextInt(), scanFile.nextInt(), scanFile.nextDouble(), scanFile.next() );
				
				System.out.println("Item number"+num+": " );
				obj[i].showData();
				System.out.println();
			}
		}
		
		
	public static Scanner rFile() throws FileNotFoundException {
			//scans the file returns the scan
			File file = new File("fullinv.txt");
			Scanner scanFile = new Scanner(file);
			return scanFile;
		}
		
	
// adds an item to the end of the array 
//returns the total amount of items in array;
	public static int addItem(item[] obj, int total) {
		int newElem = total;
		int id = newElem +1;
		Double price = 499.99;
		String cat = "Console";
		int quantity = 2;
		
		obj[newElem] = new item("Sony", id, quantity,  price, cat);
		
		return id;
		
		
	}


	
}