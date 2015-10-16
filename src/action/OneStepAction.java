package action;

import exception.ActionFinishedException;

public class OneStepAction extends Action {

	protected boolean isReady = false;
	protected boolean isFinished = false;

	public OneStepAction() {
		this.isReady = true;
		this.isFinished = false;
	}

	public void doStep() throws ActionFinishedException{
		super.doStep();
		this.isReady = false;
		this.isFinished = true;
	}

	@Override
	public boolean isReady() {
		return this.isReady;
	}

	@Override
	public boolean isFinished() {
		return this.isFinished;
	}

	@Override
	public boolean isInProgress() {
		return !this.isFinished() && !this.isReady();
	}

}
