package action;

public abstract class Action {


	/**
	 * Made the action pass to it next step
	 */
	public abstract void doStep();
	
	/**
	 * Tells if the action is ready or not
	 * @return true if the action is ready, false if not
	 */
	public abstract boolean isReady();
	
	/**
	 * Tells if the action is in finished or not
	 * @return true if the action is finished, false if not
	 */
	public abstract boolean isFinished();
	
	/**
	 * Tells if the action is in progress or not
	 * @return true if the action is in progress, false if not
	 */
	public abstract boolean isInProgress();
}
