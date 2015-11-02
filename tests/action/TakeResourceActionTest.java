package action;

import static org.junit.Assert.*;

import org.junit.Test;

import exception.ActionFinishedException;

import pool.MockBasketPool;
import pool.ResourcePool;
import pool.resource.*;

import pool.user.ResourcefulUser;

public class TakeResourceActionTest extends ResourceActionTest {

	@Override
	public ResourceAction<Basket> createBasketAction(
			ResourcefulUser<Basket> user, ResourcePool<Basket> pool) {
		return new TakeResourceAction<Basket>(user, pool);
	}

	@Test
	public void testResourceAction() throws ActionFinishedException {
		ResourcefulUser<Basket> user = new ResourcefulUser<Basket>();

		ResourcePool<Basket> pool = new MockBasketPool();
		
		ResourceAction<Basket> action = createBasketAction(user, pool);

		assertNull(user.getResource());

		action.doStep();

		assertSame(user.getResource(), MockBasketPool.b);	
	}

	@Override
	public Action createAction() {

		
		
		return createBasketAction(new ResourcefulUser<Basket>(), new MockBasketPool());
	}
}
