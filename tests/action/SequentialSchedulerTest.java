package action;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SequentialSchedulerTest extends SchedulerTest {

	public Action createAction(){
		SequentialScheduler scheduler = new SequentialScheduler();
		scheduler.addAction(new ForeseeableAction(2));
		return scheduler;
	}

	public Scheduler createScheduler() {
		return (Scheduler)new SequentialScheduler();
	}

	@Test
	public void testSequentialScheduler(){
		Action action1 = new ForeseeableAction(2);
		Action action2 = new ForeseeableAction(1);
		Scheduler scheduler = this.createScheduler();
		
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
	
}
