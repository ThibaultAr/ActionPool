package action;

import exception.ActionFinishedException;

public abstract class Action {


	/**
	 * Made the action pass to it next step
	 * Throws an exception if the action is already finished
	 */
	public void doStep() throws ActionFinishedException {
		if(this.isFinished())
			throw new ActionFinishedException();
	}
	
	/**
	 * Tells if the action is ready or not
	 * @return true if the action is ready, false if not
	 */
	public abstract boolean isReady();
	
	/**
	 * Tells if the action is finished or not
	 * @return true if the action is finished, false if not
	 */
	public abstract boolean isFinished();
	
	/**
	 * Tells if the action is in progress or not
	 * @return true if the action is in progress, false if not
	 */
	public abstract boolean isInProgress();
}
