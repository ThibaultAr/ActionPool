package action;

import exception.ActionFinishedException;

/**
 * Actions execute sequentially
 */
public class SequentialScheduler extends Scheduler {

	public void doStep() throws ActionFinishedException {
		super.doStep();
		this.isReady = false;
		Action nextAction = this.actions.get(0);
		nextAction.doStep();
		if (nextAction.isFinished())
			this.actions.remove(0);
	}
}