import java.io.*;
 public class ClassMain   {
		static int clock = 0;


	public static void main (String [] args) {
		Read.readProcess();
		Instructions.readInstructions() ;
		mainMemory();
		
		for (int i =0;i<Read.readyQueue.length;i++) {
		Disk.Store(Read.readyQueue[i].processName,Read.readyQueue[i].duration);
		}
		
		CPUscheduler scheduler = new CPUscheduler(Read.readyQueue);
		//scheduler.printReadyQueue();
		
		while (scheduler.processReadyQueue.size()!=0) {
		//scheduler.printReadyQueue();
		//scheduler.executeProcess();
			clock=clock+500;
		scheduler.nextProcessToExecute();
		  
		
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
					process.processName = "Process "+ ++count;
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
	
	
