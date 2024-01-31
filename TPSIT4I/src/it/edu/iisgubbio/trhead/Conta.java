package it.edu.iisgubbio.trhead;

/**
 * Lanciare due thread uno che scrive 
 * i numeri da 1 a 10 e l'altro che scrive i numeri da 50 a 100
 * 
 * Dato che abbiamo realizzato un'unica classe che implementa il thread , per distinguere
 * i due thread occore passarea al costruttore una variabile di selezione
 * 
 * In questa versione non abbiamo implementato uno scheduler , i thread  partono con un ordine impartito dalla virtual machine e stampano tutti i numeri prima di passare al secondo thread
 */

public class Conta extends Thread{
	int typeThread;
	public static void main(String[] args) {
		
		Conta t= new Conta(0);
		t.start();
		Conta t1= new Conta(1);
		t1.start();
	}
	
	public Conta(int type) {
		typeThread=type;
	}
	public void stopRunning(int x) {
		if(x==5) {
			stop();
		}
	}
	public void run() {
		try {
			sleep(500);
		}catch (InterruptedException e) {
			System.out.println("ERRORE");		
		}
		if(typeThread==0) {
		for(int i=0;i<10;i++) {
			System.out.println(i);
			this.stopRunning(i);
		}

		}else {
			for(int i=50;i<=100;i++) {
				System.out.println(i);
			}
		}
	}
	
}
