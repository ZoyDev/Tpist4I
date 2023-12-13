package it.edu.iisgubbio.esercizio;

public class Operazioni {
	int numero1,numero2;
	public Operazioni(int x, int y) {
		numero1=x;
		numero2=y;
	}
	public int Somma() {
		return numero1+numero2;
	}
	public int Prodotto() {
		return numero1*numero2;
	}
	public static void main(String[] args) {
		Operazioni op=new Operazioni(3,4);
		op.Somma();
		op.Prodotto();
	}
}
