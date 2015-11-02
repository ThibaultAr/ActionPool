package action;

import pool.BasketPool;
import pool.CubiclePool;
import pool.resource.Basket;
import pool.resource.Cubicle;
import pool.user.ResourcefulUser;

public class Swimmer extends SequentialScheduler {
	protected String name;
	
	public Swimmer(String name, BasketPool baskets, CubiclePool cubicles, int timeToUndress, int timeSwimming, int timeToDress){
		this.name = name;
		ResourcefulUser<Basket> basketManager = new ResourcefulUser<Basket>();
		TakeResourceAction<Basket> takeBasket = new TakeResourceAction<Basket>(basketManager,baskets);
		FreeResourceAction<Basket> freeBasket = new FreeResourceAction<Basket>(basketManager,baskets);
		
		ResourcefulUser<Cubicle> cubicleManager = new ResourcefulUser<Cubicle>();
		TakeResourceAction<Cubicle> takeCubicle = new TakeResourceAction<Cubicle>(cubicleManager,cubicles);
		FreeResourceAction<Cubicle> freeCubicle = new FreeResourceAction<Cubicle>(cubicleManager,cubicles);
		
		Action getUndressed = new ForeseeableAction(timeToUndress);
		Action swimming = new ForeseeableAction(timeSwimming);
		Action getDressed = new ForeseeableAction(timeToDress);
		
		this.actions.add(takeBasket);
		this.actions.add(takeCubicle);
		this.actions.add(getUndressed);
		this.actions.add(freeCubicle);
		this.actions.add(swimming);
		this.actions.add(takeCubicle);
		this.actions.add(getDressed);
		this.actions.add(freeCubicle);
		this.actions.add(freeBasket);
	}
	
	
}
