package veloxxx;

public class Polizzioto {
	
	int limite;
	double priceKmh;
	
	/**
	 * Set the value of limite and pirceKmh 
	 * @param x speed limit, y price for Kmh
	 * @return Void
	 */
	public Polizzioto(int x,double y) {
		limite=x;
		priceKmh=y;
	}
	
	/**
	 * Check if he need to pay and in case check if is payable
	 * @param km kilomenters, 
	 * @param money amount of money 
	 * @return if is payable: boolean
	 */
	public boolean isPayable(int km,double money) {
		if(km>=limite) {
			return money>=(km-limite)*priceKmh; 
		}else {
			return false;
		}
	}
	
	/**
	 * Count the price of the fine 
	 * @param km kilomenters
	 * @return amout of fine
	 */
	public double countPrice(int km) {
		return (km-limite)*priceKmh;
	}
	
	/**
	 * Set the limit
	 * @param limite 
	 * @return void
	 */
	public void setLimite(int limite) {
		this.limite = limite;
	}
	
	/**
	 * Set the price for kmh
	 * @param priceKmh 
	 * @return void
	 */
	public void setPriceKmh(double priceKmh) {
		this.priceKmh = priceKmh;
	}
	
}
