public class VMM {
	static int pagereplace;
	static boolean flag ;

 	@SuppressWarnings("unused")
	static void memStore (String variableId,int value) {
			int freePage=0;
 			for(int i = 0;i<Mainmemory.mainMemory.length;i++) {
				
 				 for (int j = 0;j<Mainmemory.mainMemory.length;j++) {
 					 if (Mainmemory.mainMemory[j]==null) {
 						 flag = true;
 						 freePage = j;
 					 }
 				 }
				if(flag==true ) {
					Page page= new Page()  ;
				    page.variableId =variableId;
					page.value=value;
					Mainmemory.mainMemory[freePage]=page;
						System.out.println("Clock: "+ClassMain.clock+": Process "+Thread.currentThread().getName()+": Store: Variable  "+variableId+", "+"Value: "+value);
						flag = false;
					break;
 					}else {
 						Page page= new Page();
 					 	Mainmemory.mainMemory[i]=null;
 					 	page.variableId =variableId;
 						page.value=value;
 						Mainmemory.mainMemory[i]=page;
 						System.out.println("Clock: "+ClassMain.clock+": Process "+Thread.currentThread().getName()+": Store: Variable  "+variableId+", "+"Value: "+value);
 					 	System.out.println("Memory Manager, SWAP: Variable "+variableId+" with"+" Variable "+"1");

 						break;
 						
 					}
					
			}	
			
	}
	
	static void memFree(String variableId) {
		for(int i = 0;i<Mainmemory.mainMemory.length;i++) {
			try {
			if(Mainmemory.mainMemory[i].variableId.equals(variableId)) {
				System.out.println("Clock: "+ClassMain.clock+": Process "+Thread.currentThread().getName()+": Release: Variable  "+variableId);
				Mainmemory.mainMemory[i]=null;
			}}catch(Exception e) {
				//System.out.println("MISS");
			}
 				
			
		}
	
			
			 
		}
	static void memLookup(String variableId) {
		try {
			for(int i = 0;i<Mainmemory.mainMemory.length;i++) {
				if(Mainmemory.mainMemory[i].variableId.equals(variableId)) {
					System.out.println("Clock: "+ClassMain.clock+": Process "+Thread.currentThread().getName()+": Lookup: Variable  "+variableId+", "+"Value: ");
			}
			}	
			}catch(Exception e) {
			//	System.out.println("MISS");

			}
			}

	
	
	}
	
	
	