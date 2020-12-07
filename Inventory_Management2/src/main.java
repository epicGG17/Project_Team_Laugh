import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

@SuppressWarnings("unused")
public class main {
	static item arr = new item();
	static file File = file.getInstance();
	
	public static void main(String[] args) throws IOException {
		//creates linked list

		item arr = new item();
		File.scanFile(arr);
		InventoryGUI.Start(arr);	
	
	}


}
