package classi;

public class Quadrato {
	
	double lato;
	
	public Quadrato(int x) {
		lato=x;
	}
	
	public double calcolaArea (){
		return lato*lato;
	}
	
	public double calcolaPerimetro() {
		return lato*4;
	}
	public static void main(String[] args) {
		Quadrato x=new Quadrato(3);
		System.out.println(x.calcolaArea());
		System.out.println(x.calcolaPerimetro());
	}
}
	
