package pool;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

import pool.resource.Resource;

public abstract class ResourcePoolTest<T extends Resource> {

	public ResourcePool<T> resourcePool = createResourcePool(0);
	public ResourcePool<T> resourcePool1 = createResourcePool(1);
	public ResourcePool<T> resourcePool2 = createResourcePool(1);
	public ResourcePool<T> resourcePool3 = createResourcePool(1);

	public abstract ResourcePool<T> createResourcePool(int nb);

	@Test(expected = NoSuchElementException.class)
	public void provideResourceTestException() {
		resourcePool.provideResource();
	}

	@Test
	public void testProvideResource() {
		assertEquals(resourcePool1.provideResource(),
				resourcePool2.availableResources.remove(0));
		assertTrue(resourcePool1.givenResources
				.contains(resourcePool3.availableResources.remove(0)));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFreeResourceWithIllegalArgument() {
		resourcePool.freeResource(resourcePool.createResource());
	}

	@Test
	public void testFreeResource() {
		resourcePool1.provideResource();
		
		T resource = resourcePool1.givenResources.get(0);
		assertTrue(resourcePool1.givenResources.contains(resource));
		assertFalse(resourcePool1.availableResources.contains(resource));

		resourcePool1.freeResource(resource);

		assertFalse(resourcePool1.givenResources.contains(resource));
		assertTrue(resourcePool1.availableResources.contains(resource));
	}

	public abstract void testCreateResource();

}
