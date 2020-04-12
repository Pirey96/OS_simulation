
public class CPU implements Runnable{
	static boolean semaphore0 = true;
	static boolean semaphore1 = true;
	 
	  
	CPU(Page p,String instruction){
		Core0 c0 = new Core0();
		Core1 c1= new Core1(); 
		if (semaphore0==true) {
			semaphore0=false;
			//new Core0(p,instruction);
			c0.Start(p,instruction);
			c0.start();
			try {
				c0.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			semaphore0=true;
		}else if (semaphore1==true) {
			semaphore1=false;
			c1.Start(p, instruction);
			c1.start();
			try {
				c1.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			semaphore1=true;
			
		}
		
		
		
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}


class Core0 extends Thread{
	static String instruction;
	static Page page;
	void Start(Page p,String inst){
		page =p;
		instruction = inst;
		


	}
	
	@Override
	public void run() {
		if(instruction.equals("Store")) {
		System.out.println(""+"Store: Variable  "+page.variableId+", "+"Value: "+page.value);
			}
		else if (instruction.equals("Lookup")) {
		System.out.println(""+"Lookup: Variable  "+page.variableId+", "+"Value: "+page.value);
		}else if (instruction.equals("Release")) {
			System.out.println(""+"Release: Variable  "+page.variableId);
		}
	
	}
}
class Core1 extends Thread{
	static String instruction;
	static Page page;
	void Start(Page p,String inst){
		page =p;
		instruction = inst;
		


	}
	
	@Override
	public void run() {
		
		
			if(instruction=="Store") {
		System.out.println("(Core 1) "+"Store: Variable  "+page.variableId+", "+"Value: "+page.value);
			}
		
	
	}
}