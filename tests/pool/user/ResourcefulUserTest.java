package pool.user;

import static org.junit.Assert.*;

import org.junit.Test;

import pool.resource.Basket;

public class ResourcefulUserTest {

	@Test
	public void testSetResetResource() {
		ResourcefulUser<Basket> resourcefulUser = new ResourcefulUser<Basket>();
		assertNull(resourcefulUser.getResource());

		resourcefulUser.setResource(new Basket());
		assertNotNull(resourcefulUser.getResource());

		resourcefulUser.resetResource();
		assertNull(resourcefulUser.getResource());
	}
}
