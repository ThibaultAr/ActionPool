package action;

import static org.junit.Assert.*;

import org.junit.Test;
import pool.BasketPool;
import pool.resource.Basket;
import pool.user.ResourcefulUser;

public class FreeResourceActionTest {

	@Test
	public void testResourceAction() {
		ResourcefulUser<Basket> user = new ResourcefulUser<Basket>();
		BasketPool pool = new BasketPool(1);
		FreeResourceAction<Basket> action = new FreeResourceAction<Basket>(user, pool);
		
		assertTrue(pool.containsAsAvailableResources(user.getResource()));
		assertFalse(pool.containsAsGivenResources(user.getResource()));
		
		action.resourceAction();
		
		assertFalse(pool.containsAsAvailableResources(user.getResource()));
		assertTrue(pool.containsAsGivenResources(user.getResource()));
		assertTrue(action.isFinished());
	}
	
	@Test
	public void testFreeResourceAction() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoStep() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsReady() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsFinished() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsInProgress() {
		fail("Not yet implemented");
	}

	@Test
	public void testResourceAction1() {
		fail("Not yet implemented");
	}

}
