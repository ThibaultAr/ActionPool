package pool;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

import pool.resource.Basket;
import pool.resource.Resource;

public abstract class ResourcePoolTest<T extends Resource> {

	protected ResourcePool<Basket> resourcePool = (ResourcePool<Basket>) new BasketPool(0);
	protected ResourcePool<Basket> resourcePool1 = (ResourcePool<Basket>) new BasketPool(1);
	protected ResourcePool<Basket> resourcePool2 = (ResourcePool<Basket>) new BasketPool(1);
	protected ResourcePool<Basket> resourcePool3 = (ResourcePool<Basket>) new BasketPool(1);
	protected Basket resource = new Basket();

	@Test(expected = NoSuchElementException.class)
	public void provideResourceTestException() {
		resourcePool.provideResource();
	}

	@Test
	public void provideResourceTest() {
		assertSame(resourcePool1.provideResource(),
				resourcePool2.availableResources.remove(0));
		assertTrue(resourcePool1.givenResources
				.contains(resourcePool3.availableResources.remove(0)));
	}

	@Test(expected = IllegalArgumentException.class)
	public void freeResourceTestException() {
		resourcePool.freeResource(resource);
	}

	@Test
	public void freeResourceTest() {
		Basket resource1 = resourcePool1.givenResources.get(0);
		assertTrue(resourcePool1.givenResources.contains(resource1));
		assertFalse(resourcePool1.availableResources.contains(resource1));

		resourcePool1.freeResource(resource1);

		assertFalse(resourcePool1.givenResources.contains(resource1));
		assertTrue(resourcePool1.availableResources.contains(resource1));
	}
}
