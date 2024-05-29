package veloxxx;

public class Main {

	public static void main(String[] args) {
		Polizzioto x=new Polizzioto(100,10.0);
		Automobilista a= new Automobilista(200.00,120);
		if(x.isPayable(a.km, a.money)) {
			a.pay(x.countPrice(120));
		}
		a.addMoney(120);

	}
}
