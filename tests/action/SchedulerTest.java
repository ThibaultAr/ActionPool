package action;

import static org.junit.Assert.*;

import org.junit.Test;

public abstract class SchedulerTest extends ActionTest{
	
	public abstract Action createAction();
	
	public abstract Scheduler createScheduler();
	
	
	@Test
	public void testSchedulerWithScheduler() {
		Action action = new ForeseeableAction(2);
		Scheduler scheduler = this.createScheduler();
		Scheduler subScheduler = this.createScheduler();
		
		subScheduler.addAction(action);
		scheduler.addAction(subScheduler);
		
		assertTrue(subScheduler.isReady());
		
		scheduler.doStep();
		
		assertTrue(scheduler.isInProgress());
		assertTrue(subScheduler.isInProgress());
		
		scheduler.doStep();
		
		assertTrue(scheduler.isFinished());
		assertTrue(subScheduler.isFinished());		
	}
}
