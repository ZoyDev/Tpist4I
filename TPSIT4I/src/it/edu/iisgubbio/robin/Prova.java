package it.edu.iisgubbio.robin;


public class Prova {
	   public static void main(String[] args) {
			RoundRobin scheduler= new RoundRobin(4,3);
		    scheduler.add("0",5);
			scheduler.add("1",3);
			scheduler.add("2",8);
			scheduler.add("3",6);
			System.out.println("Il valore medio del tempo di attesa è: "+scheduler.ordina());			
	   } 
}
