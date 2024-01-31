package it.edu.iisgubbio.newTrhead;

public class Main {
	public static void main(String[] args) {
		int x[]= new int [5];
		int y[]= new int [5];
		for(int i=0;i<x.length;i++) {
			x[i]=(int) (Math.random()*10+1);
			y[i]=(int) (Math.random()*10+1);
		}
		
		CustomTrhead c1=new CustomTrhead();
		c1.run(x);
		CustomTrhead c2=new CustomTrhead();
		c2.run(y);
	}
}
