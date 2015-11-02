package action;

import exception.ActionFinishedException;
import pool.ResourcePool;
import pool.resource.Resource;
import pool.user.ResourcefulUser;

/**
 * ResourceAction is an action with a specific behavior on an user's resource
 * pool
 * 
 * @param <R>
 */
public abstract class ResourceAction<R extends Resource> extends Action {
	protected ResourcefulUser<R> user;
	protected ResourcePool<R> pool;
	protected boolean isReady;
	protected boolean isFinished;

	public abstract void resourceAction();

	public ResourceAction(ResourcefulUser<R> user, ResourcePool<R> pool) {
		this.user = user;
		this.pool = pool;
		this.isReady = true;
		this.isFinished = false;
	}

	/**
	 * Made the action pass to it next step
	 * Throws an exception if the action is already finished
	 */
	public void doStep() throws ActionFinishedException {
		super.doStep();
		this.isReady = false;
		this.resourceAction();
	}

	public boolean isReady() {
		return this.isReady;
	}

	public boolean isFinished() {
		return this.isFinished;
	}

	public boolean isInProgress() {
		return !this.isReady() && !this.isFinished();
	}

	public ResourcefulUser<R> user() {
		return user;
	}
}
