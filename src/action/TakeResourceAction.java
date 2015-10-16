package action;

import java.util.NoSuchElementException;

import pool.ResourcePool;
import pool.resource.Resource;
import pool.user.ResourcefulUser;

public class TakeResourceAction<R extends Resource> extends ResourceAction<R>{
	
	public TakeResourceAction(ResourcefulUser<R> user, ResourcePool<R> pool){
		super(user, pool);
	}

	public void resourceAction() {
		try {
			R resource = this.pool.provideResource();
			this.user.setResource(resource);
			this.isFinished = true;
		} catch (NoSuchElementException e){
			System.out.println("There's no resources available.");
		}
	}
	
}
