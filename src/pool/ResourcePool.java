package pool;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import pool.resource.Resource;

/**
 * A pool of resources. There is two kind of resources, available and given ones.
 */
public abstract class ResourcePool<T extends Resource> {
	protected List<T> availableResources = new LinkedList<T>();
	protected List<T> givenResources = new LinkedList<T>();

	public ResourcePool(int nbResources) {
		for (int i = 0; i < nbResources; i++)
			this.availableResources.add(createResource());
	}

	public T provideResource() throws NoSuchElementException {
		if (this.availableResources.isEmpty())
			throw new NoSuchElementException();
		T resource = this.availableResources.remove(0);
		givenResources.add(resource);
		return resource;
	}

	public void freeResource(T resource) throws IllegalArgumentException {
		if (!this.givenResources.contains(resource))
			throw new IllegalArgumentException();
		this.givenResources.remove(resource);
		this.availableResources.add(resource);
	}

	public abstract T createResource();

	/**
	 * used by Display
	 */
	public abstract String getName();

}
