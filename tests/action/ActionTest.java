package action;

import static org.junit.Assert.*;

import org.junit.Test;

import exception.ActionFinishedException;

public abstract class ActionTest {
	public abstract Action createAction();

	@Test
	public void testOnlyOneValidStateAtEachMoment() {
		Action action = this.createAction();
		assertTrue(action.isReady());
		assertFalse(action.isInProgress());
		assertFalse(action.isFinished());

		while (!action.isFinished()) {
			tryAction(action);
			assertFalse(action.isReady());
			assertTrue(action.isFinished() == !action.isInProgress());
		}

		assertFalse(action.isReady());
		assertFalse(action.isInProgress());
		assertTrue(action.isFinished());
	}

	@Test
	public void testReadyProgress() {
		Action action = this.createAction();
		assertTrue(action.isReady());
		tryAction(action);
		assertTrue(action.isInProgress());
	}

	@Test(expected = ActionFinishedException.class, timeout = 2000)
	public void doStepWhileFinishedThrowsException()
			throws ActionFinishedException {
		Action action = createAction();
		while (!action.isFinished()) {
			tryAction(action);
		}
		
		assertTrue(action.isFinished());
		action.doStep();
	}

	protected void tryAction(Action action) {
		try {
			action.doStep();
		} catch (ActionFinishedException e) {
			fail("action was not supposed to be finished, we just checked");
		}
	}
	
}
