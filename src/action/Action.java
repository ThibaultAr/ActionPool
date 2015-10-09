package action;

public abstract class Action {

	public abstract void doStep();
	
	public abstract boolean isReady();
	
	public abstract boolean isFinished();
	
	public abstract boolean isInProgress();
}
