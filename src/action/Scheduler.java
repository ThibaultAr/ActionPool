package action;

import java.util.LinkedList;
import java.util.List;

/**
 * A Scheduler allows to execute some Actions in a specific order
 */
public abstract class Scheduler extends Action {

	protected List<Action> actions;
	protected boolean isReady = true;
	protected boolean isInitialized = false;

	public Scheduler() {
		this.actions = new LinkedList<Action>();
	}

	public void addAction(Action action) {
		this.isInitialized = true;
		this.actions.add(action);
	}

	public boolean isReady() {
		return this.isInitialized && this.isReady;
	}

	public boolean isFinished() {
		return this.isInitialized && !this.isReady() && this.actions.isEmpty();
	}

	public boolean isInProgress() {
		return isInitialized && !this.isReady() && !this.isFinished();
	}

}
