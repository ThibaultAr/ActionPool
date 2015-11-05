package action;

import exception.ActionFinishedException;

/**
 * Actions execute sequentially
 */
public class SequentialScheduler extends Scheduler {

	/**
	 * Does a step of the first action, the next call of doStep will do a step of the first action in the list
	 * while it's not finished
	 */
	public void doStep() throws ActionFinishedException {
		super.doStep();
		this.isReady = false;
		Action nextAction = this.actions.get(0);
		nextAction.doStep();
		if (nextAction.isFinished())
			this.actions.remove(0);
	}
}