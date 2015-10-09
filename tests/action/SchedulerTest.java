package action;

import static org.junit.Assert.*;

import org.junit.Test;

public class SchedulerTest {
	public Action createAction(){
		Scheduler scheduler = new Scheduler();
		scheduler.addAction(new ForeseeableAction(1));
		return scheduler;
	}
	
	@Test
	public void testScheduler(){
		Action action1 = new ForeseeableAction(2);
		Action action2 = new ForeseeableAction(1);
		Scheduler scheduler = new Scheduler();
		
		scheduler.addAction(action1);
		scheduler.addAction(action2);
		
		assertTrue(action1.isReady());
		assertTrue(action2.isReady());
		assertTrue(scheduler.isReady());
		
		scheduler.doStep();
		
		assertTrue(action1.isInProgress());
		assertTrue(action2.isReady());
		assertTrue(scheduler.isInProgress());
		
		scheduler.doStep();
		
		assertTrue(action1.isFinished());
		assertTrue(action2.isReady());
		assertTrue(scheduler.isInProgress());
		
		scheduler.doStep();
		
		assertTrue(action1.isFinished());
		assertTrue(action2.isFinished());
		assertTrue(scheduler.isFinished());
		
		
	}
	
	
	@Test
	public void testSchedulerWithScheduler() {
		Action action = new ForeseeableAction(2);
		Scheduler scheduler = new Scheduler();
		Scheduler subScheduler = new Scheduler();
		
		subScheduler.addAction(action);
		scheduler.addAction(subScheduler);
		
		assertTrue(action.isReady());
		assertTrue(subScheduler.isReady());
		
		scheduler.doStep();
		
		assertTrue(scheduler.isInProgress());
		assertTrue(subScheduler.isInProgress());
		assertTrue(action.isInProgress());
		
		scheduler.doStep();
		
		assertTrue(scheduler.isFinished());
		assertTrue(subScheduler.isFinished());
		assertTrue(action.isFinished());
		
	}
}
