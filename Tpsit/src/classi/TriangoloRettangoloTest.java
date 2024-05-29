package classi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TriangoloRettangoloTest{

	
	TriangoloRettangolo ret= new TriangoloRettangolo(1,1);
	
	@Test
	void testArea() {
		assertEquals(0.5, ret.calcolaArea(),"");

	}
	@Test
	void testPerimetro() {
		assertEquals(3.4142135623730951, ret.calcolaPerimetro(),"");

	}
	
	@Test
	void testIpo() {
		assertEquals(1.4142135623730951, ret.Ipotenusa(),"");
	}

	
	

}