package action;

import exception.ActionFinishedException;

public abstract class Action {

	/**
	 * Throws an exception if the action is already finished
	 * @throws ActionFinishedException
	 */
	public void doStep() throws ActionFinishedException {
		if (this.isFinished())
			throw new ActionFinishedException();
	}

	public abstract boolean isReady();

	public abstract boolean isFinished();

	public abstract boolean isInProgress();

}
