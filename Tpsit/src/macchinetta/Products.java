package macchinetta;

public class Products {
	
	String name;
	double price;
	int quantity;
	
	public Products(String x, double c, int i) {
		name=x;
		price=c;
		quantity=i;

	}
	
	@Override
	public String toString() {
		return name+"|"+price+"|"+quantity;
	}
}
