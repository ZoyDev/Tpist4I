package it.edu.iisgubbio.trhead;

/**
 * Un thread in java può essere realizzato in vari modi:
 * 1)Faccio una classe che estende la classe nativa di Java Thread che ha due metodi principali:	
 * 		Start():Fa partire il thread
 * 		Run(): Contiene i Codice che deve essere eseguito dal thread	
 * 
 * 
 */
public class HelloThreads extends Thread{
	
	
	public static void main(String[] args) {
		
		HelloThreads t= new HelloThreads();
		t.start();
	} 
	
	public void run() {
		System.out.println("Hello from a thread");
	}
	
}
