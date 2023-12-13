package it.edu.iisgubbio.priorità;


public class Prova {
	   public static void main(String[] args) {

		Priorità scheduler= new Priorità(4);	
		scheduler.add("0",8,1);
		scheduler.add("1",3,2);
		scheduler.add("2",8,1);
		scheduler.add("3",6,3);
		System.out.println("Il valore medio del tempo di attesa è: "+scheduler.ordina());
	}

	
}