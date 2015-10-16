package action;

import pool.ResourcePool;
import pool.resource.Resource;
import pool.user.ResourcefulUser;

public class FreeResourceAction<R extends Resource> extends ResourceAction<R> {
	
	public FreeResourceAction(ResourcefulUser<R> user, ResourcePool<R> pool){
		super(user, pool);
	}

	public void resourceAction() {
		try {
			R resource = user.getResource();
			this.pool.freeResource(resource);
			this.isFinished = true;
		} catch (IllegalArgumentException e){
			System.out.println("This resource can't be free.");
		}
	}
}
