package it.edu.iisgubbio.treag;

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
	public void run() {
		if(typeThread==0) {
			System.out.println("Primo");

		}else {
			System.out.println("Secondo");
		}
	}
	
}
