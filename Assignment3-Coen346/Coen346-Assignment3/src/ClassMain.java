import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
 public class ClassMain   {
		static int clock = 0;
		static List  <Process> schedule = new LinkedList<Process>();
		static List  <Process> loadedSchedule = new LinkedList<Process>();

	public static void main (String [] args) throws InterruptedException {
		Read.readProcess();
		Instructions.readInstructions() ;
		mainMemory();
		for (Process process:Read.readyQueue) {
			schedule.add(process);
		}

		
			while(schedule.size()!=0) {
			clock = clock +1000;
			for(int i = 0;i<schedule.size();i++) {
			if(schedule.get(i).startTime==clock/1000) {
				System.out.println ("Clock  "+clock+": Process "+schedule.get(i).processName+":  Started");
				Process process = schedule.get(i);
				schedule.remove(i);
				loadedSchedule.add(process);
				process.Start();
				process.Resume();
				Thread.sleep(500);
				process.Suspend();
				executeLoadedProcess();
			}
			}
			}while(loadedSchedule.size()!=0) {
				executeLoadedProcess();
			
			}
		}
		
	
	
	
	static void executeLoadedProcess() {
		for(int i = 0;i<loadedSchedule.size();i++) {
			if(loadedSchedule.get(i).startTime==clock/1000) {
				
					loadedSchedule.get(i).Resume();
					loadedSchedule.get(i).Suspend();
					Process temp = loadedSchedule.get(i);
					loadedSchedule.remove(i);
					loadedSchedule.add(temp);
					if(loadedSchedule.size()!=0) {
						loadedSchedule.get(i).Resume();
						loadedSchedule.get(i).Suspend();


					}
				}
				}
			}
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static void mainMemory () {
		Mainmemory.mainMemory= new Page[Read.numberOfPages];
		for (int i =0;i<Read.numberOfPages;i++) {
			//System.out.println(Mainmemory.mainMemory[i]);
		}
	}
	
	
	
	
 
}









class Read {
	static Process [] readyQueue;
	static int numberOfPages;
	static void readProcess() {
		File file = new File("C:\\Users\\pirey\\Desktop\\processes.txt"); //read a text file
		BufferedReader br = null;
		try {                                                           
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String st;
		//Scheduler scheduler = new Scheduler();
		try {
			st = br.readLine();
			int numberOfProcesses = Integer.parseInt(st);
			//System.out.println(numberOfProcesses);
			readyQueue = new Process [numberOfProcesses];
			int count = 0;
			
			while ((st = br.readLine()) != null) {
				String [] splitter = st.split(" +", 2);
					int startTime = Integer.parseInt(splitter[0]);
					int duration = Integer.parseInt(splitter[1]);
					//System.out.println(arr[0]+ " "+ arr[1]);
					Process process = new Process();
					/////////////////////////////////////////////////////////////////////////////////////////////
					process.duration=duration*1000;
					process.startTime = startTime;
					process.processName = ""+ ++count;
					readyQueue[count-1]=process;
					//////////////////////////////////////////////////////////////////////
			}
			//a.printList(process);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		 mainMemorySize();
	}
	
	static void mainMemorySize() {
		File file = new File("C:\\Users\\pirey\\Desktop\\memconfig.txt"); //read a text file
		BufferedReader br = null;
		try {                                                           
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String st;
		//Scheduler scheduler = new Scheduler();
		try {
			st = br.readLine();
			numberOfPages = Integer.parseInt(st);
			//System.out.println(numberOfPages);
			
			//a.printList(process);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	
	
	}
}
	