package veloxxx;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PolizziotoTest {

	Polizzioto x=new Polizzioto(100,10.0);

	
	@Test
	void test() {
		assertEquals(true,x.isPayable(120, 400));
		assertEquals(200,x.countPrice(120));
	}

}
