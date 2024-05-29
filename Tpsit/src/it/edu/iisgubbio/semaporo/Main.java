package it.edu.iisgubbio.semaporo;

import java.util.concurrent.Semaphore;

public class Main {

	
	public static void main(String[] args) throws InterruptedException {
		Semaphore sam = new Semaphore(1);
		RisorsaCondivisa ris= new RisorsaCondivisa();
		WorkerThread c=new WorkerThread(sam,ris,"C");
		WorkerThread p=new WorkerThread(sam,ris,"P");
		
		c.start();
		p.start();
		
		c.join();
		p.join();
		
		System.out.println("v "+ris.count);

	}	
}
