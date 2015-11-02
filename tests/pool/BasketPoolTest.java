package pool;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

import pool.resource.Basket;

public class BasketPoolTest extends ResourcePoolTest<Basket>{

	@Test
	public void testBasketPool() {
		BasketPool basketPool = new BasketPool(0);
		assertNotNull(basketPool);
	}

	@Test
	public void testCreateResource() {
		BasketPool basketPool = new BasketPool(0);
		assertSame(basketPool.createResource(), new Basket());
	}

	@Test
	public void testProvideResource() {
		fail("Not yet implemented");
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testProvideResourceNotAvailablegit () {
		BasketPool basketPool = new BasketPool(0);
		basketPool.containsAsAvailableResources(new Basket());
		
	}

	@Test
	public void testFreeResource() {
		fail("Not yet implemented");
	}

	@Test
	public void testContainsAsAvailableResources() {
		fail("Not yet implemented");
	}

	@Test
	public void testContainsAsGivenResources() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateResource1() {
		fail("Not yet implemented");
	}

}
