package pool;

import static org.junit.Assert.*;

import org.junit.Test;

import pool.resource.Basket;

public class BasketPoolTest extends ResourcePoolTest<Basket> {

	@Test
	public void testCreateResource() {
		BasketPool basketPool = new BasketPool(0);
		Basket basket = new Basket();
		assertTrue(basket.equals(basketPool.createResource()));

	}

	@Override
	public ResourcePool<Basket> createResourcePool(int nb) {
		return new BasketPool(nb);
	}
}
