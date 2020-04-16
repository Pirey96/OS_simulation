public class Process implements Runnable {
String processName;
int duration;
int startTime;
boolean suspend=false;
boolean terminate = false;
Thread thread = new Thread(this);
Page page;

synchronized void Start() {
	thread.start();
}
synchronized void Suspend() {

	suspend = true;
}
synchronized void Resume() {

	suspend =false;
	notify();
}
synchronized void Terminate() {
	System.out.println("Clock: "+ClassMain.clock+": Process "+Thread.currentThread().getName()+":  Finished ");

	terminate = true;
	
}
	
void instructionDecoder(String string) {
	try {
	String [] splitter = string.split(" +", 3);
	String variableId = splitter[1];
	int value = Integer.parseInt(splitter[2]);
	VMM.memStore(variableId, value);
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
	
	 
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
		
			while (terminate == false) {
		Thread.currentThread().setName(processName);
		if(suspend==false){
			System.out.println("Clock: "+ClassMain.clock+": Process "+Thread.currentThread().getName()+":  Resumed ");
			instructionDecoder(Instructions.getInstruction());

		}
		if(suspend == true) {
			System.out.println("Clock: "+ClassMain.clock+"Process "+Thread.currentThread().getName()+":  Paused ");

		}
		if(duration == 0) {
			Terminate();
			ClassMain.schedule.remove(Integer.parseInt(processName));
		}else {
			duration = duration - 1000;

		}
			}
		synchronized (this) {
			if(suspend == true) {
				wait();
			}
		}
		
			
		
		}catch(Exception e) {
			
		}
	}
	
}
