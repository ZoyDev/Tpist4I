package it.edu.iisgubbio.semaporo;

import java.util.concurrent.Semaphore;



public class WorkerThread extends Thread{

	
	Semaphore sem;
	RisorsaCondivisa ris;
	
	public WorkerThread(Semaphore semaforo,RisorsaCondivisa x,String threadName) {
		super(threadName);
		sem=semaforo;
		ris=x;
	}
	
	@Override
	public void run() {
		if(this.getName().equals("P")) {
			System.out.println("Oh Bona,sono il produttore");
			try {
				System.out.println("Ciao sono sempre io il produttore , sto aspettando il permesso di scrivere");
				sem.acquire();
				System.out.println("Permesso accordato!");
				for(int i=0;i<5;i++) {
					ris.count++;
					System.out.println(getName()+":"+ris.count);
					Thread.sleep(10);
				}
			}catch(InterruptedException exc) {
				System.out.println(exc);
			}
			System.out.println("Riliasciato!");
			sem.release();
		}else {
			System.out.println("Oh Bona,sono il consumatore");
			try {
				System.out.println("Ciao sono sempre io il consumatore , sto aspettando il permesso di scrivere");
				sem.acquire();
				System.out.println("Permesso accordato!");
				for(int i=0;i<5;i++) {
					ris.count--;
					System.out.println(getName()+":"+ris.count);
					Thread.sleep(10);
				}
			}catch(InterruptedException exc) {
				System.out.println(exc);
			}
			System.out.println("Riliasciato!");
			sem.release();

		}
	}
}
