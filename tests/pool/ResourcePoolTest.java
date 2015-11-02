package pool;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

import pool.resource.Resource;

public abstract class ResourcePoolTest<T extends Resource> {

	ResourcePool<T> resourcePool = createResourcePool(0);
	ResourcePool<T> resourcePool1 = createResourcePool(1);
	ResourcePool<T> resourcePool2 = createResourcePool(1);
	ResourcePool<T> resourcePool3 = createResourcePool(1);

	public abstract ResourcePool<T> createResourcePool(int nb);

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
		resourcePool.freeResource(resourcePool.createResource());
	}

	@Test
	public void freeResourceTest() {
		T resource = resourcePool1.givenResources.get(0);
		assertTrue(resourcePool1.givenResources.contains(resource));
		assertFalse(resourcePool1.availableResources.contains(resource));

		resourcePool1.freeResource(resource);

		assertFalse(resourcePool1.givenResources.contains(resource));
		assertTrue(resourcePool1.availableResources.contains(resource));
	}

	public abstract void createResourceTest();

}
