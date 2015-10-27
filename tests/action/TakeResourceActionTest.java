package action;

import static org.junit.Assert.*;

import org.junit.Test;

import exception.ActionFinishedException;

import pool.BasketPool;
import pool.ResourcePool;
import pool.resource.*;

import pool.user.ResourcefulUser;

public class TakeResourceActionTest extends ResourceActionTest{
	public class MockPool extends BasketPool{
		protected Basket b = new Basket();
		public MockPool(){
			super(1);
		}
		
		public Basket provideResource(){
			return b;
		}
	}
	
	@Override
	public ResourceAction<Basket> createBasketAction(
			ResourcefulUser<Basket> user, ResourcePool<Basket> pool) {
		return new TakeResourceAction<Basket>(user,pool);
	}


	@Test
	public void resourceActionTest() throws ActionFinishedException {
		ResourcefulUser<Basket> user = new ResourcefulUser<Basket>();
		ResourcePool<Basket> pool = new MockPool();
		
		ResourceAction<Basket> action = createBasketAction(user, pool);
		
		assertNull(user.getResource());
		
		action.doStep();
		
		assertSame(user.getResource(), pool.provideResource());	
	}
}
