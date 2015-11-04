package action;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pool.ResourcePool;
import pool.resource.Basket;
import pool.user.ResourcefulUser;

public abstract class ResourceActionTest extends ActionTest {

	public abstract ResourceAction<Basket> createBasketAction(
			ResourcefulUser<Basket> user, ResourcePool<Basket> pool);

	@Test
	public void testStates() {
		Action action = this.createAction();
		assertTrue(action.isReady());
		tryAction(action);
		assertTrue(action.isFinished());
	}
}
