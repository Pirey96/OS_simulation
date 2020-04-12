import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
public class Instructions {
	static File file = new File("C:\\Users\\pirey\\Desktop\\commands.txt"); //read a text file
	static int i=0;
	static int nextInstruction=0;
	static String[] Instruction=new String[10000000];
	
	
	
	
	static void readInstructions() {
		BufferedReader br = null;
		
		try {                                                           
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String st;
		try {
			while ((st = br.readLine()) != null) {
			Instruction [i++] = st;
			
			}
		}catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
	}
	static String getInstruction() {
		if(Instruction[nextInstruction+1]==null) {
			nextInstruction = 0;
		}
		//System.out.println(Instruction[nextInstruction++]);

		return Instruction[nextInstruction++];
		
	}
	
	

}
