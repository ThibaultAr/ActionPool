package action;

import java.util.List;

public class Scheduler {
	protected List<Action> actions;
	protected boolean isReady;
	
	public void addAction(Action action) {
		this.actions.add(action);
	}
	
	public boolean isReady(){
		return this.isReady;
	}
	
	
	
}
