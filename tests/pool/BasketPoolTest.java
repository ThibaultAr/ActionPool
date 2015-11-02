package pool;

import static org.junit.Assert.*;

import org.junit.Test;

import pool.resource.Basket;

public class BasketPoolTest extends ResourcePoolTest<Basket>{

	@Test
	public void createResourceTest() {
		BasketPool basketPool = new BasketPool(0);
		assertSame(basketPool.createResource(), new Basket());
		
	}

}
