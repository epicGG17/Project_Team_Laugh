import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class wFile {

	public static void saveFile(item[] obj, int total) throws IOException {
		
		//overwrites the existing file adding the updated items
		// should be done after reading the file
	
		File file = new File("fullinv.txt");
		FileWriter fw = new FileWriter(file);
		PrintWriter pw = new PrintWriter(fw);
		
		pw.println(total);
		for( int i = 0; i < total; i++) {
			
			pw.println(obj[i].name + " " + obj[i].id + " " +
					obj[i].quantity + " " + obj[i].price + " " +obj[i].category);
		}
		
		pw.close();
		
		
	}
}
