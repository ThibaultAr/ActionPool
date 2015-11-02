package action;

import static org.junit.Assert.*;

import org.junit.Test;

import exception.ActionFinishedException;

import pool.MockPool;
import pool.ResourcePool;
import pool.resource.*;

import pool.user.ResourcefulUser;

public class TakeResourceActionTest extends ResourceActionTest {

	@Override
	public ResourceAction<Basket> createBasketAction(
			ResourcefulUser<Basket> user, ResourcePool<Basket> pool) {
		return new TakeResourceAction<Basket>(user, pool);
	}

	@Test(expected = ActionFinishedException.class)
	public void testResourceActionOnFinishedAction()
			throws ActionFinishedException {
		ResourcefulUser<Basket> user = new ResourcefulUser<Basket>();
		ResourcePool<Basket> pool = new MockPool();

		ResourceAction<Basket> action = createBasketAction(user, pool);

		action.doStep();
		action.doStep();
	}

	@Test
	public void testResourceAction() throws ActionFinishedException {
		ResourcefulUser<Basket> user = new ResourcefulUser<Basket>();
		ResourcePool<Basket> pool = new MockPool();

		ResourceAction<Basket> action = createBasketAction(user, pool);

		assertNull(user.getResource());

		action.doStep();

		assertSame(user.getResource(), MockPool.b);
	}

	@Override
	public Action createAction() {

		return createBasketAction(new ResourcefulUser<Basket>(), new MockPool());
	}
}
