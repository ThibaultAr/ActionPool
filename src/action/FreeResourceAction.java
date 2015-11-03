package action;

import displayer.Displayer;
import pool.ResourcePool;
import pool.resource.Resource;
import pool.user.ResourcefulUser;

/**
 * gets a Resource from an User back
 */
public class FreeResourceAction<R extends Resource> extends ResourceAction<R> {

	public FreeResourceAction(ResourcefulUser<R> user, ResourcePool<R> pool) {
		super(user, pool);
	}

	public void resourceAction() {
		try {
			Displayer.getDisplayer().display(
					"freeing resource from " + pool.getName() + "\n");
			R resource = user.getResource();
			this.pool.freeResource(resource);
			this.isFinished = true;
		} catch (IllegalArgumentException e) {
			Displayer.getDisplayer().display("...failed\n");
			/* this instruction is not supposed to fail, we just checked */
		}
	}
}
