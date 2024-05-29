package veloxxx;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AutomobilistaTest {
	Automobilista a= new Automobilista(200.00,120);
	@Test
	void test() {
		assertEquals(100,a.pay(100));
	}

}
