package pool;

import pool.resource.Basket;

public class MockPool extends BasketPool{
	public static final Basket b = new Basket();
	public MockPool(){
		super(1);
		this.givenResources.add(MockPool.b);
	}
	
	public Basket provideResource(){
		return b;
	}
}
