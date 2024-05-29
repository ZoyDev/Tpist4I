package classi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuadratoTets {
	Quadrato quadrato=new Quadrato(2);
	@Test
	void test() {
		assertEquals(4, quadrato.calcolaArea(),"");
		assertEquals(8, quadrato.calcolaPerimetro(),"");
	}
	

}
