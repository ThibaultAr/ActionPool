package pool;

import pool.resource.Basket;


public class MockBasketPool extends BasketPool{
	public static final Basket b = new Basket();
	public MockBasketPool(){
		super(1);
		this.givenResources.add(MockBasketPool.b);
	}

	public Basket provideResource() {
		return b;
	}
}
