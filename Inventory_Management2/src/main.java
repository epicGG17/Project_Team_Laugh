import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

@SuppressWarnings("unused")
public class main {
	
	public static void main(String[] args) throws IOException {
		//creates linked list
		item arr = new item();
		file.scanFile(arr);
		/*
		//test write file
	    arr.addItem("Console", "Xbox-One", 499.99, 9, 22);
		arr.addItem("Console", "Wii", 149.99, 9, 22);
		file.writeFile(arr);
		askSave(arr);
		*/
		InventoryGUI.Start(arr);
		
	}
	
	/*
	// asks if the user wants to save the file 
	static void askSave(item arr) throws IOException {
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Enter yes/YES to save");
		String s = myObj.nextLine().toUpperCase();  // Read user input
		
		switch(s) {
		  case "YES":
			file.writeFile(arr);
			  file.saveFile(arr);
			  System.out.println("File was saved.");
		      break;
		  default:
			  System.out.println("File was not saved.");
		}
		
	}
	*/

}
