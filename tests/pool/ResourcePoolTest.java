package pool;

import junit.framework.Test;

public class ResourcePoolTest {

	@Test(expected=NoSuchElementException.class)
	public void provideResourceTest() {
		T resourcePool = new T(0);
		resourcePool.provideResource();
	}
}
