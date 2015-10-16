package action;

import static org.junit.Assert.*;

import org.junit.Test;

public abstract class SchedulerTest extends ActionTest {

	public abstract Action createAction();

	public abstract Scheduler createScheduler();
	
	public Scheduler createScheduler(Action action){
		Scheduler scheduler = this.createScheduler();
		scheduler.addAction(action);
		return scheduler;
	}

	@Test
	public void testSchedulerWithScheduler() {
		Action action = new ForeseeableAction(2);
		Scheduler scheduler = this.createScheduler();
		Scheduler subScheduler = this.createScheduler();

		subScheduler.addAction(action);
		scheduler.addAction(subScheduler);

		assertTrue(subScheduler.isReady());

		tryAction(scheduler);

		assertTrue(scheduler.isInProgress());
		assertTrue(subScheduler.isInProgress());

		tryAction(scheduler);

		assertTrue(scheduler.isFinished());
		assertTrue(subScheduler.isFinished());
	}
	
	@Test
	public void with1OneStepAction(){
		OneStepAction action1 = new OneStepAction();
		Scheduler scheduler = createScheduler(action1);
		
		assertFalse(scheduler.isFinished());
		assertFalse(action1.isFinished());
		
		tryAction(scheduler);
		
		assertTrue(scheduler.isFinished());
		assertTrue(action1.isFinished());
	}
	

}
