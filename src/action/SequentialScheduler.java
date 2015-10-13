package action;

public class SequentialScheduler extends Scheduler {

	public void doStep(){
		this.isReady = false;
		Action nextAction = this.actions.get(0);
		nextAction.doStep();
		if(nextAction.isFinished())
			this.actions.remove(0);
	}
}