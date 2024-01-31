package it.edu.iisgubbio.esercizio;

public class Operazioni {
	int numero1,numero2;
	/**
	 * Assign the firts and second number
	 * @param x First Number, y Second Number
	 * @return Void
	 */
	public Operazioni(int x, int y) {
		numero1=x;
		numero2=y;
	}
	/**
	 * Sum the two numbers
	 * @param None
	 * @return sum
	 */
	public int Somma() {
		return numero1+numero2;
	}
	/**
	 * Moltiplicate the two numbers
	 * @param None
	 * @return Moltiplicate
	 */
	public int Prodotto() {
		return numero1*numero2;
	}
	public static void main(String[] args) {
		Operazioni op=new Operazioni(3,4);
		op.Somma();
		op.Prodotto();
	}
}
