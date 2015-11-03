package action;

import exception.ActionFinishedException;

public abstract class Action {

	/**
	 * Made the action pass to it next step Throws an exception if the action is
	 * already finished
	 */
	public void doStep() throws ActionFinishedException {
		if (this.isFinished())
			throw new ActionFinishedException();
	}

	public abstract boolean isReady();

	public abstract boolean isFinished();

	public abstract boolean isInProgress();

}
