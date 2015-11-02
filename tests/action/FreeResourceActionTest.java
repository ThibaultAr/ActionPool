package action;

import static org.junit.Assert.*;

import org.junit.Test;

import pool.MockBasketPool;
import pool.ResourcePool;
import pool.resource.Basket;
import pool.user.ResourcefulUser;
import exception.ActionFinishedException;

public class FreeResourceActionTest extends ResourceActionTest{
	
	@Override
	public ResourceAction<Basket> createBasketAction(
			ResourcefulUser<Basket> user, ResourcePool<Basket> pool) {
		return new FreeResourceAction<Basket>(user,pool);
	}


	@Test
	public void resourceActionTest() throws ActionFinishedException {
		ResourcefulUser<Basket> user = new ResourcefulUser<Basket>();
		ResourcePool<Basket> pool = new MockBasketPool();
		
		ResourceAction<Basket> action = createBasketAction(user, pool);
		
		user.setResource(MockBasketPool.b);
		assertNotNull(user.getResource());
		
		action.doStep();	
	}


	@Override
	public Action createAction() {
		ResourceAction<Basket> action = createBasketAction(new ResourcefulUser<Basket>(), new MockBasketPool());
		action.user.setResource(MockBasketPool.b);
		return action;
	}
}
