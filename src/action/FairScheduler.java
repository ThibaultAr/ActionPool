package action;

public class FairScheduler extends Scheduler{
	protected int index = 0;
	
	/**
	 * Does a step of an action, the next call of doStep will do a step of the next non-finished action in the list.
	 */
	public void doStep(){
		this.isReady = false;
		int nbActions = this.actions.size();
		Action nextAction = this.actions.get(this.index%nbActions);
		nextAction.doStep();
		if(nextAction.isFinished())
			this.actions.remove(nextAction);
		this.index++;
	}
}
