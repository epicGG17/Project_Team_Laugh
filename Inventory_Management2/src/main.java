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
		InventoryGUI.Start(arr);	
	}
}
