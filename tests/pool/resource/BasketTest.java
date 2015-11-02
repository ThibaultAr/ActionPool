package pool.resource;

import static org.junit.Assert.*;

import org.junit.Test;

public class BasketTest implements ResourceTest {

	@Test
	public void getDescriptionTest() {
		Basket basket = new Basket();
		assertEquals(basket.getDescription(), "Basket");
	}

}
