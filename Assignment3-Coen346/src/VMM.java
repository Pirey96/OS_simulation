
public class VMM {
	static int pagereplace;
	static void memStore (String variableId,int value) {
 			for(int i = 0;i<Mainmemory.mainMemory.length;i++) {
				// mainMemory[i].timeStamp;
				if(Mainmemory.mainMemory[i]==null ) {
					Page page= new Page()  ;
				    page.variableId =variableId;
					page.value=value;
					Mainmemory.mainMemory[i]=page;
					new CPU (Mainmemory.mainMemory[i],"Store");
					break;
 					}else {
 						Page page= new Page();
 					 	Mainmemory.mainMemory[i]=null;
 					 	page.variableId =variableId;
 						page.value=value;
 						Mainmemory.mainMemory[i]=page;
 						new CPU (Mainmemory.mainMemory[i],"Store");
 						break;
 						
 					}
					
			}	
			
	}
	
	static void memFree(String variableId) {
		for(int i = 0;i<Mainmemory.mainMemory.length;i++) {
			try {
			if(Mainmemory.mainMemory[i].variableId.equals(variableId)) {
				new CPU(Mainmemory.mainMemory[i],"Release");
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
				new CPU (Mainmemory.mainMemory[i],"Lookup");
			}
			}	
			}catch(Exception e) {
			//	System.out.println("MISS");

			}
			}

	
	
	}
	
	
	
	


