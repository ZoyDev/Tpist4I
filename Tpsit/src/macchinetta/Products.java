package macchinetta;

public class Products {
	
	String name;
	int id;
	double price;
	int quantity;
	
	public Products(String x, double c, int i,int s) {
		name=x;
		price=c;
		quantity=i;
		id=s;
	}
	
	@Override
	public String toString() {
		return name+"|"+price+"|"+quantity+"|"+id;
	}
}
