package action;

import java.util.LinkedList;
import java.util.List;

public class Scheduler extends Action{

	protected List<Action> actions;
	protected boolean isReady = true;
	protected boolean isInitialized = false;
	
	public Scheduler(){
		this.actions = new LinkedList<Action>();
	}
	
	/**
	 * Add the action passed in parameter to the scheduler
	 * @param action
	 * 				the action to be add to the actions list
	 */
	public void addAction(Action action) {
		this.isInitialized = true;
		this.actions.add(action);
	}
	
	/**
	 * Tells if the action is ready or not
	 * @return the value of the attribute isReady
	 */
	public boolean isReady(){
		return this.isInitialized && this.isReady;
	}
	
	public boolean isFinished(){
		return this.isInitialized && !this.isReady() && this.actions.isEmpty();
	}
	
	public boolean isInProgress(){
		return isInitialized && !this.isReady() && !this.isFinished();
	}
	
	public void doStep(){
		isReady = false;
		Action nextAction = actions.get(0);
		nextAction.doStep();
		if(nextAction.isFinished())
			actions.remove(0);
	}
}
