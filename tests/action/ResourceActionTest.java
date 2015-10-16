package action;

import org.junit.Test;

import exception.ActionFinishedException;

public abstract class ResourceActionTest {

	public abstract void resourceActionTest();

	@Test(expected=ActionFinishedException.class)
	public void doStepTest() {
		
	}
}
