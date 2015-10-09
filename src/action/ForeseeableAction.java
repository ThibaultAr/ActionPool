package action;

public class ForeseeableAction {

	protected int totalTime;
	protected int remainingTime;
	
	/**
	 * Constructor
	 * @param totalTime
	 */
	public ForeseeableAction(int totalTime){
		this.totalTime = totalTime;
	}
	
	/**
	 * Tells if the action is ready or not
	 * @return true if remainingTime and totalTime are the same, false if not
	 */
	public boolean isReady(){
		return remainingTime == totalTime;
	}
	
	/**
	 * Tells if the action is in progress or not
	 * @return true if the action is not ready nor finished, false if not
	 */
	public boolean isInProgress(){
		return !isReady() && !isFinished();
	}
	
	/**
	 * Tells if the action is in finished or not
	 * @return true if remainingTime is <= 0, false if not
	 */
	public boolean isFinished(){
		return remainingTime <= 0;
	}
	
	/**
	 * Decrement the action remaining time
	 */
	public void doStep(){
		remainingTime--;
	}
}
