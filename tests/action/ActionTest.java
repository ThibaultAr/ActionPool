package action;

import static org.junit.Assert.*;

import org.junit.Test;

public abstract class ActionTest {
	public abstract Action createAction();
	

	@Test
	public void onlyOneValidStateAtEachMoment() {
		Action action = this.createAction();
		assertTrue(action.isReady());
		assertFalse(action.isInProgress());
		assertFalse(action.isFinished());
		
		while(!action.isFinished()){
			action.doStep();
			assertFalse(action.isReady());
			assertTrue(action.isFinished() == !action.isInProgress());
		}
		
		assertFalse(action.isReady());
		assertFalse(action.isInProgress());
		assertTrue(action.isFinished());
	}
	
	@Test
	public void testReadyProgress(){
		Action action = this.createAction();
		assertTrue(action.isReady());
		action.doStep();
		assertTrue(action.isInProgress());
	}
}
