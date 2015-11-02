package pool;

import pool.resource.Cubicle;

public class CubiclePool extends ResourcePool<Cubicle> {

	public CubiclePool(int nbCubicle) {
		super(nbCubicle);
	}

	public Cubicle createResource() {
		return new Cubicle();
	}
}
