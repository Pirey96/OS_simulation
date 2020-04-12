import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

public class Disk {
	
	 public static void Store(String variableID,int value) {
	        try {
	            FileWriter writer = new FileWriter("C:\\Users\\pirey\\Desktop\\vm.txt");
	            writer.write(variableID+"   "+value);
	            writer.write("\r\n");   // write new line
	            //writer.write("Good Bye!");
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	 
	    }
	}
	
	
	

