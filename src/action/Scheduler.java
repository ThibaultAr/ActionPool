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
	
	public void addAction(Action action) {
		this.isInitialized = true;
		this.actions.add(action);
	}
	
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
