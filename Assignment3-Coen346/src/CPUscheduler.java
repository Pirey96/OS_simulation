import java.util.*;
public class CPUscheduler{
	
	static List <Process> processReadyQueue = new LinkedList<Process>();
	static int count = 1;
	 static int clock = 1000;
	 static boolean pth = false;
	 CPUscheduler(Process [] arr) {
		 
		 
			for (Process process:arr) {
				processReadyQueue.add(process);
				
				
				
			}
			
			

		}
////////////////////////////////////////////////////////   CPU    //////////////////////////////////////////////////////////////////////
	void executeProcess(Process process) {
		if(CPU.semaphore0==true) {
			System.out.print (process.processName+": ");

		instructionDecoder(Instructions.getInstruction());
		}if (CPU.semaphore1) {
			System.out.print (process.processName+": ");

			instructionDecoder(Instructions.getInstruction());
		}if (CPU.semaphore0==true||CPU.semaphore1==true) {
		process.duration = process.duration-1000;
		}
			
		}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	void instructionDecoder(String string) {
		try {
		String [] splitter = string.split(" +", 3);
		//String instruction = splitter[0];
		//if(splitter[0].equals("Store")) {
			
		String variableId = splitter[1];
		int value = Integer.parseInt(splitter[2]);
		
		VMM.memStore(variableId, value);
		//}
		}catch (Exception e) {
			String [] splitter2 = string.split(" +", 2);
			 
 			if(splitter2[0].equals("Lookup")) {
				String variableId = splitter2[1];
				VMM.memLookup(variableId);
 			 
			}  
				if(splitter2[0].equals("Release")){
					VMM.memFree(splitter2[1]);
				 
			}
			}
		
	}
	 void release(String string) {
		 
		 
	 }
	
	void nextProcessToExecute() {
		
			Process process = processReadyQueue.get(0);
		if (process.duration == 0) {
			processReadyQueue.remove(0);
			
		}
		
		
		for (int i=0;i<processReadyQueue.size();i++) {
			
			
 			if (processReadyQueue.get(i).duration==0) {
				processReadyQueue.remove(i);
			}
		if (processReadyQueue.get(i).startTime < ClassMain.clock/1000){
			processReadyQueue.get(i).timeStamp=ClassMain.clock;
			executeProcess(processReadyQueue.get(i));
 			
		}
		}
	}
	
	
	void printReadyQueue() {
		for (int i = 0;i <processReadyQueue.size();i++) {
			System.out.println("Clock:"+clock+" "+processReadyQueue.get(i).processName);
		}
	}
	
class thread extends Thread{
	
	
	@Override
	public void run() {
		
	}
}
	

}


