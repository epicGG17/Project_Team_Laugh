import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class main {
	static item arr = new item();
	static file File = file.getInstance();
	
	public static void main(String[] args) throws IOException {
		//creates linked list
		
		File.scanFile(arr);
		
		//test write file
		File.writeFile(arr);
		InventoryGUI.Start(arr);
		
		//as
		//askSave(arr);
		
	}
	
	// asks if the user wants to save the file 
	static void askSave(item arr) throws IOException {
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Enter yes/YES to save");
		String s = myObj.nextLine().toUpperCase();  // Read user input
		
		switch(s) {
		  case "YES":
			File.writeFile(arr);
			  file.saveFile(arr);
			  System.out.println("File was saved.");
		      break;
		  default:
			  System.out.println("File was not saved.");
		}
		
	}

}
