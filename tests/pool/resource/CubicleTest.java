package pool.resource;

import static org.junit.Assert.*;

import org.junit.Test;

public class CubicleTest implements ResourceTest {

	@Test
	public void getDescriptionTest() {
		Cubicle cubicle = new Cubicle();
		assertEquals(cubicle.getDescription(), "Cubicle");
	}

}
