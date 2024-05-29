package veloxxx;

public class Automobilista {
	double money;
	int km;
	//Costruttore ritorna oggetto.
	public Automobilista(double x,int y) {
		money=x;
		km=y;
	}
	
	/**
	 * Pay
	 * @param d amout to pay
	 * @return remaning money
	 */
	public double pay(double d) {
		money=money-d;
		return money;
	}
	
	/**
	 * add money
	 * @param d amout to add
	 * @return void 
	 */
	public void addMoney(int q) {
		money=money+q;
	}
}
