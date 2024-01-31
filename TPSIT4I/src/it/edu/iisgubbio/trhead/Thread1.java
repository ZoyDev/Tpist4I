package it.edu.iisgubbio.trhead;

public class Thread1 extends Thread{
	
	public void stopRunning(int x) {
		if(x==5) {
			this.stop();		
		}
	}
	public void run() {
		try {
			sleep(500);
		}catch (InterruptedException e) {
			System.out.println("ERRORE");		
		}
		for(int i=0;i<10;i++) {
			System.out.println(i);
			stopRunning(i);
		}

	
	}
}
