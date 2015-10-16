package action;

import exception.ActionFinishedException;
import pool.ResourcePool;
import pool.resource.Resource;
import pool.user.ResourcefulUser;

public abstract class ResourceAction<R extends Resource> extends Action {
	protected ResourcefulUser<R> user;
	protected ResourcePool<R> pool;
	protected boolean isReady;
	protected boolean isFinished;
	
	public abstract void resourceAction();

	public ResourceAction (ResourcefulUser<R> user, ResourcePool<R> pool){
		this.user = user;
		this.pool = pool;
		this.isReady = true;
		this.isFinished = false;
	}
	
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
}
