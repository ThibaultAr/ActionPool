package pool;

import pool.resource.Basket;

public class BasketPool extends ResourcePool<Basket> {

	public BasketPool(int nbBasket) {
		super(nbBasket);
	}

	public Basket createResource() {
		return new Basket();
	}
}
