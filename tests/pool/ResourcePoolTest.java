package pool;

import java.util.NoSuchElementException;

import org.junit.Test;

import pool.resource.Resource;

public abstract class ResourcePoolTest<T extends Resource> {

	@Test(expected=NoSuchElementException.class)
	public void provideResourceTestException() {
		? resourcePool = (?) new ?(0);
		resourcePool.provideResource();
	}
	
	@Test
	public void provideResourceTest() {
		? resourcePool1 = (?) new ?(1);
		? resourcePool2 = (?) new ?(1);
		? resourcePool3 = (?) new ?(1);
		resourcePool.provideResource();
		assertSame(resourcePool1.provideResource(), resourcePoll2.availableResources.remove(0));
		assertTrue(resourcePool1.givenResources.contains(resourcePoll3.availableResources.remove(0)));
	}
	
	/* A terminer*/
	
	/*@Test(expected=IllegalArgumentException.class)
	public void freeResourceTestException() {
		
	}
	
	public void freeResource(T resource) throws IllegalArgumentException {
		if(!this.givenResources.contains(resource))
			throw new IllegalArgumentException();
		this.givenResources.remove(resource);
		this.availableResources.add(resource);
	}*/
	
}
