package it.edu.iisgubbio.newTrhead;

/*
 * dato un arry di 5 numeri tra 1 e 10, il tread stampa il vettore solo se il numero del ciclo è tra i numeri che passa
 */
public class CustomTrhead extends Thread{

	public void run(int x[]) {
		for(int i=0;i<x.length;i++){
			for(int c=0;c<11;c++){
			if(x[i]==c) {
				System.out.print(x[i]+" ");
			}
		}
			}
		try {
			sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" ");
	}
}
