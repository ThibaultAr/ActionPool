package action;

public abstract class Action {

	public abstract void dostep();
	
	public abstract boolean isReady();
	
	public abstract boolean isFinished();
	
	public abstract boolean isInProgress();
}
