package action;

import java.util.List;

public class Scheduler {
	
	protected List<Action> actions;
	protected boolean isReady;
	
	/**
	 * Add the action passed in parameter to the scheduler
	 * @param action
	 * 				the action to be add to the actions list
	 */
	public void addAction(Action action) {
		this.actions.add(action);
	}
	
	/**
	 * Tells if the action is ready or not
	 * @return the value of the attribute isReady
	 */
	public boolean isReady(){
		return this.isReady;
	}
	
	
	
}
