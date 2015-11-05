package pool.user;

import pool.resource.Resource;

/**
 * A ResourcefulUser contains a resource.
 *
 * @param <R> a resource
 */
public class ResourcefulUser<R extends Resource> {

	protected R resource;

	public R getResource() {
		return resource;
	}

	public void setResource(R resource) {
		this.resource = resource;
	}

	public void resetResource() {
		this.resource = null;
	}
}
