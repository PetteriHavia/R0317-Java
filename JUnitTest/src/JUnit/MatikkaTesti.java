package JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MatikkaTesti {

	@Test
	void test() {
		assertEquals(5, Matikkaa.summa(3,2));
	}
	
	@Test
	void potenssi() {
		assertEquals(16, Matikkaa.potenssi(4,2));
	}
	
	@Test
	void pintaAla() {
		assertEquals(8, Matikkaa.pintaAla(4,2));
	}
	
	@Test
	void pintaAlaNegatiivinen() {
		assertEquals(0, Matikkaa.pintaAla(-4,2));
	}
}
