package action;

import java.util.NoSuchElementException;

import displayer.Displayer;

import pool.ResourcePool;
import pool.resource.Resource;
import pool.user.ResourcefulUser;

/**
 * brings a Resource from a Pool to an User
 */
public class TakeResourceAction<R extends Resource> extends ResourceAction<R> {

	public TakeResourceAction(ResourcefulUser<R> user, ResourcePool<R> pool) {
		super(user, pool);
	}

	public void resourceAction() {
		try {
			Displayer.getDisplayer().display(
					"trying to take resource from " + pool.getName() + " ...");
			R resource = this.pool.provideResource();
			this.user.setResource(resource);
			this.isFinished = true;
			Displayer.getDisplayer().display("success\n");
		} catch (NoSuchElementException e) {
			Displayer.getDisplayer().display("failed\n");
		}
	}

}
