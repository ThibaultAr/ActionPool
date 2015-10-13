package action;

import static org.junit.Assert.*;

import org.junit.Test;

public class FairSchedulerTest extends SchedulerTest{

	public Action createAction() {
		FairScheduler scheduler = new FairScheduler();
		scheduler.addAction(new ForeseeableAction(2));
		return scheduler;
	}

	public Scheduler createScheduler() {
		return (Scheduler)new FairScheduler();
	}
	
	@Test
	public void testFairScheduler(){
		Action action1 = new ForeseeableAction(3);
		Action action2 = new ForeseeableAction(2);
		Scheduler scheduler = this.createScheduler();
		
		scheduler.addAction(action1);
		scheduler.addAction(action2);
		
		assertTrue(action1.isReady());
		assertTrue(action2.isReady());
		assertTrue(scheduler.isReady());
		
		scheduler.doStep();
		
		assertTrue(action1.isInProgress());
		assertFalse(action2.isInProgress());
		assertTrue(scheduler.isInProgress());
		
		scheduler.doStep();
		
		assertTrue(action2.isInProgress());
		assertTrue(action1.isInProgress());
		assertTrue(scheduler.isInProgress());
		
		scheduler.doStep();
		
		assertTrue(action1.isInProgress());
		assertTrue(action2.isInProgress());
		assertTrue(scheduler.isInProgress());
		
		scheduler.doStep();
		
		assertTrue(action1.isInProgress());
		assertTrue(action2.isFinished());
		assertTrue(scheduler.isInProgress());
		
		scheduler.doStep();
		
		assertTrue(action1.isFinished());
		assertTrue(action2.isFinished());
		assertTrue(scheduler.isFinished());
	}
}
