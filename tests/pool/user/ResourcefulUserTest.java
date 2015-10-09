package pool.user;

import org.junit.Test;

public class ResourcefulUserTest {

	@Test
	public void resetResourceTest() {
		ResourcefulUser resourcefulUser= new ResourcefulUser(1);
		AssertNotSame(resourcefulUser.getResource(), null);
		resourcefulUser.reset();
		AssertSame(resourcefulUser.getResource(), null);
		
	}
}
