package classi;

public class TriangoloRettangolo {
	double base,altezza;
	
	public TriangoloRettangolo(int x,int y) {
		base=x;
		altezza=y;
	}
	public double calcolaArea (){
		return (base*altezza)/2;
	}
	// viva il debe imperatore <3
	
	public double calcolaPerimetro() {
		return base+altezza+Ipotenusa();
	}
	public double Ipotenusa() {
		return Math.sqrt((base*base)+(altezza*altezza));
	}

	
}
