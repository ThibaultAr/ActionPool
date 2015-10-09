package pool.user;

import static org.junit.Assert.*;

import org.junit.Test;

public class ResourcefulUserTest {

	@Test
	public void resetResourceTest() {
		ResourcefulUser resourcefulUser= new ResourcefulUser(1);
		assertNotSame(resourcefulUser.getResource(), null);
		resourcefulUser.reset();
		assertSame(resourcefulUser.getResource(), null);
		
	}
}
