package action;

import displayer.Displayer;
import exception.ActionFinishedException;

/**
 * Action with a foreseeable time of execution
 */
public class ForeseeableAction extends Action {

	protected int totalTime;
	protected int remainingTime;
	protected String name = "doing";

	public ForeseeableAction(int totalTime) {
		this.totalTime = totalTime;
		this.remainingTime = totalTime;
	}

	public ForeseeableAction(int totalTime, String name) {
		this.totalTime = totalTime;
		this.remainingTime = totalTime;
		this.name = name;
	}

	public boolean isReady() {
		return remainingTime == totalTime;
	}

	public boolean isInProgress() {
		return !isReady() && !isFinished();
	}

	public boolean isFinished() {
		return remainingTime <= 0;
	}

	public void doStep() throws ActionFinishedException {
		super.doStep();
		remainingTime--;
		Displayer.getDisplayer().display(
				this.name + " (" + (this.totalTime - this.remainingTime) + "/"
						+ this.totalTime + ")\n");
	}

}
