package pool;

import static org.junit.Assert.*;

import org.junit.Test;

import pool.resource.Cubicle;

public class CubiclePoolTest extends ResourcePoolTest<Cubicle> {

	@Test
	public void createResourceTest() {
		CubiclePool cubiclePool = new CubiclePool(0);
		Cubicle cubicle = new Cubicle();
		assertTrue(cubicle.equals(cubiclePool.createResource()));
	}

	@Override
	public ResourcePool<Cubicle> createResourcePool(int nb) {
		return new CubiclePool(nb);
	}
}
