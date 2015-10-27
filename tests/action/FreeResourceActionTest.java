package action;

import org.junit.Test;

import pool.BasketPool;
import pool.ResourcePool;
import pool.resource.Basket;
import pool.user.ResourcefulUser;
import exception.ActionFinishedException;

public class FreeResourceActionTest extends ResourceActionTest{
	public static Basket b = new Basket();
	public class MockUser extends ResourcefulUser<Basket>{

		public Basket getResource(){
			return b ;
		}
	}
	
	public class MockPool extends BasketPool{
		public MockPool(){
			super(1);
			this.givenResources.add(b);
		}
	}
	
	@Override
	public ResourceAction<Basket> createBasketAction(
			ResourcefulUser<Basket> user, ResourcePool<Basket> pool) {
		return new FreeResourceAction<Basket>(new MockUser(),new MockPool());
	}


	@Test
	public void resourceActionTest() throws ActionFinishedException {
		ResourcefulUser<Basket> user = new MockUser();
		ResourcePool<Basket> pool = new MockPool();
		
		
		ResourceAction<Basket> action = createBasketAction(user, pool);
		
		
		assertNotNull(user.getResource());
		
		action.doStep();	
	}
}
