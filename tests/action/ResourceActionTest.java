package action;

import org.junit.Test;

import pool.BasketPool;
import pool.ResourcePool;
import pool.resource.Basket;
import pool.user.ResourcefulUser;

import exception.ActionFinishedException;

public abstract class ResourceActionTest {

	//public abstract void resourceActionTest(ResourceAction<Basket> action, ResourcefulUser<Basket> user, ResourcePool<Basket> pool)throws ActionFinishedException;

	public abstract ResourceAction<Basket> createBasketAction(ResourcefulUser<Basket> user, ResourcePool<Basket> pool);
	
	@Test(expected=ActionFinishedException.class)
	public void doStepTestThrowException() throws ActionFinishedException {
		ResourcefulUser<Basket> user = new ResourcefulUser<Basket>();
		ResourcePool<Basket> pool = new BasketPool(1);
		
		ResourceAction<Basket> action = createBasketAction(user, pool);
		
		action.doStep();
		action.doStep();
	}
	
	/*@Test
	public void testResourceActionDoStep() throws ActionFinishedException{
		ResourcefulUser<Basket> user = new ResourcefulUser<Basket>();
		ResourcePool<Basket> pool = new BasketPool(1);
		
		ResourceAction<Basket> action = createBasketAction(user, pool);
		
		resourceActionTest(action, user, pool);
	}*/
	
}
