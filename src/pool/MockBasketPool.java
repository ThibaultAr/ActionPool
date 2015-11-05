package pool;

import pool.resource.Basket;

/**
 * A mock class of BasketPool used for Tests.
 * @author thibault
 *
 */
public class MockBasketPool extends BasketPool {
	public static final Basket basket = new Basket();

	public MockBasketPool() {
		super(1);
		this.givenResources.add(MockBasketPool.basket);
	}

	public Basket provideResource() {
		return basket;
	}
}
